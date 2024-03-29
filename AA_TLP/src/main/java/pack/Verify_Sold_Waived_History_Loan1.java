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

public class Verify_Sold_Waived_History_Loan1 extends AA_TLP{
	public static void Verify_Sold_Waived_History_Loan1(String SSN,String FileName) throws Exception
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
				Thread.sleep(3000);
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='911101']")).click();			
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
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");


				if(ProductID.equals("TLP"))
				{

					//driver.findElement(By.name("button")).click();
					///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					//   /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]    
				}
				//  driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				driver.findElement(By.name("transactionList")).sendKeys("History");
				driver.findElement(By.xpath("//*[@id='go_Button']")).click();
				test.log(LogStatus.PASS, "Click on Go for TRANSACTION Selection Button");
/*
				String SoldAmountotherloan = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[6]/td[4]/font")).getText();


				String SoldAmount = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[6]/td[5]/font")).getText();

				if((SoldAmountotherloan).contains("sold"))
				{
					test.log(LogStatus.PASS,"Salvage Amount:" +SoldAmount );
				}
				else
				{
					test.log(LogStatus.PASS,"Salvage Record is not Displayed.");
				}
				*/
			/////////////////////////////////////////////	
				//                                                       //*[@id="transactionDetailsTable"]/tbody/tr[2]/td[4]/font
				List<WebElement> options = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr"));
				int schsize = options.size();
				test.log(LogStatus.INFO, " Rows count is::"+schsize);	

				for(int i=2; i<=schsize-1; i++)
				{
	                 int j= i-1;
					String TransactionName = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[4]/font")).getText();
					test.log(LogStatus.INFO, "Transaction:: "+i+"__Name is ::"+TransactionName);	

				
					if(TransactionName.contains("WriteOff"))
					{
						test.log(LogStatus.INFO, "Waived Amount is Effected to the First Loan"+TransactionName);
						int R =i+1;
						String TransactionName1 = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+R+"]/td[4]/font")).getText();

						
						test.log(LogStatus.INFO, "Transaction:: "+R+"__Name is ::"+TransactionName1);	
						if(TransactionName.contains("Waived"))
						{
							test.log(LogStatus.INFO, "Waived Amount is Effected to the First Loan"+TransactionName);
							//test.log(LogStatus.INFO, "RowNumber is ::"+i);	
		
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Waived Amount is not Effected to the First Loan"+TransactionName);

						}

						//test.log(LogStatus.INFO, "RowNumber is ::"+i);	
	
					
					}
	/*					else
						{
							test.log(LogStatus.INFO, "Transactions Done in First loan are :"+i+TransactionName);	

						}
					*/
				}
////////////////////////////////////////////////revathi
				/*String Waivedrecord  = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[8]/td[4]/font")).getText();
				//*[@id="transactionDetailsTable"]/tbody/tr[8]/td[4]/font


				String WaivedAmt  = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr[8]/td[5]/font")).getText();
				//*[@id="transactionDetailsTable"]/tbody/tr[8]/td[5]/font												


				if((Waivedrecord).contains("Write Off Waived"))
				{
					test.log(LogStatus.PASS,"Waived Amount:" +WaivedAmt );

				}

				else
				{
					driver.close();

					WebDriver driver = new InternetExplorerDriver();
					//test.log(LogStatus.PASS,"Waived Record is not Displayed.");
					this.Verify_Sold_Waived_History_Loan2(SSN, FileName);

				}*/
				//   String CheckStatus = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[3]/td/span[2]")).getText();

				//    test.log(LogStatus.PASS,"Check Status is ::"+CheckStatus);

				//    String LoanStatus = driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[2]/td/span[2]")).getText();

				//    test.log(LogStatus.PASS,"Loan Status is ::"+LoanStatus);
			}
		}
	}

}
