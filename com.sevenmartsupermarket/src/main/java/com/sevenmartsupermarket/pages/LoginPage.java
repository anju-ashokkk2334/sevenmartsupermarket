package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream ip;
	GeneralUtility generalutility;

	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement userNameField;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInField;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement invalidMessage;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);

	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void click_SignIn() {
		signInField.click();
	}

	public void login() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		login(userName, password);

	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		click_SignIn();
	}

	public boolean checkErrorMessage(String expectedErrorMessage) {
		generalutility = new GeneralUtility(driver);
		return generalutility.is_WordPresent(invalidMessage, expectedErrorMessage);

	}
}
