package com.anb.androidreference;

import io.appium.java_client.MobileElement;
import com.anb.androidreference.Page_Elements;
import com.anb.androidreference.Page_Elements.LocatorType;
import com.anb.library.Operations;

public class Page_Helper extends Operations {

	MobileElement element;
		
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
  

}
