package com.sevenmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.ExcelRead;

public class PushNotificationTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	PushNotificationPage pushnotificationpage;

	ExcelRead excelread = new ExcelRead();

	@Test
	public void verifyPushNotification_AlertMessage() {
		excelread.setExcelFile("PushNotification", "Notification");
		String notificationHeading = excelread.getCellData(1, 0);
		System.out.println(notificationHeading);

		String data = excelread.getCellData(1, 1);
		System.out.println(data);
		excelread.setExcelFile("LoginData", "LoginCredential");
		String loginHeading = excelread.getCellData(1, 0);
		System.out.println(loginHeading);

		String password = excelread.getCellData(1, 1);
		System.out.println(password);
	}
@Test
public void verify_Alert() {
	loginpage=new LoginPage(driver);
	loginpage.login("shameer","shameer");
	homepage=new HomePage(driver);
	pushnotificationpage=new PushNotificationPage(driver);
	pushnotificationpage.clickOnPushNotification();
	pushnotificationpage.sendNotification("shameer", "anju");
	pushnotificationpage.checkAlertMessage("Message send successfully");
	boolean actualResult=pushnotificationpage.checkAlertMessage("Message send successfully");
	Assert.assertTrue(actualResult);
	
	
}
}
