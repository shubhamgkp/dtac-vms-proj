package com.qa.dtac.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.dtac.base.BasePage;
import com.qa.dtac.generic.Utility;

public class SearchGroupRole extends BasePage{

	public SearchGroupRole(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[text()='Group Role']")
	WebElement grouprole;
	
	@FindBy(xpath="//a[text()='Search Group Type']")
	WebElement searchgroup;
	
	@FindBy(xpath="//select[@formcontrolname='roleTypeCode']")
	WebElement roletype;
	
	@FindBy (xpath="//input[@id='groupTypeCode']")
	WebElement grouprolecode;
	
	@FindBy(xpath="//input[@id='groupTypeName']")
	WebElement grouprolename;
	
	@FindBy(xpath="//select[@formcontrolname='status']")
	WebElement status;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement search;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement msg;
	public void Grouprole()
	{
		grouprole.click();
	}
	public void a()
	{
		
	}
	public void Searchgroup()
	{
		searchgroup.click();
	}
	
	public void Rtype()
	{
		Utility.drop(roletype, "Gera304");
		roletype.click();
	}
	
	public void GroupRoleCode(String rolecode)
	{
		grouprolecode.sendKeys(rolecode);
	}
	
	public void GroupRoleName(String rolename)
	{
		grouprolename.sendKeys(rolename);
	}
	public void userstatus()
	{
      Utility.drop(status, "ALL");
     
	}
	
	public void search()
	{
		search.click();
	}

	public boolean msg()
	{
		return msg.isDisplayed();
	}
}
