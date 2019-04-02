package com.qa.datc.testscript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.dtac.base.BaseTest;
import com.qa.dtac.pages.EditRoleType;
import com.qa.dtac.pages.LoginPage;

@Listeners(com.qa.dtac.generic.TestListener.class)
public class EditRoleTest extends BaseTest {

	@Test
	public void editRole() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setLoginId("123");
		lp.setLoginPass("123");
		lp.setLoginButtonClick();
		Thread.sleep(3000);

		EditRoleType ert = new EditRoleType(driver);
		ert.roleType();
		ert.SearchType();

		ert.code("");

		ert.name("");
		// Thread.sleep(2000);
		ert.drop();
		ert.search();
		ert.edit();

	}
}
