package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static List<String[]> readExcel(String filePath, String sheetName) throws Exception {
        List<String[]> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // Skip header
            String[] rowData = new String[row.getLastCellNum()];
            for (int i = 0; i < row.getLastCellNum(); i++) {
                rowData[i] = row.getCell(i) != null ? row.getCell(i).toString() : "";
            }
            data.add(rowData);
        }
        workbook.close();
        fis.close();
        return data;
    }
}