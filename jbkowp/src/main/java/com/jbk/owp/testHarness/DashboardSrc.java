package com.jbk.owp.testHarness;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.jbk.owp.base.TestBase;
import com.jbk.owu.page.DashboardPagee;



public class DashboardSrc extends TestBase {
	
	public void CheckMainNavigationText() {
		System.out.println(101);
		PageFactory.initElements(driver, DashboardPagee.class);
		Assert.assertEquals(DashboardPagee.mainnavigationtext().getText(), "MAIN NAVIGATION");
		System.out.println(102);
	}	  	  

	
	public void Dashboard_Main_Heading_Text_Check() {
		System.out.println(103);
		Assert.assertEquals(DashboardPagee.dashboardmainheading().getText(), "Dashboard Courses Offered");
		System.out.println(104);
	}

	
	public void user_Navigation_spell_Check() {
		System.out.println(105);
		Assert.assertEquals(DashboardPagee.usernavigationtext().getText(), "Users");
		System.out.println(106);
		//Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}


}
