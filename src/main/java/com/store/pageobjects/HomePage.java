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
public class HomePage extends BaseClass {
	Action action = new Action();
	
	@FindBy(xpath="//span[text()=\"My wishlists\"]")
	WebElement myWishLists;
	
	@FindBy(xpath = "//span[text()=\"Order history and details\"]")
	WebElement OrderHistory;
	
	public HomePage() {
		 PageFactory.initElements(getDriver(), this);
	 }
	
	public boolean validateMyWishList() {
		return action.isDisplayed(getDriver(),myWishLists);
		
	}
	
	public boolean validateOrderHistory() {
		return action.isDisplayed(getDriver(),OrderHistory);
	}
	
	public String getCurrentUrl() {
		String currentUrl = getDriver().getCurrentUrl();
		return currentUrl;
	}
	
}
