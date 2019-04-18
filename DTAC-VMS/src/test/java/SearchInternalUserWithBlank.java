import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.dtac.base.BaseTest;
import com.qa.dtac.pages.LoginPage;
import com.qa.dtac.pages.SearchInternalUserPages;

public class SearchInternalUserWithBlank extends BaseTest {
	@Test
	public void testSearchInternalUserWithBlank() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setLoginId("123");
		lp.setLoginPass("123");
		lp.setLoginButtonClick();
		Thread.sleep(3000);
		SearchInternalUserPages sr=new SearchInternalUserPages(driver);
		sr.clickOnUserMaintenance();
		sr.clickOnSearcgInternalUser();
		sr.clickOnSearchButton();
		Thread.sleep(7000);
		Assert.assertEquals(sr.elementDistplayed(), true);
	}


}
