package com.jbk.owp.test;

import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.channels.AcceptPendingException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.dataprovider.StaticDataProvider;
import com.jbk.owu.page.LoginPage;
import com.jbk.owu.page.RegisterPage;
import com.jbk.owu.util.ItestListner;
import com.jbk.owu.util.Reports;

@Listeners(ItestListner.class)
public class RegisterMemberPageTest extends TestBase {
	//Class Object
	LoginPage loginpage;
	RegisterPage resisterpage;
	
	public RegisterMemberPageTest() {
		super();	
	}
	@BeforeMethod
	public void setupTest() throws IOException
	{   
		resisterpage = new RegisterPage();	
	}
	
	@Test(priority=1,groups="Regression")
	public void verifyRegisterMemberlink() throws Exception {
		LoginPage.regpage();
		Assert.assertEquals(getTitle(), "JavaByKiran | Registration Page");
		Reports.test=Reports.extent.createTest("verifyRegisterMemberlink", "This test case validate to check Register a new Membership link");
	}
	@Test(priority=2,groups="Regression")
	public void verifyTitle() throws Exception{
		Assert.assertEquals(getTitle(), "JavaByKiran | Registration Page");
		Reports.test=Reports.extent.createTest("VerifyTitle", "This test case validate to check Title of Register a new Membership link");
	}
	@Test(priority=3,groups="Regression")
	public void verifyPlaceholderName() throws Exception{
		Assert.assertEquals(getValue(RegisterPage.getPlaceholderName(), "placeholder"), "Name");
		Reports.test=Reports.extent.createTest("verifyPlaceholderName", "This test case validate to check Placeholder of Name on registeration page");
	}
	@Test(priority=4,groups="Regression")
	public void verifyPlaceholderMobile() throws Exception{
		Assert.assertEquals(getValue(RegisterPage.getPlaceholderMobile(), "placeholder"), "Mobile");
		Reports.test=Reports.extent.createTest("verifyPlaceholderMobile", "This test case validate to check Placeholder of Mobile on registeration page");	
	}
	@Test(priority=5,groups="Regression")
	public void verifyPlaceholderEmail() throws Exception{
		Assert.assertEquals(getValue(RegisterPage.getPlaceholderEmail(), "placeholder"), "Email");
		Reports.test=Reports.extent.createTest("verifyPlaceholderEmail", "This test case validate to check Placeholder of Email on registeration page");
	}
	@Test(priority=6,groups="Regression")
	public void verifyPlaceholderPassword() throws Exception{
		Assert.assertEquals(getValue(RegisterPage.getPlaceholderPassword(), "placeholder"), "Password");
		Reports.test=Reports.extent.createTest("verifyPlaceholderEmail", "This test case validate to check Placeholder of Email on registeration page");	
	}
	@Test(priority=7,groups="Regression",dataProviderClass=StaticDataProvider.class,dataProvider = "d_Register")
	public void verifyRegisterMemberValidinfo(String tcId, String tcDescription,String name,String mobile,String eamil, String pwd,String expResult) throws Exception {
		clear(RegisterPage.getPlaceholderName());
		RegisterPage.getPlaceholderName().sendKeys(name);
		//sendKeys(RegisterPage.getPlaceholderName(),name,"Enter Name Address");
		
		clear(RegisterPage.getPlaceholderMobile());
		RegisterPage.getPlaceholderMobile().sendKeys(mobile);
		//sendKeys(RegisterPage.getPlaceholderMobile(),mobile,"Enter Mobile Address");
	
		clear(RegisterPage.getPlaceholderEmail());
		RegisterPage.getPlaceholderEmail().sendKeys(eamil);
		//sendKeys(RegisterPage.getPlaceholderEmail(),eamil,"Enter Email Address");
	
		clear(RegisterPage.getPlaceholderPassword());
		RegisterPage.getPlaceholderPassword().sendKeys(pwd);
		//sendKeys(RegisterPage.getPlaceholderPassword(), pwd,"Enter password Address");
		click(RegisterPage.getBtn_signin());
		try {
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = driver.switchTo().alert();
		    System.out.println(alert.getText());
		    alert.accept();
		    Assert.assertTrue(alert.getText().contains(expResult));
		} catch (Exception e) {
		    //exception handling
		}

		Reports.test=Reports.extent.createTest("verifyRegisterMemberValidinfo", "This test case validate to check Register Member functionality with Validinfo");
	}

	@Test(priority=8,groups="Regression")
	public void verifyAlreadyMembershipLink(){
		System.out.println("verifyAlreadyMembershipLink===>>out");
		RegisterPage.getClick_AlreadyMembership().click();
		Reports.test=Reports.extent.createTest("verify_RegisterMember_Validinfo", "This test case validate to check Register Member functionality with Validinfo");
	}
}


