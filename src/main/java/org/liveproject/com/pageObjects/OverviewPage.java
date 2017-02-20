package org.liveproject.com.pageObjects;

import org.liveproject.com.SeleniumAutomation.IPNWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends IPNWebPage {

public OverviewPage(WebDriver driver)  {
		super(driver);
    }

	// Declaration of UI Elements
	
	
	@FindBy(name = "//*[@id='sidebar']/div/a[1]")
	private WebElement requestPayment;
	
	@FindBy(id = "//*[@id='sidebar']/div/a[2]")
	private WebElement sendPayment;
	
	@FindBy(xpath = "//a[@href='/paymentTransaction/myPayments']")
	private WebElement payments;
	
	public WebElement getReqPaymentButton() {
		return requestPayment;
	}
	
	public WebElement getSendPaymentButton() {
		return sendPayment;
	}
	
	public WebElement getPaymentsLink() {
		return payments;
	}
	
	public void clickPaymentsLink() {
		getPaymentsLink().click();
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
	
	

