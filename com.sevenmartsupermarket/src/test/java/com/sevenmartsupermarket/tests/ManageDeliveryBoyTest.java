package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoy;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ManageDeliveryBoy managedeliveryboy;

	
	public void navigateTo_DeliveryBoy() {
		loginpage = new LoginPage(driver);
		loginpage.login("shameer", "shameer");
		managedeliveryboy = new ManageDeliveryBoy(driver);
		managedeliveryboy.clickOnDeliveryBoy();

	}

	@Test
	public void add_NewDeliveryBoy() {
		navigateTo_DeliveryBoy();
		managedeliveryboy = new ManageDeliveryBoy(driver);
		managedeliveryboy.addNewDeliveryBoy();
		managedeliveryboy.enter_DeliveryBoyName("ShameerN.S");
		managedeliveryboy.enter_DeliveryBoyEmail("niza@gmail.com");
		managedeliveryboy.enter_DeliveryBoyPhone("998680708");
		managedeliveryboy.enter_DeliveryBoyAddress("Tc162/90 ");
		managedeliveryboy.enter_UserName("shameernizarudeen");
		managedeliveryboy.enter_Password("nizar");
		managedeliveryboy.clickSave();
		
		
	}
	@Test
	public void newDeliveryBoy() {
		navigateTo_DeliveryBoy();
		managedeliveryboy = new ManageDeliveryBoy(driver);
		managedeliveryboy.createDeliveryBoy("shammi", "sha@gmail.com", "234", "tc123", "ushh", "ussp");
	}
	@Test
	public void  verify_NamesOfDeliveryBoy() {
		navigateTo_DeliveryBoy();
		managedeliveryboy = new ManageDeliveryBoy(driver);
		managedeliveryboy.print_delivery_BoyNames();
		managedeliveryboy.editUser("client28/12/2023 16:30:53");
	}
	

}