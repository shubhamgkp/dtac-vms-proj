package com.search.testscript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.dtac.base.BaseTest;
import com.qa.dtac.pages.EditGroupRole;
import com.qa.dtac.pages.LoginPage;

public class EditGroup extends BaseTest {
     @Test
	public void editrole () throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setLoginId("123");
		lp.setLoginPass("123");
		lp.setLoginButtonClick();
		Thread.sleep(3000);
		
		EditGroupRole obj= new EditGroupRole(driver);
		obj.Grouprole();
		obj.Searchgroup();
		obj.Rtype();
		obj.userstatus();
		Thread.sleep(5000);
		obj.search();
		Thread.sleep(5000);
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");*/
		// WebElement.sendKeys(Keys.DOWN, Keys.RETURN);
		obj.Edit();
		Thread.sleep(5000);
		obj.clear();
		Thread.sleep(5000);
	}
	
}
