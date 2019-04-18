package com.qa.dtac.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.dtac.base.BasePage;
import com.qa.dtac.generic.Utility;

public class EditGroupRole extends BasePage{

	public EditGroupRole(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
	
	/*@FindBy(xpath="//i[@placement='top'][3]")
	WebElement edit;*/	
/*	@FindBy(xpath="//i[@class='ti-pencil text-info m-r-10'][3]")
	WebElement edit;*/
	
	/*@FindBy(xpath="//i[@class='ti-pencil text-info m-r-10'][2]")
	List<WebElement> edit;
	*/
	
	@FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody[1]/tr[1]/td[5]/div[1]/div[2]")
	WebElement edit;
	@FindBy(xpath="//input[@id='groupTypeName']")
	WebElement groupnameclear;
	
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
	
	/*
	 * public void GroupRoleCode(String rolecode) {
	 * grouprolecode.sendKeys(rolecode); }
	 * 
	 * public void GroupRoleName(String rolename) {
	 * grouprolename.sendKeys(rolename); }
	 */
	public void userstatus()
	{
      Utility.drop(status, "ALL");
     
	}
	
	public void search()
	{
		search.click();
	}
	
	public  void Edit() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", edit);
		//Thread.sleep(5000);
		//edit.get(3).click();
		edit.click();
		//edit.click();
		
	}
	
	public void clear()
	{
		groupnameclear.clear();
		groupnameclear.sendKeys("abc");
	
	}

	
}
