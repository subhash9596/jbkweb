	package com.jbk.owp.test;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.util.Reports;
//File InputStream - It is a class and using method read the any files ..
//workbook class - 
public class RegisterMemberPageTest extends TestBase {
	@Test(priority=1,groups="Regression")
	public void verifyRegisterMemberlink() {
		System.out.println("RegTest o1 >>> verifyRegisterMemberlink");
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		WebElement strText = driver.findElement(By.xpath("/html/body/div/div[1]/a/b"));
		String actText = strText.getText();
		String expText = "Java By Kiran";
		Reports.test=Reports.extent.createTest("verifyRegisterMemberlink", "This test case validate to check Register a new Membership link");
		Assert.assertEquals(actText, expText);
		System.out.println("------------------------------");
	}
	@Test(priority=2,groups="Regression")
	public void verifyHeading(){
		System.out.println("RegTest o2 >>>verifyHeading");
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Registration Page";
		Reports.test=Reports.extent.createTest("verifyHeading", "This test case validate to check Heading of Register a new Membership link");
		Assert.assertEquals(actTitle, expTitle);
		System.out.println("****************************************************");	
	}
	@Test(priority=3,groups="Regression")
	public void verifyPlaceholderName(){
		System.out.println(" RegTest o1 >>> verifyPlaceholderName");
		String atuName = driver.findElement(By.xpath("//*[@id='name']")).getAttribute("placeholder");
		String expName = "Name";
		Reports.test=Reports.extent.createTest("verifyPlaceholderName", "This test case validate to check Placeholder of Name on registeration page");
		Assert.assertEquals(atuName, expName);
	}
	@Test(priority=4,groups="Regression")
	public void verifyPlaceholderMobile(){
		System.out.println(" RegTest o4 >>> verifyPlaceholderMobile");
		String actMobileName = driver.findElement(By.xpath("//*[@id='mobile']")).getAttribute("placeholder");
		String expMobileName = "Mobile";
		Reports.test=Reports.extent.createTest("verifyPlaceholderMobile", "This test case validate to check Placeholder of Mobile on registeration page");
		Assert.assertEquals(actMobileName, expMobileName);
		
	}
	@Test(priority=5,groups="Regression")
	public void verifyPlaceholderEmail(){
		System.out.println(" RegTest o5 >>> verifyPlaceholderEmail");
		String actEmailName = driver.findElement(By.xpath("//*[@id='email']")).getAttribute("placeholder");
		String expEmailName = "Email";
		Reports.test=Reports.extent.createTest("verifyPlaceholderEmail", "This test case validate to check Placeholder of Email on registeration page");
		Assert.assertEquals(actEmailName, expEmailName);
	}
	@Test(priority=6,groups="Regression")
	public void verifyPlaceholderPassword(){
		System.out.println(" RegTest 06 >>> verifyPlaceholderPassword");
		String actPwdName = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("placeholder");
		String expPwdName = "Password";
		Reports.test=Reports.extent.createTest("verifyPlaceholderEmail", "This test case validate to check Placeholder of Email on registeration page");
		Assert.assertEquals(actPwdName, expPwdName);	
	}
	@Test(priority=7,groups="Regression")
	public void verifyRegistermemberBlankinfo(){
		WebElement setName = driver.findElement(By.xpath("//*[@id='name']"));
		setName.sendKeys("");
		String expName = "ab";
		Assert.assertNotEquals(setName, expName);
		WebElement actMoble = driver.findElement(By.xpath("//*[@id='mobile']"));
		actMoble.sendKeys("");
		String expMobile="87678888";
		Assert.assertNotEquals(actMoble, expMobile);
		WebElement actEmail = driver.findElement(By.xpath("//*[@id='email']"));
		actEmail.sendKeys("");
		String expEmail="singale@gmail.com";
		Assert.assertNotEquals(actEmail, expEmail);
		WebElement actPwd = driver.findElement(By.xpath("//*[@id='password']"));
		actMoble.sendKeys("");
		String expPwd="singale@gmail.com";
		Reports.test=Reports.extent.createTest("verifyRegistermemberBlankinfo", "This test case validate to check Register a new membership with blnkinfo");
		Assert.assertNotEquals(actPwd, expPwd);
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div/button")).click();
		String name = driver.findElement(By.xpath("//*[@id='name_error']")).getText();
		System.out.println(name);
		String mobile = driver.findElement(By.xpath("//*[@id='mobile_error']")).getText();
		System.out.println(mobile);
		String email = driver.findElement(By.xpath("//*[@id='email_error']")).getText();
		System.out.println(email);
		String password = driver.findElement(By.xpath("//*[@id='password_error']")).getText();
		System.out.println(password);	
		System.out.println("****************************************************");
	}
	
	@Test(priority=8,groups="Regrression")
	public void verifyErrorMessageRegistermember(){
		String actname = driver.findElement(By.xpath("//*[@id='name_error']")).getText();
		String ename = "Please enter Name.";
		Assert.assertEquals(actname, ename);
		String actmobile = driver.findElement(By.xpath("//*[@id='mobile_error']")).getText();
		String actename = "Please enter Mobile.";
		Assert.assertEquals(actmobile, actename);
		String actemail = driver.findElement(By.xpath("//*[@id='email_error']")).getText();
		String expEmal = "Please enter Email.";
		Assert.assertEquals(actemail, expEmal);
		String actpwd = driver.findElement(By.xpath("//*[@id='password_error']")).getText();
		String exppwd = "Please enter Password.";
		Reports.test=Reports.extent.createTest("verifyErrorMessageRegistermember", "This test case validate to check Error Message of Registermember");
		Assert.assertEquals(actpwd, exppwd);
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div/button")).click();
		System.out.println("****************************************************");
		
	}
	@Test(priority=9,groups="Regression")
	public void verifyRegisterMemberValidinfo() throws InterruptedException{
		WebElement setName = driver.findElement(By.xpath("//*[@id='name']"));
		setName.sendKeys("subhash");
		WebElement actMoble = driver.findElement(By.xpath("//*[@id='mobile']"));
		actMoble.sendKeys("87678888");
		WebElement actEmail = driver.findElement(By.xpath("//*[@id='email']"));
		actEmail.sendKeys("singale@gmail.com");
		WebElement actPwd = driver.findElement(By.xpath("//*[@id='password']"));
		actPwd.sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div/button")).click();
		Alert alt = driver.switchTo().alert();
		String actResult  = alt.getText();
		String expResult  = "User registered successfully.";
		Reports.test=Reports.extent.createTest("verifyRegisterMemberValidinfo", "This test case validate to check Register Member functionality with Validinfo");
		Assert.assertEquals(actResult, expResult);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();

	}
//	@Test(priority=10,groups="Regression")
//	public void verifyAlreadyMembershipLink() throws Exception{
//		System.out.println("verifyAlreadyMembershipLink===>>out");
//
//		  WebDriverWait wait = new WebDriverWait(driver, 15);
//		  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/a/h4")));
//		  String actText= element.getText();
//		  
//		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
//	     String actText=	driver.findElement(By.xpath("/html/body/div/div[1]/a/h4")).getText();
//	    String expText = "JAVA | SELENIUM | PYTHON";
//	    logger = extend.createTest("verifyAlreadyMembershipLink", "This test case validate to check Already Membership Link");
//	    Assert.assertEquals(actText, expText);
//	    
//	}
//	
	
}
