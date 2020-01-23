package com.jbk.owp.test;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbk.owp.base.TestBase;
import com.jbk.owu.dataprovider.StaticDataProvider;
import com.jbk.owu.page.RegisterPage;
import com.jbk.owu.util.ItestListner;
import com.jbk.owu.util.Reports;

@Listeners(ItestListner.class)
public class RegisterMemberPageTest extends TestBase {
	//Class Object
	@BeforeMethod
	public void setupTest() throws IOException
	{
		RegisterPage resisterpage = new RegisterPage();
		PageFactory.initElements(driver, RegisterPage.class);
	}

	public RegisterMemberPageTest() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	@Test(priority=1,groups="Regression")
	public void verifyRegisterMemberlink() {
		RegisterPage.getLink_RegisterMemberlink().click();
		Assert.assertEquals(RegisterPage.getText_ExpRegisterMemberlink().getText(), "Java By Kiran");
		Reports.test=Reports.extent.createTest("verifyRegisterMemberlink", "This test case validate to check Register a new Membership link");
	}
	@Test(priority=2,groups="Regression")
	public void verifyHeading(){
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Registration Page");
		Reports.test=Reports.extent.createTest("verifyHeading", "This test case validate to check Heading of Register a new Membership link");
	}
	@Test(priority=3,groups="Regression")
	public void verifyPlaceholderName(){
		System.out.println(" RegTest o1 >>> verifyPlaceholderName");
		Assert.assertEquals(RegisterPage.getPlaceholderName().getAttribute("placeholder"), "Name");
		Reports.test=Reports.extent.createTest("verifyPlaceholderName", "This test case validate to check Placeholder of Name on registeration page");
	}
	@Test(priority=4,groups="Regression")
	public void verifyPlaceholderMobile(){
		Assert.assertEquals(RegisterPage.getPlaceholderMobile().getAttribute("placeholder"), "Mobile");
		Reports.test=Reports.extent.createTest("verifyPlaceholderMobile", "This test case validate to check Placeholder of Mobile on registeration page");	
	}
	@Test(priority=5,groups="Regression")
	public void verifyPlaceholderEmail(){
		Assert.assertEquals(RegisterPage.getPlaceholderEmail().getAttribute("placeholder"), "Email");
		Reports.test=Reports.extent.createTest("verifyPlaceholderEmail", "This test case validate to check Placeholder of Email on registeration page");

	}
	@Test(priority=6,groups="Regression")
	public void verifyPlaceholderPassword(){
		Assert.assertEquals(RegisterPage.getPlaceholderPassword().getAttribute("placeholder"), "Password");
		Reports.test=Reports.extent.createTest("verifyPlaceholderEmail", "This test case validate to check Placeholder of Email on registeration page");	
	}
	@Test(priority=7,groups="Regression",dataProviderClass=StaticDataProvider.class,dataProvider = "d_Register")
	public void verifyRegisterMemberValidinfo(String tcId, String tcDescription,String name,String mobile,String eamil, String pwd,String expResult) throws Exception {
		RegisterPage.getPlaceholderName().clear();
		RegisterPage.getPlaceholderName().sendKeys(name);
		RegisterPage.getPlaceholderMobile().clear();
		RegisterPage.getPlaceholderMobile().sendKeys(mobile);
		RegisterPage.getPlaceholderEmail().clear();
		RegisterPage.getPlaceholderEmail().sendKeys(eamil);
		RegisterPage.getPlaceholderPassword().clear();
		RegisterPage.getPlaceholderPassword().sendKeys(pwd);
		RegisterPage.getBtn_signin().click();
		Alert alt = driver.switchTo().alert();
		String actResult  = alt.getText();
		Reports.test=Reports.extent.createTest("verifyRegisterMemberValidinfo", "This test case validate to check Register Member functionality with Validinfo");
		Assert.assertEquals(actResult, expResult);
		driver.switchTo().alert().accept();
	}

	@Test(priority=8,groups="Regression")
	public void verifyAlreadyMembershipLink(){
		System.out.println("verifyAlreadyMembershipLink===>>out");
		RegisterPage.getClick_AlreadyMembership().click();
		Reports.test=Reports.extent.createTest("verify_RegisterMember_Validinfo", "This test case validate to check Register Member functionality with Validinfo");
	}
}


