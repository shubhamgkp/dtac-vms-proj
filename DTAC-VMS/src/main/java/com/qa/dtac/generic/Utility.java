package com.qa.dtac.generic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility 
{
	public static ResultSet result;
	public static Connection conn;
	public static Statement stmt;
	
	public static void drop(WebElement element, String key)
	{
		Select s= new Select(element);
		s.selectByVisibleText(key);		
	}
	public static void dataBaseConnection(String sqlQuery)
	{
	conn=null;
	String url="jdbc:postgresql://192.168.0.116:5432/vmsdbqa";
	//String url="jdbc:informix-sqli://192.24.207.114:13001/emcom:INFORMIXSERVER=ids_emcom;IFX_LOCK_MODE_WAIT=2;IFX_ISOLATION_LEVEL=1";
	String un="postgres";
	String pwd="postgres";
	try
	{
		Class.forName("org.postgresql.Driver").newInstance();
		conn=DriverManager.getConnection(url, un, pwd);
		stmt=conn.createStatement();
		result=stmt.executeQuery(sqlQuery);
		result.next();		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally
	{
		if(conn!=null)
		{
			conn=null;
		}	
	}
	}
	public static String AlphaNumericString(int n) {
		String AlphaNumericString = "AB" + "__" + "yz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}
	
	
	public static String getAlphaNumericString(int n) {

		String AlphaNumericString = "AB" + "_____" + "ab";

		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			int index = (int) (AlphaNumericString.length() * Math.random());

			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
	
	
	//Uploading Images
	public static void uploadImage(WebElement ele)
	{
		File file = new File("./images/f.jpg");
		ele.sendKeys(file.getAbsolutePath());

		//ele.sendKeys(imageFilepath);
	}

	public static String getCurrentMonth()
	{
		SimpleDateFormat s = new SimpleDateFormat("MMM");//jan,feb...//MM:- 09,M 1,2....
		return s.format(new Date());
	}
	
	public static String getFormatedDateTime(){
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return simpleDate.format(new Date());
	}
	
	public static void clickUsingJS(WebDriver driver,WebElement e){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",e);
	}
	
	public static void moveToElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	
	public static String getScreenShot(WebDriver driver, String imageFolderPath)
	{
		String imagePath=imageFolderPath+"/"+getFormatedDateTime()+".png";
		TakesScreenshot page=(TakesScreenshot) driver;
		
		try{
			FileUtils.copyFile(page.getScreenshotAs(OutputType.FILE), new File(imagePath));
		}catch(Exception e){
			
		}
		return imagePath;	
	}
	
	public static String getScreenShot(String imageFolderPath)
	{
		String imagePath=imageFolderPath+"/"+getFormatedDateTime()+".png";
		
		try
		{
			Dimension desktopSize=Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(desktopSize));
			ImageIO.write(image,"png",new File(imagePath));
		}
		catch(Exception e)
		{
		}
		return imagePath;	
	}
	
	
	public static String getPropertyValue(String filePath,String key)
	{
		String value="";
		Properties ppt=new Properties();
		try{
			ppt.load(new FileInputStream(filePath));
			value=ppt.getProperty(key);
		}
		catch(Exception e)
		{
		}
		return value;
	}
	
	
	public static int getExcelRowCount(String path,String sheet)
	{
		int r=0;
		try
		{
			
			r=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
	
	
	public static String getExcelCellValue(String path,String sheet,int r,int c)
	{
		String v="";
		try
		{
			
			v=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
	
	
	
	
	public static int browserCount(WebDriver driver)
	{
		int count=driver.getWindowHandles().size();
		return count;
	}
	
	
	//helps to verify element's presence 
	public static boolean verifyElementIsPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean verifyElementIsPresent(WebDriver driver, WebElement element, int timeOut)//used for loaster error
	{
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean verifyElementIsClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public static boolean verifyElementIsNotPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			return false;
		}
		catch(Exception e)
		{
			return true;
		}
	}
	
	//always compare url with contains method
	//switching behalf of URL
	public static boolean switchBrowser(String eURL,WebDriver driver)
	{
		String currentWH = driver.getWindowHandle();
		Set<String> allWH = driver.getWindowHandles();
		for(String wh : allWH)
		{
			String url=driver.switchTo().window(wh).getCurrentUrl();
			if(url.contains(eURL))
			{
				System.out.println("Browser found");
				return true;
			}
		}
		driver.switchTo().window(currentWH);
		return false;
		
	}
	
	//switching behalf of element
	public static boolean switchBrowser(WebDriver driver,WebElement element)
	{
		String currentWH = driver.getWindowHandle();
		Set<String> allWH = driver.getWindowHandles();
		for(String wh : allWH)
		{
			driver.switchTo().window(wh);
			if(verifyElementIsPresent(driver,element))
			{
				System.out.println("Browser found");
				return true;
			}
		}
		driver.switchTo().window(currentWH);
		return false;	
	}
	
	public static boolean switchBrowser(WebDriver driver, String eTitle)//add try catch in all the overloaded method
	{
		String currentWH="";
		try
		{
			currentWH = driver.getWindowHandle();
		}
		catch(Exception e)
		{}
		
		Set<String> allWH = driver.getWindowHandles();
		for(String wh : allWH)
		{
			String title=driver.switchTo().window(wh).getTitle();
			if(title.contains(eTitle))
			{
				System.out.println("Browser found");
				System.out.println("Title is : "+title);
				return true;
			}
		}
		driver.switchTo().window(currentWH);
		System.out.println("Browser not found");
		return false;
	}
	
	public static void selectValueFromDropdown(WebElement e,int i)
	{
		Select select=new Select(e);
		select.selectByIndex(i);
	}
	public static void selectValueFromDropdown(WebElement e,String value)
	{
		Select select=new Select(e);
		select.selectByValue(value);
		//select.selectByVisibleText(value);
	}
	
	public static String getSelectedTextFromDropDown(WebElement e)
	{
		Select select=new Select(e);
		return select.getFirstSelectedOption().getText();
		
	}
	
	public static void setTextInTextFld(WebDriver driver,WebElement ele,String arg)
	{
		try {
			if(verifyElementIsPresent(driver, ele)&& ele!=null)
			{
				ele.clear();
				ele.sendKeys(arg);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	
	//Highlight the Element
	public static void highlightElement(WebDriver driver, WebElement element) throws InterruptedException 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	      
    	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid blue;');", element); 
    	//js.executeScript("arguments[0].style.border ='5px solid blue;');",element);
        Thread.sleep(2000);
	
     }
	public static int randomNumber(int minValue, int maxValue)
	{
		try {
			return (int)(Math.random()*maxValue+minValue);
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
	}
	/*
	 * Write data into Excel_Sheet
	 */
	public static void writeDataIntoExcel(String path,String sheet,int r,int c,String value)
	{
	    try
	    {
	        FileInputStream input=new FileInputStream(path);
	        XSSFWorkbook wb=new XSSFWorkbook(input);
	        XSSFSheet sh=wb.getSheet(sheet);
	        //XSSFRow row=sh.getRow(r);
	        XSSFRow row=sh.createRow(r);
	        row.createCell(c).setCellValue(value);
	        FileOutputStream fileOut=new FileOutputStream(path);
	        wb.write(fileOut);
	        wb.close();
	    }	
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	/*
	 * generate Random String
	 */
	public static String randomString() {
        //String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
	}
	
	public static String randomString(int length) {
        //String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
	}




}
