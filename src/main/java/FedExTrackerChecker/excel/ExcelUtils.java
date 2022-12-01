package FedExTrackerChecker.excel;

import FedExTrackerChecker.Main;
import FedExTrackerChecker.entities.RowData;
import FedExTrackerChecker.requests.FedExRequest;
import FedExTrackerChecker.requests.ResponseParser;
import okhttp3.Response;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ExcelUtils {
    public static ArrayList<Long> getTrackingNumbers(File file) throws IOException, InvalidFormatException {
        ArrayList trackingNumbers = new ArrayList();
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);


        Row headerRow = sheet.getRow(0);
        int trackingColumn = -1;
        for (Cell cell : headerRow) {
            if (cell.toString().toLowerCase().contains("tracking")) {
                trackingColumn = cell.getColumnIndex();
                break;
            }
        }
        if (trackingColumn == -1) return trackingNumbers;
        int index = 0;
        for (Row row : sheet) {
            index++;
            if (index == 1) continue;
            Cell cell = row.getCell(trackingColumn);
            trackingNumbers.add((long) cell.getNumericCellValue());
        }

        System.out.println(trackingNumbers);
        return trackingNumbers;
    }

    public static void buildResultsFile(ArrayList<RowData> rowData) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Tracking Results");
        int headers = 0;
        Row header = sheet.createRow(0);
        for (int i = 0; i < RowData.class.getDeclaredFields().length; i++) {
            String fieldName = RowData.class.getDeclaredFields()[i].getName();
            Cell c = header.createCell(i);
            c.setCellValue(fieldName);
            headers++;
        }

        for (int i = 1; i <= rowData.size(); i++) {
            Row row = sheet.createRow(i);
            RowData dataRow = rowData.get(i - 1);
            for (int j = 0; j < RowData.class.getDeclaredFields().length; j++) {
                try {
                    Object fieldValue = RowData.class.getDeclaredFields()[j].get(dataRow);
                    Cell c = row.createCell(j);
                    c.setCellValue(String.valueOf(fieldValue));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            }
        }

        for (int i = 0; i < headers; i++) {
            sheet.autoSizeColumn(i);
        }

        try {
            String randomString = UUID.randomUUID().toString().substring(0, 4);
            LocalDateTime localDateTime = LocalDateTime.now();
            String time = localDateTime.getHour() + " " + localDateTime.getMinute();
            File folder = new File(Main.getTrackingFolder() + "/CheckedTracking");
            folder.mkdirs();
            FileOutputStream out = new FileOutputStream(folder.getAbsolutePath() + "/" + rowData.get(0).getCustomerReference() + " " + time + " " + randomString + ".xlsx");
            workbook.write(out);

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dumpTrackingSet(ArrayList<Long> trackingSet) throws IOException, InterruptedException {
        ArrayList<ArrayList<Long>> segmentedTracking = new ArrayList<>();
        ArrayList<Long> currSet = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < trackingSet.size(); i++) {
            count++;
            currSet.add(trackingSet.get(i));

            if (count >= 30 || i == trackingSet.size() - 1) {
                segmentedTracking.add(currSet);
                currSet = new ArrayList<>();
                count = 0;
            }
        }

        HashMap<ArrayList<Long>, Response> responses = new HashMap<>();
        ArrayList<Thread> threads = new ArrayList<>();
        for (ArrayList<Long> trackingSegment : segmentedTracking) {
            Thread.sleep(200); // should work to limit under 1400 transactions/10seconds
            Thread thread =
                    new Thread(() -> {
                        Response response;
                        try {
                            response = FedExRequest.getTrackingResults(trackingSegment);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        responses.put(trackingSegment, response);
                    });
            threads.add(thread);
            thread.start();
        }
        outer:
        while (true) {
            for (Thread thread : threads) {
                if (thread.isAlive()) continue outer;
            }
            break;
        }

        ArrayList<RowData> rowData = new ArrayList<>();
        for (ArrayList<Long> trackingSegment : responses.keySet()) {
            ArrayList<RowData> parsedData = ResponseParser.parseResponse(responses.get(trackingSegment));
            if (parsedData.isEmpty()) {
                for (Long trackingNumber : trackingSegment) {
                    parsedData.add(new RowData(String.valueOf(trackingNumber)));
                }
            }
            rowData.addAll(parsedData);
        }

        buildResultsFile(rowData);
    }
}
