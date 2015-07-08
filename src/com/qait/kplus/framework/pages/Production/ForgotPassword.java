package com.qait.kplus.framework.pages.Production;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword {

	@FindBy(css="input#ForgotPasswordUsername")
	public static WebElement Email_Add;
	
	@FindBy(css="input[value='submit']")
	public static WebElement Continue;
	
	@FindBy(css="p:contains('Enter the email address')")
	public static WebElement Headertext;
	
	@FindBy(css="li:contains('Please enter your correct')")
	public static WebElement email_id_validation;
	
	@FindBy(css="li:contains(Your email address is not in our system)")
	public static WebElement email_Errormessage;
	
	
	public static void SubmitForgotPassword(){
		Email_Add.sendKeys("");
		Continue.click();	
	}
	
	public static boolean Headermessage(){
		String actualtext = Headertext.getText();
		String ExpText = "Enter the email address associated with your account and click “Continue.” We will email you instructions to reset your password";
		if(actualtext.equalsIgnoreCase(ExpText)){
			return true;
		}else{
			System.out.println("Text doesn't match to expected");
			return false;
		}
	}
	
	public static void InvalidEmailflow(){
		Email_Add.sendKeys("test1234@mms.org");
		Continue.click();
	}
}