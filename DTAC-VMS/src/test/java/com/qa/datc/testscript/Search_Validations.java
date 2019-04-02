package com.qa.datc.testscript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.qa.dtac.base.BaseTest;
import com.qa.dtac.pages.LoginPage;
import com.qa.dtac.pages.SearchRoleType;

@Listeners(com.qa.dtac.generic.TestListener.class)
public class Search_Validations extends BaseTest {
	
	@Test(invocationCount = 1)
	public void searchRole() throws InterruptedException {

			LoginPage lp = new LoginPage(driver);
			lp.setLoginId("123");
			lp.setLoginPass("123");
			lp.setLoginButtonClick();
			Thread.sleep(3000);

			SearchRoleType sc = new SearchRoleType(driver);
			sc.roleType();
			sc.SearchType();
			sc.code("124");
			sc.name("Mukul");
			Thread.sleep(5000);
			sc.drop();
			sc.search();
			/*driver.findElement(By.xpath("//th[@class='sorting_asc']")).getText();
			System.out.println(driver.findElement(By.xpath("//th[@class='sorting_asc']")).getText());*/
			// Assert.assertEquals(driver.findElement(By.xpath("//th[@class='sorting_asc']")).getText(),
			// "Role Type Cod");
			Assert.assertTrue(sc.msg());
			
			
	}

}
