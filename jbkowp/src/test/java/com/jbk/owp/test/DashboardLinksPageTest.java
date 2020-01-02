package com.jbk.owp.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jbk.owp.base.TestBase;


public class DashboardLinksPageTest extends TestBase{

	@Test(priority =1)
	public void verifyUserLink() throws InterruptedException{
    System.out.println("tstcase 1 >>>verifyUserLink");
		try {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			driver.findElement(By.xpath("//ul[@class='sidebar-menu']//*[.='Users']")).click();
			Thread.sleep(2000);
			String actResult =driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/h3")).getText();
			String expResult = "User List";
			logger = extend.createTest("verifyUserLink", "This test case validate to check User link from leftnavigation");
			Assert.assertEquals(actResult, expResult);
		} catch (NoSuchElementException e) {
			System.out.println("Page not found >>> It is a error ");
		}
		System.out.println("==========================");	
	}	
	@Test(priority =2)
	public void verifyOperatorslink() {
		System.out.println("tstcase 2 >>>verifyOperatorslink");
		try {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			driver.findElement(By.xpath("//ul[@class='sidebar-menu']//*[.='Operators']")).click();
			String actResult =driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
			String expResult = "Operators";
			logger = extend.createTest("verifyOperatorslink", "This test case validate to check Operators link from leftnavigation");
			Assert.assertEquals(actResult, expResult);	
		} catch (NoSuchElementException e) {
			System.out.println("Page not found");
		}
		System.out.println("==========================");
	}
	@Test(priority =3)
	public void verifyUsefulLink(){
		System.out.println("tstcase 3 >>>verifyUsefulLink");
		driver.findElement(By.xpath("//ul[@class='sidebar-menu']//*[.='     Useful Links']")).click();
		String actResult =driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
		String expResult = "Useful Links";
		logger = extend.createTest("verifyUsefullink", "This test case validate to check Userful link from leftnavigation");
		Assert.assertEquals(actResult, expResult);
		System.out.println("==========================");
	}
	@Test(priority =4)
	public void verifyDownloadLink() throws InterruptedException{
		System.out.println("tstcase 4 >>>verifyDownloadLink");
		driver.findElement(By.xpath("//ul[@class='sidebar-menu']//*[.='Downloads']")).click();
		Thread.sleep(2000);
		String actResult =driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
		String expResult = "Downloads";
		logger = extend.createTest("verifyDownloadlink", "This test case validate to check Download link from leftnavigation");
		Assert.assertEquals(actResult, expResult);
		System.out.println("==========================");
	}



}

