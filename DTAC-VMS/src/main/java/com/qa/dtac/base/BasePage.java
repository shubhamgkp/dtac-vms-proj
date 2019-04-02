package com.qa.dtac.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.dtac.generic.Utility;

public abstract class BasePage 
{
	public Logger log=Logger.getLogger(this.getClass());
	public long timeout=Long.parseLong(Utility.getPropertyValue(AutomationConstants.CONFIG_PATH, "EXPLICIT"));
	public WebDriver driver;
	public WebDriverWait wait;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver,timeout);
		PageFactory.initElements(driver, this);
	}
	
}
