package com.sevenmartsupermarket.pages;



import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class AddOfferPage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream ip;
	PageUtility pageutility;
	WaitUtility waitutility;
	
	@FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[5]")
	WebElement moreInfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement addNew;
	@FindBy(xpath="//input[@id='offer_code']")
	WebElement offer_Code;
	@FindBy(xpath="//input[@id='offer_per']")
	WebElement percentage;
	@FindBy(xpath="//input[@id='offer_price']")
	WebElement amount;
	@FindBy(xpath="//div[@class='note-editable card-block']")
	WebElement description;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	public AddOfferPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	
	public void ClickOnMoreInfo() {
		moreInfo.click();
	}
	public void ClickNew() {
		addNew.click();
	}

		 public void enter_Offer(String offer) {
			  offer_Code.sendKeys(offer);
			 }
		 public void enter_Percentage(String percentageData) {
			  percentage.sendKeys(percentageData);
			 }
		 public void enter_Amount(String amountData) {
			  amount.sendKeys(amountData);
			 }
		 public void enter_Description(String descriptionData) {
			  description.sendKeys(descriptionData);
			 }
		 public void imageUpload() {
			 
			  
			 
			  File file=new File(Constants.IMAGE_FILE_PATH);
			  choosefile.sendKeys(file.getAbsolutePath());
		}
		 public void saveOffer() {
			 pageutility=new PageUtility(driver);
			 pageutility.scrollAndClick(saveButton);
			
		 }
		 }
	


