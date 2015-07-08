package com.qait.kplus.framework.pages.Production;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qait.kplus.framework.util.ExcelFileHandling;
import com.qait.kplus.framework.util.PageElements;
import com.qait.kplus.framework.util.UIutils;

public class IM_PurchaseForm {

	@FindBy (css= "input#UserProfile_FName")
	public static WebElement first_name;
	
	@FindBy (css= "UserProfile_LName")
	public static WebElement last_name;
	
	@FindBy (css= "select#UserProfile_Suffix")
	public static WebElement Suffix;
	
	@FindBy (css= "input#UserProfile_ActiveAddress_Address1")
	public static WebElement address1;
	
	@FindBy (css= "input#UserProfile_ActiveAddress_City")
	public static WebElement city;
	
	@FindBy (css= "select#UserProfile_ActiveAddress_StateCode")
	public static WebElement state;
	
	@FindBy (css= "input#UserProfile_ActiveAddress_Zip")
	public static WebElement zip;
	
	@FindBy (css= "select#UserProfile_ActiveAddress_CountryCode")
	public static WebElement country;
	
	@FindBy (css= "select#UserProfile_WorkPlaceCode")
	public static WebElement placeofwork;
	
	@FindBy (css= "select#UserProfile_SpecialtyCode")
	public static WebElement specialty;
	
	@FindBy (css= "input#UserProfile_MailingAddrIsBillingAddr-no")
	public static WebElement billing_radio;
	
	@FindBy (css= "input#UserProfile_Username")
	public static WebElement email_add;
	
	@FindBy (css= "input#UserProfile_ConfirmUsername2")
	public static WebElement confirm_email;
	
	@FindBy (css= "input#UserProfile_Password")
	public static WebElement password;
	
	@FindBy (css= "input#UserProfile_ConfirmPassword2")
	public static WebElement confirm_pass;
	
	@FindBy (css= "input#UserProfile_SOI")
	public static WebElement SOI_checkbox;
	
	@FindBy (css= "input#CreditCardInfo_NameOnCreditCard")
	public static WebElement name_cc;
	
	@FindBy (css= "select#CreditCardInfo_CreditCardType")
	public static WebElement CardType;
	
	@FindBy (css= "input#CreditCardInfo_CreditCardNumber")
	public static WebElement Card_no;
	
	@FindBy (css= "select#CreditCardInfo_CreditCardExpMonth")
	public static WebElement Exp_month;
	
	@FindBy (css= "select#CreditCardInfo_CreditCardExpYear")
	public static WebElement Exp_year;
	
	@FindBy (css= "input.form-submit-button")
	public static WebElement Submitform;
	
	@FindBy (css= "h3.productName")
	public static WebElement ProductForm;
	
	@FindBy	(css= "css= a#h2-customer-sign-in")
	public static WebElement Sign_In;
	
	public static void main (String []args) throws IOException{
		PurchaseFM();
	}
	
	
	
	public static void PurchaseFM() throws IOException{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://knowledgeplusqa.nejm.org/");
		driver.findElement(By.xpath("//button/span[contains(text(),'Buy Now')]")).click();
		
		
		
		driver.findElement(By.xpath("//input[@id='IMTEST']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		//ExcelFileHandling.TestDataList = ExcelFileHandling.GetTestData("C:\\Users\\vipinverma\\Desktop\\KplusTestData.xlsx", "Internal_Medicine","TC_03");
		first_name.sendKeys("First Name");
		last_name.sendKeys("Last Name");
		PageElements.DropDown(Suffix,"Suffix");
		address1.sendKeys("Address1");
		city.sendKeys("City");
		PageElements.DropDown(state, "State");
		zip.sendKeys("Zip Code");
		PageElements.DropDown(country, "Country");
		PageElements.DropDown(placeofwork, "Place of Work");
		PageElements.DropDown(specialty, "Specialty");
		
		email_add.sendKeys("Email address");
		confirm_email.sendKeys("Email address");
		password.sendKeys("Password");
		confirm_pass.sendKeys("Password");
		
		name_cc.sendKeys("CC_Name");
		PageElements.DropDown(CardType, "Card Type");
		Card_no.sendKeys("Card_No");
		PageElements.DropDown(Exp_month,"Exp Month");
		PageElements.DropDown(Exp_year, "Exp Year");
		
		Submitform.click();
		
		//PurchaseConfirmation PurchaseConfirmationObj = PageFactory.initElements(UIutils.browsers,PurchaseConfirmation.class);
		//return PurchaseConfirmationObj;
	}
	
	public static void HeaderName(){
		String Expected = ProductForm.getText();
		String Actual = ProductForm.getText();
	}	
		
	
	public void IMPurchseformSignIn(){
			Sign_In.click();
			
			
		}
	
	}

