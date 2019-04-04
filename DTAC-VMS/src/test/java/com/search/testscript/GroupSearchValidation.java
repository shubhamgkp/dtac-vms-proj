package com.search.testscript;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.dtac.base.BaseTest;
import com.qa.dtac.pages.LoginPage;
import com.qa.dtac.pages.SearchGroupRole;

public class GroupSearchValidation extends BaseTest {
	@Test(invocationCount = 1)
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
		obj.GroupRoleName("ac");
		obj.userstatus();
		Thread.sleep(4000);
		obj.search();
		/*System.out.println("code--------->" + GroupRoleCode);
		System.out.println("name------>" + rolename);*/
		Assert.assertTrue(obj.msg());

	}

}
