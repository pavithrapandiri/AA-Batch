package pack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*import Test.CO_ILP.Need;
import Test.CO_ILP.scenario;*/
import pack.*;

import bsh.*;
//import scala.collection.Iterator;
//import scala.collection.Set;

//import Pages.HomePage;
//import Pages.LoginPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;
import java.io.FileReader;

public class StoreInfo extends AA_TLP{
	public static void StoreInfo(String SSN,String FileName) throws Exception
	{
	//-------------done updating
//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/TLP/"+FileName);	
	int lastrow=TestData.getLastRow("NewLoan");
	String sheetName="NewLoan";		
	test.log(LogStatus.INFO, "Edit Store Info");
	for(int row=2;row<=lastrow;row++)
	{	
		String RegSSN = TestData.getCellData(sheetName,"SSN",row);
		if(SSN.equals(RegSSN))
		{
			String TxnType=TestData.getCellData(sheetName,"TxnType",row);
			String TenderType = TestData.getCellData(sheetName,"TenderType",row);	
			String ProductID=TestData.getCellData(sheetName,"ProductID",row);
			//String UserName = TestData.getCellData(sheetName,"UserName",row);
			//String Password = TestData.getCellData(sheetName,"Password",row);
			//String StoreId = TestData.getCellData(sheetName,"StoreId",row);
			//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
					
			driver.get(AdminURL);
			test.log(LogStatus.PASS, "Admin portal is launched");	
			driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
			test.log(LogStatus.PASS, "Username is entered: "+UserName);			        
			driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
			test.log(LogStatus.PASS, "Password is entered: "+Password);					  	        			   			
			driver.findElement(By.name("login")).click();
			test.log(LogStatus.PASS, "Clicked on Submit button");			
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("topFrame");
	driver.findElement(By.xpath("//*[contains(text(),'Store Setup')]")).click();	
	test.log(LogStatus.PASS, "Clicked on Store Setup");
	Thread.sleep(1000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("mainFrame");
	driver.findElement(By.linkText("Store Config")).click();
	test.log(LogStatus.PASS, "Clicked on Store Config");
	driver.findElement(By.linkText("Edit Store")).click();
	test.log(LogStatus.PASS, "Clicked on Edit Store");			
	driver.switchTo().frame("main");		
	  driver.findElement(By.name("locationBean.locNbr")).sendKeys(StoreId);
	  test.log(LogStatus.PASS, "Store number is entered: "+StoreId);
	  driver.findElement(By.name("Submit2")).click();
	  test.log(LogStatus.PASS, "Clicked on submit button");
	  
	  for(String winHandle : driver.getWindowHandles())
	  {
		    driver.switchTo().window(winHandle);
	} 
	     driver.switchTo().defaultContent();
		 driver.switchTo().frame("mainFrame");
		 driver.switchTo().frame("main");													  	 	  
	     driver.findElement(By.name("locationBean.locStatusCd")).sendKeys("Crash Package");
	     driver.switchTo().defaultContent();
		 driver.switchTo().frame("mainFrame");
		 driver.switchTo().frame("main");													    	
		 if(driver.findElement(By.name("submitButton")).isDisplayed())
			{
			 test.log(LogStatus.PASS, "Store Edit is Successfully completed ");
				driver.findElement(By.name("submitButton")).click();
			}
		 else
			{
				test.log(LogStatus.FAIL, "Store Edit is not Successfull ");
			}
		}
		}
	}
	
	public static void Safeassign(String SSN,String FileName) throws Exception{
		//-------------done updating
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/TLP/"+FileName);
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";		
			test.log(LogStatus.INFO, "Safe Assign");
			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String TxnType=TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);	
					String ProductID=TestData.getCellData(sheetName,"ProductID",row);
					//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
					//String UserName = TestData.getCellData(sheetName,"UserName",row);
					//String Password = TestData.getCellData(sheetName,"Password",row);
					 String StoreId = TestData.getCellData(sheetName,"StoreId",row);
					 
					 Login.Login(UserName, Password, StoreId);
				
					driver.switchTo().defaultContent();				
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Cash Management')]")).click();			
					test.log(LogStatus.PASS, "Clicked on Cash Management");
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.linkText("Safe")).click();
					test.log(LogStatus.PASS, "Clicked on Assign");	
					driver.findElement(By.linkText("Assign")).click();
					test.log(LogStatus.PASS, "Clicked on Assign");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("safeAssignRequestBean.empPwd")).sendKeys(Password);
					driver.findElement(By.name("safeAssignRequestBean.noOf100Dollars")).sendKeys("500");
					driver.findElement(By.name("safeassign")).click();
					
					try { 
					    Alert alert = driver.switchTo().alert();
					    alert.accept();
					    //if alert present, accept and move on.														
						
					}
					catch (NoAlertPresentException e) {
					    //do what you normally would if you didn't have the alert.
						
					}
					Thread.sleep(2000);
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					    
					    if(driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).isDisplayed())
					    {
					
					    	 test.log(LogStatus.PASS,"Safe assigned successfully with over/short.");
					    	 driver.findElement(By.xpath("//input[(@type='submit') and (@value='Ok')]")).click();
					    	 				    }
					    else
					    {
					    	test.log(LogStatus.FAIL,"Safe is not assigned .");
					    }
					}
					}
					}


}
