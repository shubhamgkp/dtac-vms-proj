package com.qa.dtac.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.dtac.base.BasePage;
import com.qa.dtac.generic.Utility;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//input[@name='loginid']") // PAGE FACTORY MODEL
	WebElement userLoginId;

	@FindBy(xpath = "//input[@name='pass']")
	WebElement userLoginPass;
	
	@FindBy(xpath="//select[@id='language']")
	WebElement language;
	

	@FindBy(xpath = "//button[text()='Login']")
	WebElement userLoginButtonClick;
	
	public void setLoginId(String strLoginId) {

		userLoginId.sendKeys(strLoginId);
	}

	public void setLoginPass(String strPass) {
		userLoginPass.sendKeys(strPass);

	}

	public void language()
	{
		//language.click();
		Utility.drop(language, "English");
	}
	public void setLoginButtonClick() {

		userLoginButtonClick.click();

	}
	/*
	 * public void Login(String login, String pass) {
	 * 
	 * driver.findElement(By.xpath("//input[@name='loginid']")).sendKeys(login);
	 * driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(pass);
	 * driver.findElement(By.xpath("//button[text()='Login']")).click(); }
	 */
}
