package com.qait.kplus.framework.pages.Production;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qait.kplus.framework.util.PageElements;
import com.qait.kplus.framework.util.UIutils;




public class ProdSelection {

	@FindBy (xpath= "//select[@id='UserProfession']")
	public static WebElement Prof_Category;
	
	@FindBy (xpath="//input[@id='IMTEST']")
	public static WebElement im_radio;
	
	@FindBy (xpath="//input[@id='FMTEST']")
	public static WebElement fm_radio;
	
	@FindBy (xpath="//input[@value='Continue']")
	public static WebElement Continue ;
	
	@FindBy (xpath="//div[@class='cdf-progress-bg']")
	public static WebElement Step_notify;
	
	@FindBy (xpath="//div[@class='ecomSplash']")
	public static WebElement hero_image;
	
	@FindBy (xpath="//span[contains(text(),'Please select professional category.')]")
	public static WebElement Prof_catevalidation;
	
	
	
	public IM_PurchaseForm FamilyMed(){
		PageElements.DropDown(Prof_Category, "Student");
		fm_radio.click();
		Continue.click();
		
		IM_PurchaseForm FMFormobj = PageFactory.initElements(UIutils.browsers,IM_PurchaseForm.class );
		return FMFormobj;
		 }
	
	public FM_PurchaseForm InternalMed(){
		PageElements.DropDown(Prof_Category, "Student");
		im_radio.click();
		Continue.click();
		
		FM_PurchaseForm IMFormobj = PageFactory.initElements(UIutils.browsers,FM_PurchaseForm.class );
		return IMFormobj; 
	}
	
	
}


