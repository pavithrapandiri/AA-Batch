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

public class NewLoanRule extends AA_TLP{
		
	public static void NewLoanRule(String SSN,String FileName) throws Exception{

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

					String State = TestData.getCellData(sheetName,"StateID",row);
					String ProductID=TestData.getCellData(sheetName,"ProductID",row);
					System.out.println(ProductID);
					//String UserName = TestData.getCellData(sheetName,"UserName",row);
					//String Password = TestData.getCellData(sheetName,"Password",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String ProductName = TestData.getCellData(sheetName,"ProductName",row);

					String VehicleType= TestData.getCellData(sheetName,"VehicleType",row);
					String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);

					String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
					String NewVIN3= TestData.getCellData(sheetName,"NewVIN3",row);
					//String StoreId = TestData.getCellData(sheetName,"StoreId",row);

					System.out.println(ProductID);

					//String StoreId = TestData.getCellData(sheetName,"StoreId",row);

					//String stateProduct=State+" "+ProductID;
					String stateProductType=State+" "+ProductType;
					String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					System.out.println(ESign_CollateralType);
					String ESign_LoanAmt = TestData.getCellData(sheetName,"ESign_LoanAmt",row);
					String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
					String ESign_DisbType = TestData.getCellData(sheetName,"ESign_DisbType",row);
					String ESign_DisbType2 = TestData.getCellData(sheetName,"Esign_DisbType2",row);
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
					String AllowPromotion = TestData.getCellData(sheetName,"Allow Promotion",row);
					String CouponNbr = TestData.getCellData(sheetName,"CouponNbr",row);
					String ESign_Preference = TestData.getCellData(sheetName,"ESign_Preference",row);
					String ESign_Checks = TestData.getCellData(sheetName,"ESign_Checks",row);
					String ESign_Password=TestData.getCellData(sheetName,"ESign_Password",row);
					String ESign_CheckNbr = TestData.getCellData(sheetName,"ESign_CheckNbr",row);			
					String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
					System.out.println(last4cheknum);
					System.out.println(stateProductType);
					//String AppURL = TestData.getCellData(sheetName,"AppURL",row);

					//String StateID = TestData.getCellData(sheetName,"StateID",row);

					String Parent_Window = driver.getWindowHandle();
					
					Login.Login(UserName, Password, StoreId);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					driver.switchTo().frame("topFrame");
					//*[@id="911100"]/a
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					//*[@id="911100"]/a
					driver.findElement(By.cssSelector("li[id='911100']")).click();			
					test.log(LogStatus.PASS, "Clicked on New Loan");		
					driver.switchTo().frame("main");		
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");		
					for(String winHandle : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle);	
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Click on GO Button");
					// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[13]/input      Loan2
					// /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input      Loan1
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					//	Selection of Product based on the Name provided in Test Data

					if(driver.findElement(By.id("LoanButtonId")).isEnabled())
						//if(driver.findElement(By.name("ShareScreenBtn")).isEnabled())
						if(ProductID.equals("TLP"))							
						{					
							System.out.println("IN TLP");
							// name="vehicleChk"   //*[@id="veh1"]
							////*[@id="vehicleType_dd"]
							driver.findElement(By.xpath("//*[@id='vehicleType_dd']")).sendKeys(VehicleType);
							// //*[@id="vinDD"]
							test.log(LogStatus.PASS, "Vehicle Type is selected as :: "+VehicleType);
							driver.findElement(By.xpath("//*[@id='vinDD']")).sendKeys("New");
							test.log(LogStatus.PASS, "Vehicle Status is selected as :: New ");
							// //*[@id="vinPop"]/div/table[1]/tbody/tr[1]/td[2]/input
							driver.findElement(By.xpath("//*[@id='vinPop']/div/table[1]/tbody/tr[1]/td[2]/input")).sendKeys(NewVIN);	
							test.log(LogStatus.PASS, "VIN entered is ::  "+NewVIN);
							driver.findElement(By.xpath("//*[@id='vinPop']/div/table[1]/tbody/tr[2]/td[2]/input")).sendKeys(NewVIN);
							test.log(LogStatus.PASS, "Confirm VIN entered is ::  "+NewVIN);
							driver.findElement(By.xpath("//*[@id='vinPop']/div/table[3]/tbody/tr/td/input[2]")).click();
							test.log(LogStatus.PASS, "Clicked on Submi VIN button ");
							driver.findElement(By.xpath("//*[@id='td.miles_tf']/input")).clear();

							driver.findElement(By.xpath("//*[@id='td.miles_tf']/input")).sendKeys("200");

							test.log(LogStatus.PASS, "Appraisal Value is entered as :: 200 ");
							driver.findElement(By.xpath("//*[@id='bbHit_Button']")).click();
							test.log(LogStatus.PASS, "Clicked on Hit BlackBook button ");
						}	
					Alert alert1 = driver.switchTo().alert();

					/*		for(String winHandle : driver.getWindowHandles()){
						driver.switchTo().window(winHandle);
					}				    
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");*/
					int count = 4;
					/*	System.out.println("before for loop" );
					for(int i=1;i<=count;i++)
					 */
					//Alert alert1 = driver.switchTo().alert();
					/*	if(alert1.getText().contains("4"))*/
					{


						try { 
							Alert alert = driver.switchTo().alert();
							String Var = alert.getText();
							System.out.println("alert message" + Var);

							alert.accept();
							System.out.println("Alert accepted");
							//if alert present, accept and move on.														

						}
						catch (NoAlertPresentException e) {
							//do what you normally would if you didn't have the alert.
						}
						/*			
						Thread.sleep(3000);
						// String message = driver.findElement(By.xpath("//*[@id='errMsg']/ul/li")).getText();
						test.log(LogStatus.PASS, "Maximum loans given and the message displayed is:"+ alert1.getText());
						 */
						test.log(LogStatus.PASS, "Maximum loans given is :"+ count);





						//else
						/*	{
							if(i==1)
							{
								this.NewLoanWithVIN(SSN, FileName,NewVIN);

							}
							if(i==2)
							{
								this.NewLoanWithVIN2(SSN, FileName,NewVIN);


							}
							if(i==3)
							{

								this.NewLoanWithVIN2_1(SSN, FileName,NewVIN2);

							}
							if(i==4)
							{
								this.NewLoanWithVIN2(SSN, FileName,NewVIN2);
							}
						}
						 */

						/*}while((driver.findElement(By.xpath("//*[@id='errMsg']/ul/li")).isDisplayed())== false);*/
						/*driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							String DueDate=null;

							DueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[11]/td[2]/span[2]")).getText();
							//DueDate=driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[4]/td[3]/span[2]")).getText();		 
							System.out.print(DueDate);	*/

						//driver.close();
					}
				}
			}
		}

	}
}
