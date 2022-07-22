package com.store.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.store.base.BaseClass;
import com.store.pageobjects.IndexPage;
import com.store.utility.Log;

public class IndexPageTest extends BaseClass {
	
	IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	 
	@Test(groups = "Smoke") 
	public void verifyLogo() {
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyLogo");
		Log.info("Validating title");
		String title = indexPage.getStoreTitle();
		Assert.assertEquals(title, prop.getProperty("title"));
		Log.info("Validated title");
		Log.endTestCase("verifyLogo");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().close();
	}
}
