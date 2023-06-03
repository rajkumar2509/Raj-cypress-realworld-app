package com.pages;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class TransactionsPage extends BaseClass {
	public TransactionsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@data-test='transaction-sender-4AvM8cN1DdS']")
	private WebElement txtpublicsender;
	@FindBy(xpath = "//span[@data-test='transaction-receiver-mEYl_ZSc5Qqe']")
	private WebElement txtpublicreceiver;
	@FindBy(xpath = "//h2[text()='Transaction Detail']")
	private WebElement txtTransactionMsg;
	@FindBy(xpath = "//a[@data-test='sidenav-home']")
	private WebElement btnHome;
	@FindBy(xpath = "//div[@data-test='transaction-list-filter-date-range-button']")
	private WebElement clickDate;
	@FindBy(xpath = "//li[@data-date='2023-06-01']")
	private WebElement fromDateSel;
	@FindBy(xpath = "//li[@data-date='2023-06-04']")
	private WebElement toDateSel;
	@FindBy(xpath ="//a[@data-test='nav-contacts-tab']")
	private WebElement tabFriends;
	@FindBy(xpath = "//a[@data-test='nav-personal-tab']")
	private WebElement tabMine;
	@FindBy(xpath = "//a[@data-test='transaction-list-empty-create-transaction-button']")
	private WebElement btnCreateTrans;
	@FindBy(id = "user-list-search-input")
	private WebElement boxSearch;
	@FindBy(xpath = "//span[text()='Edgar Johns']")
	private WebElement clickUser;
	@FindBy(id = "amount")
	private WebElement selectAmount;
	@FindBy(id = "transaction-create-description-input")
	private WebElement addNote;
	@FindBy(id = "transaction-create-description-input")
	private WebElement txtDescription;
	@FindBy(xpath = "//button[@data-test='transaction-create-submit-request']")
	private WebElement btnRequest;
	@FindBy(xpath = "//button[@data-test='transaction-create-submit-payment']")
	private WebElement btnPay;
	@FindBy(xpath = "//h2[text()='Requested ']")
	private WebElement txtRequested;
	@FindBy(xpath = "//a[@data-test='new-transaction-return-to-transactions']")
	private WebElement btnReturnToTrans;
	@FindBy(xpath = "//button[@data-test='new-transaction-create-another-transaction']")
	private WebElement btnCreateAnoTrans;
	@FindBy(xpath = "//div[text()='Personal']")
	private WebElement txtPersonalMsg;
	
	
	public WebElement getAddNote() {
		return addNote;
	}
	public WebElement getTxtpublicsender() {
		return txtpublicsender;
	}
	public WebElement getTxtpublicreceiver() {
		return txtpublicreceiver;
	}
	public WebElement getTxtTransactionMsg() {
		return txtTransactionMsg;
	}
	public WebElement getBtnHome() {
		return btnHome;
	}
	public WebElement getClickDate() {
		return clickDate;
	}
	public WebElement getFromDateSel() {
		return fromDateSel;
	}
	public WebElement getToDateSel() {
		return toDateSel;
	}
	public WebElement getTabFriends() {
		return tabFriends;
	}
	public WebElement getTabMine() {
		return tabMine;
	}
	public WebElement getBtnCreateTrans() {
		return btnCreateTrans;
	}
	public WebElement getBoxSearch() {
		return boxSearch;
	}
	public WebElement getClickUser() {
		return clickUser;
	}
	public WebElement getSelectAmount() {
		return selectAmount;
	}
	public WebElement getTxtDescription() {
		return txtDescription;
	}
	public WebElement getBtnRequest() {
		return btnRequest;
	}
	public WebElement getBtnPay() {
		return btnPay;
	}
	public WebElement getTxtRequested() {
		return txtRequested;
	}
	public WebElement getBtnReturnToTrans() {
		return btnReturnToTrans;
	}
	public WebElement getBtnCreateAnoTrans() {
		return btnCreateAnoTrans;
	}
	public WebElement getTxtPersonalMsg() {
		return txtPersonalMsg;
	}
	
	public void amount(String amount) {
		elementSendKeys(getSelectAmount(), amount);
	}
	
	public void note(String note) {
		elementSendKeys(getAddNote(), note);
	}

}
