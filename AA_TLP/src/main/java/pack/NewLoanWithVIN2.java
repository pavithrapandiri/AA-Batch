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

public class NewLoanWithVIN2 extends AA_TLP{
		
	public static void NewLoanWithVIN2(String SSN,String FileName,String NewVIN2) throws Exception{


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
				//String Term = TestData.getCellData(sheetName,"Term",row);
				String VehicleType= TestData.getCellData(sheetName,"VehicleType",row);
				// String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				//System.out.println(Term);
				//String StoreId = TestData.getCellData(sheetName,"StoreId",row);
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
				String ABA_Number = TestData.getCellData(sheetName,"ABARoutingNbr",row);
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				System.out.println(last4cheknum);
				System.out.println(stateProductType);
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				////String UserName = TestData.getCellData(sheetName,"UserName",row);
				////String Password = TestData.getCellData(sheetName,"Password",row);
				// System.out.println(Password);
				//String StoreId = TestData.getCellData(sheetName,"StoreId",row);
				//String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				//String StateID = TestData.getCellData(sheetName,"StateID",row);
				//String SSN = TestData.getCellData(sheetName,"SSN",row);	
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
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
					if(driver.findElement(By.name("ShareScreenBtn")).isEnabled() || driver.findElement(By.id("LoanButtonId")).isEnabled())
					if(ProductID.equals("TLP"))							
					{					
						System.out.println("IN TLP");
						driver.findElement(By.xpath("//*[@id='vehicleType_dd']")).sendKeys(VehicleType);
						driver.findElement(By.xpath("//*[@id='vinDD']")).sendKeys("New");
						driver.findElement(By.xpath("//*[@id='vinPop']/div/table[1]/tbody/tr[1]/td[2]/input")).sendKeys(NewVIN2);	
						driver.findElement(By.xpath("//*[@id='vinPop']/div/table[1]/tbody/tr[2]/td[2]/input")).sendKeys(NewVIN2);
						driver.findElement(By.xpath("//*[@id='vinPop']/div/table[3]/tbody/tr/td/input[2]")).click();
						driver.findElement(By.xpath("//*[@id='td.miles_tf']/input")).clear();
						driver.findElement(By.xpath("//*[@id='td.miles_tf']/input")).sendKeys("200");
						driver.findElement(By.xpath("//*[@id='bbHit_Button']")).click();				
					}												
				if(ProductName.equals("TNPAYDAY"))
				{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/input")).click();
					test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
				}
				if(ProductName.equals("TNPDL all coll"))
				{								////*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input
					driver.findElement(By.name("prodSel")).click();
					test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
				}
				if(ProductName.equals("Tennessee"))
				{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input")).click();
					test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
				}
				if(ProductName.equals("Line of Credit"))
				{

					if(StoreId.equals("5434"))
					{
						driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")).click();
					}
					if(StoreId.equals("5434"))
					{

						driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input")).click();
						test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);

					}
					if(StoreId.equals("1343"))
					{
						driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input")).click();
						test.log(LogStatus.PASS, "ProductName is selected as "+ProductName);
					}

				}

				driver.findElement(By.name("ShareScreenBtn")).click();
				test.log(LogStatus.PASS, "ShareScreen Button clicked");
				for( String winHandle1 : driver.getWindowHandles())

				{
					if(!(winHandle1.equals(Parent_Window)))
					{
						driver.switchTo().window(winHandle1);
						Thread.sleep(1000);
						driver.findElement(By.name("confirmSummary")).click();
						test.log(LogStatus.PASS, "ConfirmShareScreen Button clicked");
					}

				}
				Thread.sleep(3000);
				driver.switchTo().window(Parent_Window);

				for( String winHandle1 : driver.getWindowHandles())

				{

					driver.switchTo().window(winHandle1);

				}                 

				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				driver.findElement(By.id("LoanButtonId")).click();
				//driver.findElement(By.id("LoanButtonId")).click();

				test.log(LogStatus.PASS, "Clicked on New Loan button");
				//New Loan Screens
				if(ProductID.equals("PDL"))
				{	

					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
					if(!(ESign_LoanAmt.isEmpty()))
					{
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[13]/td[3]/input")).sendKeys(ESign_LoanAmt);
						test.log(LogStatus.PASS, "Loan amount is enterted as "+ESign_LoanAmt);
					}
					driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
					test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as "+last4cheknum);					
					Thread.sleep(3000);
					String Instamt=driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");
					System.out.println(Instamt);
					driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type1 is enterted as "+ESign_DisbType);
					Thread.sleep(2000);
					driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys("215");					
					test.log(LogStatus.PASS, "Disb Amt1 is enterted as ::" +"215");
					Thread.sleep(3000);
					driver.findElement(By.name("advanceRequestBean.disbursementTypeSecond")).sendKeys(ESign_DisbType2);
					test.log(LogStatus.PASS, "Disb Type2 is selected as ::Cash");



					driver.findElement(By.name("advanceRequestBean.disbAmtSecond")).sendKeys("210");
					test.log(LogStatus.PASS, "Disb Amt2 is enterted as 210");
					driver.findElement(By.name("advanceRequestBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Electronic Communication Consent is selected as "+ESign_CourtesyCallConsent);
					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						if(ESign_Preference.equals("Call"))	
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))	
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))	
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try { 
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.														

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					if(AllowPromotion.equals("Yes"))
					{
						driver.findElement(By.xpath("//*[@id='allowCoupons']/td[3]/input")).click();
						test.log(LogStatus.PASS, "AllowPromotion is selected ");
						driver.findElement(By.xpath("//*[@id='coupon']/td[3]/div[1]/input")).sendKeys(CouponNbr);
						test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
					}

					driver.findElement(By.xpath("//*[@id='idNoChecks']/td[3]/select")).sendKeys(ESign_Checks);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Checks);
				  WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='chkNbr0']")));
					driver.findElement(By.xpath("//*[@id='chkNbr0']")).sendKeys(ESign_CheckNbr);
					test.log(LogStatus.PASS, "Check number is "+ESign_CheckNbr);
					driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(ESign_Password);
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
					driver.findElement(By.name("finishadvance")).click();
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
					test.log(LogStatus.PASS, "click on Finish Loan button ");

					try { 
						Alert alert = driver.switchTo().alert();
						String Var1 = alert.getText();
						test.log(LogStatus.PASS, "ALert Displayed is :: "+Var1);

						alert.accept();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(2000);
					try { 
						Alert alert = driver.switchTo().alert();
						String Var = alert.getText();
						test.log(LogStatus.PASS, "ALert Displayed is :: "+Var);
						alert.accept();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("OKBut")));
					// driver.findElement(By.name("OKBut")).click();					
					driver.findElement(By.xpath("//*[@id='OKBut']")).click();				
					test.log(LogStatus.PASS, "click on Yes button ");
					test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("bdyLoad");

				}

				if(ProductID.equals("ILP"))
				{	
					driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);									
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					String Instamt=driver.findElement(By.name("advanceRequestBean.advanceAmt")).getAttribute("value");
					System.out.println(Instamt);
					driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Instamt);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+Instamt);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						if(ESign_Preference.equals("Call"))	
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))	
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))	
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try { 
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.														

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					if(AllowPromotion.equals("Yes"))
					{
						driver.findElement(By.name("allowPromotion")).click();
						test.log(LogStatus.PASS, "AllowPromotion is selected ");
						//String mwh=driver.getWindowHandle();
						driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);
						test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
						//String winHandle = driver.getWindowHandle(); //Get current window handle.									
					}
					WebElement ele = driver.findElement(By.name("requestBean.siilBean.nbrOfInst"));
					String NumofInst=ele.getAttribute("value");
					//*[@id="errorMessage"]/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[5]/td[2]/input
					System.out.println(NumofInst);
					int installments = Integer.parseInt(NumofInst);
					for(int i=0;i<installments;i++)
					{
						Random rand = new Random();
						int rand1 = rand.nextInt(100000);	
						String chknum = Integer.toString(rand1);
						driver.findElement(By.id("checkNbrs"+i)).sendKeys(chknum);

					}			 					 			
					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
					driver.findElement(By.name("finishLoan")).click();
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
					test.log(LogStatus.PASS, "click on Finish Loan button ");
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					//for( String winHandle1 : driver.getWindowHandles())
					//{
					// driver.switchTo().window(winHandle1);
					//}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("OKBut")));
					driver.findElement(By.name("OKBut")).click();
					//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]")).click();				
					test.log(LogStatus.PASS, "click on Yes button ");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
						//driver.findElement(By.name("ok")).click();
					}
					else
					{
						test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
					}
				}

				if(ProductID.equals("TLP"))
				{	
					String TitleNumber= TestData.getCellData(sheetName,"TitleNumber",row);
					String AppraisalValue= TestData.getCellData(sheetName,"Appraisal Value",row);
					String ExteriorColor=TestData.getCellData(sheetName,"ExteriorColor",row);
					String LicensePlateNumber=TestData.getCellData(sheetName,"License Plate Number",row);
					//String VehicleGrade=TestData.getCellData(sheetName,"Vehicle Grade",row);
					String LicensePlateExp=TestData.getCellData(sheetName,"License Plate Expiry",row);
					String InsuranceCoverage=TestData.getCellData(sheetName,"Insurance Coverage",row);
					String PhoneNbr=TestData.getCellData(sheetName,"Phone Nbr",row);
					String PhoneNbr1 = PhoneNbr.substring(0, 3);
					String PhoneNbr2 = PhoneNbr.substring(3, 6);
					String PhoneNbr3 = PhoneNbr.substring(6, 10);
					String InsuranceCompany =TestData.getCellData(sheetName,"Insurance Company",row);
					String InsuranceExpiryDate=TestData.getCellData(sheetName,"Insurance Expiry Date",row);
					String PolicyNumber=TestData.getCellData(sheetName,"Policy Number",row);
					String InsuranceExpiryDate0[] =InsuranceExpiryDate.split("/");
					String InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
					String InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
					String InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
					//name="requestBean.titleNumber"
					driver.findElement(By.name("requestBean.titleNumber")).clear();
					driver.findElement(By.name("requestBean.titleNumber")).sendKeys(TitleNumber);
					//name="requestBean.appraisalVal"
					driver.findElement(By.name("requestBean.appraisalVal")).clear();
					driver.findElement(By.name("requestBean.appraisalVal")).sendKeys(AppraisalValue);
					//driver.findElement(By.xpath("//*[@id='appraisal']")).sendKeys(AppraisalValue);
					//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.name("button1")).click();
					test.log(LogStatus.PASS, "click on Update 1 button ");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("requestBean.extClr")));
					driver.findElement(By.name("requestBean.extClr")).sendKeys(ExteriorColor);
					//requestBean.licensePltNbr
					driver.findElement(By.name("requestBean.licensePltNbr")).clear();
					driver.findElement(By.name("requestBean.licensePltNbr")).sendKeys(LicensePlateNumber);
					//requestBean.licensePltExpire
					driver.findElement(By.name("requestBean.licensePltExpire")).clear();
					driver.findElement(By.name("requestBean.licensePltExpire")).sendKeys(LicensePlateExp);
					//requestBean.paintCondition
					driver.findElement(By.name("requestBean.paintCondition")).sendKeys("Clean");
					driver.findElement(By.name("requestBean.bodyCondition")).sendKeys("Clean");
					driver.findElement(By.name("requestBean.glassCondition")).sendKeys("Clean");
					driver.findElement(By.name("requestBean.tiresCondition")).sendKeys("Clean");
					driver.findElement(By.name("requestBean.coverageType")).sendKeys(InsuranceCoverage);
					driver.findElement(By.name("iPhoneNbr1")).clear();
					driver.findElement(By.name("iPhoneNbr1")).sendKeys(PhoneNbr1);
					driver.findElement(By.name("iPhoneNbr2")).clear();
					driver.findElement(By.name("iPhoneNbr2")).sendKeys(PhoneNbr2);
					driver.findElement(By.name("iPhoneNbr3")).clear();
					driver.findElement(By.name("iPhoneNbr3")).sendKeys(PhoneNbr3);
					driver.findElement(By.name("requestBean.companyName")).clear();
					driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
					driver.findElement(By.name("iexpiry1")).clear();
					driver.findElement(By.name("iexpiry1")).sendKeys(InsuranceExpiryDate1);
					driver.findElement(By.name("iexpiry2")).clear();
					driver.findElement(By.name("iexpiry2")).sendKeys(InsuranceExpiryDate2);
					driver.findElement(By.name("iexpiry3")).clear();
					driver.findElement(By.name("iexpiry3")).sendKeys(InsuranceExpiryDate3);
					driver.findElement(By.name("requestBean.polocyNbr")).clear();
					driver.findElement(By.name("requestBean.polocyNbr")).sendKeys(PolicyNumber);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("button2")));
					driver.findElement(By.name("button2")).click();			
					driver.findElement(By.name("button2")).click();		
					test.log(LogStatus.PASS, "click on Update 2 button ");
					Thread.sleep(8000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("process")));
					driver.findElement(By.name("process")).click();
					test.log(LogStatus.PASS, "click on process Loan button ");
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(3000);
					driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
					//requestBean.siilBean.disbType
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					//requestBean.siilBean.advAmt
					String Instamt=driver.findElement(By.name("requestBean.siilBean.advAmt")).getAttribute("value");
					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(Instamt);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+Instamt);

					if(ESign_DisbType.equals("ACH"))	
					{

						driver.findElement(By.name("newAbaNbr")).sendKeys(ABA_Number);
						test.log(LogStatus.PASS, "ABA Number entered");
						driver.findElement(By.name("newCkngAccntNbr")).sendKeys(ESign_CheckNbr);
						test.log(LogStatus.PASS, "Newchecking number Enetered");

					}
					Thread.sleep(5000);

					driver.findElement(By.name("requestBean.siilBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Payment Reminder Consent is selected as "+ESign_CourtesyCallConsent);
					if(ESign_CourtesyCallConsent.equals("Yes"))
					{
						if(ESign_Preference.equals("Call"))	
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))	
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))	
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try { 
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.														

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					if(AllowPromotion.equals("Yes"))
					{
						driver.findElement(By.name("allowPromotion")).click();
						test.log(LogStatus.PASS, "AllowPromotion is selected ");
						//String mwh=driver.getWindowHandle();
						driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);
						test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
						//String winHandle = driver.getWindowHandle(); //Get current window handle.									
					}

					if(ESign_CollateralType.equals("CHECK"))
					{
						driver.findElement(By.name("requestBean.checkNbrs")).sendKeys(ESign_CheckNbr);
						test.log(LogStatus.PASS, "Check number Entered");
					}
					driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
					driver.findElement(By.name("finishLoan")).click();
					test.log(LogStatus.PASS, "Click on Finish Loan Button");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.xpath("//*[@id='OKBut']")).click();	
					//driver.findElement(By.name("OKBut")).click();
					//driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]")).click();				
					test.log(LogStatus.PASS, "click on Yes button ");
					for( String winHandle1 : driver.getWindowHandles())
					{
						driver.switchTo().window(winHandle1);
					}			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					//OKBut
					Thread.sleep(5000);
					if(driver.findElement(By.name("ok")).isDisplayed())
						//if(driver.findElement(By.name("OKBut")).isDisplayed())
					{
						test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
						//driver.findElement(By.name("ok")).click();
						driver.findElement(By.name("ok")).click();
					}
					else
					{
						test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
					}
				}
			}

		}
	}
}
