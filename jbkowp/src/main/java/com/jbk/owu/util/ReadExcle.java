package com.jbk.owu.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jbk.owp.base.TestBase;

public class ReadExcle extends TestBase {
	
	static String excel_path= currentDir+"\\src\\test\\resources\\JBKTestData.xlsx";
	
	public String getDataFromCell(String xlFilePath,String sheetName,int row,int coloumn)
	{
		String a = null;
		try {
		FileInputStream fis = new FileInputStream(excel_path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Row row1 = sheet.getRow(row);
		Cell cell = row1.getCell(coloumn);
		XSSFCell cellval = sheet.getRow(row).getCell(coloumn);
		a =  cellval.toString();
		}catch (Exception e) {
			e.getMessage();
		}
		return a;
	}

	public static String[][] getCellData(String path, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet s = workbook.getSheet(sheetName);
        int rowcount = s.getLastRowNum();
        int cellcount = s.getRow(0).getLastCellNum();
        String data[][] = new String[rowcount][cellcount];
        for (int i = 1; i <= rowcount; i++) {
              Row r = s.getRow(i);
              for (int j = 0; j < cellcount; j++) {
                    Cell c = r.getCell(j);
                    try {
                          if (c.getCellType() == CellType.STRING) {
                                data[i - 1][j] = c.getStringCellValue();
                          } else {
                                data[i - 1][j] = String.valueOf(c.getNumericCellValue());
                          }
                    } catch (Exception e) {
                          e.printStackTrace();
                    }
              }
        }
        return data;
  }
}
