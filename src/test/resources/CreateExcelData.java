package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class CreateExcelData {
    public static void main(String[] args) {
        try {
            // Create a new workbook
            Workbook workbook = new XSSFWorkbook();
            // Create a new sheet
            Sheet sheet = workbook.createSheet("Sheet1");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("username");
            headerRow.createCell(1).setCellValue("password");

            // Create data rows
            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("user1");
            row1.createCell(1).setCellValue("pass1");

            Row row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("user2");
            row2.createCell(1).setCellValue("pass2");

            // Auto-size columns
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            // Write to file
            FileOutputStream fileOut = new FileOutputStream("src/test/resources/testdata.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

            System.out.println("testdata.xlsx created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}