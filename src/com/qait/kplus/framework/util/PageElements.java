package com.qait.kplus.framework.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageElements {
	
	public static void MouseHover(WebElement we){
		Actions actObj = new Actions(UIutils.browsers);
		actObj.moveToElement(we).build().perform();
	}
	
	
	public static void Drag_Drop(WebElement src_we1, WebElement dest_we2){
		Actions actObj = new Actions(UIutils.browsers);
		actObj.dragAndDrop(src_we1, dest_we2).build().perform();
	}
	
	
	public static void fn_rightclick(WebElement we){
		Actions actObj = new Actions(UIutils.browsers);
		actObj.contextClick().build().perform();
	}
	
	
	public static void DropDown(WebElement we, String Value){	//Handle Drop down
		Select sel = new Select(we);
		try {
			sel.selectByValue(Value);
		}catch(Exception e){
			sel.selectByVisibleText(Value);
		}
	}
	
	public static void AlertHandle(WebElement we){
		Alert alert = UIutils.browsers.switchTo().alert();
		String AlertText = alert.getText();
		alert.accept();
	}
	
	public static void SwitchFrame(WebElement we){
		UIutils.browsers.switchTo().frame(we);
	}
	
	public static void fn_Input(WebElement we, String FieldName){
		we.sendKeys(FieldName);
	}
	
	public static void PerformClick(WebElement we){

		Dimension dim = we.getSize();
		
		if (dim.getHeight()>0 || dim.getWidth()>0){
			we.click();
		}else{
			System.out.println("WebElement is hidden and having no dimesions");
		}
			
	}
}

