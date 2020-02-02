package com.jbk.owp.test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.owp.base.TestBase;
import com.jbk.owu.page.DashboardPagee;
import com.jbk.owu.page.LoginPage;
import com.jbk.owu.page.UsefulLinkPage;

public class UsefulLinksTest extends TestBase {
	UsefulLinkPage Usefullinkpage;
	DashboardPagee Dashboardpage;
	LoginPage loginpage;
	@BeforeMethod
	public void setupTest() throws IOException
	{
		Usefullinkpage = new UsefulLinkPage();
	}
//	@Test(priority=1)
//	public static void Login(){
//		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("kiran@gmail.com");
//		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
//		driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
//		driver.findElement(By.xpath("//ul/li/a[contains(@href,\"links.html\")]")).click();
//		//DashboardPagee.UsefulLinkPage();
//	}
	@Test(priority=2)
	public static void VerifySchedule() throws Exception{
		//DashboardPagee.UsefulLinkPage();
		driver.findElement(By.xpath("//ul/li/a[contains(@href,\"links.html\")]")).click();
		System.out.println(111);
		waitInvisibilityOf(UsefulLinkPage.getSchedulelink());
		UsefulLinkPage.getSchedulelink().click();
		System.out.println(2222);
	}
	@Test(priority=3)
	public static void VideoLactures() throws Exception{
		System.out.println(111);
		waitForElement(UsefulLinkPage.getVideo_Lactures(), 3);
		UsefulLinkPage.getVideo_Lactures().click();
		System.out.println(2222);
	}
	@Test(priority=4)
	public static void SeleniumInterview () throws Exception{
		System.out.println(111);
		waitForElement(UsefulLinkPage.getSelenium_Interview(), 3);
		UsefulLinkPage.getSelenium_Interview().click();
		System.out.println(2222);
	}
	@Test(priority=5)
	public static void JavaInterview() throws Exception{
		System.out.println(111);
		waitForElement(UsefulLinkPage.getJava_Interview(), 3);
		UsefulLinkPage.getJava_Interview().click();
		System.out.println(2222);	
	}
	@Test(priority=6)
	public static void Courses() throws Exception{
		System.out.println(111);
		waitForElement(UsefulLinkPage.getCourses(), 3);
		UsefulLinkPage.getCourses().click();
		System.out.println(2222);	
	}
}
