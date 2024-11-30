package testconfigdemo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class configReader {
	Properties pro;
	//constructor to read the config
   public configReader()  {

		File src=new File("./config/config.property");
			try {
				FileInputStream fis1= new FileInputStream(src);
				//property class to read the property file
				 pro=new Properties();
				
				pro.load(fis1);
			} catch (Exception e) {		
				System.out.println("exception is" +e.getMessage());
			} 
}

	public String gogglelogin() {
		String URLname= pro.getProperty("URL");
		return URLname;
	}
	
	//public String goggleXpath() {
		//WebElement Xpath=pro.getProperty("Googlesearchbox");
	
	
	
}
