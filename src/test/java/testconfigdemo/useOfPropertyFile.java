package testconfigdemo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;
@Test
public class useOfPropertyFile {
	//it will throw all the exception within this method
	public void testConfig() throws Exception {
		File src=new File("./config/config.property");
		
		
			FileInputStream fis1= new FileInputStream(src);
			//property class to read the property file
			Properties pro=new Properties();
			
			pro.load(fis1);
			String URLvalue= pro.getProperty("URL");
			System.out.println("URL is" +URLvalue);
		
	}

}
