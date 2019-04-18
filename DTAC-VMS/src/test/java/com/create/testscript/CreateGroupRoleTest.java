package com.create.testscript;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.dtac.base.BaseTest;
import com.qa.dtac.generic.Utility;
import com.qa.dtac.pages.CreateGroupRole;
import com.qa.dtac.pages.LoginPage;

public class CreateGroupRoleTest extends BaseTest {
	@Test
	public void testgrouprole() throws InterruptedException, SQLException {
		LoginPage lp = new LoginPage(driver);
		lp.setLoginId("123");
		lp.setLoginPass("123");
		lp.setLoginButtonClick();
		String rolecode = Utility.AlphaNumericString(10);
		String rolename = Utility.getAlphaNumericString(10);
		CreateGroupRole obj = new CreateGroupRole(driver);

		obj.GroupRole1();

		obj.creategroup();
		obj.Rtype();
		obj.GroupRoleCode(rolecode);
		obj.GroupRoleName(rolename);
		obj.userstatus();

		obj.rights();

		obj.submit();
		System.out.println("code--------->" + rolecode);
		System.out.println("name------>" + rolename);
		Utility.dataBaseConnection("select * from vms_acl_group_role where group_role_name='" + rolename + "'");
		Thread.sleep(5000);
		String rolename_db = Utility.result.getString("group_role_name");
		Assert.assertEquals(rolename_db, rolename);
	}

}
