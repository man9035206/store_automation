/**
 * 
 */
package com.store.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.store.base.BaseClass;
import com.store.dataprovider.DataProviders;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.SearchResultsPage;

/**
 * @author administrator
 *
 */
public class SearchResultTest extends BaseClass {
	IndexPage indexPage;
	SearchResultsPage searchResultsPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	

	@Test(groups = "Smoke",dataProvider = "searchProduct",dataProviderClass = DataProviders.class)
	public void productAvailblelityTest(String productName) {
		indexPage = new IndexPage();
		searchResultsPage = indexPage.searchProduct(productName);
		Boolean result = searchResultsPage.isProductavailable();
		Assert.assertTrue(result);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
