package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.store.base.BaseClass;
import com.store.dataprovider.DataProviders;
import com.store.pageobjects.HomePage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials",dataProviderClass = DataProviders.class)
	public void logiTest(String uname, String pswd) throws InterruptedException {
		System.out.println(uname);
		indexPage= new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(uname,pswd);
		String actualUrl = homePage.getCurrentUrl();
		String expectedUrl="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualUrl, expectedUrl);
		 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
