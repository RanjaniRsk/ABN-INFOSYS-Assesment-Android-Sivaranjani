package com.anb.androidreference;


import org.testng.annotations.Test;

import com.anb.library.Base_Test;
public class Page_Test extends Base_Test{

Page_Helper helper = new Page_Helper();
	
	@Test
	public void validateAndroidReferencePageElements() throws Exception {
		helper.android_Reference_Page_Elements();

	}
	
	
}
