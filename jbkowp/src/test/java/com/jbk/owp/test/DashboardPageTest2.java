package com.jbk.owp.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jbk.owp.base.TestBase;
import com.jbk.owp.testHarness.DashboardSrc;

import com.jbk.owu.util.Reports;


public class DashboardPageTest2 extends TestBase {
	// Class objects
	DashboardSrc dashboard = new DashboardSrc();
	
	@Test(priority=1)
	public void CheckMainNavigationText() {
		dashboard.CheckMainNavigationText();
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "Main Navigation Speeling Chec");
	}	  	  
	@Test(priority=2)
	public void Dashboard_Main_Heading_Text_Check() {
		dashboard.Dashboard_Main_Heading_Text_Check();
		//Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}

	@Test(priority=3)
	public void user_Navigation_spell_Check() {
		dashboard.user_Navigation_spell_Check();
		Reports.test=Reports.extent.createTest("CheckMainNavigationText", "This test validate to check spell of heading");
	}
}
