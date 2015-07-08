package com.qait.kplus.framework.pages.Production;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qait.kplus.framework.util.PageElements;

import com.qait.kplus.framework.util.UIutils;

public class MarketingSite {

	@FindBy (xpath="//div[@class='logo']/a/img") 
	//css= div[class='logo']>a>img
	public static WebElement NEJMLogo_btn;
	
	@FindBy (xpath= "//div[@class='avada-row']/a")  //css=a:contains('Call Toll-Free 1-855-318-9303')
	//css= a.header-tab
	public static WebElement tollfree_no;
	
	@FindBy (xpath="//div[@id='nejm-login']")
	public static WebElement SignIn_btn;
	
	@FindBy (xpath="//button/span[contains(text(),'Buy Now')]")
	public static WebElement BuyNow_btn;
	
	@FindBy (xpath="//div/iframe[@id='xd_frame']")
	public static WebElement SignIn_Frame;
	
	@FindBy (xpath="//input[@id='Username']")
	@CacheLookup
	public static WebElement Username;
	
	@FindBy (xpath="//input[@id='Password']")
	public static WebElement Password;
	
	@FindBy (xpath="//button[@id='login-submit']")
	public static WebElement Submit_btn;
	
	@FindBy (xpath="//p/a[contains(text(),'Forgot Password?')]")
	public static WebElement forgotpwd_link;
	
	@FindBy (xpath="//p//a[contains(text(),'Get Help with Sign In.')]")
	public static WebElement Helplink;
	
	@FindBy (xpath="//div[@class='login-cdf-msg-box hide']/p/span[@data-valmsg-for='Username']")
	public static WebElement EmailErrormessage;
	
	@FindBy (xpath="//div[@class='login-cdf-msg-box hide']/p/span[@data-valmsg-for='Password']")
	public static WebElement PwrdErrormessage;
	
	@FindBy (xpath="//div[@class='login-cdf-msg-box hide']/p")
	public static WebElement Credentials_errormessage;
	
	@FindBy (xpath="//div/input[@id='inf_field_FirstName']")
	public static WebElement Lead_FirstName;
	
	@FindBy (xpath="//div/input[@id='inf_field_LastName']")
	public static WebElement Lead_LastName;
	
	@FindBy (xpath="//div/input[@id='inf_field_Email']")
	public static WebElement Lead_Email;
	
	@FindBy (xpath="//div/select[@id='inf_field_Country']")
	public static WebElement Lead_CountryDropdown;
		
	@FindBy (xpath="//div/select[@id='inf_custom_Profession0']")
	public static WebElement Lead_ProffDropdown;
	
	@FindBy (xpath="//div/select[@id='inf_custom_Specialty']")
	public static WebElement Lead_Specialty;
	
	@FindBy (xpath="//div/select[@id='inf_custom_CertificationExamSeason']")
	public static WebElement Lead_ExamDate;
	
	@FindBy (xpath="//button/span[contains(text(),'Sign Up')]")
	public static WebElement Lead_SignUpbtn;

	
	//Methods for each actions
	
	public Profile validLogin() throws IOException{			// Login Method
		SignIn_btn.click();
		PageElements.SwitchFrame(SignIn_Frame);
		Username.clear();
		Username.sendKeys();
		Password.sendKeys("");
		Submit_btn.click();
	
		Profile ProfObj = PageFactory.initElements(UIutils.browsers, Profile.class); //Creating PageFactory Object of Profile Page
		return ProfObj;
	}
	
	public SignIn InvalidLogin() throws IOException{			// Invalid Login Method
		Username.clear();
		Username.sendKeys("");
		Password.sendKeys("");
		Submit_btn.click();
		//Creating PageFactory Object of SignIn Page
		SignIn SignInObj = PageFactory.initElements(UIutils.browsers, SignIn.class);
		return SignInObj;
	}
	
	public static boolean verify_Validation(){		// Verify Validation Message if both fields are blank	
		String ErrorMessage = Credentials_errormessage.getText();
		if(ErrorMessage.equalsIgnoreCase("The Email Address field is required. The Password field is required.")){
			System.out.println("Text Verified and displayed as Expected");
			return true;
		}else{
			System.out.println("Fail: Text does not match with Expected");
			return false;
		}
	}
	
	public static ProdSelection BuyNowProduct(){	// BuyNOW button verification
		BuyNow_btn.click();
		
		//Creating PageFactory Object of Product Selection Page
		ProdSelection ProdSelObj = PageFactory.initElements(UIutils.browsers, ProdSelection.class);
		return ProdSelObj;
	}
	
	public static void LeadGen(){					// Lead Generate Test cases
		Lead_FirstName.sendKeys("");
		Lead_LastName.sendKeys("");
		Lead_Email.sendKeys("");
		
		PageElements.DropDown(Lead_CountryDropdown, "United States");
		PageElements.DropDown(Lead_ProffDropdown, "Physician");
		PageElements.DropDown(Lead_Specialty, "Cardiology");
		PageElements.DropDown(Lead_ExamDate, "Fall 2018");
		
		Lead_SignUpbtn.click();
		
		UIutils.browsers.close();
	}
	
	
	public static boolean Callus_tollfree(){
		String tollfree = tollfree_no.getText();
		if (tollfree.equalsIgnoreCase("1-855-318-9303")){
			return true;
		}else{
			System.out.println("Tool free no is not correct");
			return false;
		}
	}
	
	
	
}
