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
public class OrderPage extends BaseClass {
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	private WebElement unitPrice;
	
	@FindBy(id="total_price")
	private WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	
	public OrderPage() { 
		 PageFactory.initElements(getDriver(), this);
	}
	
	
	public double getUnitPrice() {
		String unitPrice1 = unitPrice.getText(); 
		String unit= unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		System.out.println("unit price :"+ unit);
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getFinalPrice() {
		String finalPrice1 = totalPrice.getText(); 
		String price= finalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalPrice = Double.parseDouble(price);
		return finalPrice/100;
	}
	
	public LoginPage clickOnCheckout() {
		proceedToCheckOut.click();
		return new LoginPage();
	}
	
	
}
