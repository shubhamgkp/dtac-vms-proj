package com.qa.dtac.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.qa.dtac.generic.Utility;


public class HomePage extends BasePage
{
	@FindBy(xpath="//span[contains(text(),'Saurav Upadhyay')]")
	private WebElement vms;
	
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logout;
	
	
	@FindBy(xpath = "//input[@name='loginid']")
	private WebElement un;
	

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	public void verifyLogoutSuccessfully()
	{
		if(Utility.verifyElementIsPresent(driver, un))
		{
			log.info("logout succefully...");
		}
		else
		{
			log.error("Error!!! unable to logout...");
			Assert.fail();
		}
	}
	
	public void clickOnDatcAdmin()
	{
		vms.click();
	}
	public void logout()
	{
		logout.click();
	}

}