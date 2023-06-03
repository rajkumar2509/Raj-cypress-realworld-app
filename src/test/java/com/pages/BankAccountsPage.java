package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BankAccountsPage extends BaseClass {
	public BankAccountsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@role='button'])[5]")
	private WebElement btnBankAccounts;
	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement btnDelete;
	@FindBy(xpath = "//p[text()='(Deleted)']")
	private WebElement txtDeletedMsg;
	@FindBy(xpath = "(//a[@role='button'])[7]")
	private WebElement btnCreate;
	@FindBy(xpath = "//h2[text() = 'Create Bank Account']")
	private WebElement txtCreateBankAccount;
	@FindBy(xpath = "//*[@id=\"bankaccount-bankName-input\"]")
	private WebElement txtBankAccount;
	@FindBy(xpath = "//*[@id=\"bankaccount-routingNumber-input\"]")
	private WebElement txtRoutingNum;
	@FindBy(xpath = "//*[@id=\"bankaccount-accountNumber-input\"]")
	private WebElement txtAccNum;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement btnSave;
	@FindBy(xpath = "//h2[text()='Bank Accounts']")
	private WebElement txtBankAccounts;

	public WebElement getTxtBankAccounts() {
		return txtBankAccounts;
	}

	public WebElement getBtnBankAccounts() {
		return btnBankAccounts;
	}

	public WebElement getBtnDelete() {
		return btnDelete;
	}

	public WebElement getTxtDeletedMsg() {
		return txtDeletedMsg;
	}

	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public WebElement getTxtCreateBankAccount() {
		return txtCreateBankAccount;
	}

	public WebElement getTxtBankAccount() {
		return txtBankAccount;
	}

	public WebElement getTxtRoutingNum() {
		return txtRoutingNum;
	}

	public WebElement getTxtAccNum() {
		return txtAccNum;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

}
