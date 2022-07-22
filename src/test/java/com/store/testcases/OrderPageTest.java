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
public class OrderPageTest extends BaseClass {
	
	private IndexPage index;
	private SearchResultsPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		index= new IndexPage();
		searchResultPage=index.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getFinalPrice();
		System.out.println("unit price :" + unitPrice);
		System.out.println("final price :" + totalPrice);
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble(qty)))+2;
		System.out.println("totalExpectedPrice :" + totalExpectedPrice);
		AssertJUnit.assertEquals(totalPrice, totalExpectedPrice);
	}
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	} 
	
}
