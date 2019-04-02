package com.qa.dtac.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.dtac.base.BasePage;
import com.qa.dtac.generic.Utility;


public class EditRoleType extends BasePage{

	public EditRoleType(WebDriver driver) {
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

	@FindBy(xpath="//i[@class='ti-pencil text-info m-r-10']")
	List<WebElement> allElements;

	
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
		Utility.drop(dropdown, "ALL");
	}

	public void search()
	{
		search.click();
	}

	public void edit() throws InterruptedException
	{

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebElement element = driver.findElement(By.xpath("//i[@class='ti-pencil text-info m-r-10']"));
			js.executeScript("arguments[0].scrollIntoView();", allElements);
			allElements.get(5).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebElement element = driver.findElement(By.xpath("//i[@class='ti-pencil text-info m-r-10']"));
			js.executeScript("arguments[0].scrollIntoView();", allElements);
			allElements.get(5).click();
		}	

		
	}

}
