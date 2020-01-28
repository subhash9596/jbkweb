package com.jbk.owp.testHarness;


import java.util.HashMap;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jbk.owp.base.TestBase;
import com.jbk.owu.page.DashboardPagee;
import com.jbk.owu.page.LoginPage;
import com.jbk.owu.util.Reports;

public class LoginSrc extends TestBase {
  
	private static HashMap<String, String> Login_map = new HashMap<>();
	public void LoginToApplication(String loginData[]) throws Exception {
		PageFactory.initElements(driver, LoginPage.class);
		
		// Test Data
					
		            String tcId = loginData[0];
					String tcDescription = loginData[1];
					String Username = loginData[2];
					String password = loginData[3];
					String expResult = loginData[4];
					
					
					System.out.println(Username);
					System.out.println(password);
					System.out.println(tcDescription);
					System.out.println(expResult);
					
	    //Test Steps 
		    clear(LoginPage.getEmail());
			//waitForElement(LoginPage.getEmail(), 10);
			sendKeys(LoginPage.getEmail(), Username);
			//waitForElement(LoginPage.getPassword(), 10);
			clear(LoginPage.getPassword());
			sendKeys(LoginPage.getPassword(), password);
			click(LoginPage.getButn_Signin());
			if(tcDescription.equals("Withblankdinfo")){
				Assert.assertEquals(getText(LoginPage.getMsg_erroremail()),expResult);
				Reports.test=Reports.extent.createTest("LoginwithBlankInfo", "This test case validate to check login functionality with Blank info");
			}else if(tcDescription.equals("InvalidInfo")){
				Assert.assertEquals(getText(LoginPage.getMsg_erroremail()),expResult);
				Reports.test=Reports.extent.createTest("LoginwithInvalidInfo", "This test case validate to check login functionality with invalid info");
			}else if(tcDescription.equals("validInfo")){
				Assert.assertEquals(getText(DashboardPagee.mainnavigationtext()), expResult);
				Reports.test=Reports.extent.createTest("LoginwithValidInfo", "This test case validate to check login functionality with valid info");
			}
		}
	
	public void verify_Current_Url() throws Exception{
		Assert.assertEquals(getcurrentURL(), "file:///E:/Offline%20Website/index.html");
		//Reports.test=Reports.extent.createTest("verifyUrl", "This test case validate to check URL of offlien application");	
	}
	
	public void verifyApplicationTitle() throws Exception{
		String title="JavaByKiran | Log in";
		Assert.assertEquals(getTitle(), title);
		//Reports.test=Reports.extent.createTest("verifyApplicationTitle", "This test case validate to check Title of offline application");
}
}



