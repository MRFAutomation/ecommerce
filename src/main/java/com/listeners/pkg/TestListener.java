package com.listeners.pkg;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.base.pkg.EcomBaseTest;
import com.reports.pkg.ExtentReport;

public class TestListener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		EcomBaseTest baseTest = new EcomBaseTest();

		System.out.println("Failed test case is: " + result.getInstanceName());
		if (result.getThrowable() != null) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			result.getThrowable().printStackTrace(pw);
			System.out.println(sw.toString());
		}
		String imgPath = baseTest.takeScreenshotWithImgPath();

		ExtentReport.getTest().fail("Test case failed with exception: " + result.getThrowable(),
				MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
	}

//	public void onTestStart(ITestResult result) {
//		ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
//				.assignCategory("Chrome Version 98").assignAuthor("Rana Farhan");
//	}

	public void onTestSuccess(ITestResult result) {
		ExtentReport.getTest().log(Status.PASS, "Test passed");
	}

	public void onFinish(ITestContext context) {
		ExtentReport.getExtentReporter().flush();
	}

	public void onStart(ITestContext context) {
		ExtentReport.startTest(context.getName().toString(), context.toString());
	}

}
