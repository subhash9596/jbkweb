package com.jbk.owp.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.owp.base.TestBase;
import com.jbk.owu.page.CoursesOfferedPage;
import com.jbk.owu.page.DashboardPagee;
import com.jbk.owu.page.LoginPage;
import com.jbk.owu.page.UsefulLinkPage;
import com.jbk.owu.util.Reports;

public class CoursesOfferdTest extends TestBase {
	
	DashboardPagee Dashboardpage;
	LoginPage loginpage;
	CoursesOfferedPage CoursesOfferedpage;
	

	@BeforeMethod
	public void setup() throws IOException
	{
		CoursesOfferedPage cp = new CoursesOfferedPage();
	}
	
	@Test(priority=0)
	public void Login() throws Exception{
		Reports.extent.createTest("Login TEST CASE");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
		waitInvisibilityOf(CoursesOfferedPage.getSeleniumMoreInfo());
		driver.findElement(By.xpath("//a[href='../pdf/selenium-testing-syllabus-jbk.pdf']")).click();
}
}
