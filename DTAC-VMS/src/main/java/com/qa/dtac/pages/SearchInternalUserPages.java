package com.qa.dtac.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.dtac.base.BasePage;

public class SearchInternalUserPages extends BasePage {
	@FindBy(xpath="//span[contains(text(),'User Maintenance')]")  private WebElement userMaintenance;	
	@FindBy(xpath="//a[contains(text(),'Search Internal User')]") private WebElement searchInternalUser;
	@FindBy(xpath="//input[@id='loginid']") private WebElement loginId;
	@FindBy(id="userloginid") private WebElement userLoginid;
	@FindBy(id="firstname") private WebElement firstName;
	@FindBy(id="lastname") private WebElement lastName;
	@FindBy(xpath="//button[@id='submitForm']") private WebElement searchButton;
	@FindBy(xpath="//th[contains(text(),'User Login ID')]") private WebElement userLoginDisplayed;
	@FindBy(xpath="//td[text()='mukul']") private WebElement dataDisplayed;
	
	
	public SearchInternalUserPages(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnUserMaintenance()
	{
		userMaintenance.click();
	}
	public void clickOnSearcgInternalUser()
	{
		searchInternalUser.click();
	}
	public void userLoginid(String loginName)
	{
		loginId.sendKeys(loginName);
	}
	public void firstName(String firstname)
	{
		firstName.sendKeys(firstname);
	}
	public void lastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	public void clickOnSearchButton() throws InterruptedException
	{
		Thread.sleep(2000);
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", searchButton);*/
		searchButton.click();
	}
	public boolean elementDistplayed()
	{
		return userLoginDisplayed.isDisplayed();
		
	}

	public boolean dataDisplayed()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dataDisplayed);
		return dataDisplayed.isDisplayed();
		
	}
}
