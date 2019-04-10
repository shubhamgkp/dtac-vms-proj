package com.create.testscript;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.dtac.base.BaseTest;
import com.qa.dtac.generic.Utility;
import com.qa.dtac.pages.CreateRoleType;
import com.qa.dtac.pages.LoginPage;


@Listeners(com.qa.dtac.generic.TestListener.class)
public class CreateRoleTestscript extends BaseTest
{
	//String role_Name="";
	@Test(invocationCount=5)
public void testRoleCreate() throws InterruptedException, IOException, SQLException {
		
		
	
			LoginPage lp = new LoginPage(driver);
			lp.setLoginId("123");
			lp.setLoginPass("123");
			lp.setLoginButtonClick();
			Thread.sleep(3000);
			
			String code=Utility.getAlphaNumericString(15);
			Thread.sleep(3000);
			String name=Utility.AlphaNumericString(37);
			

			CreateRoleType role = new CreateRoleType(driver);
			role.RoleType();
			role.CreateRole();
			role.RoleTypeCode(code);
			
			role.RoleTypeName(name);
			role.RList();
			role.Button();
			Assert.assertEquals(role.verify(), true);
			System.out.println("code--------->"+code);
			System.out.println("name------>"+name);
			Utility.dataBaseConnection("select * from vms_acl_role_type where role_type_code='"+code+"'");
			Thread.sleep(5000);
			String rolecode=Utility.result.getString("role_type_code");
            Assert.assertEquals(code, rolecode);

		
		
}
}
