package com.anb.library;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.anb.androidreference.Page_Helper;
import com.anb.utilities.PropReader;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;	



public class Base_Test   {
	
	private static Logger log = LogManager.getLogger(Page_Helper.class.getName());
	String folder_name;
	DateFormat df;


	public AndroidDriver<MobileElement> driver;
	
	public void setup() throws IOException {
		   System.out.println("Inside Before Class");
		    PropReader.GetInstance(); 
	        File app = new File(PropReader.getapkFilePath()); 
	        DesiredCapabilities cap = new DesiredCapabilities();	        
			cap.setCapability("deviceName", PropReader.getDeviceName());
			cap.setCapability("platformVersion", PropReader.getPlatformVersion());
			cap.setCapability("platformName", PropReader.getPlatformName());
			cap.setCapability("udid", PropReader.getUDID());
			cap.setCapability("app", app.getAbsolutePath());
			cap.setCapability("noReset",PropReader.getNoReset());
			driver = new AndroidDriver<MobileElement>(new URL(PropReader.getURL()), cap);	
		}
	
  

	public void logStatusFail(String description, String expected ,String actual ,String testStatus ) throws Exception {
		
		 folder_name="screenshot";
		 File f=driver.getScreenshotAs(OutputType.FILE);
		 df=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		 new File(folder_name).mkdir();
		 String file_name=df.format(new Date())+Page_Helper.class.getName()+".png";
		 FileHandler.copy(f, new File(folder_name + "/" + file_name));
		 System.out.println("Screenshot is Captured");
		 System.out.println(description);
		 System.out.println(expected);
		 System.out.println(actual);
		 System.out.println(testStatus);
		log.error("Status Failed : "+ description+ "~~~~" +actual+ "~~~~" +expected + "~~~~" +testStatus);
	}
		
		public void logStatusPass(String description, String expected ,String actual ,String testStatus) {
			System.out.println(description);
			System.out.println(expected);
			System.out.println(actual);
			System.out.println(testStatus);
			log.info("Status Passed  : "+ description+ "~~~~" +actual+ "~~~~" +expected + "~~~~" +testStatus);
		}
		
		@AfterTest
		public void tearDown() {
			driver.quit();
			
		}



		

}
