package com.test1.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;


public class helper {
//keeping this method static so that we can directly call it using class name without creating an object for this
	public static void captureScreenshot(WebDriver driver) {
		//TakesScreenshot is interface with method getScreenshotAs which will return object as FILE type
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler class having method copy(to, from). new file because this should be in File format
		try {
			FileHandler.copy(src, new File("./ScreenShots/" + getCurrentDateTime() + ".png"));
		} catch (IOException e) {
          System.out.println("Unable to capture Screenshot" +e.getMessage());		}
		
	}
	//to create a timestamp method so that we can store multiple SSs and it wont overwrite.
			public static String getCurrentDateTime() {
				
				//SimpleDateformat is inbuilt class for current timestamp and DateFormat is parent class of SimpleDateFormat, so created an object of 
				//Datefomat class below
				DateFormat customformat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss") ;				
				
		//Inbuilt Date class object
				Date currentdate=new Date();
				return customformat.format(currentdate);
				
			}
	
	public void toHandleAlert() {
		
	}
	
	public void toHandleWindows() {
		
	}
}
