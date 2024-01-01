package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.ScreenShot;

public class HomeTest extends Base{
	HomePage homepage;
	LoginPage loginpage;

	@Test
	public void verify_ProfileName() {
		loginpage=new LoginPage(driver);
		loginpage.login("shameer", "shameer");
	homepage=new HomePage(driver);
	homepage.get_ProfileName();
	
	}

}
