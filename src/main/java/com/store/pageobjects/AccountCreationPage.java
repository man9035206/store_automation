/**
 * 
 */
package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

/**
 * @author administrator
 *
 */
public class AccountCreationPage extends BaseClass { 
	Action action = new Action();
	
	@FindBy(xpath = "//h1[text()=\"Create an account\"]")
	WebElement formTitle; 
	
	
	public AccountCreationPage() {
		 PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateFormTitle() {
		return action.isDisplayed(getDriver(), formTitle);
	}
}
