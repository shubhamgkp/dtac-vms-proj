package com.createinternaluser;

import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.dtac.base.BaseTest;
import com.qa.dtac.generic.Utility;
import com.qa.dtac.pages.CreateInternalUserPage;


public class CreateInternalUserWithValidData  extends BaseTest
{
	String loginNames;
	@Test
	public void  testCreateInternalUserWithValidData() throws InterruptedException, SQLException
	{
		String loginName=Utility.randomString(7);
		String firstname=Utility.randomString(7);
		String lastname=Utility.randomString(5);
		String contactNo="345262718765";
		String emails=Utility.randomString(5);
		String email=emails+"@hr.com";
		CreateInternalUserPage cr=new CreateInternalUserPage(driver);
		cr.clickOnUserMaintenance();
		cr.clickOnCreateInternalUser();
		Thread.sleep(3000);
		cr.roleType();
		cr.userLoginid(loginName);
		cr.firstName(firstname);
		cr.lastName(lastname);
		cr.contactNo(contactNo);
		cr.email(email);
		Thread.sleep(7000);
		cr.clickOnSubmitButton();
		Utility.dataBaseConnection("select * from vms_user_profile where user_code='"+loginName+"'");
		Thread.sleep(5000);
		 loginNames=Utility.result.getString("user_code");
        Assert.assertEquals(loginNames, loginName);
		Assert.assertEquals(cr.message(), true);	
		
	}
}
