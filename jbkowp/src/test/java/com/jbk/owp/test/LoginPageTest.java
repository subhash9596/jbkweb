package com.jbk.owp.test;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.dataprovider.StaticDataProvider;
import com.jbk.owu.page.DashboardPagee;
import com.jbk.owu.page.LoginPage;
import com.jbk.owu.page.RegisterPage;
import com.jbk.owu.util.TestNgListner;
import com.jbk.owu.util.Reports;
import com.jbk.owu.util.Retry;

//@Listeners(TestNgListner.class)
public class LoginPageTest extends TestBase{
	RegisterPage Resisterpage;
	LoginPage loginpage;
	DashboardPagee Dashboardpage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setupTest() throws IOException
	{
		loginpage = new LoginPage();
	}
	
	@Test(priority=1,groups="Regression",retryAnalyzer = Retry.class)
	public void verify_Current_Url() throws Exception{
		Assert.assertEquals(getcurrentURL(), "file:///E:/Offline%20Website/index.html");
		Reports.test=Reports.extent.createTest("verifyUrl", "This test case validate to check URL of offlien application");	
	}
	@Test(priority=2,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyApplicationTitle() throws Exception{
		Assert.assertEquals(getTitle(), "JavaByKiran | Log ");
		Reports.test=Reports.extent.createTest("verifyApplicationTitle", "This test case validate to check Title of offline application");
	}
	@Test(priority=3,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyTitle() throws Exception{
		//getText(LoginPage.getText_title(), "test of the application")
		Assert.assertEquals(getText(LoginPage.getText_title()),"Java By subhash");
		Reports.test=Reports.extent.createTest("verifyTitle", "This test case validate to check text java by Kiran on login page ");
	}
	@Test(priority=4,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyloginsesion() throws Exception{
		Assert.assertEquals(getText(LoginPage.getText_Loignsession()), "Sign in to start your session");
		Reports.test=Reports.extent.createTest("verifyloginsesion", "This test case validate to check session message on login page");
	}
	@Test(priority=5,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyPlaceHolderUsername() throws Exception {
		Assert.assertEquals(getValue(LoginPage.getEmail(), "placeholder"), "Email");
		Reports.test=Reports.extent.createTest("verifyPlaceHolderUsername", "This test case validate to check placeholder of username on login page");
	}
	@Test(priority=6,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyPlaceHolderPassword() throws Exception {
		Assert.assertEquals(getValue(LoginPage.getPassword(),"placeholder"), "Password");
		Reports.test=Reports.extent.createTest("verifyPlaceHolderPassword", "This test case validate to check placeholder of password on login page");
	}	
	@Test(priority=7,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyButtoncolor() {
		WebElement btnLogin=LoginPage.getBtn_signcolor();
		System.out.println("Before Mouseover buttonr color is "+ btnLogin.getCssValue("background-color"));
		Actions act = new Actions(driver);
		act.moveToElement(btnLogin).build().perform();
		Reports.test=Reports.extent.createTest("check_Button_color", "This test case validate to check sign in button color  on login page");
		System.out.println("after mouse over button color"+ btnLogin.getCssValue("color"));
	}
	@Test(priority=8,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyLinks(){
		Reports.test=Reports.extent.createTest("verifyLinks", "This test case validate to check all links ");
		List <WebElement>links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		System.out.println("---------------------------");
		for(int i=0;i<links.size();i++){
			System.out.println("All the links avilabe >>>"+links.get(i).getText());
		}
	}
	@Test(priority=9,groups="Regression",dataProviderClass=StaticDataProvider.class,dataProvider = "d_login",retryAnalyzer = Retry.class)
	public void LoginTest(String tcId, String tcDescription,String Username,String Password,String expResult) throws Exception{
		System.out.println("Test Case ID >>"+tcId);
		System.out.println("Test Case ID >>"+tcDescription);
		Dashboardpage=loginpage.login(Username, Password);
	//	Reports.test=Reports.extent.createTest("Login", "This test case validate to check login functionality with Blank,invalid and Valid info");
		if(tcDescription.equals("Withblankdinfo")){
			Assert.assertEquals(getText(LoginPage.getMsg_erroremail()),expResult);
			Reports.test=Reports.extent.createTest("LoginwithBlankInfo", "This test case validate to check login functionality with Blank info");
		}else if(tcDescription.equals("InvalidInfo")){
			Assert.assertEquals(getText(LoginPage.getMsg_erroremail()),expResult);
			Reports.test=Reports.extent.createTest("LoginwithInvalidInfo", "This test case validate to check login functionality with invalid info");
		}else if(tcDescription.equals("validInfo")){
			Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard");
			Reports.test=Reports.extent.createTest("LoginwithValidInfo", "This test case validate to check login functionality with valid info");
		}
	}
}


