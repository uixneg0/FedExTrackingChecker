package FedExTrackerChecker.excel;

import FedExTrackerChecker.entities.RowData;
import FedExTrackerChecker.requests.FedExRequest;
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
import java.util.HashMap;

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
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        Row header = sheet.createRow(0);
        header.getCell(0).setCellValue("Tracking Number");
    }

    public static void dumpTrackingSet(ArrayList<Long> trackingSet) {
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

        HashMap<ArrayList<Long>, Response> responseMap = new HashMap<>();
        ArrayList<Thread> threads = new ArrayList<>();
        for (ArrayList<Long> trackingSegment : segmentedTracking) {
            Thread thread =
                    new Thread(() -> {
                        Response response;
                        try {
                            response = FedExRequest.getTrackingResults(trackingSegment);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        responseMap.put(trackingSegment, response);
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
    }
}
