package com.anb.library;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import com.anb.androidreference.Page_Elements.Attribute;
import com.anb.androidreference.Page_Elements.LocatorType;

import io.appium.java_client.MobileElement;

public class Operations extends Base_Test{
	
	
	MobileElement element;
	
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
	


}
