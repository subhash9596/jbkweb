package com.jbk.owp.test;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbk.owp.base.TestBase;
import com.jbk.owu.page.DashboardPagee;
import com.jbk.owu.page.LoginPage;
import com.jbk.owu.page.UsefulLinkPage;
import com.jbk.owu.util.Reports;
import com.jbk.owu.util.Retry;
import com.jbk.owu.util.TestNgListner;
@Listeners(TestNgListner.class)
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
//		driver.findElement(By.xpath("//a[@href='links.html']")).click();
//		//DashboardPagee.UsefulLinkPage();
//	}
	@Test(priority=2,groups="Regression",retryAnalyzer = Retry.class)
	public static void VerifyScheduleTab() throws Exception{
		//DashboardPagee.usefulllink();
		driver.findElement(By.xpath("//a[@href='links.html']")).click();
		Reports.extent.createTest("VerifyScheduleTab", "This test case validate to check schedule tab");
		waitInvisibilityOf(UsefulLinkPage.getSchedulelink());
		String parent = driver.getWindowHandle();
		System.out.println("Parent-->"+parent);
		UsefulLinkPage.getSchedulelink().click();
		Thread.sleep(5000);
		Set<String> windows = driver.getWindowHandles();
		System.out.println("windows-->"+windows);
		int count =windows.size();
		System.out.println("count-->"+count);
		for(String child:windows){
			if(!parent.equalsIgnoreCase(child)){
				Thread.sleep(5000);
				driver.switchTo().window(child);
				String title = driver.getTitle();
				driver.close();
				System.out.println("Title of child window===>>"+title);	
				System.out.println("----------------------------------------");
			}
		}driver.switchTo().window(parent);
	}

	@Test(priority=3,groups="Regression",retryAnalyzer = Retry.class)
	public static void VideoLacturesTab() throws Exception{
		Reports.extent.createTest("VerifyVideoLecturesTab", "This test case validate to check video Lacture tab");
		waitForElement(UsefulLinkPage.getVideo_Lactures(), 3);
		String parent = driver.getWindowHandle();
		System.out.println("Parent Window Id ==>>>"+parent);
		UsefulLinkPage.getVideo_Lactures().click();
		Thread.sleep(5000);
		Set<String> allwindow = driver.getWindowHandles();
		int count =allwindow.size();
		System.out.println("Totle widow count video ===>"+count);
		for(String child:allwindow){
			System.out.println("Child Count ===>"+child);
			if(!parent.equalsIgnoreCase(child)){
				driver.switchTo().window(child);
				String title1 =driver.getTitle();
				System.out.println("Title of child window ======>> "+title1);
				driver.close();
				//	Assert.assertEquals(title, "Video Tutorial in Java, Python, Selenium - Java by Kiran");
				System.out.println("----------------------------------------");
			}
		}driver.switchTo().window(parent);
	}
	@Test(priority=4,groups="Regression",retryAnalyzer = Retry.class)
	public static void SeleniumInterview () throws Exception{
		Reports.extent.createTest("VerifySeleniumInterviewTab", "This test case validate to check selenium interview ");
		waitForElement(UsefulLinkPage.getSelenium_Interview(), 3);
		String parent = driver.getWindowHandle();
		System.out.println("Parent Window Id ==>>>"+parent);
		UsefulLinkPage.getSelenium_Interview().click();
		Thread.sleep(5000);
		Set<String> allwindow = driver.getWindowHandles();
		int count =allwindow.size();
		System.out.println("Totle widow count video ===>"+count);
		for(String child:allwindow){
			System.out.println("Child Count ===>"+child);
			if(!parent.equalsIgnoreCase(child)){
				driver.switchTo().window(child);
				String title1 =driver.getTitle();
				driver.close();
				System.out.println("Title of child window ======>> "+title1);
				//	Assert.assertEquals(title, "Video Tutorial in Java, Python, Selenium - Java by Kiran");
				System.out.println("----------------------------------------");
			}
		}driver.switchTo().window(parent);
	}

	@Test(priority=5,groups="Regression",retryAnalyzer = Retry.class)
	public static void JavaInterviewTab() throws Exception{
		Reports.extent.createTest("VerifyJavaInterviewTab", "This test case validate to check Java Interview tab");
	//	waitForElement(UsefulLinkPage.getJava_Interview(), 3);
		String parent = driver.getWindowHandle();
		System.out.println("Parent Window Id ==>>>"+parent);
		UsefulLinkPage.getJava_Interview().click();
		//Thread.sleep(5000);
		Set<String> allwindow = driver.getWindowHandles();
		int count =allwindow.size();
		System.out.println("Totle widow count video ===>"+count);
		for(String child:allwindow){
			System.out.println("Child Count ===>"+child);
			if(!parent.equalsIgnoreCase(child)){
				driver.switchTo().window(child);
				String title1 =driver.getTitle();
				driver.close();
				System.out.println("Title of child window ======>> "+title1);
				System.out.println("----------------------------------------");
			}
		}driver.switchTo().window(parent);
	}
	@Test(priority=6,groups="Regression",retryAnalyzer = Retry.class)
	public static void CoursesTab() throws Exception{
		Reports.extent.createTest("VerifyCoursesTab", "This test case validate to check courses tab");
		waitForElement(UsefulLinkPage.getCourses(), 3);
		String parent = driver.getWindowHandle();
		System.out.println("Parent Window Id ==>>>"+parent);
		UsefulLinkPage.getCourses().click();
		//Thread.sleep(5000);
		Set<String> allwindow = driver.getWindowHandles();
		int count =allwindow.size();
		System.out.println("Totle widow count video ===>"+count);
		for(String child:allwindow){
			System.out.println("Child Count ===>"+child);
			if(!parent.equalsIgnoreCase(child)){
				driver.switchTo().window(child);
				String title1 =driver.getTitle();
				driver.close();
				System.out.println("Title of child window ======>> "+title1);
				System.out.println("----------------------------------------");
			}
		}driver.switchTo().window(parent);
	}
	
	@Test(priority=7,groups="Regression",retryAnalyzer = Retry.class)
	public static void PlacemntTab() throws Exception{
		Reports.extent.createTest("VerifyPlacemntTab", "This test case validate to check placement tab");
		waitForElement(UsefulLinkPage.getPlacement(), 3);
		String parent = driver.getWindowHandle();
		System.out.println("Parent Window Id ==>>>"+parent);
		UsefulLinkPage.getPlacement().click();
		Set<String> allwindow = driver.getWindowHandles();
		int count =allwindow.size();
		System.out.println("Totle widow count video ===>"+count);
		for(String child:allwindow){
			System.out.println("Child Count ===>"+child);
			if(!parent.equalsIgnoreCase(child)){
				driver.switchTo().window(child);
				String title1 =driver.getTitle();
				driver.close();
				System.out.println("Title of child window ======>> "+title1);
				System.out.println("----------------------------------------");
			}
		}driver.switchTo().window(parent);
	}
		
	}

