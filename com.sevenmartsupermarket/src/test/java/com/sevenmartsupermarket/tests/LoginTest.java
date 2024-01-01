package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	@Test
	public void verifyLogin() {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		String expectedProfileName="Admin";
		loginpage.login();
		
		//String actualProfileName=homepage.get_ProfileName();
		//Assert.assertEquals(actualProfileName, expectedProfileName);
		
	}
	@Test
	public void verify_InvalidLogin_ErrorMessage() {
		loginpage=new LoginPage(driver);
		loginpage.login("us","pa");
		boolean actualResult=loginpage.checkErrorMessage("Invalid Username/Password");
		Assert.assertTrue(actualResult);
		
	}
	}


