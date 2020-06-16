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
import java.util.Set;
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

public class Auction extends AA_TLP{
		
	public static void Auction(String SSN,String FileName,int days) throws Exception

	{

		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/TLP/"+FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		System.out.println("NewLoan "+lastrow);
		String sheetName="NewLoan";		
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
				System.out.println(AdminURL);
				test.log(LogStatus.INFO, "Scheduler-Store Aging");

				System.out.println(ProductID);	
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				
				Login.Login(UserName, Password, StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Thread.sleep(7000);
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='911101']")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Clicked on Transactions");		
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");		
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");

				String CsrLoan=	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText();
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				if(ProductID.equals("TLP"))
				{
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[13]/input")).click();
				}
				test.log(LogStatus.PASS, "Click on GO Button");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("History");
				if(ProductID.equals("TLP"))
				{
					driver.findElement(By.xpath("//*[@id='go_Button']")).click(); 
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				String DefaultDate=null;
				DefaultDate = driver.findElement(By.xpath("//*[@id='myTable1']/tbody[2]/tr[3]/td[2]")).getText();
				test.log(LogStatus.PASS, "Capture Default date:"+DefaultDate);
				driver.close();
				driver = new InternetExplorerDriver();
				driver.get(AdminURL);
				String Parent_Window = driver.getWindowHandle();
				DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
				driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
				test.log(LogStatus.PASS, "Username is entered: admin");
				driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
				test.log(LogStatus.PASS, "Password is entered: "+Password);
				driver.findElement(By.name("login")).click();
				test.log(LogStatus.PASS, "Clicked on Submit button");
				Thread.sleep(2000);
				Date DDueDate = df.parse(DefaultDate);
				Calendar cal = Calendar.getInstance();
				cal.setTime(DDueDate);
				cal.add(Calendar.DATE, days);
				Date DDueDateminus1= cal.getTime();
				String DueDateminus1 =df.format(DDueDateminus1);
				String DueDate0[] =DueDateminus1.split("/");
				String DueDate1 = DueDate0[0];
				String DueDate2 = DueDate0[1];
				String DueDate3 = DueDate0[2];
				driver.switchTo().defaultContent();
				driver.switchTo().frame("topFrame");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();
				test.log(LogStatus.PASS, "Clicked on Transactions");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Title Loan")).click();
				test.log(LogStatus.PASS, "Clicked on Title Loan");
				Thread.sleep(1000);
				driver.findElement(By.linkText("Post Default Transactions")).click();
				test.log(LogStatus.PASS, "Clicked on Post Default Transactions");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("requestBean.storeId")).sendKeys(StoreId);
				test.log(LogStatus.PASS, "Store number is entered: "+StoreId);
				Thread.sleep(1000);
				driver.findElement(By.name("requestBean.ssn")).sendKeys(SSN);
				test.log(LogStatus.PASS, "SSN number is Entered: ");
				driver.findElement(By.name("requestBean.statusType")).sendKeys("Auction");
				test.log(LogStatus.PASS, "Auction is entered: ");
				driver.findElement(By.name("submit")).click();
				test.log(LogStatus.PASS, "Clicked on submitt Button: ");
				//--------------updated new code
				driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[6]/input")).click();
				test.log(LogStatus.PASS, "Clicked on Go Button: ");
				driver.findElement(By.name("history")).click();
				Thread.sleep(4000);
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}
				Thread.sleep(4000);
				driver.manage().window().maximize();
				String Loan1 = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
				test.log(LogStatus.PASS, "Loan number --"+Loan1);
				Set<String> windows= driver.getWindowHandles();
				for(String winHandle1:windows)			
				{
					if(!Parent_Window.equalsIgnoreCase(winHandle1))
						driver.switchTo().window(winHandle1).close();
				}

				driver.switchTo().window(Parent_Window);
				if(CsrLoan.equals(Loan1))
				{			
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					driver.findElement(By.name("solvageCompany")).sendKeys("CARS");
					test.log(LogStatus.PASS, "Solvage Company is selected CARS ");
					driver.findElement(By.name("rpossesdate1")).sendKeys(DueDate1);
					test.log(LogStatus.PASS, "Month is Entered");
					driver.findElement(By.name("rpossesdate2")).sendKeys(DueDate2);
					test.log(LogStatus.PASS, "Day is Entered");
					driver.findElement(By.name("rpossesdate3")).sendKeys(DueDate3);
					test.log(LogStatus.PASS, "Year is Entered");
					Thread.sleep(5000);
					driver.findElement(By.name("requestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password Entered");
					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, "Click on submitt Button");
				}
				else
				{
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("cancelLoan")).click();
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("requestBean.storeId")).sendKeys(StoreId);
					test.log(LogStatus.PASS, "Store number is entered: "+StoreId);
					Thread.sleep(1000);
					driver.findElement(By.name("requestBean.ssn")).sendKeys(SSN);
					test.log(LogStatus.PASS, "SSN number is Entered: ");
					driver.findElement(By.name("requestBean.statusType")).sendKeys("Auction");
					test.log(LogStatus.PASS, "Auction is entered: ");
					driver.findElement(By.name("submit")).click();
					test.log(LogStatus.PASS, "Clicked on submit Button: ");
					driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[3]/td[6]/input")).click();
					test.log(LogStatus.PASS, "Clicked on Go Button: ");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("solvageCompany")).sendKeys("CARS");
					test.log(LogStatus.PASS, "Solvage Company is selected CARS ");
					driver.findElement(By.name("rpossesdate1")).sendKeys(DueDate1);
					test.log(LogStatus.PASS, "Month is Entered");
					driver.findElement(By.name("rpossesdate2")).sendKeys(DueDate2);
					test.log(LogStatus.PASS, "Day is Entered");
					driver.findElement(By.name("rpossesdate3")).sendKeys(DueDate3);
					test.log(LogStatus.PASS, "Year is Entered");
					Thread.sleep(3000);
					driver.findElement(By.name("requestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "Password Entered");
					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, "Click on submitt Button");
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				if( driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).isDisplayed())
				{
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).click();
					test.log(LogStatus.PASS, "OK Button is Clicked");
					test.log(LogStatus.PASS, "Auction updated successfully.");
				}
				else
				{
					test.log(LogStatus.FAIL, "Auction Not updated successfully.");
				}
			}
		}
	}

}
