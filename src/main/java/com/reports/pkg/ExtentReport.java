package com.reports.pkg;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	static ExtentReports extent;
	final static String filePath = "ExtentReport.html";
	static Map<Integer, ExtentTest> extentTestMap = new HashMap();

	public synchronized static ExtentReports getExtentReporter() {
		if (extent == null) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Appium Framework");
			spark.config().setReportName("Extent Report Demo");
			extent.attachReporter(spark);
		}
		return extent;
	}
	
	public static synchronized ExtentTest startTest(String testName, String dsc) {
		ExtentTest test = getExtentReporter().createTest(testName, dsc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
	}
	
	 public static synchronized ExtentTest getTest() {
	        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	    }
}
