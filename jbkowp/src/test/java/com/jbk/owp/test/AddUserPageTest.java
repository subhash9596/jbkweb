package com.jbk.owp.test;
import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.util.Reports;
import com.jbk.owu.util.Retry;

import com.jbk.owu.dataprovider.StaticDataProvider;
import com.jbk.owu.page.DashboardPagee;
import com.jbk.owu.page.RegisterPage;
import com.jbk.owu.page.AddUserPage;
import com.jbk.owu.page.LoginPage;

public class AddUserPageTest extends TestBase {

	RegisterPage Resisterpage;
	DashboardPagee DashboardPage;
	LoginPage loginpage;

	@BeforeMethod
	public void setupTest() throws IOException
	{
		AddUserPage dp= new AddUserPage();
	}
	@Test(priority=1,dataProviderClass=StaticDataProvider.class,dataProvider = "d_AddUser",retryAnalyzer = Retry.class)
	public void Fill_Form(String tcid, String tcDescription,String Username,String Mobile,String Email,String Cources,String Gender,String selectvalue,String Password) throws Exception{
		DashboardPage.userpage();
		Reports.test=Reports.extent.createTest("verifyAdduser", "This test case validate to check add user functionality with blnk info");
		clear(AddUserPage.getTxt_Username());
		waitForElement(AddUserPage.getTxt_Username(), 2);
		AddUserPage.getTxt_Username().sendKeys(Username);
		//sendKeys(UserPage.getTxt_Username(),Username);
		clear(AddUserPage.getTxt_Mobile());
		AddUserPage.getTxt_Mobile().sendKeys(Mobile);
		clear(AddUserPage.getTxt_Email());
		AddUserPage.getTxt_Email().sendKeys(Email);
		clear(AddUserPage.getTxt_Course());
		AddUserPage.getTxt_Course().sendKeys(Cources);
		if (Gender.equals("Male")) {
			AddUserPage.getBtn_radios_Male().click();
		} else if(Gender.equals("Female")) {
			AddUserPage.getBtn_radios_Female().click();
		}
		AddUserPage.selectstate(selectvalue);
		clear(AddUserPage.getTxt_Password());
		AddUserPage.getTxt_Password().sendKeys(Password);
		AddUserPage.getBtn_Submit().click();
		 driver.switchTo().alert().accept();
	    Reports.test=Reports.extent.createTest("LoginwithValidInfo", "This test case validate to check login functionality with valid info");
		}
	
	@Test(priority=2,dataProviderClass=StaticDataProvider.class,dataProvider = "d_AddUser",retryAnalyzer = Retry.class)
	public void VerifyCancel(String tcid, String tcDescription,String Username,String Mobile,String Email,String Cources,String Gender,String selectvalue,String Password) throws Exception{
		Reports.test=Reports.extent.createTest("verifyAdduser", "This test case validate to check Cancel functionality with info");
		
		clear(AddUserPage.getTxt_Username());
		waitForElement(AddUserPage.getTxt_Username(), 2);
		AddUserPage.getTxt_Username().sendKeys(Username);
		clear(AddUserPage.getTxt_Mobile());
		AddUserPage.getTxt_Mobile().sendKeys(Mobile);
		clear(AddUserPage.getTxt_Email());
		AddUserPage.getTxt_Email().sendKeys(Email);
		clear(AddUserPage.getTxt_Course());
		AddUserPage.getTxt_Course().sendKeys(Cources);
		if (Gender.equals("Male")) {
			AddUserPage.getBtn_radios_Male().click();
		} else if(Gender.equals("Female")) {
			AddUserPage.getBtn_radios_Female().click();
		}
		AddUserPage.selectstate(selectvalue);
		clear(AddUserPage.getTxt_Password());
		AddUserPage.getTxt_Password().sendKeys(Password);
		AddUserPage.getBtn_Cancel().click();
		Assert.assertEquals(getTitle(), "JavaByKiran | User");
	    Reports.test=Reports.extent.createTest("VerifyCancelWithValid", "This test case validate to check cancel functionality with valid info");
		}
	}


	

	
