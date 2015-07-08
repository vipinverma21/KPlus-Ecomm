package com.qait.kplus.framework.pages.Production;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qait.kplus.framework.util.UIutils;

public class Profile {

	@FindBy (xpath ="//div/h1[contains(text(),'Profile')]")
	public static WebElement ProfilePageheader;
	
	@FindBy (xpath="//div//h2/a[contains(text(),'Sign out.')]")
	public static WebElement SignOut_Btn;
	
	
	
	
	public static void VerifyPageHeader() {
	
	}
	
	public void SignOut() {
		SignOut_Btn.click();
	}
}
