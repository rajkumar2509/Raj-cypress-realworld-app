package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC2_MyAccountStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@When("User should click my account tab")
	public void userShouldClickMyAccountTab() {
		pom.getMyAccountPage().getBtnMyAccount().click();
	}

	@Then("User should verify user settings text {string}")
	public void userShouldVerifyUserSettingsText(String expUserSettingMsg) {
		WebElement txtUserSettingMsg = pom.getMyAccountPage().getTxtUserSettingMsg();
		String actUserSettingMsg = elementGetText(txtUserSettingMsg);
		boolean containsUserSettingMsg = actUserSettingMsg.contains(expUserSettingMsg);
		Assert.assertTrue("Verify user settings msg", containsUserSettingMsg);
	}

	@When("User should perform with invalid details {string},{string}")
	public void userShouldPerformWithInvalidDetails(String email, String phonenumber) {
		pom.getMyAccountPage().enterDetails(email, phonenumber);
	}

	@Then("User should click save button")
	public void userShouldClickSaveButton() {
		pom.getMyAccountPage().getBtnSave().click();
	}

	@Then("User should verify error msg contains {string},{string}")
	public void userShouldVerifyErrorMsgContains(String expValidemailAdd, String extPhoneNoNotValid) {
		
		WebElement txtMustContainValidEmailErrorMsg = pom.getMyAccountPage().getTxtMustContainValidEmailErrorMsg();
		String actMustContainValidEmailErrorMsg = elementGetText(txtMustContainValidEmailErrorMsg);
		boolean containsMustContainValidEmailErrorMsg = actMustContainValidEmailErrorMsg.contains(expValidemailAdd);
		Assert.assertTrue("Verify must contain valid email error msg", containsMustContainValidEmailErrorMsg);
		
		WebElement txtPhoneNoNotValidErrorMsg = pom.getMyAccountPage().getTxtPhoneNoNotValidErrorMsg();
		String actPhoneNoNotValidErrorMsg = elementGetText(txtPhoneNoNotValidErrorMsg);
		boolean containsPhoneNoNotValidErrorMsg = actPhoneNoNotValidErrorMsg.contains(extPhoneNoNotValid);
		Assert.assertTrue("Verify phone number not valid error msg", containsPhoneNoNotValidErrorMsg);
	}

}
