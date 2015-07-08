package com.qait.kplus.framework.pages.Production;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn {

	@FindBy(css= "div.logo")
	public static WebElement NEJM_header;
	
	@FindBy(css= "a:contains('Buy Now.')")
	public static WebElement BuyNow;
	
	@FindBy(css="input#UserProfile_Username")
	public static WebElement username_field;
	
	@FindBy(css="input#UserProfile_Password")
	public static WebElement password_field;
	
	@FindBy(css="input[value='signin']")
	public static WebElement signIn_btn;
	
	@FindBy(css="css=span.link-text")
	public static WebElement forgot_pswd;
		
}


