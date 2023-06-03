package com.pagemanager;

import com.pages.AuthorizationPage;
import com.pages.BankAccountsPage;
import com.pages.MyAccountPage;
import com.pages.TransactionsPage;

public class PageObjectManager {
	private AuthorizationPage authorizationPage;
	private MyAccountPage myAccountPage;
	private BankAccountsPage bankAccountsPage;
	private TransactionsPage transactionPage;

	public AuthorizationPage getAuthorizationPage() {
		return (authorizationPage == null) ? authorizationPage = new AuthorizationPage() : authorizationPage;
	}
	public MyAccountPage getMyAccountPage() {
		return (myAccountPage == null) ? myAccountPage = new MyAccountPage() : myAccountPage;
	}
	public BankAccountsPage geBankAccountsPage() {
		return (bankAccountsPage == null) ? bankAccountsPage = new BankAccountsPage() : bankAccountsPage;
	}
	public TransactionsPage getTransactionPage() {
		return (transactionPage == null) ? transactionPage = new TransactionsPage() : transactionPage;
	}
}
