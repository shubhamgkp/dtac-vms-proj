package com.qa.dtac.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.dtac.base.BasePage;
import com.qa.dtac.generic.Utility;

public class CreateInternalUserPage  extends BasePage{

	@FindBy(xpath="//span[contains(text(),'User Maintenance')]")  private WebElement userMaintenance;	
	@FindBy(xpath="//a[contains(text(),'Create Internal User')]") private WebElement createInternalUser;
	@FindBy(xpath="//select[@formcontrolname='roleTypeCode']") private WebElement roleType;
	@FindBy(id="userloginid") private WebElement userLoginid;
	@FindBy(id="firstname") private WebElement firstName;
	@FindBy(id="lastname") private WebElement lastName;
	@FindBy(id="contactno") private WebElement contactno;
	@FindBy(id="notificationlanguage") private WebElement notificationLanguage;
	@FindBy(id="email") private WebElement email;
	@FindBy(id="logincredentialsmaintained") private WebElement loginCredentialsMaintained;
	@FindBy(id="grouproles") private WebElement groupRoles;
	@FindBy(id="submitForm") private WebElement submitButton;
	@FindBy(id="backToDashBoard") private WebElement cancelButton;
	@FindBy(xpath="//div[contains(text(),'Transaction Successful')]") private WebElement msg;
	@FindBy(xpath="//div[contains(text(),'Enter valid user login Id')]") private WebElement errorUserloginId;
	@FindBy(xpath="//div[contains(text(),'Enter valid First Name')]") private WebElement errorFN;
	@FindBy(xpath="//div[contains(text(),'Enter valid Last Name')]") private WebElement errorLN;
	@FindBy(xpath="//div[contains(text(),'Enter valid contact Number')]") private WebElement errorContctNo;
	@FindBy(xpath="//div[contains(text(),'Enter email address')]") private WebElement errorEmail;
	@FindBy(xpath="//div[contains(text(),'Valid Login Id should have minimum 4 ')]") private WebElement minLoginId;
	@FindBy(xpath="//div[contains(text(),'Valid contact Number should have minimum 11 ')]") private WebElement minContctNo;
	@FindBy(xpath="//div[contains(text(),'Valid email address should have minimum 4 ')]") private WebElement minEmail;
	
	@FindBy(xpath="//div[contains(text(),'Allowed Special characters are _ and -')]") private WebElement spcLoginId;
	@FindBy(xpath="//div[contains(text(),'Special characters *, $, &, %, -, > and < are excluded.')]") private WebElement spcFLN;
	@FindBy(xpath="//div[contains(text(),'Enter numeric value only')]") private WebElement  spcCont;
	@FindBy(xpath="//div[contains(text(),'Enter valid email address')]") private WebElement  spcEmail;
	public CreateInternalUserPage(WebDriver driver) {
		super(driver);
	}
	public void clickOnUserMaintenance()
	{
		userMaintenance.click();
	}
	public void clickOnCreateInternalUser()
	{
		createInternalUser.click();
	}
	
	public void roleType() throws InterruptedException
	{
		
		Utility.selectValueFromDropdown(roleType, "Gera304");
		roleType.click();
		//Thread.sleep(3000);
		
	}
	public void userLoginid(String loginName)
	{
		userLoginid.sendKeys(loginName);
	}
	public void firstName(String firstname)
	{
		firstName.sendKeys(firstname);
	}
	public void lastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	public void contactNo(String contactNo)
	{
		contactno.sendKeys(contactNo);
	}
	public void email(String emails)
	{
		email.sendKeys(emails);
	}
	public void groupRoles()
	{
		Utility.selectValueFromDropdown(groupRoles, "");
	}
	
	public void clickOnSubmitButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", submitButton);
		submitButton.click();
	}
	public void clickOnCancelButton()
	{
		cancelButton.click();
	}
	public boolean message()
	{
		return msg.isDisplayed();
	}
	
	public boolean errorLoginId()
	{
		return errorUserloginId.isDisplayed();
	}
	public boolean errorFirstName()
	{
		return errorFN.isDisplayed();
	}
	public boolean errorLastName()
	{
		return errorLN.isDisplayed();
	}
	public boolean errorContctNo()
	{
		return errorContctNo.isDisplayed();
	}
	public boolean errorEmail()
	{
		return errorEmail.isDisplayed();
	}
	
	
	public boolean minEmail()
	{
		return minEmail.isDisplayed();
	}
	
	public boolean minContactNo()
	{
		return minContctNo.isDisplayed();
	}
	
	public boolean minLoginId()
	{
		return minLoginId.isDisplayed();
	}
	public boolean spcLoginId()
	{
		return spcLoginId.isDisplayed();
	}
	public boolean spcFLN()
	{
		return spcFLN.isDisplayed();
	}
	public boolean spcContact()
	{
		return spcCont.isDisplayed();
	}
	public boolean spcEmail()
	{
		return spcEmail.isDisplayed();
	}
	
	

}