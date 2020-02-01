package com.jbk.owu.dataprovider;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.util.ReadExcle;


public class StaticDataProvider extends TestBase {
	@DataProvider(name = "d_login")
	public static Object[][] LoginData() throws EncryptedDocumentException, InvalidFormatException {
		Object[][] testdata =ReadExcle.getDataFromXls("Login");
		return testdata;
}
	@DataProvider(name = "d_Register")
	public static Object[][] RegisterData() throws EncryptedDocumentException, InvalidFormatException {
		Object[][] testdata =ReadExcle.getDataFromXls("Registration");
		return testdata;
}
	@DataProvider(name = "d_AddUser")
	public static Object[][] UserData() throws EncryptedDocumentException, InvalidFormatException {
		Object[][] testdata =ReadExcle.getDataFromXls("AddUser");
		return testdata;
}
}
