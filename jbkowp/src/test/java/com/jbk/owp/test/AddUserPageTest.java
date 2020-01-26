package com.jbk.owp.test;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.util.Reports;
import com.jbk.owu.page.DashboardPagee;
import com.jbk.owu.page.RegisterPage;
import com.jbk.owu.page.UserPage;
import com.jbk.owu.page.LoginPage;
public class AddUserPageTest extends TestBase {

	RegisterPage Resisterpage;
	DashboardPagee DashboardPage;
	

	@BeforeMethod
	public void setupTest() throws IOException
	{
		UserPage dp= new UserPage();
		PageFactory.initElements(driver, UserPage.class);
	}
	
//	@Test(priority=1)
//	public void loginToDashboard() throws Exception{
//		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("kiran@gmail.com");
//		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
//		driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
//	}
	
	@Test(priority=10)
	public void Click_onUser() throws Exception{
		//click(UserPage.getLink_User());
		driver.findElement(By.xpath("//a[@href='users.html']")).click();
	}	
	@Test(priority=11)
	public void Click_On_AddUser_Btn() throws Exception{
		//click(UserPage.getBtn_Adduser());
		driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary btn-sm pull-right']")).click();
		
	}	
	@Test(priority=12)
	public void Fill_Form() throws Exception{
		Reports.test=Reports.extent.createTest("verifyAdduserB", "This test case validate to check add user functionality with blnk info");
		clear(UserPage.getTxt_Username());
		sendKeys(UserPage.getTxt_Username(),"username");
		clear(UserPage.getTxt_Mobile());
		sendKeys(UserPage.getTxt_Mobile(),"8547562541");
		clear(UserPage.getTxt_Email());
		sendKeys(UserPage.getTxt_Email(),"email@gmail.com");
		Thread.sleep(2000);
		clear(UserPage.getTxt_Course());
		sendKeys(UserPage.getTxt_Course(),"selenium");
		click(UserPage.getBtn_radios_Female());
		Thread.sleep(2000);
		WebElement we = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select"));
		Select s = new Select(we);
		s.selectByVisibleText("Maharashtra");
		clear(UserPage.getTxt_Password());
		sendKeys(UserPage.getTxt_Password(),"123456");
		click(UserPage.getBtn_Submit());
		@SuppressWarnings("unused")
		Alert alt2 = driver.switchTo().alert();
		Thread.sleep(100);
		System.out.println(driver.switchTo().alert().getText());
    	driver.switchTo().alert().accept();
		
	}

	}
