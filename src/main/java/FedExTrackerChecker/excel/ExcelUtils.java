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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ExcelUtils {

    /**
     * Takes an XLSX/XLS file as arg and parses the tracking numbers from the file.
     * Column header for tracking numbers must contain "tracking" as a substring.
     */
    public static List<Long> parseTrackingNumbers(InputStream inputStream) throws IOException {
        List<Long> trackingNumbers = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(inputStream);
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
        return trackingNumbers;
    }

    /**
     * Returns an Apache POI workbook from passed in list of row data.
     */
    public static Workbook buildWorkbook(ArrayList<RowData> rowData) {
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

        return workbook;
    }

    /**
     * Takes in a list of longs (tracking numbers).
     * Segments the list into segments of 30 (FedEx max request size is 30 tracking numbers).
     * Sends and parses requests for each segment of tracking numbers.
     * Returns an Apache POI workbook based off all responses.
     */
    public static Workbook buildWorkbook(List<Long> trackingSet, String oAuthToken) throws IOException, InterruptedException {
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
                        response = FedExRequest.getTrackingResults(trackingSegment, oAuthToken);
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
        return buildWorkbook(rowData);
    }
}
