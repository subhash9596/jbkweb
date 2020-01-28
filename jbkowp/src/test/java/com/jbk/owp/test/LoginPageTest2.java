package com.jbk.owp.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.jbk.owp.base.TestBase;
import com.jbk.owp.testHarness.LoginSrc;
import com.jbk.owu.dataprovider.StaticDataProvider;
import com.jbk.owu.page.DashboardPagee;
import com.jbk.owu.page.LoginPage;
import com.jbk.owu.page.RegisterPage;
import com.jbk.owu.util.ItestListner;
import com.jbk.owu.util.Reports;
import com.jbk.owu.util.Retry;

@Listeners(ItestListner.class)
public class LoginPageTest2 extends TestBase{
	// Class objects
	LoginSrc login = new LoginSrc();
	
	
	@Test(priority = 1, retryAnalyzer = Retry.class)
	public void Verify_Current_Url() throws Exception {
		Reports.test = Reports.extent.createTest("Verify Current URL ");
		try {
			login.verify_Current_Url();
		} catch (Exception e) {
			Reports.extent.createTest("Not display current URL");
		}
	}
	
	@Test(priority = 2, retryAnalyzer = Retry.class)
	public void verifyApplicationTitle() throws Exception {
		Reports.test = Reports.extent.createTest("Verify Title ");
		try {
			login.verifyApplicationTitle();
		} catch (Exception e) {
			//Reports.extent.createTest("Not display current URL");
			System.out.println("incorrect title");
		}
	}
	
	@Test(priority = 3, dataProviderClass = StaticDataProvider.class, dataProvider = "d_login", retryAnalyzer = Retry.class)
	public void Login(String testdata[]) throws Exception {
		Reports.test = Reports.extent.createTest("login To Application");
		try {
			login.LoginToApplication(testdata);
		} catch (Exception e) {
			Reports.extent.createTest("Loign is failed");
		}
	}
}




