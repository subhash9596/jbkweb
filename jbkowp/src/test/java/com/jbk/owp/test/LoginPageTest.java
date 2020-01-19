package com.jbk.owp.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.dataprovider.StaticDataProvider;
import com.jbk.owu.util.Reports;
public class LoginPageTest extends TestBase {

	@Test(priority=10,groups="Regression")
	public void verifyUrl() throws Exception{
		//Actual Result 
		System.out.println("Login Testcase 01 >> verifyUrl"); 
		String my_url = driver.getCurrentUrl();
		System.out.println("url of login page::"+my_url);
		String expected_url = "file:///E:/Offline%20Website/index.html";
		//logger=extend.createTest("verifyUrl", "This test case validate to check URL of offlien application");
		Reports.test=Reports.extent.createTest("verifyUrl", "This test case validate to check URL of offlien application");
		Assert.assertEquals(my_url, expected_url);
	}
	@Test(priority=11,groups="Regression")
	public void verifyApplicationTitle(){
		System.out.println("Login Testcase 02 >> verifyApplicationTitle");
		String my_title=driver.getTitle();
		System.out.println("Page Title of Login Page is:: "+my_title);
		String expected_title =  "JavaByKiran | Log in";
		Reports.test=Reports.extent.createTest("verifyApplicationTitle", "This test case validate to check Title of offline application");
		Assert.assertEquals(my_title, expected_title);
	}
	@Test(priority=12,groups="Regression")
	public void verifyTitle(){
		System.out.println("Login Testcase 03 >> verifyTitle");
		String my_title=driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();
		System.out.println("Titel of login page :: "+my_title);
		//Expected Result 
		String exp_title = "Java By subhash";
		Reports.test=Reports.extent.createTest("verifyTitle", "This test case validate to check text java by Kiran on login page ");
		Assert.assertEquals(my_title, exp_title);
		System.out.println("===================================");

	}
	@Test(priority=13,groups="Regression")
	public void verifyloginsesion(){
		System.out.println("Login Testcase 04 >> verifyloginsesion");
		String actStr = driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
		System.out.println("Start Your ssession ");
		String expStr = "Sign in to start your session";
		Reports.test=Reports.extent.createTest("verifyloginsesion", "This test case validate to check session message on login page");
		Assert.assertEquals(actStr, expStr);
		System.out.println("==================================");
	}
	@Test(priority=14,groups="Regression")
	public void verifyPlaceHolderUsername() {
		System.out.println("Login Testcase 05 >> verifyPlaceHolderUsername");
		String actUnPlace = driver.findElement(By.xpath("//*[@id='email']")).getAttribute("placeholder");
		System.out.println("Actueal Place holder of usernamen : ="+actUnPlace);
		//Expected Result : 
		String expUnPlace = "Email";
		Reports.test=Reports.extent.createTest("verifyPlaceHolderUsername", "This test case validate to check placeholder of username on login page");
		Assert.assertEquals(actUnPlace, expUnPlace);
		System.out.println("Test case fifth with Thread id : ="+Thread.currentThread().getId());
	}
	@Test(priority=15,groups="Regression")
	public void verifyPlaceHolderPassword() {
		System.out.println("Login Testcase 06 >> verifyPlaceHolderPassword");
		String actPwdPlace = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("placeholder");
		System.out.println("Actual Place holder of Password : ="+actPwdPlace);
		//Expected Result : 
		String expPwdPlace = "Password";
		Reports.test=Reports.extent.createTest("verifyPlaceHolderPassword", "This test case validate to check placeholder of password on login page");
		Assert.assertEquals(actPwdPlace, expPwdPlace);
	}	
	@Test(priority=16,groups="Regression")
	public void verifyButtoncolor() {
		System.out.println("Login Testcase 07 >> verifyButtoncolor");
		WebElement btnLogin=  driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
		System.out.println("Before Mouseover buttonr color is "+ btnLogin.getCssValue("background-color"));
		Actions act = new Actions(driver);
		act.moveToElement(btnLogin).build().perform();
		Reports.test=Reports.extent.createTest("check_Button_color", "This test case validate to check sign in button color  on login page");
		System.out.println("after mouse over button color"+ btnLogin.getCssValue("color"));
	}
	@Test(priority=17,groups="Regression")
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

//	@DataProvider
//	public Object[][] LoginData() throws EncryptedDocumentException, InvalidFormatException {
//		Object[][] testdata =ReadExcle.getDataFromXls("Login");
//		return testdata;
//	}	
	@Test(priority=18,groups="Regression",dataProviderClass=StaticDataProvider.class,dataProvider = "d_login")
	public void Login(String tcId, String tcDescription,String Username,String Password,String expResult) throws Exception{
		System.out.println("Test Case ID >>"+tcId);
		System.out.println("Test Case ID >>"+tcDescription);
		driver.findElement(By.xpath("//*[@id='email']")).clear();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();	
		

		if(tcDescription.equals("Withblankdinfo")){
			String actResult= driver.findElement(By.xpath("//*[@id='email_error']")).getText();
			Reports.test=Reports.extent.createTest("LoginwithBlankInfo", "This test case validate to check login functionality with Blank , invalid and valid info");
			Assert.assertEquals(actResult,expResult);
		}else if(tcDescription.equals("InvalidInfo")){
			String actResult1= driver.findElement(By.xpath("//*[@id='email_error']")).getText();
			Reports.test=Reports.extent.createTest("LoginwithInvalidInfo", "This test case validate to check login functionality with Blank , invalid and valid info");
			Assert.assertEquals(actResult1,expResult);
		}else if(tcDescription.equals("InvalidInfo")){
			WebElement text = driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1"));
			String acttx = text.getText();
			Reports.test=Reports.extent.createTest("LoginwithValidInfo", "This test case validate to check login functionality with Blank , invalid and valid info");
			Assert.assertEquals(acttx, expResult);
		}
	}
}

//		@DataProvider
//		public Object[][] login() {
//			return new Object[][] {
//				new Object[] { "TCJBK01", "BlankInfo","","","Please enter email." },
//				new Object[] { "TCJBK02", "InvalidInfo","abc","345","Please enter email as kiran@gmail.com"},
//				new Object[] { "TCJBK03", "ValidInfo","kiran@gmail.com","123456","Dashboard Courses Offered" },
//			};
//	}



