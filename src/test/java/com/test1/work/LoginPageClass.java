package com.test1.work;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;


public class LoginPageClass {

	@FindBy(xpath="//*[@id='email']") WebElement uname;
	@FindBy(xpath="//*[@id='password']") WebElement pass;
	@FindBy(xpath="//button/div/div/div[.='Login']") WebElement loginButton;
	
	public void loginToQuora(String usernameofQuora,String passwordofQUora) {
		
		uname.sendKeys(usernameofQuora);
		pass.sendKeys(passwordofQUora);
		loginButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	  

}
