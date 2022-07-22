/**
 * 
 */
package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.base.BaseClass;

/**
 * @author administrator
 *
 */
public class SearchResultsPage extends BaseClass {
	
	@FindBy(xpath = "//*[@id=\"center_column\"]//img")
	WebElement productResult;
	
	public SearchResultsPage() { 
		 PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductavailable() {
		return productResult.isDisplayed();
	}
	
	public AddToCartPage clickOnProduct() {
		productResult.click();
		return new AddToCartPage();
	}
	
}
