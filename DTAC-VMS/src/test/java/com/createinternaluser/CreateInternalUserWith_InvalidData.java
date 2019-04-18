package com.createinternaluser;

import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.dtac.base.BaseTest;
import com.qa.dtac.generic.Utility;
import com.qa.dtac.pages.CreateInternalUserPage;

public class CreateInternalUserWith_InvalidData  extends BaseTest
{
	String loginNames;
	@Test
	public void  testCreateInternalUserWith_InvalidData() throws InterruptedException, SQLException
	{
		String loginName=Utility.randomString(3);
		Integer contactNo=Utility.randomNumber(222, 999);
		String emails=Utility.randomString(3);
		CreateInternalUserPage cr=new CreateInternalUserPage(driver);
		cr.clickOnUserMaintenance();
		cr.clickOnCreateInternalUser();
		Thread.sleep(3000);
		cr.roleType();
		cr.userLoginid(loginName);
		cr.firstName("");
		cr.lastName("");
		cr.contactNo(contactNo.toString());
		cr.email(emails);
		Thread.sleep(7000);
		cr.clickOnSubmitButton();
		Assert.assertEquals(cr.minLoginId(), true);
		Assert.assertEquals(cr.errorFirstName(), true);
		Assert.assertEquals(cr.errorLastName(), true);
		Assert.assertEquals(cr.minContactNo(), true);
		Assert.assertEquals(cr.minEmail(), true);	
	}
}
