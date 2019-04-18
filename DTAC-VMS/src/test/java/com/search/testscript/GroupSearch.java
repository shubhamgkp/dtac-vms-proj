package com.search.testscript;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.dtac.base.BaseTest;
import com.qa.dtac.generic.Utility;
import com.qa.dtac.pages.LoginPage;
import com.qa.dtac.pages.SearchGroupRole;

public class GroupSearch extends BaseTest {
	
	@Test
	public void testgrouproleSearch() throws InterruptedException, SQLException {
		LoginPage lp = new LoginPage(driver);
		lp.setLoginId("123");
		lp.setLoginPass("123");
		lp.setLoginButtonClick();
		/*String rolecode = Utility.AlphaNumericString(10);
		String rolename = Utility.getAlphaNumericString(10);*/
		
		SearchGroupRole obj= new SearchGroupRole(driver);
		obj.Grouprole();
		obj.Searchgroup();
		obj.Rtype();
		obj.GroupRoleCode("");
		obj.GroupRoleName("");
		obj.userstatus();
		Thread.sleep(2000);
		obj.search();
		/*System.out.println("code--------->" + GroupRoleCode);
		System.out.println("name------>" + rolename);*/
		String message=driver.findElement(By.xpath("//th[text()='Role Type']")).getText();
		Assert.assertEquals(message, "Role Type");

	}
}
