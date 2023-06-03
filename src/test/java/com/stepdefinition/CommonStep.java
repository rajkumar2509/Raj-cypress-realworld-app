package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify user name {string}")
	public void userShouldVerifyUserName(String expUserNameMsg) {
		implicitWait();
		WebElement txtUserVerifyMsg = pom.getAuthorizationPage().getTxtUserVerifyMsg();
		String actUserVerifyMsg = elementGetText(txtUserVerifyMsg);
		boolean containsUserVerifyMsg = actUserVerifyMsg.contains(expUserNameMsg);
		Assert.assertTrue("Verify user name msg after signin", containsUserVerifyMsg);
	}
}
