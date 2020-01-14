package com.jbk.owu.dataProvider;

import org.testng.annotations.DataProvider;

import com.jbk.owp.base.TestBase;
import com.katalyst.util.ReadExcel;

public class StaticDataProvider extends TestBase {
	
	static String excel_path= currentDir+"\\src\\test\\resources\\JBKTestData.xlsx";
	
	@DataProvider(name = "d_login")
	public static Object[][] LoginData() throws Exception {
		Object[][] testObjArray = ReadExcel.getCellData(excel_path,"Login");
		return testObjArray;
	}

}
