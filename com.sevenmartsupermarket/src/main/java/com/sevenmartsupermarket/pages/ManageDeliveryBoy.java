package com.sevenmartsupermarket.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class ManageDeliveryBoy {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	

	@FindBy(xpath = "//i[@class='nav-icon fas fa-user-plus']")
	WebElement manageBoy;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
	WebElement addNew;
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//textarea[@id='address']")
	WebElement address;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveField;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> deliveryBoyNames;

	public ManageDeliveryBoy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnDeliveryBoy() {
		manageBoy.click();
	}

	public void addNewDeliveryBoy() {
		addNew.click();
	}

	public void enter_DeliveryBoyName(String boyName) {
		name.sendKeys(boyName);

	}

	public void enter_DeliveryBoyEmail(String boyEmail) {
		email.sendKeys(boyEmail);
	}

	public void enter_DeliveryBoyPhone(String phoneNumber) {
		phone.sendKeys(phoneNumber);
	}

	public void enter_DeliveryBoyAddress(String boyAddress) {
		address.sendKeys(boyAddress);
	}

	public void enter_UserName(String user) {
		username.sendKeys(user);
	}

	public void enter_Password(String pass) {
		password.sendKeys(pass);

	}
	public void createDeliveryBoy(String name,String emails,String phn,String address,String us,String pass) {
		
		addNewDeliveryBoy();
		enter_DeliveryBoyName(name);
		enter_DeliveryBoyEmail(emails);
		enter_DeliveryBoyPhone(phn);
		enter_DeliveryBoyAddress(address);
		enter_UserName(us);
		enter_Password(pass);
		clickSave();
		
	}

	public void clickSave() {

		pageutility=new PageUtility(driver);
		pageutility.scrollAndClick(saveField);
		
	}

	public void print_delivery_BoyNames() {

		List<String> names = new ArrayList<String>();
		generalutility = new GeneralUtility(driver);
		names = generalutility.getTextOfElements(deliveryBoyNames);
		System.out.println(names);
	}

	public void editUser(String editingPerson) {
		int index = 0;
		List<String> names = new ArrayList<String>();
		generalutility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		names = generalutility.getTextOfElements(deliveryBoyNames);
		System.out.println(names);
		for (index = 0; index < names.size(); index++) {
			if (editingPerson.equals(names.get(index))) {
				index++;
				break;

			}

		}
		WebElement editButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr["+index+"]//td[8]//a[1]"));
		pageutility.scrollAndClick(editButton);
	}

}
