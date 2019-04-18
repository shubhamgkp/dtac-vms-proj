package com.qa.dtac.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.dtac.base.BasePage;
import com.qa.dtac.generic.Utility;

public class CreateGroupRole extends BasePage {

	public CreateGroupRole(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[text()='Group Role']")
	WebElement grouprole;
	
	@FindBy(xpath="//a[text()='Create Group Role']")
	WebElement creategrouptype;
	
	@FindBy(xpath="//select[@formcontrolname='roleTypeCode']")
	WebElement roletype;
	
	@FindBy (xpath="//input[@id='groupTypeCode']")
	WebElement grouprolecode;
	
	@FindBy(xpath="//input[@id='groupTypeName']")
	WebElement grouprolename;
	
	@FindBy(xpath="//select[@formcontrolname='status']")
	WebElement status;
	
	/*public List<WebElement> roleName(String s)
	{
		 List<WebElement> rolesrights=driver.findElements(By.xpath("//div[@_ngcontent-c2='']//div[@class='ng-untouched ng-pristine ng-valid']//label[contains(text(),'s')]"));
		
		return rolesrights;
	}*/
	//@FindBy(xpath="//div[@_ngcontent-c2='']//div[@class='ng-untouched ng-pristine ng-valid']//label[contains(text(),'role')]")
	//@FindBy(xpath="//input[@class='ng-untouched ng-pristine']")
	@FindBy(xpath="//input[@type='checkbox']")
	List<WebElement> rolesrights;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submit;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancel;
	public void GroupRole1()
	{
		grouprole.click();
	}
	
	public void creategroup()
	{
		creategrouptype.click();
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
      Utility.drop(status, "Active");
     
	}
	public void rights() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@type='checkbox']"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		rolesrights.get(0).click();
		rolesrights.get(2).click();
		rolesrights.get(4).click();
	}
	public void submit() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//button[text()='Submit']"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		submit.click();
	}
	public void cancel()
	{
		cancel.click();
	}
}
