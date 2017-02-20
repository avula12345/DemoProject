package org.liveproject.com.SeleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HDFCBank {
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		List<WebElement> frameList=driver.findElements(By.tagName("iframe"));
		System.out.println(frameList.size());
		
		driver.switchTo().frame(driver.findElement(By.id("http-push")));
		
		WebElement el = driver.findElement(By.xpath("//img[@src='//cdn25.vizury.com/ssp/IN_HDFC_DMP/Close.png']"));
		el.click();
		
		driver.switchTo().parentFrame();
		driver.findElement(By.id("loginsubmit")).click();
		
		driver.quit();
		
	}
}