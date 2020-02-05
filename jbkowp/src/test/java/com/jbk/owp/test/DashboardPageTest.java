package com.jbk.owp.test;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.page.DashboardPagee;
import com.jbk.owu.page.LoginPage;
import com.jbk.owu.page.RegisterPage;
import com.jbk.owu.util.Reports;
import com.jbk.owu.util.Retry;
import com.jbk.owu.util.TestNgListener;


public class DashboardPageTest extends TestBase {
 
	RegisterPage Resisterpage;
	LoginPage loginpage;
	DashboardPagee Dashboardpage;

	@BeforeMethod
	public void setupTest() throws IOException
	{
		DashboardPagee dp= new DashboardPagee();
	}
	@Test(priority=1,groups="Regression",retryAnalyzer = Retry.class)
	public void CheckMainNavigationText() {
		Assert.assertEquals(DashboardPagee.mainnavigationtext().getText(), "MAIN NAVIGATION");
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "Main Navigation Speeling Chec");
		Reports.test.log(Status.INFO,"Main Navigation Speeling Check");
	}	  	  

	@Test(priority=2,groups="Regression",retryAnalyzer = Retry.class)
	public void Dashboard_Main_Heading_Text_Check() {
		Assert.assertEquals(DashboardPagee.dashboardmainheading().getText(), "Dashboard Courses Offered");
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=3,groups="Regression",retryAnalyzer = Retry.class)
	public void user_Navigation_spell_Check() {
		Assert.assertEquals(DashboardPagee.usernavigationtext().getText(), "Users");
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=4,groups="Regression",retryAnalyzer = Retry.class)
	public void oprators_Navigation_spell_Check() {
		Assert.assertEquals(DashboardPagee.operatorsnavigationtext().getText(), "Operators");
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=5,groups="Regression",retryAnalyzer = Retry.class)
	public void  useful_Links_spell_Check() {
		Assert.assertEquals(DashboardPagee.usefullinksnavigationtext().getText(), "Useful Links");
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");;
	}

	@Test(priority=6,groups="Regression",retryAnalyzer = Retry.class)
	public void  downloads_Navigation_Spelling_Check() {
		Assert.assertEquals(DashboardPagee.downloadsnavigationtext().getText(), "Downloads");
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=7,groups="Regression",retryAnalyzer = Retry.class)
	public void  logout_Navigation_Spelling_Check() {
		Assert.assertEquals(DashboardPagee.logoutnavigationtext().getText(), "Logout");
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=8,groups="Regression",retryAnalyzer = Retry.class)
	public void Dashboard_Navigation_link_Check() {
		String elink="file:///E:/Offline%20Website/pages/examples/dashboard.html";
		try
		{
			Assert.assertEquals(DashboardPagee.dashboardnavigationlink(), elink);
			Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
		}catch(Exception e)
		{
			System.out.println("Dashboard navigation link changed...");
		}
	}
	@Test(priority=9,groups="Regression",retryAnalyzer = Retry.class)
	public void user_Navigation_link_Check() {
		String elink="file:///E:/Offline%20Website/pages/examples/users.html";
		try
		{
			Assert.assertEquals(DashboardPagee.usernavigationlink(), elink);
			Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
		}catch(Exception e)
		{
			System.out.println("user navigation link changed...");
		}
	}

	@Test(priority=10,groups="Regression",retryAnalyzer = Retry.class)
	public void oprators_Navigation_link_Check() {
		String elink="file:///E:/Offline%20Website/pages/examples/operators.html";
		try
		{
			Assert.assertEquals(DashboardPagee.operatorsnavigationlink(), elink);
			Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
		}catch(Exception e)
		{
			System.out.println("operators navigation link changed...");
		}
	}

	@Test(priority=11,groups="Regression",retryAnalyzer = Retry.class)
	public void  usefulLinks_navigation_link_Check() {
		String elink="file:///E:/Offline%20Website/pages/examples/links.html";
		try
		{
			Assert.assertEquals(DashboardPagee.usefullinksnavigationlink(), elink);
			Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
		}catch(Exception e)
		{
			System.out.println("useful links navigation link changed...");
		}
	}

	@Test(priority=12,groups="Regression",retryAnalyzer = Retry.class)
	public void  downloads_Navigation_link_Check() {
		String elink="file:///E:/Offline%20Website/pages/examples/downloads.html";
		try
		{
			Assert.assertEquals(DashboardPagee.downloadsnavigationlink(), elink);
			Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
		}catch(Exception e)
		{
			System.out.println("Ddownlaods navigation link changed...");
		}
	}

	@Test(priority=13,groups="Regression",retryAnalyzer = Retry.class)
	public void sidebar_Menu_Navigations_Count()
	{
		System.out.println("Sidebar menu Navigations count to be implemented.....");	
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=14,groups="Regression",retryAnalyzer = Retry.class)
	public void User_Navigation_isdisplayed_Check() {
		Assert.assertEquals(DashboardPagee.usefullinksnavigationisdisplyed(), true);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}


	@Test(priority=15,groups="Regression",retryAnalyzer = Retry.class)
	public void operators_Navigation_isdisplayed() {
		//boolean evalue=true;
		Assert.assertEquals(DashboardPagee.operatorsnavigationisdisplyed(), true);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=16,groups="Regression",retryAnalyzer = Retry.class)
	public void usefullinks_Navaigation_isdisplayed() {
		Assert.assertEquals(DashboardPagee.usefullinksnavigationisdisplyed(), true);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=17,groups="Regression",retryAnalyzer = Retry.class)
	public void downloads_navigation_isdisplayed() {
		Assert.assertEquals(DashboardPagee.downloadsnavigationisdisplyed(), true);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=18,groups="Regression",retryAnalyzer = Retry.class)
	public void logouttabisdisplayed() {
		//boolean evalue=true;
		Assert.assertEquals(DashboardPagee.logoutnavigationisdiplyed(), true);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=19,groups="Regression",retryAnalyzer = Retry.class)
	public void moveover_Dashboard_Bgcolor()
	{
		Actions builder=new Actions(driver);
		Action moveoveruserlink=builder.moveToElement(DashboardPagee.dashboard_link).build();
		moveoveruserlink.perform();
		String ebgcolor="rgba(30, 40, 44, 1)";
		String abgcolor=DashboardPagee.dashboard_link.getCssValue("background-color");
		Assert.assertEquals(abgcolor,abgcolor);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=20,groups="Regression",retryAnalyzer = Retry.class)
	public void moveover_User_Bgcolor()
	{
		Actions builder=new Actions(driver);
		Action moveoveruserlink=builder.moveToElement(DashboardPagee.user_link).build();
		moveoveruserlink.perform();
		String ebgcolor="rgba(30, 40, 44, 1)";
		String abgcolor=DashboardPagee.user_link.getCssValue("background-color");
		Assert.assertEquals(abgcolor, ebgcolor);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}


	@Test(priority=21,groups="Regression",retryAnalyzer = Retry.class)
	public void moveover_Oprators_Bgcolor()
	{
		Actions builder=new Actions(driver);
		Action moveoveruserlink=builder.moveToElement(DashboardPagee.oprators_link).build();
		moveoveruserlink.perform();
		String ebgcolor="rgba(30, 40, 44, 1)";
		String abgcolor=DashboardPagee.oprators_link.getCssValue("background-color");
		Assert.assertEquals(abgcolor, ebgcolor);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");		 	
	}


	@Test(priority=22,groups="Regression",retryAnalyzer = Retry.class)
	public void moveover_UsefulLinks_Bgcolor()
	{
		Actions builder=new Actions(driver);
		Action moveoveruserlink=builder.moveToElement(DashboardPagee.useful_links_link).build();
		moveoveruserlink.perform();
		String ebgcolor="rgba(30, 40, 44, 1)";
		String abgcolor=DashboardPagee.useful_links_link.getCssValue("background-color");
		Assert.assertEquals(abgcolor, ebgcolor);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading"); 	
	}

	@Test(priority=23,groups="Regression",retryAnalyzer = Retry.class)
	public void moveover_downloads_Bgcolor()
	{
		Actions builder=new Actions(driver);
		Action moveoveruserlink=builder.moveToElement(DashboardPagee.downloads_link).build();
		moveoveruserlink.perform();
		String ebgcolor="rgba(30, 40, 44, 1)";
		String abgcolor=DashboardPagee.downloads_link.getCssValue("background-color");
		Assert.assertEquals(abgcolor, ebgcolor);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");	
	}

	@Test(priority=24,groups="Regression",retryAnalyzer = Retry.class)
	public void moveover_Logout_Bgcolor()
	{
		Actions builder=new Actions(driver);
		Action moveoveruserlink=builder.moveToElement(DashboardPagee.logout_link).build();
		moveoveruserlink.perform();
		String ebgcolor="rgba(0, 0, 0, 0.1)";
		String abgcolor=DashboardPagee.logout_link.getCssValue("background-color");
		Assert.assertEquals(abgcolor, ebgcolor);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=25,groups="Regression",retryAnalyzer = Retry.class)
	public void jbk_Main_Heading_Spell_check()
	{
		String etext="Java By Kiran";	
		Assert.assertEquals(DashboardPagee.jbkmainlogoheading(), etext);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=26,groups="Regression",retryAnalyzer = Retry.class)
	public void jbk_subHeading_link()
	{
		String aurl=DashboardPagee.jbksubheadinglink();
		String eurl="file:///E:/Offline%20Website/pages/examples/dashboard.html";	
		Assert.assertEquals(aurl, eurl);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=27,groups="Regression",retryAnalyzer = Retry.class)
	public void jbk_text_logo_isdisplayed()
	{
		Assert.assertEquals(DashboardPagee.jbktextlogoisdisplayed(), true);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=28,groups="Regression",retryAnalyzer = Retry.class)
	public void user_img_isdisplayed()
	{
		Assert.assertEquals(DashboardPagee.userimgisdisplyed(), true);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=29,groups="Regression",retryAnalyzer = Retry.class)
	public void dashboard_Main_Heading_Spell()
	{
		String evalue="Dashboard Courses Offered";	
		Assert.assertEquals(DashboardPagee.dashboardmainheading().getText(), evalue);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=30,groups="Regression",retryAnalyzer = Retry.class)
	public void dashboard_Fotter_Spell()
	{
		String evalue="Copyright © 2005-2019 JavaByKiran.";	
		Assert.assertEquals(DashboardPagee.dashboard_fottor_text(), evalue);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=31,groups="Regression",retryAnalyzer = Retry.class)
	public void pullright_Heading_spell()
	{
		String evalue="Design for Selenium Automation Test V 2.3.0";	
		Assert.assertEquals(DashboardPagee.pullrightfottortext(), evalue);
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=32,groups="Regression",retryAnalyzer = Retry.class)
	public void selenium_Course_Spell()
	{
		Assert.assertEquals(DashboardPagee.seleniumcoursetext(),"Selenium");
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=33,groups="Regression",retryAnalyzer = Retry.class)
	public void automationtest_spell()
	{
		Assert.assertEquals(DashboardPagee.automationtesttext(), "Automation Testing");
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spel");
	}
	
	@Test(priority=34,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyUserLink() throws Exception{
    System.out.println("tstcase 1 >>>verifyUserLink");
		try {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			DashboardPagee.usernavigationtext().click();
			String actResult =driver.getTitle();
			String expResult = "JavaByKiran | User";
			Reports.test=Reports.extent.createTest("verifyUserLink", "This test case validate to check User link from leftnavigation");
			Assert.assertEquals(actResult, expResult);
		} catch (NoSuchElementException e) {
			System.out.println("Page not found >>> It is a error ");
		}
			
	}	
	@Test(priority=35,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyOperatorslink() {
		System.out.println("tstcase 2 >>>verifyOperatorslink");
		try {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			DashboardPagee.operatorsnavigationtext().click();
			String actResult =driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
			String expResult = "Operators";
			Reports.test=Reports.extent.createTest("verifyOperatorslink", "This test case validate to check Operators link from leftnavigation");
			Assert.assertEquals(actResult, expResult);	
		} catch (NoSuchElementException e) {
			System.out.println("Page not found");
		}
		System.out.println("==========================");
	}
	@Test(priority=36,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyUsefulLink(){
		System.out.println("tstcase 3 >>>verifyUsefulLink");
		DashboardPagee.usefullinksnavigationtext().click();
		String actResult =driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
		String expResult = "Useful Links";
		Reports.test=Reports.extent.createTest("verifyUsefullink", "This test case validate to check Useful link from leftnavigation");
		Assert.assertEquals(actResult, expResult);
		System.out.println("==========================");
	}
	@Test(priority=37,groups="Regression",retryAnalyzer = Retry.class)
	public void verifyDownloadLink() throws InterruptedException{
		System.out.println("tstcase 4 >>>verifyDownloadLink");
		DashboardPagee.downloadsnavigationtext().click();
		driver.findElement(By.xpath("//ul[@class='sidebar-menu']//*[.='Downloads']")).click();
		String actResult =driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
		String expResult = "Downloads";
		Reports.test=Reports.extent.createTest("verifyDownloadlink", "This test case validate to check Download link from leftnavigation");
		Assert.assertEquals(actResult, expResult);
		System.out.println("==========================");
	}
}
