package com.createinternaluser;

import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.dtac.base.BaseTest;
import com.qa.dtac.pages.CreateInternalUserPage;

public class CreateInternalUserWithSpc_Char extends BaseTest
{
	String loginNames;
	@Test
	public void  testCreateInternalUserWithSpc_Char() throws InterruptedException, SQLException
	{
		
		CreateInternalUserPage cr=new CreateInternalUserPage(driver);
		cr.clickOnUserMaintenance();
		cr.clickOnCreateInternalUser();
		Thread.sleep(3000);
		cr.roleType();
		cr.userLoginid("xcbvf%");
		cr.firstName("dgffdsg@#$");
		cr.lastName("dgffdsg@#$");
		cr.contactNo("vdfsgsdfgfdgd");
		cr.email("asdes");
		Thread.sleep(7000);
		cr.clickOnSubmitButton();
		Assert.assertEquals(cr.spcLoginId(), true);
		Assert.assertEquals(cr.spcFLN(),true);
		Assert.assertEquals(cr.spcContact(),true);
		Assert.assertEquals(cr.spcEmail(),true);
	}

}
