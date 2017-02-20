package org.liveproject.com.SeleniumTests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	public static void main(String[] args) {

		// initialize Chrome driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\RAman\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Open gmail
		driver.get("http://www.gmail.com");

		// Enter userd id
		WebElement userName = driver.findElement(By.id("Email"));
		userName.clear();
		userName.sendKeys("testing9713@gmail.com");

		// wait 5 secs for userid to be entered

		WebElement nextBtn = driver.findElement(By.id("next"));
		nextBtn.click();

		// Enter Password
		WebElement password = driver.findElement(By.id("Passwd"));
		password.sendKeys("interview");

		// Submit button
		WebElement submitBtn = driver.findElement(By.id("signIn"));
		submitBtn.submit();
		
		// Click on the image icon present in the top right navigational Bar
		WebElement imageLink = driver.findElement(By.xpath("//span[@class='gb_3a gbii']"));
		
		if(imageLink.isDisplayed()){
			
			imageLink.click();
			//clicking on 'Sign out' link
			WebElement signOutLink = driver.findElement(By.xpath("//a[@id='gb_71']"));
			signOutLink.click();
		}

		driver.close();

	}

}