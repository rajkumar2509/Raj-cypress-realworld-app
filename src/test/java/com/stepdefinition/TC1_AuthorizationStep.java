package com.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_AuthorizationStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the cypress real world app page")
	public void userIsOnTheCypressRealWorldAppPage() {
	}

	@When("User should perform click signup {string},{string},{string},{string} and {string}")
	public void userShouldPerformClickSignupAnd(String firstname, String lastname, String username, String password,
			String confirmpassword) {
		pom.getAuthorizationPage().signUp(firstname, lastname, username, password, confirmpassword);

	}

	@Then("User should verify error messages {string},{string},{string},{string} and {string}")
	public void userShouldVerifyErrorMessagesAnd(String expFirstNameReqErrorMsg, String expLastNameReqErrorMsg,
			String expUserNameReqErrorMsg, String expEnterPasswordErrorMsg, String expConfirmPasswordErrorMsg) {

		WebElement txtFirstNameReqErrorMsg = pom.getAuthorizationPage().getFirstNameRequiredErrorMsg();
		String actFirstNameReqErrorMsg = elementGetText(txtFirstNameReqErrorMsg);
		boolean containsFirstNameReqErrorMsg = actFirstNameReqErrorMsg.contains(expFirstNameReqErrorMsg);
		Assert.assertTrue("Verify first name required error message", containsFirstNameReqErrorMsg);

		WebElement txtLastNameRequiredErrorMsg = pom.getAuthorizationPage().getLastNameRequiredErrorMsg();
		String actLastNameRequiredErrorMsg = elementGetText(txtLastNameRequiredErrorMsg);
		boolean containsLastNameRequiredErrorMsg = actLastNameRequiredErrorMsg.contains(expLastNameReqErrorMsg);
		Assert.assertTrue("Verify last name required error message", containsLastNameRequiredErrorMsg);

		WebElement txtUserNameReqErrorMsg = pom.getAuthorizationPage().getUserNameRequiredErrorMsg();
		String actUserNameReqErrorMsg = elementGetText(txtUserNameReqErrorMsg);
		boolean containsUserNameReqErrorMsg = actUserNameReqErrorMsg.contains(expUserNameReqErrorMsg);
		Assert.assertTrue("Verify user name required error message", containsUserNameReqErrorMsg);

		WebElement txtEnterPasswordErrorMsg = pom.getAuthorizationPage().getEnterPasswordErrorMsg();
		String actEnterPasswordErrorMsg = elementGetText(txtEnterPasswordErrorMsg);
		boolean containsEnterPasswordErrorMsg = actEnterPasswordErrorMsg.contains(expEnterPasswordErrorMsg);
		Assert.assertTrue("Verify enter password error msg", containsEnterPasswordErrorMsg);

		WebElement txtConfirmPasswordErrorMsg = pom.getAuthorizationPage().getConfirmPasswordErrorMsg();
		String actConfirmPasswordErrorMsg = elementGetText(txtConfirmPasswordErrorMsg);
		boolean containsConfirmPasswordErrorMsg = actConfirmPasswordErrorMsg.contains(expConfirmPasswordErrorMsg);
		Assert.assertTrue("Verify confirm your password error msg", containsConfirmPasswordErrorMsg);
	}

	@Then("User should click signup button")
	public void userShouldClickSignupButton() {
		pom.getAuthorizationPage().signupBtn();
	}

	@When("User should perform signin {string},{string}")
	public void userShouldPerformLogin(String username, String password) {
		pom.getAuthorizationPage().signIn(username, password);
	}

	@Then("User should click next button to create bank account")
	public void userShouldClickNextButtonToCreateBankAccount() {
		pom.getAuthorizationPage().nextBtn();
	}

	@When("User create bank account with without entering credentials {string},{string} and {string}")
	public void userCreateBankAccountWithWithoutEnteringCredentialsAnd(String bankname, String routingnumber,
			String accountnumber) {
		pom.getAuthorizationPage().createBankAccount(bankname, routingnumber, accountnumber);
	}

	@Then("User should verify error messages {string},{string} and {string}")
	public void userShouldVerifyErrorMessagesAnd(String expEnterBankNameErrorMsg,
			String expEnterValidBankRoutingNumberErrorMsg, String expEnterValidBankAcNumberErrorMsg) {

		WebElement txtEnterBankNameErrorMsg = pom.getAuthorizationPage().getEnterBankNameErrorMsg();
		String actEnterBankNameErrorMsg = elementGetText(txtEnterBankNameErrorMsg);
		boolean containsEnterBankNameErrorMsg = actEnterBankNameErrorMsg.contains(expEnterBankNameErrorMsg);
		Assert.assertTrue("Verify enter bank name error msg", containsEnterBankNameErrorMsg);

		WebElement txtEnterValidBankRoutingNumberErrorMsg = pom.getAuthorizationPage()
				.getEnterValidBankRoutingNumberErrorMsg();
		String actEnterValidBankRoutingNumberErrorMsg = elementGetText(txtEnterValidBankRoutingNumberErrorMsg);
		boolean containsEnterValidBankRoutingNumberErrorMsg = actEnterValidBankRoutingNumberErrorMsg
				.contains(expEnterValidBankRoutingNumberErrorMsg);
		Assert.assertTrue("Verify enter valid routing number error msg", containsEnterValidBankRoutingNumberErrorMsg);

		WebElement txtEnterValidBankAcNumberErrorMsg = pom.getAuthorizationPage().getEnterValidBankAcNumberErrorMsg();
		String actEnterValidBankAcNumberErrorMsg = elementGetText(txtEnterValidBankAcNumberErrorMsg);
		boolean containsEnterValidBankAcNumberErrorMsg = actEnterValidBankAcNumberErrorMsg
				.contains(actEnterValidBankAcNumberErrorMsg);
		Assert.assertTrue("Verify enter valid bank acc number error msg", containsEnterValidBankAcNumberErrorMsg);
	}

	@When("User create bank account with valid credentials {string},{string} and {string}")
	public void userCreateBankAccountWithValidCredentialsAnd(String bankname, String routingnumber,
			String accountnumber) {
		pom.getAuthorizationPage().createBankAccount(bankname, routingnumber, accountnumber);
		pom.getAuthorizationPage().saveBtn();
	}

	@Then("User should verify finished message {string}")
	public void userShouldVerifyFinishedMessage(String expFinishedMsg) {
		WebElement txtFinishedMsg = pom.getAuthorizationPage().getTxtFinishedMsg();
		String actFinishedMsg = elementGetText(txtFinishedMsg);
		boolean containsFinishedMsg = actFinishedMsg.contains(expFinishedMsg);
		Assert.assertTrue("Verify finished msg after create bank account", containsFinishedMsg);
	}

	@When("User should click done button")
	public void userShouldClickDoneButton() {
		pom.getAuthorizationPage().doneBtn();
	}

	@Then("User should click logout")
	public void userShouldClickLogout() {
		pom.getAuthorizationPage().getBtnLogout();
	}

	@When("User should perform signin {string},{string} with Enter Key")
	public void userShouldPerformSigninWithEnterKey(String username, String password) throws AWTException {
		pom.getAuthorizationPage().signInWithEnterKey(username, password);
	}

	@Then("User should verify after signin with empty username and min char password error message contains {string},{string}")
	public void userShouldVerifyAfterSigninWithEmptyUsernameAndMinCharPasswordErrorMessageContains(
			String expUsernameReqErrorMsg, String expPasswordLeastCharErrorMsg) {
		WebElement txtUserNameRequiredErrorMsg = pom.getAuthorizationPage().getUserNameRequiredErrorMsg();
		String actuserNameRequiredErrorMsg = elementGetText(txtUserNameRequiredErrorMsg);
		boolean containsUserNameRequiredErrorMsg = actuserNameRequiredErrorMsg.contains(expUsernameReqErrorMsg);
		Assert.assertTrue("Verify after signin with empty username", containsUserNameRequiredErrorMsg);

		WebElement txtPasswordLeastCharErrorMsg = pom.getAuthorizationPage().getPasswordLeastCharErrorMsg();
		String actPasswordLeastCharErrorMsg = elementGetText(txtPasswordLeastCharErrorMsg);
		boolean containsPasswordLeastCharErrorMsg = actPasswordLeastCharErrorMsg.contains(expPasswordLeastCharErrorMsg);
		Assert.assertTrue("Verify after signin with min char password error msg", containsPasswordLeastCharErrorMsg);
	}

	@Then("User should verify after signin with invalid credential error message contains {string}")
	public void userShouldVerifyAfterSigninWithInvalidCredentialErrorMessageContains(String expErrorSigninMsg) {
		WebElement txtErrorSigninMsg = pom.getAuthorizationPage().getTxtErrorSignin();
		String actErrorSigninMsg = elementGetText(txtErrorSigninMsg);
		boolean containsErrorSigninMsg = actErrorSigninMsg.contains(expErrorSigninMsg);
		Assert.assertTrue("verify after signin with invalid credential error message", containsErrorSigninMsg);
	}

}
