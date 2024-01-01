package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.AddOfferPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.PageUtility;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class AddOfferTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	PageUtility pageutility;
	AddOfferPage addofferpage;
	WaitUtility waitutility;
	@Test
	public void verify_AddOffers() 
	{
		loginpage = new LoginPage(driver);
		loginpage.login("shameer", "shameer");
		addofferpage=new AddOfferPage(driver);
		addofferpage.ClickOnMoreInfo();
		
	}
	@Test
	public void verify_NewOffer() {
		verify_AddOffers();
		addofferpage=new AddOfferPage(driver);
		pageutility=new PageUtility(driver);
		addofferpage.ClickNew();
		addofferpage.enter_Offer("ANJ25");
		addofferpage.enter_Percentage("25%");
		addofferpage.enter_Amount("250");
		addofferpage.enter_Description("FLAT 25% OFF ON MAMAEARTH PRODUCT");
		addofferpage.imageUpload();
		
		addofferpage.saveOffer();
		
	}
}
