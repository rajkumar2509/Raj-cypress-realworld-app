package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC4_TransactionsStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@When("User should click on everyone public transaction")
	public void userShouldClickOnEveryonePublicTransaction() {
		pom.getTransactionPage().getTxtpublicsender().click();
	}

	@Then("User should verify transaction detail msg {string}")
	public void userShouldVerifyTransactionDetailMsg(String expTransactionMsg) {
		WebElement txtTransactionMsg = pom.getTransactionPage().getTxtTransactionMsg();
		String actTransactionMsg = elementGetText(txtTransactionMsg);
		boolean containsTransactionMsg = actTransactionMsg.contains(expTransactionMsg);
		Assert.assertTrue("Verify transaction msg", containsTransactionMsg);
	}

	@Then("User should perform click home button")
	public void userShouldPerformClickHomeButton() {
		pom.getTransactionPage().getBtnHome().click();
	}

	@When("User should click on date")
	public void userShouldClickOnDate() {
		pom.getTransactionPage().getClickDate().click();
	}

	@Then("User should select date from calendar")
	public void userShouldSelectDateFromCalendar() {
		pom.getTransactionPage().getFromDateSel().click();
		pom.getTransactionPage().getToDateSel().click();
	}

	@When("User should click on friends transaction tab")
	public void userShouldClickOnFriendsTransactionTab() {
		pom.getTransactionPage().getTabFriends().click();
	}

	@Then("User should click on create a transaction button")
	public void userShouldClickOnCreateATransactionButton() {
		pom.getTransactionPage().getBtnCreateTrans().click();
	}

	@Then("User should click on search text box")
	public void userShouldClickOnSearchTextBox() {
		pom.getTransactionPage().getBoxSearch().click();
	}

	@Then("User should select contact")
	public void userShouldSelectContact() {
		pom.getTransactionPage().getClickUser().click();
	}

	@Then("User should type amount of transaction {string}")
	public void userShouldTypeAmountOfTransaction(String amount) {
		pom.getTransactionPage().amount(amount);
	}

	@Then("User should add a note on transaction {string}")
	public void userShouldAddANoteOnTransaction(String note) {
		pom.getTransactionPage().note(note);
	}

	@Then("User should click on pay to the contact button")
	public void userShouldClickOnPayToTheContactButton() {
		pom.getTransactionPage().getBtnPay().click();
	}

	@Then("User should return to transactions")
	public void userShouldReturnToTransactions() {
		pom.getTransactionPage().getBtnReturnToTrans().click();
	}

	@When("User should click on mine transaction tab")
	public void userShouldClickOnMineTransactionTab() {
		pom.getTransactionPage().getTabMine().click();
	}

	@Then("User should verify personal text {string}")
	public void userShouldVerifyPersonalText(String expPersonalMsg) {
		WebElement txtPersonalMsg = pom.getTransactionPage().getTxtPersonalMsg();
		String actPersonalMsg = elementGetText(txtPersonalMsg);
		boolean containsPersonalMsg = actPersonalMsg.contains(expPersonalMsg);
		Assert.assertTrue("Verify personal msg", containsPersonalMsg);
	}

}
