package com.qait.kplus.framework.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qait.kplus.framework.pages.Production.Profile;
import com.qait.kplus.framework.pages.Production.MarketingSite;
import com.qait.kplus.framework.util.UIutils;

public class HomePageTest {
	
	public static void main(String[] args) throws IOException{
		VerifySignIn();
	}
	
		public static void VerifySignIn() throws IOException{
		UIutils.Launchbrowser("CH");
		MarketingSite MrktObj = UIutils.openApp(UIutils.browsers, "");
		Profile ProfileObj = MrktObj.validLogin();
		ProfileObj.SignOut();
		
	}
	
		public static void VerifySignout(){
		
	}
	
		public static void VerifyPageHeader(){
		
	}
		
		public static void VerifyLeadCreation(){
			
		}
		
		public static void IMPurchase(){
			
		}
}
