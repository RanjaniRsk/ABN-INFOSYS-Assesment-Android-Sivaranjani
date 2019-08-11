package com.anb.androidreference;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import com.anb.androidreference.Page_Elements;
import com.anb.androidreference.Page_Elements.Attribute;
import com.anb.androidreference.Page_Elements.LocatorType;
import com.anb.utilities.PropReader;

public class Page_Helper {

	MobileElement element;
	public AndroidDriver<MobileElement> driver;
	private static Logger log = LogManager.getLogger(Page_Helper.class.getName());
	String folder_name;
	DateFormat df;
	

public void setup() throws IOException {
		System.out.println("Inside Before Method");
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
	
	public MobileElement locateElement(String XPathString, LocatorType locateBy) {
		System.out.println("Locating Element " + XPathString);
		try {
			switch (locateBy) {
			case ID:
				element = driver.findElement(By.id(XPathString));
				break;
			case XPATH:
				element = driver.findElement(By.xpath(XPathString));
			default:
				break;
			}
			System.out.println("*************Element Located for XPathString " + XPathString);

		} catch (NoSuchElementException e) {
			if (element == null) {
				System.out.println("*************Unable to get element for XPathString " + XPathString);
			}

			e.printStackTrace();
		}
		return element;

	}

	
	public boolean getElementPresence(String XPathString, LocatorType locateBy) {
		boolean found = true;
		try {
			element = locateElement(XPathString,locateBy);
			if (null == element) {
				System.out.println( "*************Element is not available for XPathString :"+XPathString);
				found= false;

			}
		} catch (Exception e) {
			System.out.println("*************Element is not available for XPathString " + XPathString);
			found= false;	
					}
		return found;


	}

	public String getAttribute(String XPathString, LocatorType locateBy, Attribute attribute) {
		String value = null;

		try {
			element = locateElement(XPathString, locateBy);
			if (null == element) {
				System.out.println(
						Thread.currentThread().getName() + "*************Element is not available to fetch attribute ");
				return "";

			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName()
					+ "*************Element is not available to fetch attribute " + XPathString);
			return "";
		}

		if (attribute.toString() != null) {
			while (true) {
				try {
					value = element.getAttribute(attribute.toString());
					break;
				} catch (Exception e) {
					value = "";
				}
			}
		} else {
			System.out.println(
					Thread.currentThread().getName() + "*************No Matchinhg Attribute found  " + attribute.toString());
		}

		if (value == null) {
			value = "";
			System.out.println(
					Thread.currentThread().getName() + "*************Could not fetch value for the attribute ");
		}
		return value;

	}
	
	
	public void click(String XPathString, LocatorType locateBy) {


		try {
			element = locateElement(XPathString, locateBy);
			if (null == element) {
				System.out.println("*************Element is not available to Click ");
			}
			else {
				try {
					element.click();
					System.out.println("*************Element is Clicked ");
				}
				catch(Exception e) {
					System.out.println(
							Thread.currentThread().getName() + "*************Click Operation failed for XPathString :  "+XPathString);
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName()
					+ "*************Element is not available to Click " + XPathString);
		}

		
		return;

	
	}
	
	
	public boolean isNotNullAndNotEmpty(String value) {
		boolean result =false;
		try {
			if(null != value && !value.isEmpty()) {
				result =true;
			}
			}
		catch(Exception e) {
			e.printStackTrace();
			return result;
		}
		
		return result;
		
	}
	
	public void android_Reference_Page_Elements() throws Exception {

		if (getElementPresence(Page_Elements.getPageInstance().getXPath_lbl_ByText(Page_Elements.PAGE_HEADER_TXT),
				LocatorType.XPATH)) {
			logStatusPass("Validate Android Reference page display",
					"User should be displayed with Android Reference Page", "Android Reference is displayed properly",
					"Passed");

			if (getElementPresence(Page_Elements.getPageInstance().getXPath_lbl_ByImage(Page_Elements.SETTINGS_ICONTXT),
					LocatorType.XPATH)) {
				logStatusPass("Validate the Settings Icon", "Settings Icon Should be displayed",
						"Settings Icon button is displayed", "Passed");
				click(Page_Elements.getPageInstance().getXPath_lbl_ByImage(Page_Elements.SETTINGS_ICONTXT),
						LocatorType.XPATH);

				if (getElementPresence(Page_Elements.getPageInstance().getXPath_lbl_ByText(Page_Elements.SETTINGS_TXT),
						LocatorType.XPATH)) {
					logStatusPass("Validate if Setting is displayed tapping settings Icon",
							"Settings should be displayed on tapping settings icon",
							"Setting is displayed on tapping Settings Icon", "Passed");
				} else {
					logStatusFail("Validate if Setting is displayed tapping settings Icon",
							"Settings should be displayed on tapping settings icon",
							"Setting is not displayed on tapping Settings Icon", "Failed");
				}
			} else {
				logStatusFail("Validate the Settings Icon", "Settings Icon Should be displayed",
						"Settings Icon button is not displayed", "Failed");
			}
			Thread.sleep(5000);
			if (getElementPresence(Page_Elements.getPageInstance().getXPath_lbl_ByText(Page_Elements.HELLO_WORLD_TXT),
					LocatorType.XPATH)) {
				logStatusPass("Validate Hello World text", "Hello World text should be displayed",
						"Hello World text is displayed", "Passed");

			} else {
				logStatusFail("Validate Hello World text", "Hello World text should be displayed",
						"Hello World text is not displayed", "Failed");
			}
			if (getElementPresence(Page_Elements.MAIL_ICON_ID, LocatorType.ID)) {
				logStatusPass("Validate if MailBox Icon is displayed", "MailBox icon should be displayed",
						"MailBox icon is displayed", "Passed");
				click(Page_Elements.MAIL_ICON_ID, LocatorType.ID);
				if (getElementPresence(
						Page_Elements.getPageInstance().getXPath_lbl_ByText(Page_Elements.REPLACE_OWNACTION_TXT),
						LocatorType.XPATH)) {
					logStatusPass("Validate if Replace Own Action is displayed on tapping mailbox icon",
							"Replace your own action should be displayed", "Replace your own action is displayed",
							"Passed");

				} else {
					logStatusFail("Validate if Replace Own Action is displayed on tapping mailbox icon",
							"Replace your own action should be displayed", "Replace your own action is not displayed",
							"Failed");

				}
			} else {
				logStatusFail("Validate if MailBox Icon is displayed", "MailBox icon should be displayed",
						"MailBox icon is not displayed", "Failed");
			}

		} else {
			logStatusFail("Validate Android Reference page display ",
					"User should be displayed with Android Reference Page", "Android Reference is displayed", "Failed");

		}

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
	


	public void tearDown() {
		driver.quit();
		
	}	  

}
