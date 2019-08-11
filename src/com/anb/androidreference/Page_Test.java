package com.anb.androidreference;


import org.testng.annotations.Test;
public class Page_Test extends Page_Helper{

Page_Helper helper = new Page_Helper();
	
	@Test
	public void validateAndroidReferencePageElements() throws Exception {

		helper.setup();
		helper.android_Reference_Page_Elements();

	}
	
	
}
