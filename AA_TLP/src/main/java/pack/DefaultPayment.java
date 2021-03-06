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

public class DefaultPayment extends AA_TLP{
		
	public static void DefaultPayment (String SSN,String FileName) throws Exception{

		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/TLP/"+FileName);

		int lastrow=TestData.getLastRow("NewLoan");

		System.out.println("NewLoan "+lastrow);

		String sheetName="NewLoan";

		for(int row=2;row<=lastrow;row++)

		{

			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))

			{



				String TenderType = TestData.getCellData(sheetName,"TenderType",row);

				String ProductID=TestData.getCellData(sheetName,"ProductID",row);

				//String Password = TestData.getCellData(sheetName,"Password",row);

				String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);

				String ESign_DisbType2 = TestData.getCellData(sheetName,"ESign_DisbType1",row);

				//String StoreId = TestData.getCellData(sheetName,"StoreId",row);

				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);

				//String UserName = TestData.getCellData(sheetName,"UserName",row);





				

				Login.Login(UserName, Password, StoreId);

				String SSN1 = SSN.substring(0, 3);

				String SSN2 = SSN.substring(3,5);

				String SSN3 = SSN.substring(5,9);

				Thread.sleep(4000);

				driver.switchTo().defaultContent();

				WebDriverWait wait = new WebDriverWait(driver, 30);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));

				driver.switchTo().frame("topFrame");

				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));

				driver.findElement(By.cssSelector("li[id='910000']")).click();



				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				Thread.sleep(1000);

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

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();

				}

				Thread.sleep(5000);


				test.log(LogStatus.PASS, "Click on GO Button");

				for( String winHandle1 : driver.getWindowHandles())

				{

					driver.switchTo().window(winHandle1);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				driver.findElement(By.name("transactionList")).sendKeys("Default Payment");

				test.log(LogStatus.PASS, "Transaction Type is selected as Default Payment");

				if(ProductID.equals("TLP"))

				{

					driver.findElement(By.xpath("//*[@id='go_Button']")).click();

				}

				else

				{

					driver.findElement(By.id("go_Button")).click();

				}

				for( String winHandle1 : driver.getWindowHandles())

				{

					driver.switchTo().window(winHandle1);

				}

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");


				if(ProductID.equals("TLP"))

				{

					Thread.sleep(3000);

					String PmtAmt = driver.findElement(By.name("transactionDataBean.paymentBalAmt")).getAttribute("value");
					test.log(LogStatus.PASS, " Default  payment amt Is :: "+PmtAmt );
					driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(PmtAmt);
					test.log(LogStatus.PASS, " Default  payment amt entered Is :: "+PmtAmt );
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys("Cash");
					test.log(LogStatus.PASS, " TenderType is Selected  as :: Cash " );

					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(PmtAmt);
					test.log(LogStatus.PASS, " TenderAmount entered is :: "+PmtAmt );

					driver.findElement(By.name("password")).sendKeys(Password);
					test.log(LogStatus.PASS, " password entered " );
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@name='Submit22' and @value='Finish' and @type='Button']")).click();
					//driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, " Clicked on Finish Default Payment " );

				}

				try { 
					Alert alert = driver.switchTo().alert();
					alert.accept();


				}
				catch (NoAlertPresentException e) {

				}

				Thread.sleep(2000);

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");

				{

					if(driver.findElement(By.name("Ok")).isDisplayed())

					{

						test.log(LogStatus.PASS, "Default Payment is Completed Successfully ");

						driver.findElement(By.name("Ok")).click();

					}

					else

					{

						test.log(LogStatus.FAIL, "Default Payment is not Completed Successfully ");

					}

				}

			}

		}

	}		

}
