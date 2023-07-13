package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    public static FileInputStream fis = null;

    public static List<Map<String, String>> getExcelData(String sheetName, String path) {
        List<Map<String, String>> data = new ArrayList<>();
        try {
            fis = new FileInputStream(path);
            XSSFWorkbook xssfWB = new XSSFWorkbook(fis);
            Sheet sheet = xssfWB.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            for (int rows = 1; rows < sheet.getPhysicalNumberOfRows(); rows++) {
                Row row = sheet.getRow(rows);
                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int col = 0; col < headerRow.getPhysicalNumberOfCells(); col++) {
                    String key = headerRow.getCell(col).toString();
                    String value = row.getCell(col).toString();
                    rowMap.put(key, value);
                }
                data.add(rowMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
