package org.liveproject.com.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {
	
	public static void main(String args[]) throws InterruptedException{
		
		WebDriver d = new FirefoxDriver();
		d.get("https://online.actitime.com/abc60/login.do");
		d.manage().window().maximize();
		d.findElement(By.id("username")).sendKeys("pavaniramyojit");
		d.findElement(By.xpath("//input[@name='pwd']")).sendKeys("u7ANe8Y6");
		d.findElement(By.xpath("//*[@id='loginButton']/div")).click();
		Thread.sleep(5000);
		WebElement we = d.findElement(By.xpath("//div[@class='controlInnerContainer']/div/table/tbody/tr/td[2]"));
		WebElement we1 = d.findElement(By.xpath("//div[@class='controlInnerContainer']/div/table/tbody/tr/td[4]"));
		
		System.out.println(we.getCssValue("color"));
		System.out.println(we1.getCssValue("color"));
		
		
		d.findElement(By.xpath("//div[@class='switcherBackground']")).click();
		
		System.out.println(we.getCssValue("color"));
		System.out.println(we1.getCssValue("color"));
		d.quit();
	}

}
