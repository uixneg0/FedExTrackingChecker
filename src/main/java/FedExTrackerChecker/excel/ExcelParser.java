package FedExTrackerChecker.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelParser {
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
}
