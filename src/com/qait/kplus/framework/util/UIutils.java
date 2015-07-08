package com.qait.kplus.framework.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;


import org.openqa.selenium.support.ui.Select;

import com.qait.kplus.framework.pages.Production.MarketingSite;

public class UIutils {

	public static WebDriver browsers;
	
	public static void BrowserCapabilities(){
		DesiredCapabilities Capablitiy = new DesiredCapabilities();
		Capablitiy.setBrowserName("Firefox");
		
	}
	
	public static void Launchbrowser(String Browserval){
				
		if (Browserval.equalsIgnoreCase("FF")){
			browsers = new FirefoxDriver();	
			
		}else if(Browserval.equalsIgnoreCase("CH")){
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			browsers = new ChromeDriver();
			
		}else if(Browserval.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer.exe");
			browsers = new InternetExplorerDriver();
		}
		browsers.manage().window().maximize();
		browsers.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	
	public static MarketingSite openApp(WebDriver browsers, String URL){
		browsers.get(URL);
		
		MarketingSite MrktngObj = PageFactory.initElements(UIutils.browsers, MarketingSite.class);
		return MrktngObj;
	}
	
	
	
	public static String TimeStamp(){
		Date TS = new Date();
		SimpleDateFormat dformat = new SimpleDateFormat("Mdh:m:sa");
		String TimeStamp = dformat.format(TS);
		String finalts = TimeStamp.replace(":", "");
		
		return finalts;
	}
	
	public static void TakeScreenShots(WebDriver browsers) throws IOException{
		File scrFile = ((TakesScreenshot)browsers).getScreenshotAs(OutputType.FILE);
		String timestamp = TimeStamp();
		FileUtils.copyFile(scrFile, new File("C:/Users/vipinverma/Desktop/"+timestamp+".jpg"));
	}
	
	public static void WindowHandle(int i, String windowtitle ){
		Set <String> AllWindows = browsers.getWindowHandles();
		Iterator windowItr = AllWindows.iterator();
		while (windowItr.hasNext()){
			browsers.switchTo().window(windowtitle);
		}
	}
	
	
	public void testmethod(){
		System.out.println("i am Non Static Mentod");
	}
}




		

