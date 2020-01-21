package com.jbk.owu.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jbk.owp.base.TestBase;
public class Reports extends TestBase {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
    public static String reportPath = currentDir + "\\Reports\\" +"_OWUReport"+timeStamp;
   // private static String path = currentDir + "\\Reports\\" + timeStamp +"\\_OWUReport\\Screenshots\\";
   
	public static void startReport()
	{
			htmlReporter = new ExtentHtmlReporter(reportPath);
			//initialize ExtentReports and attach the HtmlReporter
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			//To add system or environment info by using the setSystemInfo method.
			extent.setSystemInfo("Browser", browser);
			extent.setSystemInfo("Environment", environment);
			extent.setSystemInfo("Project Name",projectName);
			extent.setSystemInfo("Suite", suite);

			//configuration items to change the look and feel
			//add content, manage tests etc
			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("JBK Extent Report ");
			htmlReporter.config().setReportName("Test Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
	}
	
//	public static void infoTest(String caseNo, String Description) throws Exception
//	{
//		String testResult = "Case No : " + caseNo + " &nbsp; <br /> &nbsp; Description : " + Description.substring(0, Math.min(Description.length(), 60)) + "...";
//		test.info(MarkupHelper.createLabel(testResult, ExtentColor.BLUE));
//	}
//	
//	public static void passTest(String object) throws Exception
//	{
//		test.pass(object);
//	}
//
//	public static void failTest(String object) throws Exception
//	{
//		String path = currentDir + "\\Reports\\" + timeStamp +"_OWPReport\\Screenshots\\" + object;
//		String screenshotPath = Screenshot.getScreenshot(driver, path);
//		test.fail("Fail " + object);
//		test.addScreenCaptureFromPath(screenshotPath);
//	}

}
