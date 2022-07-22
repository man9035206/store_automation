/**
 * 
 */
package com.store.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.store.base.BaseClass;
import com.store.dataprovider.DataProviders;
import com.store.pageobjects.*;

/**
 * @author administrator
 *
 */
public class EndToEndTest extends BaseClass {
	private IndexPage index;
	private SearchResultsPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummaryPage orderSummary;
	private OrderConfirmationPage orderConfirmationPage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test(dataProvider = "getProduct",dataProviderClass = DataProviders.class,groups = "Regression")
	public void endToEndTest(String productName, String qty, String size) {
		index = new IndexPage();
		searchResultPage = index.searchProduct(productName);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckout();
		
		addressPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		AssertJUnit.assertEquals(actualMessage, expectedMsg);
		
		
	}
	
	

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	} 

}
