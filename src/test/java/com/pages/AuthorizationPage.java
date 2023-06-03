package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class AuthorizationPage extends BaseClass {
	public AuthorizationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-test='signup']")
	private WebElement linkSignup;
	@FindBy(id = "firstName")
	private WebElement txtFirstName;
	@FindBy(id = "lastName")
	private WebElement txtLastName;
	@FindBy(id = "username")
	private WebElement txtUserName;
	@FindBy(id = "password")
	private WebElement txtPassword;
	@FindBy(id = "confirmPassword")
	private WebElement txtConfirmPassword;
	@FindBy(xpath = "//h1[text()='Sign Up']")
	private WebElement txtSignup;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSignup;
	@FindBy(xpath = "//h1[text()='Sign in']")
	private WebElement txtSignin;
	@FindBy(xpath = "//p[text()='Enter a bank name']")
	private WebElement enterBankNameErrorMsg;
	@FindBy(xpath = "//p[text()='Enter a valid bank routing number']")
	private WebElement enterValidBankRoutingNumberErrorMsg;
	@FindBy(xpath = "//p[text()='Enter a valid bank account number']")
	private WebElement enterValidBankAcNumberErrorMsg;
	@FindBy(id = "firstName-helper-text")
	private WebElement firstNameRequiredErrorMsg;
	@FindBy(id = "lastName-helper-text")
	private WebElement lastNameRequiredErrorMsg;
	@FindBy(id = "username-helper-text")
	private WebElement userNameRequiredErrorMsg;
	@FindBy(id = "password-helper-text")
	private WebElement enterPasswordErrorMsg;
	@FindBy(id = "confirmPassword-helper-text")
	private WebElement confirmPasswordErrorMsg;
	@FindBy(id = "password-helper-text")
	private WebElement passwordLeastCharErrorMsg;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSignin;
	@FindBy(xpath = "//div[text()='Username or password is invalid']")
	private WebElement txtErrorSignin;
	@FindBy(xpath = "//span[text() = 'Next']")
	private WebElement btnNext;
	@FindBy(xpath = "//span[text()='Home']")
	private WebElement txtUserVerifyMsg;
	@FindBy(xpath = "//*[@id=\"bankaccount-bankName-input\"]")
	private WebElement txtBankAccount;
	@FindBy(xpath = "//*[@id=\"bankaccount-routingNumber-input\"]")
	private WebElement txtRoutingNum;
	@FindBy(xpath = "//*[@id=\"bankaccount-accountNumber-input\"]")
	private WebElement txtAccNum;
	@FindBy(xpath = "//h2[text()='Finished']")
	private WebElement txtFinishedMsg;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement btnSave;
	@FindBy(xpath = "//span [text()='Done']")
	private WebElement btnDone;
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement btnLogout;

	public WebElement getLinkSignup() {
		return linkSignup;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getTxtConfirmPassword() {
		return txtConfirmPassword;
	}

	public WebElement getTxtSignup() {
		return txtSignup;
	}

	public WebElement getBtnSignup() {
		return btnSignup;
	}

	public WebElement getTxtSignin() {
		return txtSignin;
	}

	public WebElement getEnterBankNameErrorMsg() {
		return enterBankNameErrorMsg;
	}

	public WebElement getEnterValidBankRoutingNumberErrorMsg() {
		return enterValidBankRoutingNumberErrorMsg;
	}

	public WebElement getEnterValidBankAcNumberErrorMsg() {
		return enterValidBankAcNumberErrorMsg;
	}

	public WebElement getFirstNameRequiredErrorMsg() {
		return firstNameRequiredErrorMsg;
	}

	public WebElement getLastNameRequiredErrorMsg() {
		return lastNameRequiredErrorMsg;
	}

	public WebElement getUserNameRequiredErrorMsg() {
		return userNameRequiredErrorMsg;
	}

	public WebElement getEnterPasswordErrorMsg() {
		return enterPasswordErrorMsg;
	}

	public WebElement getConfirmPasswordErrorMsg() {
		return confirmPasswordErrorMsg;
	}

	public WebElement getPasswordLeastCharErrorMsg() {
		return passwordLeastCharErrorMsg;
	}

	public WebElement getBtnSignin() {
		return btnSignin;
	}

	public WebElement getTxtErrorSignin() {
		return txtErrorSignin;
	}

	public WebElement getBtnNext() {
		return btnNext;
	}

	public WebElement getTxtUserVerifyMsg() {
		return txtUserVerifyMsg;
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

	public WebElement getTxtFinishedMsg() {
		return txtFinishedMsg;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getBtnDone() {
		return btnDone;
	}

	public WebElement getBtnLogout() {
		return btnLogout;
	}

	public void signUp(String firstname, String lastname, String username, String password, String confirmpassword) {
		elementClick(getLinkSignup());
		implicitWait();
		elementClick(getLinkSignup());
		elementSendKeys(getTxtFirstName(), firstname);
		elementSendKeys(getTxtLastName(), lastname);
		elementSendKeys(getTxtUserName(), username);
		elementSendKeys(getTxtPassword(), password);
		elementSendKeys(getTxtConfirmPassword(), confirmpassword);
		elementSendKeys(getTxtFirstName(), firstname);
		implicitWait();
	}

	public void signupBtn() {
		elementClick(getBtnSignup());
	}

	public void nextBtn() {
		elementClick(getBtnNext());
	}

	public void doneBtn() {
		elementClick(getBtnDone());
	}

	public void saveBtn() {
		elementClick(getBtnSave());
	}

	public void logoutBtn() {
		elementClick(getBtnLogout());
	}

	public void createBankAccount(String bankname, String routingnumber, String accountnumber) {
			elementSendKeys(getTxtBankAccount(), bankname);
			elementSendKeys(getTxtRoutingNum(), routingnumber);
			elementSendKeys(getTxtAccNum(), accountnumber);
			elementClick(getTxtBankAccount());

	}

	public void signIn(String username, String password) {
		elementSendKeys(getTxtUserName(), username);
		elementSendKeys(getTxtPassword(), password);
		if (getBtnSignin().isEnabled()) {
			elementClick(getBtnSignin());
		} else {
			elementSendKeys(getTxtUserName(), username);
		}
		implicitWait();
	}

	public void signInWithEnterKey(String username, String password) throws AWTException {
		elementSendKeys(getTxtUserName(), username);
		elementSendKeys(getTxtPassword(), password);
		implicitWait();
		enter();
		
	}
}
