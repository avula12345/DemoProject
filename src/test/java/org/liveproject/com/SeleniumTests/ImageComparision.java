package org.liveproject.com.SeleniumTests;

import org.liveproject.com.SeleniumAutomation.IPNWebPage;
import org.testng.annotations.Test;

public class ImageComparision extends IPNWebPage {

	String file1 = "C:\\Users\\ravula\\Desktop\\IUSWidgetTesting\\loadPayLinkBusinessLogo_1.png";
	String file2 = "C:\\Users\\ravula\\Desktop\\IUSWidgetTesting\\secureLock.png";


	public ImageComparision() {
		super(driver);
	}
	

	@Test()
    public void sanity01_InvalidSignIn() throws Exception {

		// Test case variables
		boolean res;
		
		res = CompareImages(file1,file2);
		System.out.println(res);
			
	
    }

}
