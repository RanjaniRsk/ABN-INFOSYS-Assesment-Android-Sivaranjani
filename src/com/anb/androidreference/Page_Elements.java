package com.anb.androidreference;


public class Page_Elements{
	  private static Page_Elements instance;
	  private static final Object lock = new Object();
	  String XPathString;
	
	 private Page_Elements() {
	    }

	    public static Page_Elements getPageInstance() {
	        if (instance == null) {
	            synchronized (lock) {
	                if (instance == null) {
	                    instance = new Page_Elements();
	                   
	                }
	            }
	        }
	        return instance;
	    }
	

public enum ElementType {
	TEXT("android.widget.TextView"), IMAGE("android.widget.ImageView");
	private String value;

	public String getValue() {
		return this.value;
	}

	private ElementType(String value) {
		this.value = value;
	}
}

public enum Attribute {
	ID("id"), TEXT("text"), NAME("name"), CONTENTDESC("content-desc");
	private String value;
	public String getValue() {
		return this.value;
	}
	private Attribute(String value) {
		this.value = value;
	}
}
public enum LocatorType {
	 	ID,XPATH,NAME
}


public static final String PAGE_HEADER_TXT ="ReferenceAndroid";
public static final String SETTINGS_ICONTXT ="More options";
public static final String SETTINGS_TXT ="Settings";
public static final String HELLO_WORLD_TXT ="Hello World!";
public static final String MAIL_ICON_ID ="com.abnamro.apps.referenceandroid:id/fab";
public static final String REPLACE_OWNACTION_TXT ="Replace with your own action";




public String getXPath_lbl_ByText(String value) {
	
	if(XPathString != null) {
		XPathString=null;
	}
	XPathString ="//"+ElementType.TEXT.getValue()+"[@"+Attribute.TEXT.getValue()+"=\'"+value+"\']";
	return XPathString;
	}

public String getXPath_lbl_ByImage(String value) {
	
	if(XPathString != null) {
		XPathString=null;
	}
	
	XPathString ="//"+ElementType.IMAGE.getValue()+"[@"+Attribute.CONTENTDESC.getValue()+"=\'"+value+"\']";
	
	return XPathString;
	
	
}
	
	
}


