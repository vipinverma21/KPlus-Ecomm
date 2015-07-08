package com.qait.kplus.framework.pages.Production;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://knowledgeplusqa.nejm.org/");
		driver.findElement(By.xpath("//button/span[contains(text(),'Buy Now')]")).click();
		
		driver.findElement(By.xpath("//input[@id='IMTEST']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		driver.findElement(By.cssSelector("input#UserProfile_FName")).sendKeys("First Name");

	}

}
