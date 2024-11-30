package com.test1.work;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.test1.utility.helper;

public class prePostCondition {
	public WebDriver driver;
	@BeforeClass
	public void setUp() {
		driver=BrowserFactory.startApp(driver, "Chrome", "https://www.quora.com/");
		System.out.println(driver.getTitle());	
	}
	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
	}

	
	@AfterMethod
	// provides information about the results of a test method execution.
	//It allows you to access details such as test status, start and end times, exception information, and more.
	public void captureSS(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
{
		helper.captureScreenshot(driver);
	}
		
}
}
