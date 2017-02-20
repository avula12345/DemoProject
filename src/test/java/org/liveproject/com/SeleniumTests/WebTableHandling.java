package org.liveproject.com.SeleniumTests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
public class WebTableHandling {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.actitime.com/");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//*[@id='loginButton']/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/tasks/otasklist.do']")).click();
		
		//count no of rows in a webtable
		
		int rows = 1;
		
		WebElement ele = driver.findElement(By.xpath("//table[@class='listTable withRoundCorners']/tbody"));
		boolean istableExists = ele.isDisplayed();
		
		while (istableExists) {
			
			try {	
				
				driver.findElement(By.xpath("//table[@class='listTable withRoundCorners']/tbody/tr[" + rows + "]"));
				
			}catch (org.openqa.selenium.NoSuchElementException e){
				
				rows=rows-3;
				break;
			}
		
			rows = rows + 1;		
		}
		System.out.println("No of Rows = " + rows);
		
		int cols = 1;
        
        WebElement RecentPayments = driver.findElement(By.xpath("//table[@class='listTable withRoundCorners']/tbody"));
				
		while (RecentPayments.isDisplayed()) {
			
			try {	
				
				driver.findElement(By.xpath("//table[@class='listTable withRoundCorners']/tbody/tr[3]/td[" + cols + "]"));
				
			}catch (org.openqa.selenium.NoSuchElementException e){
				
				cols=cols-1;
				break;
			}
		
			cols = cols + 1;		
			}
		
		System.out.println("No of Columns = " + cols);
		
		int pageLinks = 1;
		
        WebElement pagination = driver.findElement(By.xpath(".//*[@id='tasksListForm']/table/tbody/tr[3]/td/table/tbody"));
        
		while (pagination.isDisplayed()) {
			
			try {	
				
				driver.findElement(By.xpath("//*[@id='tasksListForm']/table/tbody/tr[3]/td/table/tbody/tr/td[1]/nobr[" + pageLinks + "]"));
				
			}catch (org.openqa.selenium.NoSuchElementException e){
				
				pageLinks=pageLinks-1;
				break;
			}
		
			pageLinks = pageLinks + 1;		
			}
		        
		System.out.println("No of Pagination Elements = " + pageLinks);
		
		List<String> arrListUIValues = new ArrayList<String>();
		
		if(pageLinks!=0){
			
			List<WebElement> paginationLink =driver.findElements(By.xpath("//*[@id='tasksListForm']/table/tbody/tr[3]/td/table/tbody/tr/td[1]/nobr")); 
			
			// check if pagination link exists 
			
			int size = paginationLink.size();

			if(size>0){ 
				System.out.println("pagination exists");
				boolean val = paginationLink.get(size-1).getText().contains("Next");
				System.out.println(val);

				for(int j=1;j<=size-3;j++){
					WebElement link = driver.findElement(By.xpath("//*[@id='tasksListForm']/table/tbody/tr[3]/td/table/tbody/tr/td[1]/nobr[" + size + "]/a"));
					link.click();
					Thread.sleep(3000);
				}
			} else {
				System.out.println("pagination not exists");
			}
			
		} else{
			
			System.out.println("Pagination Element not exists");
		}

		driver.close();
		
	}
}
