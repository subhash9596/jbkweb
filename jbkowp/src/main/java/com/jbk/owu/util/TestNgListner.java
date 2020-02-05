package com.jbk.owu.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListner implements ITestListener {


	public void onTestStart(ITestResult result) {
		System.out.println("=====>Testing is Staring :: "+result.getName());	
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("=====>Testcase Suceessfully passed ::  "+result.getName());	
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("=====>Testcase Failed ::  "+result.getName());	
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("=====>Testcase Skipped ::  "+result.getName());	
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("=====>Testcase Failed Percentage ::  "+result.getName());
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ITestContext context) {
		System.out.println("=====>Testcase Finished ::  "+context.getName());	
	}
}
