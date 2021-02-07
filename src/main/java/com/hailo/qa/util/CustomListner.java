package com.hailo.qa.util;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hailo.qa.base.TestBase;

public class CustomListner extends TestBase implements ITestListener{
	
	private static Logger logger = Logger.getLogger(CustomListner.class.getName());

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//logger.info("==========Test Execution Started ===================");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//logger.info("==========Testcase passed ===================");
	}

	public void onTestFailure(ITestResult result) {
		
		//logger.info("==========Testcase failed ===================");

		System.out.println("Test Case FAILED");
		failed(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
