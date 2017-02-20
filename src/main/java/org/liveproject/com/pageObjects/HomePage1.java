
package org.liveproject.com.pageObjects;

import org.liveproject.com.SeleniumAutomation.IPNWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage1 extends IPNWebPage {

public HomePage1(WebDriver driver)  {
		super(driver);
    }

	// Declaration of UI Elements
	
	
	@FindBy(name = "signin")
	private WebElement signInButton;
	
	@FindBy(id = "signup")
	private WebElement signUp;
	
	
	
	public WebElement getSignUpButton() {
		return signUp;
	}
	
	public WebElement getSignInButton() {
		return signInButton;
	}
	
	public void clickSignIn() {
		signInButton.click();
	}
	
	/*
	@Override
	public List<WebElement> pageElementsToWait() {
		// TODO Auto-generated method stub
		List<WebElement> myElementList = new ArrayList<WebElement>();
		//myElementList.add(mockUserName);
		myElementList.add(signInButton);
		myElementList.add(signUp);
		//myElementList.add(forgotpwdLink);
		return myElementList;
	}

	@Override
	public String setPageName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	*/
	
	
		
	}
	
	

