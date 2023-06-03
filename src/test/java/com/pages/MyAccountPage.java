package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class MyAccountPage extends BaseClass {
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@role='button'])[4]")
	private WebElement btnMyAccount;
	@FindBy(xpath = "//h2[text()='User Settings']")
	private WebElement txtUserSettingMsg;
	@FindBy(id = "user-settings-email-input")
	private WebElement txtEmail;
	@FindBy(id = "user-settings-phoneNumber-input")
	private WebElement txtPhoneNo;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSave;
	@FindBy(id = "user-settings-email-input-helper-text")
	private WebElement txtMustContainValidEmailErrorMsg;
	@FindBy(id = "user-settings-phoneNumber-input-helper-text")
	private WebElement txtPhoneNoNotValidErrorMsg;
	
	public WebElement getBtnMyAccount() {
		return btnMyAccount;
	}

	public WebElement getTxtUserSettingMsg() {
		return txtUserSettingMsg;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPhoneNo() {
		return txtPhoneNo;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getTxtMustContainValidEmailErrorMsg() {
		return txtMustContainValidEmailErrorMsg;
	}

	public WebElement getTxtPhoneNoNotValidErrorMsg() {
		return txtPhoneNoNotValidErrorMsg;
	}


public void enterDetails(String email, String phonenumber) {
	
	getTxtEmail().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
	elementSendKeys(getTxtEmail(), email);
	getTxtPhoneNo().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
	elementSendKeys(getTxtPhoneNo(), phonenumber);
	
	implicitWait();
}

}
