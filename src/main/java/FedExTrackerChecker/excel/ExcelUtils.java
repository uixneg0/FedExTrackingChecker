package FedExTrackerChecker.excel;

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
import java.io.IOException;
import java.util.ArrayList;

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
//        sheet.setColumnWidth(0, 6000);
//        sheet.setColumnWidth(1, 4000);

        Row header = sheet.createRow(0); //TODO SET HEADERS
        header.createCell(0).setCellValue("Tracking Number");
        header.createCell(1).setCellValue("Tracking Number");
        header.createCell(2).setCellValue("Tracking Number");
        header.createCell(3).setCellValue("Tracking Number");
        header.createCell(4).setCellValue("Tracking Number");
        header.createCell(5).setCellValue("Tracking Number");
        header.createCell(6).setCellValue("Tracking Number");
        header.createCell(7).setCellValue("Tracking Number");
        for (int i = 1; i <= rowData.size(); i++) {
            Row row = sheet.createRow(i);
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

        ArrayList<Response> responses = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();
        for (ArrayList<Long> trackingSegment : segmentedTracking) {
            Thread.sleep(50);
            Thread thread =
                    new Thread(() -> {
                        Response response;
                        try {
                            response = FedExRequest.getTrackingResults(trackingSegment);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        responses.add(response);
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
        for (Response response : responses) {
            rowData.addAll(ResponseParser.parseResponses(response));
        }

        buildResultsFile(rowData);
    }
}
