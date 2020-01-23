package com.jbk.owp.test;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.dataprovider.StaticDataProvider;
import com.jbk.owu.page.LoginPage;
import com.jbk.owu.page.RegisterPage;
import com.jbk.owu.util.ItestListner;
import com.jbk.owu.util.Reports;
import com.jbk.owu.util.Retry;

@Listeners(ItestListner.class)
public class LoginPageTest extends TestBase{
	RegisterPage Resisterpage;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setupTest() throws IOException
	{
		loginpage = new LoginPage();
		PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test(priority=1,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyUrl() throws Exception{
		//Actual Result 
		Assert.assertEquals(driver.getCurrentUrl(), "file:///E:/Offline%20Website/index.html");
		Reports.test=Reports.extent.createTest("verifyUrl", "This test case validate to check URL of offlien application");
		
	}
	@Test(priority=2,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyApplicationTitle(){
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
		Reports.test=Reports.extent.createTest("verifyApplicationTitle", "This test case validate to check Title of offline application");
	
	}
	@Test(priority=3,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyTitle(){
		Assert.assertEquals(LoginPage.getText_title().getText(),"Java By subhash");
		Reports.test=Reports.extent.createTest("verifyTitle", "This test case validate to check text java by Kiran on login page ");
		

	}
	@Test(priority=4,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyloginsesion(){
		Assert.assertEquals(LoginPage.getText_Loignsession().getText(), "Sign in to start your session");
		Reports.test=Reports.extent.createTest("verifyloginsesion", "This test case validate to check session message on login page");

	}
	@Test(priority=5,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyPlaceHolderUsername() {
		Assert.assertEquals(LoginPage.getEmail().getAttribute("placeholder"), "Email");
		Reports.test=Reports.extent.createTest("verifyPlaceHolderUsername", "This test case validate to check placeholder of username on login page");
		
	}
	@Test(priority=6,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyPlaceHolderPassword() {
		Assert.assertEquals(LoginPage.getPassword().getAttribute("placeholder"), "Password");
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
		System.out.println("Login Testcase 08 >> verifyLinks");
		Reports.test=Reports.extent.createTest("verifyLinks", "This test case validate to check all links ");
		List <WebElement>links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		System.out.println("---------------------------");
		for(int i=0;i<links.size();i++){
			System.out.println("All the links avilabe >>>"+links.get(i).getText());
		}
	}
		
		@Test(priority=9,groups="Regression",dataProviderClass=StaticDataProvider.class,dataProvider = "d_login",retryAnalyzer = Retry.class)
		public void Login(String tcId, String tcDescription,String Username,String Password,String expResult) throws Exception{
			System.out.println("Test Case ID >>"+tcId);
			System.out.println("Test Case ID >>"+tcDescription);
			LoginPage.getEmail().clear();
			LoginPage.getEmail().sendKeys(Username);
			LoginPage.getPassword().clear();
			LoginPage.getPassword().sendKeys(Password);
			LoginPage.getButn_Signin().click();	
	
			if(tcDescription.equals("Withblankdinfo")){
				Assert.assertEquals(LoginPage.getMsg_erroremail().getText(),expResult);
				Reports.test=Reports.extent.createTest("LoginwithBlankInfo", "This test case validate to check login functionality with Blank , invalid and valid info");
			}else if(tcDescription.equals("InvalidInfo")){
				Assert.assertEquals(LoginPage.getMsg_erroremail().getText(),expResult);
				Reports.test=Reports.extent.createTest("LoginwithInvalidInfo", "This test case validate to check login functionality with Blank , invalid and valid info");
			}else if(tcDescription.equals("validInfo")){
				//Assert.assertEquals(DashboardPage.getText_dashboard().getText(), expResult);
				Reports.test=Reports.extent.createTest("LoginwithValidInfo", "This test case validate to check login functionality with Blank , invalid and valid info");
				
			}
			
		}
	
	}


