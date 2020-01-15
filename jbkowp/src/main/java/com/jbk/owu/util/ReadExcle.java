package com.jbk.owu.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jbk.owp.base.TestBase;

public class ReadExcle extends TestBase {
	
	
	//public static String xlFilePath= "C:/Users/Subhash/git/jbkowp/jbkowp/src/test/resources/OwpTestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	//private static String Testdata_Sheet_Path="H:\\CIProject\\pom\\src\\test\\resources\\datatodp.xlsx";
	  public static Object[][] getDataFromXls(String sheetname) throws EncryptedDocumentException, InvalidFormatException {
		  System.out.println(1111);
		  FileInputStream file=null;
		  System.out.println(2222);
		  try
		  {
			  System.out.println(3333);
			  file=new FileInputStream(xlFilePath);
			  System.out.println(4444);
		  }catch(FileNotFoundException e)
		  
		  {
	    e.printStackTrace();		  
		 }
	try {
		 System.out.println(55555);
	  book=WorkbookFactory.create(file);	
	}catch(InvalidFormatException e) {
		e.printStackTrace();
	}catch(IOException e) {
			e.printStackTrace();
	}
	 System.out.println(666666);
	sheet =  book.getSheet(sheetname);
	System.out.println("sheet>>"+sheet);
	 System.out.println(7777777);
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 System.out.println(888888);
	for(int i=0;i<sheet.getLastRowNum();i++)
		
	{
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
		{
			System.out.println(99999);
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
		
	}	  return data;
	 } 

	  
	
}
