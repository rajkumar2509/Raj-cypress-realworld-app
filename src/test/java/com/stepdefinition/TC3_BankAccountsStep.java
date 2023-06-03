package com.stepdefinition;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC3_BankAccountsStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@When("User should click bank accounts tab")
	public void userShouldClickBankAccountsTab() {
		pom.geBankAccountsPage().getBtnBankAccounts().click();
	}

	@Then("User should verify bank accounts text {string}")
	public void userShouldVerifyBankAccountsText(String expTxtBankAccounts) {
		WebElement txtBankAccounts = pom.geBankAccountsPage().getTxtBankAccounts();
		String actTxtBankAccounts = elementGetText(txtBankAccounts);
		boolean containsBankAccounts = actTxtBankAccounts.contains(expTxtBankAccounts);
		Assert.assertTrue("Verify bank accounts text msg", containsBankAccounts);
	}

	@When("User should perform create bank account")
	public void userShouldPerformCreateBankAccount() {
		pom.geBankAccountsPage().getBtnCreate().click();
	}

	@When("User should perform with delete tab")
	public void userShouldPerformWithDeleteTab() {
		pom.geBankAccountsPage().getBtnDelete().click();
	}

	@Then("User should verify deleted msg {string}")
	public void userShouldVerifyDeletedMsg(String expDeletedMsg) {
		WebElement txtDeletedMsg = pom.geBankAccountsPage().getTxtDeletedMsg();
		String actTxtDeletedMsg = elementGetText(txtDeletedMsg);
		boolean containsTxtDeletedMsg = actTxtDeletedMsg.contains(expDeletedMsg);
		Assert.assertTrue("Verify delted txt msg", containsTxtDeletedMsg);
	}

}
