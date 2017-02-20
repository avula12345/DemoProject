package org.liveproject.com.SeleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GetDropDownValues {
	
    public static void main(String[] args) throws Exception
    {
        WebDriver wd=new FirefoxDriver();
        wd.get("https://qbo.intuit.com/qbo32/login?webredir/");
        wd.manage().window().maximize();
        
        // Find the no of links
        
        List<WebElement> links = wd.findElements(By.tagName("a"));
        
		System.out.println(links.size());
 
		for (int i = 1; i<links.size(); i++)
 
		{
 
			System.out.println(links.get(i).getText());
 
		}
 
        
        /*
        wd.get("http://toolsqa.com/automation-practice-form/");
        
        WebElement element=wd.findElement(By.id("continents"));
        Select select=new Select(element);
        List<WebElement> list=select.getOptions();
        for(int i=0;i<list.size();i++)          
            {
                System.out.println(list.get(i).getText());
            }
                
        wd.close();
        */
        
        /*
        WebElement element=wd.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
        element.click();
        
        List<WebElement> ulElements = wd.findElements(By.xpath(".//*[@id='dropdownGroup1']/div/ul"));
        //System.out.println(ulElements.size());
        
        for (int i = 1; i <= ulElements.size(); i++) {
        	
        	List<WebElement> liElements  = wd.findElements(By.xpath(".//*[@id='dropdownGroup1']/div/ul["+i+"]/li"));
            
        	  //System.out.println(liElements.size());
            
            for(int j = 1;j <= liElements.size(); j++){
            	
            	WebElement linkElement = wd.findElement(By.xpath(".//*[@id='dropdownGroup1']/div/ul["+i+"]/li["+j+"]/a"));
            	System.out.println(linkElement.getText());
            	
            	if(linkElement.getText().equals("Bengaluru (BLR)")) {
            		linkElement.click();
                }
            }
            
        }
        
        */
		wd.close();
    }
}
