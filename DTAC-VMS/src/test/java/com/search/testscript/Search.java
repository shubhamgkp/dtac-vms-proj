package com.search.testscript;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.dtac.base.BaseTest;
import com.qa.dtac.pages.LoginPage;
import com.qa.dtac.pages.SearchRoleType;

@Listeners(com.qa.dtac.generic.TestListener.class)
public class Search extends BaseTest {
	
	@Test(invocationCount=1)
	
	public void searchRole() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setLoginId("123");
		lp.setLoginPass("123");
		lp.setLoginButtonClick();
		Thread.sleep(3000);
		
		SearchRoleType sc= new SearchRoleType(driver);
		sc.roleType();
		sc.SearchType();
		sc.code("");
		sc.name("Mukul");
		//Thread.sleep(2000);
		sc.drop();
		sc.search();
		String msg= driver.findElement(By.xpath("//th[@class='sorting_asc']")).getText();
		Assert.assertEquals(msg, "Role Type Name");
		
		
		
		
		
	}
	
}
