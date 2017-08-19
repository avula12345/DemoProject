package org.liveproject.com.SeleniumTests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenBrowser {
	
	@Test
	public void openbrowser(){
	
	System.setProperty("webdriver.gecko.driver", "E:\\IMP\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://www.hdfcbank.com/");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.quit();
		System.out.println("Changes made by y");
	}
}
