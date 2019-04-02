package com.qa.dtac.base;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.qa.dtac.generic.Utility;
import com.qa.dtac.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest implements AutomationConstants
{
	public WebDriver driver;
	public static ExtentTest eTest;
	public static String reportFile;
	public static Logger log;
	public static String url;
	public static String un;
	public static String pw;
	public static long iTimeout;
	public static long eTimeout;
	public static ExtentReports eReport;
	
	public boolean loginRequired=false;
	public boolean logoutRequired=false;
	
	
	public BaseTest()
	{
		log=Logger.getLogger(this.getClass());
	}
	
	@BeforeSuite
	public void init()
	{
		log.info("ExtentReport Initializing...");
		String now = Utility.getFormatedDateTime();
		reportFile=REPORT_PATH+now+".html";
		eReport = new ExtentReports(reportFile);
	}
	
	@BeforeTest
	public void initGlobalVar()
	{
		log.info("Global variables are Initializing...");
		url=Utility.getPropertyValue(CONFIG_PATH, "URL");
		un=Utility.getPropertyValue(CONFIG_PATH, "USERNAME");
		pw=Utility.getPropertyValue(CONFIG_PATH, "PASSWARD");
		iTimeout=Long.parseLong(Utility.getPropertyValue(CONFIG_PATH, "IMPLICIT"));
		eTimeout=Long.parseLong(Utility.getPropertyValue(CONFIG_PATH, "EXPLICIT"));
	}
	@Parameters({"browser"})
	@BeforeClass
	public void initApplication(@Optional("chrome")String browser)
	{
		if(browser.equals("chrome"))
		{
			log.info(" browser "+browser+" opening...");
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			/* headless Browser
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("window-size=1400,800");
			  options.addArguments("headless");
			  driver = new ChromeDriver(options);*/
			  driver=new ChromeDriver();
		}
		else
		{
			log.info("Firefox browser opening...");
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(iTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void preCondtion(Method method) throws InterruptedException
	{
		driver.get(url);
		log.info("url entered...");
		if(loginRequired)
		{
			log.info("Auto Login...");
			try
			{
				LoginPage l=new LoginPage(driver);
				//l.login(un,pw);

			}
			catch(Exception e)
			{}
		}
		eTest=eReport.startTest(method.getName());
		log.info("started test executing : "+method.getName());
	}
	
	
	@AfterMethod
	public void postCondition(ITestResult testNGTestResult) throws InterruptedException
	{	
		if(logoutRequired)
		{
			log.info("Auto logout");
			new HomePage(driver).logout();
		}
		if(testNGTestResult.getStatus()==ITestResult.FAILURE)
		{
			String imgPath =Utility.getScreenShot(driver, REPORT_PATH);//taking screenshot of browser
			String path = eTest.addScreenCapture("."+imgPath);
			eTest.log(LogStatus.FAIL,"Check log for details",path);
			log.error("Test is FAILED");
	
		}
		else
		{		
			eTest.log(LogStatus.PASS,"Script executed successfully");
			log.info("Test is PASSED \n");
		}
			eReport.endTest(eTest);
	}	
	@AfterClass
	public void closeApplication()
	{
		log.info("closing browser");
		driver.close();
	}
	@AfterSuite
	public void publishReport() throws Exception
	{
		log.info("publishing report "+reportFile);
		eReport.flush();
	}
}
