package com.coverFox.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHealthPlanPage {
	// encapsulation in POM classes
	// data members-->private-->
	// variables-->weElements
	@FindBy(className = "next-btn")
	private WebElement nextButton;

	// constructor
	public CoverFoxHealthPlanPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// methods

	public void clickOnNextButton() {
		nextButton.click();
		System.out.println("clicking on next button");
	}
}
