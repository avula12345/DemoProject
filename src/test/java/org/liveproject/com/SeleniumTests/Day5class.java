package org.liveproject.com.SeleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day5class {

	public static void main(String[] args) {
		String baseUrl = "https://ipn.intuit.com/";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);

		System.out
				.println("*******************************************************************");

		System.out.println("Extracting more than one element in a web page");

		System.out
				.println("*******************************************************************");

		List<WebElement> eleme = driver.findElements(By.className("button"));

		for (WebElement e : eleme) {
			System.out.println(e.getAttribute("name"));
		}

		System.out
				.println("*******************************************************************");

		System.out.println("Extracting All Links From a Page");

		System.out
				.println("*******************************************************************");

		List<WebElement> linkElements = driver.findElements(By.tagName("a"));

		// extract all the link texts of each link element in a web page
		for (WebElement e : linkElements) {
			System.out.println(e.getText());
		}

		System.out
				.println("*******************************************************************");

		System.out.println("Extracting Objects From Specific Area Of A Page");

		System.out
				.println("*******************************************************************");
		
		// Extracting objects from specific area of a web page

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='detail']"));

		for (WebElement ele : elements) {

			System.out.println(ele.getText());
		}

		System.out
				.println("*******************************************************************");

		System.out.println("Verify the existence of an element in a web page");

		System.out
				.println("*******************************************************************");
		
		System.out.println("");

		WebElement elem = driver.findElement(By.id("signup"));

		if (elem.isDisplayed()) {
			System.out.println("Element visible");
		} else {
			System.out.println("Element Not visible");
		}

		driver.quit();
	}
}