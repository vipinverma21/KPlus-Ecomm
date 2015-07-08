package com.qait.kplus.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.yaml.snakeyaml.Yaml;
import java.util.*;

public class ReadPropertyFile {

	public static Properties propobj; 
	//protected InputStream input = ReadPropertyFile.class.getClassLoader().getResourceAsStream("E:\\Automation\\Kplus\\KplusEcommAutomation\\data\\Configurations.properties");
	protected FileInputStream fis = new FileInputStream("E:\\Automation\\Kplus\\KplusEcommAutomation\\data\\Configurations.properties");
	
	public ReadPropertyFile()throws Exception {
		propobj = new Properties();
		propobj.load(fis);
// or  propobj.load(input)    // if i have to user the location of the properties file in workspace then use this
	}
		
	public String getURL(){
		return propobj.getProperty("url");
	}
	
	public String getBrowser(){
		return propobj.getProperty("browser");
	}
	
	public String getUsername(){
		return propobj.getProperty("username");
	}
	
	public String getPassword(){
		return propobj.getProperty("password");
		
	}
}



