package testconfigdemo;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class configUser  {
	
	@Test
	public void configTest() {
		
	configReader config=new configReader();
	
	WebDriver driver =new ChromeDriver();
	driver.get(config.gogglelogin());
	
	
	}

}
