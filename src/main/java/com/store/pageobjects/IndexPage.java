package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class IndexPage extends BaseClass {
	 
	Action action= new Action();
	
	 @FindBy(xpath="//a[@class='login']")
	 WebElement signInBtn;
	 
	 @FindBy(xpath="//img[@class=\"logo img-responsive\"]")
	 WebElement storeLogo;
	 
	 @FindBy(id="search_query_top")
	 WebElement searchProductBox;
	 
	 @FindBy(name="submit_search")
	 WebElement searchProductBtn;
	 
	 public IndexPage() {
		 PageFactory.initElements(getDriver(), this);
	 }
	 
	 public LoginPage clickOnSignIn() {
		 action.fluentWait(getDriver(), signInBtn, 10);
		 action.click(getDriver(), signInBtn);
		 return new LoginPage();
	 }
	
	 public boolean validateLogo() {
		 return action.isDisplayed(getDriver(), storeLogo);
	 }
	
	 public String getStoreTitle() {  
		  String storeTitle = getDriver().getTitle();
		  return storeTitle;
	 }
	 
	 public SearchResultsPage searchProduct(String productName) { 
		 action.type(searchProductBox, productName );
		 action.click(getDriver(), searchProductBtn);
		 return new SearchResultsPage();
	 }
	 
}
