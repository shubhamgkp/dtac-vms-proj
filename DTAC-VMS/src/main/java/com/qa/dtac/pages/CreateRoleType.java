package com.qa.dtac.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.dtac.base.BasePage;

public class CreateRoleType extends BasePage{
	public CreateRoleType(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//span[text()='Role Type']")
	WebElement roleType;

	@FindBy(xpath = "//a[text()='Create Role Type']")
	WebElement createRoleType;

	@FindBy(xpath = "//input[@id='roletypecode']")
	WebElement roleTypeCode;

	@FindBy(xpath = "//input[@id='roletypename']")
	WebElement roleTypeName;

	@FindBy(xpath = "//input[@formcontrolname='viewPermission']")
	List<WebElement> roleList;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submit;
	@FindBy(xpath = "//div[contains(text(),' Transaction Successful ')]")
	WebElement msg;
	
	


	public void RoleType() {

		roleType.click();

	}

	public void CreateRole() {
		createRoleType.click();
	}

	public void RoleTypeCode(String RoleTypeCode) {
		roleTypeCode.sendKeys(RoleTypeCode);
	}

	public void RoleTypeName(String RoleTypeName) {
		roleTypeName.sendKeys(RoleTypeName);
	}

	public void RList() {
		roleList.get(3).click();
	}

	public void Button() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//button[text()='Submit']"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		submit.click();
	}
	public boolean verify()
	{
	return 	msg.isDisplayed();
	}

}
