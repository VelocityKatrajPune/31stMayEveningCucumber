package com.coverFox.pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {

	@FindBy(className = "mp-input-text")
	private WebElement pincodeField;
	@FindBy(id = "want-expert")
	private WebElement mobNumField;
	@FindBy(className = "next-btn")
	private WebElement continueButton;
	@FindBy(xpath = "//div[contains(text(),'pincode')]")
	private WebElement pincodeErrMsg;
	@FindBy(xpath = "//div[contains(text(),'mobile')]")
	private WebElement mobNumErrMsg;

	public CoverFoxAddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterPinCode(String pincode) throws EncryptedDocumentException, IOException {
		pincodeField.sendKeys(pincode);
		System.out.println("entering pin code... value is " + pincode);
	}

	public void enterMobNum(String mobNumb) {
		mobNumField.sendKeys(mobNumb);
		System.out.println("entering mobile number... value is " + mobNumb);
	}

	public void clickOnContinueButton() {
		continueButton.click();
		System.out.println("clicking on continue button");
	}

	public String getPincodeErrMsg() {
		Reporter.log("getting pincode error msg, msg is " + pincodeErrMsg.getText(), true);
		return pincodeErrMsg.getText();
	}

	public String getmobNumErrMsg() {
		Reporter.log("getting mobile number error msg, msg is " + mobNumErrMsg.getText(), true);
		return mobNumErrMsg.getText();
	}
}
