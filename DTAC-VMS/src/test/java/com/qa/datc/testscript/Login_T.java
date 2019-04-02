package com.qa.datc.testscript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.dtac.base.BaseTest;
import com.qa.dtac.pages.LoginPage;

@Listeners(com.qa.dtac.generic.TestListener.class)
public class Login_T extends BaseTest {

	@Test
	public void testLogin() throws InterruptedException {

		LoginPage lp=new LoginPage(driver);
		lp.setLoginId("123");
		lp.setLoginPass("123");
		lp.language();
		Thread.sleep(3000);
		lp.setLoginButtonClick();
		
	}
}
