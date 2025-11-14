package stepDefinitions;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.coverFox.DriverConfig.DriverFactory;
import com.coverFox.Pages.CoverFoxAddressDetailsPage;
import com.coverFox.Pages.CoverFoxHealthPlanPage;
import com.coverFox.Pages.CoverFoxHomePage;
import com.coverFox.Pages.CoverFoxMemberDetailsPage;
import com.coverFox.Pages.CoverFoxResultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthInsurance {

	CoverFoxHomePage coverFoxHomePage = new CoverFoxHomePage(DriverFactory.getDriver());
	CoverFoxHealthPlanPage coverFoxHealthPlanPage = new CoverFoxHealthPlanPage(DriverFactory.getDriver());
	CoverFoxMemberDetailsPage coverFoxMemberDetailsPage = new CoverFoxMemberDetailsPage(DriverFactory.getDriver());
	CoverFoxAddressDetailsPage coverFoxAddressDetailspage = new CoverFoxAddressDetailsPage(DriverFactory.getDriver());
	CoverFoxResultPage coverFoxResultPage = new CoverFoxResultPage(DriverFactory.getDriver());
	SoftAssert softAssert = new SoftAssert();

	@Given("I am on home page")
	public void i_am_on_home_page() {
		System.out.println("I am on home page");
	}

	@When("I click on get started button")
	public void i_click_on_get_started_button() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("I click on get started button");
		coverFoxHomePage.clickOnGetStartedButton();
	}

	@When("I click on next button")
	public void i_click_on_next_button() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("I click on next button");
		coverFoxHealthPlanPage.clickOnNextButton();
	}

	@When("I provide age as {string} and click on next button")
	public void i_provide_age_as_and_click_on_next_button(String age)
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(4000);
		System.out.println("I provide age as " + age + " and click on next button");
		coverFoxMemberDetailsPage.handleAgeDropDown(age);
		coverFoxMemberDetailsPage.clickOnNextButton();
	}

	@When("I provide pincode as {string}, mobNumber as {string} and click on continue button")
	public void i_provide_pincode_as_mob_number_as_and_click_on_continue_button(String pinCode, String mobNum)
			throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(4000);
		System.out.println(
				"I provide pincode as  " + pinCode + " mobNumber as " + mobNum + " and click on continue button");
		coverFoxAddressDetailspage.enterPinCode(pinCode);
		coverFoxAddressDetailspage.enterMobNum(mobNum);
		coverFoxAddressDetailspage.clickOnContinueButton();

	}

	@Then("matching Health Insurance Plans should be displayed as {string}")
	public void matching_health_insurance_plans_should_be_displayed_as(String expResults) throws InterruptedException {
		Thread.sleep(6000);
		System.out.println("matching Health Insurance Plans should be displayed as " + expResults);
		String actualResults = coverFoxResultPage.getMatchingResultNumber();

		Assert.assertEquals(actualResults, expResults);
	}

	@When("I click on continue button")
	public void i_click_on_continue_button() throws InterruptedException {
		Thread.sleep(6000);
		coverFoxAddressDetailspage.clickOnContinueButton();
	}

	@Then("validate error messages")
	public void validate_error_messages() throws InterruptedException {
		Thread.sleep(6000);
		String actualPinErrMsg = coverFoxAddressDetailspage.getPincodeErrMsg();
		String actualMobErrMsg = coverFoxAddressDetailspage.getmobNumErrMsg();
		Reporter.log("Pincode error message is: " + actualPinErrMsg, true);
		Reporter.log("Mobile number error message is: " + actualMobErrMsg, true);
		String expErrMsgMob="Please enter a valid mobile no.";
		String expErrMsgPin="Please enter a valid pincode";
		softAssert.assertEquals(actualPinErrMsg, expErrMsgPin,"Pincode error message is not matching");
		Reporter.log("pin error message validation is completed", true);
		softAssert.assertEquals(actualMobErrMsg, expErrMsgMob,"Mobile number error message is not matching");
		Reporter.log("mobile number error message validation is completed", true);
		softAssert.assertAll();
		
	}

}
