package org.liveproject.com.pageObjects;

import org.liveproject.com.SeleniumAutomation.IPNWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewIUSSignInPage extends IPNWebPage {
		
	public NewIUSSignInPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="ius-sign-in-header")
	private WebElement IUSsignInHeader;
	
	@FindBy(id="ius-userid")
	private WebElement Username;
	
	@FindBy(id="ius-password")
	private WebElement Password;
	
	@FindBy(id="ius-sign-in-submit-btn")
	private WebElement SignIn;
	
	@FindBy(id="ius-sign-in-error")
	private WebElement statusMessage;
	
	@FindBy(id="ius-mfa-options-submit-btn")
	private WebElement continueButton;
	
	@FindBy(id="ius-mfa-confirm-code")
	private WebElement confirmCodeTextField;
	
	@FindBy(id="ius-mfa-otp-submit-btn")
	private WebElement continueButton1;
	
	@FindBy(id="ius-mfa-option-email")
	private WebElement mfaEmailRadioButton;
	
	
	private WebElement Getusername()
	{
	return Username;
	}
	
	private WebElement Getpassword()
	{return Password;
	}
	
	public WebElement getStatusMessageElement() {
		return statusMessage;
	}
	
	public WebElement getContinueButton() {
		return continueButton;
	}
	
	public WebElement getConfirmCodeTextField() {
		return confirmCodeTextField;
	}
	
	public WebElement getMFAEmailRadioButton() {
		return mfaEmailRadioButton;
	}
	

	public void SetUserName(String username)
	
	{ 
		Getusername().clear();
		Getusername().sendKeys(username);	
	}
	
	
	public void SetPassword(String Pwd)
	
	{ 
		Getpassword().clear();
		Getpassword().sendKeys(Pwd);
	}
	
	
	
	public void clickSignin()
	{
		SignIn.click();
	}
	
	public void clickContinueButton()
	{
		getContinueButton().click();
	}
	
	public void clickContinueButton1()
	{
		continueButton1.click();
	}
	
	public void setConfirmCode(String code) {
		
		getConfirmCodeTextField().click();
		getConfirmCodeTextField().sendKeys(code);
	}
	
	public void clickMFAEmailRadioButton(){
		
		getMFAEmailRadioButton().click();	
	}
	
	
	public String getStatusMessage() {
		String msg = null;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(getStatusMessageElement().isEnabled()) {
				msg = statusMessage.getText();
		}		
			
		return msg;
		
	}
	
	public boolean validateMessage(String expValue) {
		String actValue = getStatusMessage();
    	if (actValue.contains(expValue))
    		return true;
    	else
    		return false;
    	    	
	}
	
	}

	
	
	