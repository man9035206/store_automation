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
public class OrderSummaryPage extends BaseClass{
	Action action = new Action();
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnconfirmOrderBtn() {
		action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}
}
