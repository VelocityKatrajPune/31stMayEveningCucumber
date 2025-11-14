package com.coverFox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHomePage {

	private int a = 10;
	// variables-->webElements
	// WebElement getStartedButton =
	// driver.findElement(By.xpath("//button[text()='Get Started']"));
	@FindBy(xpath = "//button[text()='Get Started']")
	private WebElement getStartedButton;

	// constructor-->
	public CoverFoxHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// methods-->
	public void clickOnGetStartedButton() {
		getStartedButton.click();
		System.out.println("clicking on getStartedButton");
	}

}
