package com.jbk.owu.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.jbk.owp.base.TestBase;

public class ReadExcle extends TestBase {
	private static Workbook book;
	private static Sheet sheet;
	//private static String xlFilePath= "C:/Users/Subhash/git/jbkowp/jbkowp/src/test/resources/OwpTestData.xlsx";
	private static String xlFilePath =  currentDir + "\\src\\test\\resources\\OwpTestData.xlsx";
	public static Object[][] getDataFromXls(String sheetname) throws EncryptedDocumentException, InvalidFormatException {
		FileInputStream file=null;
		try
		{
			file=new FileInputStream(xlFilePath);
		}catch(FileNotFoundException e)

		{
			e.printStackTrace();		  
		}
		try {
			book=WorkbookFactory.create(file);	
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

		sheet =  book.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)

		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}

		}	  return data;
	} 



}
