package com.test1.work;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	
	ExtentSparkReporter  htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void startReport() {
		htmlReporter=new ExtentSparkReporter("./Reports/HtmlReport.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add environement details
		reports.setSystemInfo("OS","Windows 11");
		reports.setSystemInfo("User","Browser");
		reports.setSystemInfo("Browser","Chrome");
		
		//confirguration for reports to look presentable
		htmlReporter.config().setDocumentTitle("Extent Report for Project");
		htmlReporter.config().setReportName("Test Excution Report");
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}
	@Test
	public void launchBrowser() {
		
		test=reports.createTest("Launch Browser");
		Assert.assertTrue(true);  //test passed
	}

	@Test
	public void verifyTittle() {
		
		test=reports.createTest("Verify tittle");
		Assert.assertTrue(false);  //test failed
	}
	@Test
	public void verifyemail() {
		
		test=reports.createTest("Verify Email");
		throw new SkipException("Skipping the TC with exception..");
	}

	@AfterMethod
	public void getTestResult(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "FAILED", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "PASSED", ExtentColor.GREEN));	
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIPED", ExtentColor.BLUE));
		}
	}
	
	@AfterTest
	public void tearDown() {
		
		reports.flush();
	}
	
	
}
