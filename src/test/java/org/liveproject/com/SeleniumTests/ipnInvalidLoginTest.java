package org.liveproject.com.SeleniumTests;

import java.util.concurrent.TimeUnit;

import org.liveproject.com.SeleniumAutomation.IPNWebPage;
import org.liveproject.com.pageObjects.HomePage1;
import org.liveproject.com.pageObjects.NewIUSSignInPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ipnInvalidLoginTest extends IPNWebPage {
	
	public ipnInvalidLoginTest() {
		super(driver);
	}

	// Page Objects
	HomePage1 myHomePage;
	NewIUSSignInPage newIUSSignInPage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		
		driver = new FirefoxDriver();
		driver.get("https://ipn.qa.intuit.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test()
    public void sanity01_InvalidSignIn() {

		// Test case variables
		boolean errorMessageStatus;
		String expValue = "Hmm. That didn't work.";
		String invalidUsername = "hello@gmail.com";
		String invalidPassword = "xyz45345345";
		
	     // Load Home page
		myHomePage = PageFactory.initElements(driver, 	HomePage1.class);
		
		myHomePage.clickSignIn();
		
	     // Load SignIn page
        newIUSSignInPage = PageFactory.initElements(driver, NewIUSSignInPage.class);
	
		newIUSSignInPage.SetUserName(invalidUsername);
		newIUSSignInPage.SetPassword(invalidPassword);
		newIUSSignInPage.clickSignin();

        // Validate Error Message
        errorMessageStatus = newIUSSignInPage.validateMessage(expValue);
        Assert.assertTrue(errorMessageStatus);

    }

}