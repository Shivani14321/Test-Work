package com.test1.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dropdownTest {

   @Test

   public void selectByList() {

         WebDriver driver = new ChromeDriver();

         driver.get("https://practice.expandtesting.com/dropdown");
         driver.manage().window().maximize();
 		sleep(2000);
 		System.out.println("Page is opened");

     WebElement Dropdown= driver.findElement(By.xpath("//a[@id='examples-dropdown']"));
      Dropdown.click();
     List <WebElement> options= driver.findElements(By.xpath("//*[@class='dropdown-menu show']"));
     //List <WebElement> options=  ((Select) Dropdown).getOptions();
     System.out.println("List created " + options);

     List<String> text = new ArrayList<String>();

     for(WebElement optionElement : options)
     {
    	 text.add(optionElement.getText());
     }
     System.out.println("ArrayList created " + text);

     // Creating a temp list to sort
     List<String> tempList = new ArrayList<String>();
     tempList.addAll(text);
      Collections.sort(tempList, Collections.reverseOrder());
     //Collections.sort(tempList);   //sort in ascending order
     
     System.out.println("Sorted List "+ tempList);
     //Assert.assertTrue(text.equals(tempList));
     boolean ifSortedAscending = text.equals(tempList);

     if(ifSortedAscending)
     {
         System.out.println("List is sorted");
     }
     else
         System.out.println("List is not sorted.");

     driver.quit();


     // for(int i=1; i<options.size(); i++) {
     // text.add(options.get(i).getText());
  //} 
      
   }


private void sleep(long m) {
	try {
		Thread.sleep(m);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}




