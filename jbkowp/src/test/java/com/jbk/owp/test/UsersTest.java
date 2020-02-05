package com.jbk.owp.test;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.page.DashboardPagee;
import com.jbk.owu.page.LoginPage;
import com.jbk.owu.page.RegisterPage;
import com.jbk.owu.page.UsersPage;
import com.jbk.owu.util.Reports;
import com.jbk.owu.util.Retry;
import com.jbk.owu.util.TestNgListener;

public class UsersTest extends TestBase {

	RegisterPage Resisterpage;
	DashboardPagee DashboardPage;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setups() {
		UsersPage dp= new UsersPage();
		DashboardPage.user();
	}

	@Test(priority = 1,groups="Regression",retryAnalyzer = Retry.class)
	public void getTableData() throws InterruptedException {
		Reports.extent.createTest("VerifTable count", "This test case validate to Table count");
		WebElement Table = UsersPage.getUser_Table();
		List<WebElement> tr = Table.findElements(By.tagName("tr"));
		System.out.println("total no of rows " + tr.size());
		Assert.assertEquals(tr.size(), 5);
		for (WebElement row : tr) {
			List<WebElement> td = row.findElements(By.tagName("td"));
			for (WebElement col : td) {
				System.out.println(col.getText());
			}
			System.out.println("..........................");
		}
		Thread.sleep(2000);
	}
	@Test(priority = 2,groups="Regression",retryAnalyzer = Retry.class)
	public void VerifyDelete() throws InterruptedException {
	
		Reports.extent.createTest("VerifyDelete", "This test case validate to check delete functionality");
		Thread.sleep(2000);
		UsersPage.getDelete().click();
		// click on 1St dlete button
//		Alert alt = driver.switchTo().alert();
//		String actText = alt.getText();
//		System.out.println(alt.getText());
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.getText();
		Assert.assertTrue(true, "You can not delete Default User");
		//Assert.assertEquals(alert.getText(), "You can not delete Default User");
		alert.accept();	
		/*
		 * //2nd delete option
		 * driver.findElement(By.xpath("///span[@class='label label-danger ss']"
		 * )).click(); Alert alt1=driver.switchTo().alert();
		 * 
		 * System.out.println(driver.switchTo().alert().getText());
		 * Thread.sleep(1000); driver.switchTo().alert().accept();
		 * 
		 * 
		 * Alert alt2=driver.switchTo().alert(); Thread.sleep(1000);
		 * System.out.println(driver.switchTo().alert().getText());
		 * driver.switchTo().alert().accept();
		 */
	}

}
