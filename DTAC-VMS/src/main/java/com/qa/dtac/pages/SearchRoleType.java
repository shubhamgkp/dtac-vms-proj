package com.qa.dtac.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.dtac.base.BasePage;
import com.qa.dtac.generic.Utility;


public class SearchRoleType extends BasePage{
	
	public SearchRoleType(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[text()='Role Type']")
	WebElement roleType;
	
	@FindBy(xpath="//a[text()='Search Role Type']")
	WebElement searchType;

	@FindBy(xpath="//input[@id='roletypecode']")
	WebElement roleTypecode;
	
	@FindBy(xpath = "//input[@id='roletypename']")
	WebElement roleTypeName;
	
	@FindBy(xpath="//select[@formcontrolname='status']")
	WebElement dropdown;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement search;
	
	@FindBy(xpath="//div[text()='Valid Role Type Code should have minimum 4 and maximum 15 alphanumeric digits']")
	WebElement msg;
	
	public void roleType()
	{
		roleType.click();
	}
	
	public void SearchType()
	{
		searchType.click();
	}
	public void code(String code)
	{
		
		roleTypecode.sendKeys(code);	
	}
	
	public void name(String name)
	{
		roleTypeName.sendKeys(name);
	}
	
	public void drop()
	{
		Utility.drop(dropdown, "Active");
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
