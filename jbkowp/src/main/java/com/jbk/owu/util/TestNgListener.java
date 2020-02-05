package com.jbk.owu.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("TestCase Started and TestCase detils are "+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TestCase Success and TestCase detils are "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("TestCases Failed and TestCase detils are "+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("TestCases Skippe and TestCase detils are "+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("TestCases Failed but within sucess percentate  detils are "+result.getName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("TestCases Start ====>> "+context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("TestCases Finish Time ====>> "+context.getName());
		System.out.println("Finish Time >>"+new java.util.Date());
		
	}


	
}
