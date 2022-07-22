package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	@FindBy(xpath="//p[contains(text(),'Your order on My Store is complete.')]")
	private WebElement confirmMessag;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateConfirmMessage() {
		String confirmMsg=confirmMessag.getText();
		return confirmMsg;
	}
}
