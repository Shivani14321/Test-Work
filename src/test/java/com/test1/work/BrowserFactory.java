package com.test1.work;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	
	public static WebDriver startApp(WebDriver driver, String Browser, String appURL) {
		
		if(Browser.equals("Chrome")){
			 driver= new ChromeDriver();
		}
		else if(Browser.equals("Firefox")){
			 driver= new FirefoxDriver();
		}
		else {
			System.out.println("We dont support this Browser" +Browser);
		}
		sleep(2000);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		 return driver;
	}
	
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
	private static void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}}
