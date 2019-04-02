package com.qa.dtac.generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.dtac.base.AutomationConstants;


public class TestListener implements ITestListener
{

	//@Override
	public void onTestStart(ITestResult result)
	{	
		System.out.println("start test");
	}

	//@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("success");
	}

	//@Override
	public void onTestFailure(ITestResult result)//we can not call another method of screen shot coz driver is not
	{
		System.out.println("screenshot captured");
		Utility.getScreenShot(AutomationConstants.SNAP_PATH);

	}

	//@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("skipped");
    }

	//@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("failed but with percentage");
	}

	//@Override
	public void onStart(ITestContext context) 
	{
	}

	//@Override
	public void onFinish(ITestContext context)
	{
	System.out.println("finish the tests");
	}
}

