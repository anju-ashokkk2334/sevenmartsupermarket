package com.sevenmartsupermarket.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;

public class PushNotificationPage{
	WebDriver driver;
	GeneralUtility generalutility;
	 @FindBy(xpath = "//input[@placeholder='Enter Title']")
	 WebElement titlePath;
	 @FindBy(xpath = "//input[@placeholder='Enter Description']")
	 WebElement descriptionPath;
	 @FindBy(xpath = "//i[@class='fa fa-bell']")
	 WebElement sendpath;
	 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	 WebElement alertMessage;
	 @FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications'])[1]")
	 WebElement push;

	 public PushNotificationPage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	 }
public void clickOnPushNotification() {
	push.click();
}
	 public void enter_Title(String title) {
	  titlePath.sendKeys(title);
	 }

	 public void enter_Description(String description) {
	  descriptionPath.sendKeys(description);
	 }

	 public void clickOn_Send() {
	  sendpath.click();
	 }

	 public void sendNotification(String titles, String descriptions) {
	  enter_Title(titles);
	  enter_Description(descriptions);
	  clickOn_Send();
	 }
		public boolean checkAlertMessage(String expectedAlertMessage) {
			generalutility = new GeneralUtility(driver);
			return generalutility.is_WordPresent(alertMessage, expectedAlertMessage);

		}

	}

