package utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;

import exceptions.FrameworkException;
import exceptions.InvalidPathForExcelException;

import java.io.*;
import java.util.*;

public class ExcelUtils {

    private Map<String, Map<String, String>> loginUserData = new HashMap<>();

    public Map<String, Map<String, String>> getLoginData() {
        return loginUserData;
    }

    public ExcelUtils(String excelPath, String loginDataSheet) {
        readLoginData(excelPath, loginDataSheet);
    }

    private void readLoginData(String excelPath, String loginDataSheet) {
        try (FileInputStream inputStream = new FileInputStream(new File(excelPath))) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet(loginDataSheet);

            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();

            List<String> columnHeaders = new ArrayList<>();
            for (int i = 0; i < columnCount; i++) {
                columnHeaders.add(sheet.getRow(0).getCell(i).getStringCellValue());
            }

            for (int i = 1; i <= rowCount; i++) {
                Map<String, String> rowData = new HashMap<>();
                Row row = sheet.getRow(i);
                for (int j = 0; j < columnCount; j++) {
                    rowData.put(columnHeaders.get(j), getCellValueAsString(row.getCell(j)));
                }
                loginUserData.put(getCellValueAsString(row.getCell(0)), rowData);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new InvalidPathForExcelException("Excel File you are trying to read is not found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new FrameworkException("Some IO exception happened while reading the Excel file");
        }
    }

    @SuppressWarnings("deprecation")
	private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue().trim();
    }

    // Other methods for handling Excel operations...

    public static void main(String[] args) {
        String excelPath = "path/to/your/excel.xlsx";
        String loginDataSheet = "LoginData";
        ExcelUtils excelUtils = new ExcelUtils(excelPath, loginDataSheet);

        // Now you can use methods like getLoginData() to retrieve the login data.
        Map<String, Map<String, String>> loginData = excelUtils.getLoginData();
        System.out.println(loginData);
    }
}
