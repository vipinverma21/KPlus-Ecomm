package com.qait.kplus.framework.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementsHandling {

	public static void main(String [] arg){
		findElement("xpath", "xpath");
		
	}
	
	
	public static void findElement(String type, String Locator){
		if(type.equalsIgnoreCase(type)){
			switch (Locator){
	
		case "css": 
			WebElement CSSPath = UIutils.browsers.findElement(By.cssSelector(ReadPropertyFile.propobj.getProperty("css")));
			System.out.println("i am css path");
			
		case "xpath":
			WebElement Xpath = UIutils.browsers.findElement(By.xpath(ReadPropertyFile.propobj.getProperty("xpath")));
			System.out.println("i am xpath");
		case "id":
			WebElement id = UIutils.browsers.findElement(By.id(ReadPropertyFile.propobj.getProperty("id")));
			System.out.println("i am id");
		case "class":
			WebElement classlocator = UIutils.browsers.findElement(By.id(ReadPropertyFile.propobj.getProperty("id"))); 
			System.out.println("i am classlocator");
		case "name":
			WebElement name = UIutils.browsers.findElement(By.id(ReadPropertyFile.propobj.getProperty("id")));
			System.out.println("i am name");
			}
		}
	}
}
