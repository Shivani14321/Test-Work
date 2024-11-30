package com.test1.work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

public class windowHandle {
public static void main(String[] args) {
// Initialize WebDriver
WebDriver driver = new ChromeDriver();

// Open a website
driver.get("https://example.com");

// Click on a button that opens a new window
driver.findElement(By.id("newWindowButton")).click();

// Get the handle of the main window
String mainWindowHandle = driver.getWindowHandle();

// Get the handles of all open windows
Set<String> allWindowHandles = driver.getWindowHandles();

// Iterate through the set of window handles
Iterator<String> iterator = allWindowHandles.iterator();
while (iterator.hasNext()) {
String childWindowHandle = iterator.next();
if (!mainWindowHandle.equals(childWindowHandle)) {
// Switch to the child window
driver.switchTo().window(childWindowHandle);

// Perform actions on the child window
WebElement textElement = driver.findElement(By.id("sampleHeading"));
System.out.println("The child window is "+childWindowHandle);
System.out.println("Text in child window: " + textElement.getText());

// Close the child window
driver.close();
}
}

// Switch back to the main window
driver.switchTo().window(mainWindowHandle);

// Close the main window
driver.quit();	

}}
