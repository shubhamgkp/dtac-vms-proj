package com.createinternaluser;

import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.dtac.base.BaseTest;
import com.qa.dtac.pages.CreateInternalUserPage;

public class CreateInternalUserWith_blank extends BaseTest
{
	String loginNames;
	@Test
	public void  testCreateInternalUserWith_blank() throws InterruptedException, SQLException
	{
		CreateInternalUserPage cr=new CreateInternalUserPage(driver);
		cr.clickOnUserMaintenance();
		cr.clickOnCreateInternalUser();
		cr.clickOnSubmitButton();
		Assert.assertEquals(cr.errorLoginId(), true);
		Assert.assertEquals(cr.errorFirstName(), true);
		Assert.assertEquals(cr.errorLastName(), true);
		Assert.assertEquals(cr.errorContctNo(), true);
		Assert.assertEquals(cr.errorEmail(), true);	
	}
}
 