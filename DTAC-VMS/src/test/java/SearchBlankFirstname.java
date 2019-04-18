import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.dtac.base.BaseTest;
import com.qa.dtac.pages.LoginPage;
import com.qa.dtac.pages.SearchInternalUserPages;

public class SearchBlankFirstname extends BaseTest {
	@Test
	public void testSearch() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setLoginId("123");
		lp.setLoginPass("123");
		lp.setLoginButtonClick();
		Thread.sleep(3000);
		SearchInternalUserPages sr = new SearchInternalUserPages(driver);
		sr.clickOnUserMaintenance();
		sr.clickOnSearcgInternalUser();
		sr.userLoginid("");
		sr.firstName("Bhawesh");
		Thread.sleep(2000);
		sr.clickOnSearchButton();
		Thread.sleep(7000);
		Assert.assertEquals(sr.dataDisplayed(), true);
	}
}
