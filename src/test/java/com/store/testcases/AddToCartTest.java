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
import com.store.pageobjects.AddToCartPage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.OrderPage;
import com.store.pageobjects.SearchResultsPage;

/**
 * @author administrator
 *
 */
public class AddToCartTest extends BaseClass {
	IndexPage indexPage;
	SearchResultsPage searchResultsPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void addToCartTest() {
		indexPage = new IndexPage();
		searchResultsPage = indexPage.searchProduct("T-shirt");
		addToCartPage = searchResultsPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddToCartMsg();
		AssertJUnit.assertTrue(result);
//		orderPage = addToCartPage.clickOnCheckOut();
//		Double unitPrice = orderPage.getUnitPrice();
//		Double finalPrice = orderPage.getFinalPrice();
//		System.out.println("unit price :"+ unitPrice);
//		System.out.println("final price :"+ finalPrice);
//		Double totalExpectedPrice = (unitPrice*2)+2;
//		assertEquals(finalPrice, totalExpectedPrice);
	}
	
	 

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	} 
}
