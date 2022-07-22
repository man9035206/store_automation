package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class LoginPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="passwd")
	WebElement userPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement submitLoginBtn;
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	WebElement createNewAccBtn;
	
	public LoginPage() {
		 PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String email, String password) {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, email);
		action.type(userPassword, password);
		action.click(getDriver(), submitLoginBtn);
		return new HomePage();
	}
	
	public AddressPage login(String email, String password, AddressPage addressPage) {
		action.type(userName, email);
		action.type(userPassword, password);
		action.click(getDriver(), submitLoginBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createAccount(String email) {
		action.type(emailForNewAccount, email);
		action.click(getDriver(), createNewAccBtn);
		return new AccountCreationPage();
	}
}
