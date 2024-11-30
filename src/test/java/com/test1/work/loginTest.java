package com.test1.work;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.test1.utility.helper;
//this page is example of abstraction
public class loginTest extends prePostCondition {	
	@Test
	public void loginApp() {
		
		
		ExcelDataProvider excel=new ExcelDataProvider();
		
		//PageFactory is inbuilt class having method initElement, LoginPageClass is page that we want to initialize,now it will initialize all
		//locators and return us the object of that same class, so loginpage is returned object of LoginPageClass.
		LoginPageClass loginpage=PageFactory.initElements(driver, LoginPageClass.class);
		//loginpage.loginToQuora("kksrishi@gmail.com","Rudraksha10#");
		loginpage.loginToQuora(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		//waituntil(ExpectedConditions.)
		//now we want to run this SS even if above method fails or pass, so declare 1 aftermethod in prepostconditionTest class for this
		helper.captureScreenshot(driver);
	}
	
}
