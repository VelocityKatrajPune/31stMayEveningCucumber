package com.coverFox.Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.coverFox.Utils.Utility;

public class CoverFoxMemberDetailsPage {
	// varibels
	@FindBy(id = "Age-You")
	private WebElement ageDropDown;
	@FindBy(className = "next-btn")
	private WebElement nextButton;

	// constructor
	public CoverFoxMemberDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// methods
	public void handleAgeDropDown(String age) throws EncryptedDocumentException, IOException {
		Utility.handleDropDownUsingVisibleText(ageDropDown, " " + age + " years ");

	}

	public void clickOnNextButton() {
		nextButton.click();
		System.out.println("clicking on next button");
	}

}
