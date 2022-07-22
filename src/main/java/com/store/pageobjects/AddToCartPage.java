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
public class AddToCartPage extends BaseClass {
	Action action = new Action();
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement size;
	
	@FindBy(xpath = "//span[text()=\"Add to cart\"]")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[@id=\"layer_cart\"]//h2//i")
	WebElement addedToCartMsg;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement checkOutBtn;
	
	public AddToCartPage() { 
		 PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String qntity) {
		action.type(quantity, qntity);
	}
	
	public void selectSize(String size1) {
		action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() {
		
		action.click(getDriver(), addToCartBtn);
//		addToCartBtn.click();
//		action.fluentWait(driver, checkOutBtn, 10);
	}
	
	public boolean validateAddToCartMsg() {
		action.fluentWait(getDriver(), addedToCartMsg, 10);
		return addedToCartMsg.isDisplayed();
	}
	
	public OrderPage clickOnCheckOut() {
		action.fluentWait(getDriver(), checkOutBtn, 10);
		action.JSClick(getDriver(), checkOutBtn);
		return new OrderPage();
	}
	
}
