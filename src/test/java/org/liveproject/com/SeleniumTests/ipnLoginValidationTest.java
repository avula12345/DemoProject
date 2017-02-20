package org.liveproject.com.SeleniumTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.liveproject.com.SeleniumAutomation.IPNWebPage;
import org.liveproject.com.pageObjects.HomePage1;
import org.liveproject.com.pageObjects.NewIUSSignInPage;
import org.liveproject.com.pageObjects.OverviewPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ipnLoginValidationTest extends IPNWebPage {
	
	public ipnLoginValidationTest() {
		super(driver);
	}
	
	// Page Objects
	HomePage1 myHomePage;
	NewIUSSignInPage newIUSSignInPage;
	OverviewPage overviewpage;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		
		driver = new FirefoxDriver();
		driver.get(IPNPropertyResolver().getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test()
    public void sanity01_InvalidSignIn() throws Exception {

		// Test case variables
		 
	     // Load Home page
		myHomePage = PageFactory.initElements(driver,HomePage1.class);
		
		myHomePage.clickSignIn();
		
	     // Load SignIn page
        newIUSSignInPage = PageFactory.initElements(driver, NewIUSSignInPage.class);
        
        System.out.println("User Name = " +IPNPropertyResolver().getProperty("username"));
        System.out.println("Password = " +IPNPropertyResolver().getProperty("password"));
        String Gmail_UserName = IPNPropertyResolver().getProperty("gmailusername");
        String Gmail_Password = IPNPropertyResolver().getProperty("gmailpassword");

        
		newIUSSignInPage.SetUserName(IPNPropertyResolver().getProperty("username"));
		newIUSSignInPage.SetPassword(IPNPropertyResolver().getProperty("password"));
		newIUSSignInPage.clickSignin();
		
		newIUSSignInPage.clickContinueButton();
		
		String code = readGmail(Gmail_UserName,Gmail_Password);
		System.out.println("Validation Code = " +code);
		
		
		newIUSSignInPage.setConfirmCode(code.trim());
		newIUSSignInPage.clickContinueButton1();
		
		 // Load Overview page
		overviewpage = PageFactory.initElements(driver, OverviewPage.class);
		
		Assert.assertTrue(overviewpage.getReqPaymentButton().isDisplayed());
				
    }

}