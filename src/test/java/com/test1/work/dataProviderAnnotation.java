package com.test1.work;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderAnnotation extends ExcelDataProvider{
	
	WebDriver driver=new ChromeDriver();
	
	@Test(dataProvider="provideKeyword")
	public void searchKeyword(String keyword) {
		driver.get("http://www.google.com");
        driver.manage().window().maximize();
        
        WebElement searchBox=driver.findElement(By.xpath("//*[@id='APjFqb']"));
		searchBox.sendKeys(keyword);
		//to hit enter
		searchBox.sendKeys(Keys.ENTER);
	}
	
	/*@DataProvider(name="provideKeyword")
	public Object[][] keywordMethod(){
		//create object for 2 rows and 1 column
		Object[][] searchData=new Object[2][1];
		searchData[0][0]= "Taj mahal";  //row=1
		searchData[1][0]= "Redfort";   //row-2 column-1
		return searchData;
	}*/
	
	@DataProvider(name="provideKeyword")
	public String[][] ExcelkeywordMethod(){
		//create object for 2 rows and 1 column
		String[][] searchData=new String[2][1];
		ExcelDataProvider excel=new ExcelDataProvider();
		searchData[0][0]=excel.getStringData("SearchKeyword", 0, 0);
		searchData[1][0]=excel.getStringData("SearchKeyword", 1, 0);
		System.out.println("data in excel" +searchData);
		return searchData;

	}
}
