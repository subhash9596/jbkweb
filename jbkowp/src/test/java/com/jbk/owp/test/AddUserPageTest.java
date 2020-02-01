package com.jbk.owp.test;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.util.Reports;
import com.jbk.owu.util.Retry;
import com.jbk.owu.dataprovider.StaticDataProvider;
import com.jbk.owu.page.DashboardPagee;
import com.jbk.owu.page.RegisterPage;
import com.jbk.owu.page.UserPage;
import com.jbk.owu.page.LoginPage;
public class AddUserPageTest extends TestBase {

	RegisterPage Resisterpage;
	DashboardPagee DashboardPage;
	LoginPage loginpage;

	@BeforeMethod
	public void setupTest() throws IOException
	{
		UserPage dp= new UserPage();
		DashboardPage.userpage();
	}
	@Test(priority=1,dataProviderClass=StaticDataProvider.class,dataProvider = "d_AddUser",retryAnalyzer = Retry.class)
	public void Fill_Form(String tcid, String tcDescription,String Username,String Mobile,String Email,String Cources,String Gender,String selectvalue,String Password) throws Exception{
		Reports.test=Reports.extent.createTest("verifyAdduser", "This test case validate to check add user functionality with blnk info");
		clear(UserPage.getTxt_Username());
		waitForElement(UserPage.getTxt_Username(), 2);
		UserPage.getTxt_Username().sendKeys(Username);
		
		//sendKeys(UserPage.getTxt_Username(),Username);
		
		clear(UserPage.getTxt_Mobile());
		UserPage.getTxt_Mobile().sendKeys(Mobile);
	//	waitForElement(UserPage.getTxt_Mobile(), 2);
		//sendKeys(UserPage.getTxt_Mobile(),Mobile);
		
		clear(UserPage.getTxt_Email());
		//waitForElement(UserPage.getTxt_Email(), 2);
		UserPage.getTxt_Email().sendKeys(Email);
		//sendKeys(UserPage.getTxt_Email(),Email);
		
	
		clear(UserPage.getTxt_Course());
		//waitForElement(UserPage.getTxt_Course(), 2);
		UserPage.getTxt_Course().sendKeys(Cources);
		
		//sendKeys(UserPage.getTxt_Course(),Cources)
		if (Gender.equals("Male")) {
			UserPage.getBtn_radios_Male().click();
		} else if(Gender.equals("Female")) {
			UserPage.getBtn_radios_Female().click();
		}
		UserPage.selectstate(selectvalue);
		clear(UserPage.getTxt_Password());
		//waitForElement(UserPage.getTxt_Password(), 2);
		UserPage.getTxt_Password().sendKeys(Password);
		//sendKeys(UserPage.getTxt_Password(),Password);
		UserPage.getBtn_Submit().click();
		 driver.switchTo().alert().accept();
	    Reports.test=Reports.extent.createTest("LoginwithValidInfo", "This test case validate to check login functionality with valid info");
		}
	}


	

	
