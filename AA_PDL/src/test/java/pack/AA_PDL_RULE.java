package pack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pack.Void;


public class AA_PDL_RULE extends AA_PDL {
	//@Test(priority=5,groups = "AA_PDL_RULE") //completed


	public void BorrRegistration_NewLoan_Rule() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_incom25_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_05"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan");
			     SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				
				NewLoan_Rule.NewLoan_Rule(SSN, FileName);
			
				
			}		
		}
	}
	//@Test(priority=6,groups = "AA_PDL_RULE") //completed


	public void BorrRegistration_NewLoan() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_incom100_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				
				
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}				
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				//String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_06"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan");
				SetCurrentDate.SetCurrentDate(SSN, FileName);
				//SetDate.SetDate(SSN, FileName, "02", "01", "2020");
				Login.Login(UserName,Password,StoreId);	
			
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				NewLoan.NewLoan(SSN, FileName);
				
			
				
			}		
		}
	}
	//@Test(priority=15,groups = "AA_PDL_RULE") 


	public void AA_BorrRegistration_NewLoan_Rule_incom50() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_Rule_incom50_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_15"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan");
			     SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				
				//NewLoan_Rule.NewLoan_Rule(SSN, FileName);
				AA_NewLoan_Rule_Check_LoanAmt.AA_NewLoan_Rule_Check_LoanAmt(SSN, FileName, "100");
			
				
			}		
		}
	}
	//@Test(priority=16,groups = "AA_PDL_RULE") 


	public void AA_BorrRegistration_NewLoan_incom500() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_incom500Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_16"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan");
			     SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				
				AA_NewLoan_Rule_Check_LoanAmt.AA_NewLoan_Rule_Check_LoanAmt(SSN, FileName, "500");
			
				
			}		
		}
	}
	//@Test(priority=17,groups = "AA_PDL_RULE") 


	public void AA_BorrRegistration_NewLoan_incomamount500() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_incomamount500Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_17"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan");
			    // SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				
				AA_NewLoan_Rule_Check_LoanAmt.AA_NewLoan_Rule_Check_LoanAmt(SSN, FileName, "500");
			
				
			}		
		}
	}

	
	//@Test(priority=21,groups = "AA_PDL_RULE") 


		public void BorrRegistration_NewLoan_Monthly() throws Exception 
		{
			String FileName= "AA_BorrowerRegistration_NewLoanRule_Monthly_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					if(StateID.equals("TN")){
					AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
					UserName = prop.getProperty("UserName_TN_PDL_Rule");
					Password = prop.getProperty("Password_TN_PDL_Rule");
					StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
					}
					if(StateID.equals("FL")){
						
						AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
						UserName = prop.getProperty("UserName_FL_PDL_Rule");
						Password = prop.getProperty("Password_FL_PDL_Rule");
						StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
						
					}
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"Scenario_No_21"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan");
				     SetCurrentDate.SetCurrentDate(SSN, FileName);
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
					
					NewLoan.NewLoan(SSN, FileName);
					NewLoanRule.NewLoanRule(SSN, FileName);
				
					
				}		
			}
		}
	
     // @Test(priority=22,groups = "AA_PDL_RULE") 


	public void BorrRegistration_NewLoanRule_SemiMonthly() throws Exception 
	{
		String FileName= "AA_BorrowerRegistration_NewLoanRule_SemiMonthly_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_22"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan");
			     SetCurrentDate.SetCurrentDate(SSN, FileName);
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				
				NewLoan.NewLoan(SSN, FileName);
				NewLoanRule.NewLoanRule(SSN, FileName);
			
				
			}		
		}
	}
	
	//@Test(priority=54,groups = "AA_PDL_RULE") 


	public void BorrRegistration_NewLoan_Duedate_holiday_displayvalidatedate() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_Duedate_Holiday_weekly_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_54"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan-->duedate-->holiday-->validateduedate");
				SetDate.SetDate(SSN, FileName, "12", "26", "2019");
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				
				NewLoan.NewLoan(SSN, FileName);
				AA_Newloan_weekly_BeforeHolidaydate_verification.AA_Newloan_weekly_HolidayDate_Verification(SSN, FileName);
				
			
				
			}		
		}
	}
	//@Test(priority=57,groups = "AA_PDL_RULE") 


	public void BorrRegistration_NewLoan_Duedate_holiday_displayvalidatedatedisplay() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_Duedate_Holiday_Biweekly_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_57"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan-->duedate-->holiday-->validateduedate");
			     
			     //SetDate.SetDate(SSN, FileName, "12", "19", "2019");
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				NewLoan.NewLoan(SSN, FileName);
				AA_Newloan_Biweekly_BeforeHolidaydate_verification.AA_Newloan_Biweekly_HolidayDate_Verification(SSN, FileName);
				
				
				
				
			
				
			}		
		}
	}
	//@Test(priority=66,groups = "AA_PDL_RULE") 


	public void BorrRegistration_NewLoan_SameDuedate_holiday_display() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_Duedate_SameHolidaydate_weekly_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_66"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan-->duedate-->holiday-->validateduedate");
				SetDate.SetDate(SSN, FileName, "12", "26", "2019");
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				
				NewLoan.NewLoan(SSN, FileName);
				AA_Newloan_Weekly_sameHolidaydate_verification.AA_Newloan_weekly_HolidayDate_Verification(SSN, FileName);
				
			
				
			}		
		}
	}
	//@Test(priority=69,groups = "AA_PDL_RULE") 


	public void BorrRegistration_NewLoan_Duedate_Sameholidaydate_display() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_Duedate_SameHolidaydate_Biweekly_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_69"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan-->duedate-->holiday-->validateduedate");
			     
			     SetDate.SetDate(SSN, FileName, "12", "19", "2019");
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				NewLoan.NewLoan(SSN, FileName);
				AA_Newloan_Biweekly_SameHolidaydate_Verification.AA_Newloan_Biweekly_HolidayDate_Verification(SSN, FileName);
				
				
				
				
			
				
			}		
		}
	}
	
	//@Test(priority=86,groups = "AA_PDL_RULE") 


	public void BorrRegistration_NewLoan_Duedate_Fallson_Bankholiday_Validateduedate_displayed() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_Duedate_fallsbankholiday_validate_weekly_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_69"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan-->duedate-->holiday-->validateduedate");
			     if(StateID.equals("FL")){

			     SetDate.SetDate(SSN, FileName, "12", "25", "2019");
			     }
			 	else{
			 	SetDate.SetDate(SSN, FileName, "12","26" , "2019");
			 	}
			     
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				NewLoan.NewLoan(SSN, FileName);
				AA_Newloan_Biweekly_SameHolidaydate_Verification.AA_Newloan_weekly_Duedate_Fallson_Bankholiday_Validatedatedisplay(SSN, FileName);
				
				
				
				
				
			
				
			}		
		}
	}
	
	//@Test(priority=85,groups = "AA_PDL_RULE") 


	public void BorrRegistration_NewLoan_Duedate_Fallson_Bankholiday_Validateduedate_displayed_Monthly() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_Duedate_fallsbankholiday_validate_Monthly_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_85"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan-->duedate-->holiday-->validateduedate");
			     
			     SetDate.SetDate(SSN, FileName, "12", "04", "2019");
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				NewLoan.NewLoan(SSN, FileName);
				AA_Newloan_Biweekly_SameHolidaydate_Verification.AA_Newloan_Monthly_Duedate_Fallson_Bankholiday_Validatedatedisplay(SSN, FileName);
				
				
				
				
				
			
			
			}		
		}
	}
	//@Test(priority=87,groups = "AA_PDL_RULE") 

	//public static void AA_Newloan_SemiMonthly_Duedate_Fallson_Bankholiday_Validatedatedisplay(String SSN,String FileName) throws Exception
	public void BorrRegistration_NewLoan_Duedate_Fallson_Bankholiday_Validateduedate_displayed_SemiMonthly() throws Exception 
	{
		String FileName= "AA_BorrRegistration_NewLoan_Duedate_fallsbankholiday_validate_SemiMonthly_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				if(StateID.equals("TN")){
				AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
				UserName = prop.getProperty("UserName_TN_PDL_Rule");
				Password = prop.getProperty("Password_TN_PDL_Rule");
				StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
				}
				if(StateID.equals("FL")){
					
					AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
					UserName = prop.getProperty("UserName_FL_PDL_Rule");
					Password = prop.getProperty("Password_FL_PDL_Rule");
					StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
					
				}
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_87"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan-->duedate-->holiday-->validateduedate");
			     
			     SetDate.SetDate(SSN, FileName, "12", "20", "2019");
				Login.Login(UserName,Password,StoreId);				
				RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
				NewLoan.NewLoan(SSN, FileName);
				AA_Newloan_Biweekly_SameHolidaydate_Verification.AA_Newloan_SemiMonthly_Duedate_Fallson_Bankholiday_Validatedatedisplay(SSN, FileName);
				
				
				
				
				
			
				
			}		
		}
	}
	//@Test(priority=88,groups = "AA_PDL_RULE") 


		public void BorrRegistration_NewLoan_Duedate_Fallson_Bankholiday_Validateduedate_displayed_Biweekly() throws Exception 
		{
			String FileName= "AA_BorrRegistration_NewLoan_Duedate_fallsbankholiday_validate_Biweekly_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					if(StateID.equals("TN")){
					AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
					UserName = prop.getProperty("UserName_TN_PDL_Rule");
					Password = prop.getProperty("Password_TN_PDL_Rule");
					StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
					}
					if(StateID.equals("FL")){
						
						AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
						UserName = prop.getProperty("UserName_FL_PDL_Rule");
						Password = prop.getProperty("Password_FL_PDL_Rule");
						StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
						
					}
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"Scenario_No_88"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan-->duedate-->holiday-->validateduedate");
				     if(StateID.equals("FL")){

				     SetDate.SetDate(SSN, FileName, "12", "25", "2019");
				     }
				 	else{
				 	SetDate.SetDate(SSN, FileName, "12","26" , "2019");
				 	}
				     
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL_Rule(driver, test, AppURL, SSN, FileName);				
					NewLoan.NewLoan(SSN, FileName);
					AA_Newloan_Biweekly_SameHolidaydate_Verification.AA_Newloan_Biweekly_Duedate_Fallson_Bankholiday_Validatedatedisplay(SSN, FileName);
					
					
					
					
					
				
					
				}		
			}
		}
		@Test(priority=119,groups = "AA_PDL_RULE") //completed


		public void BorrRegistration_NewLoan_prenote_6daysbeforepaymentdate() throws Exception 
		{
			String FileName= "AA_BorrRegistration_NewLoan_prenotedeposit_Beforepaymentdate_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_PDL_RULE_path") + FileName);  
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					if(StateID.equals("TN")){
					AppURL = prop.getProperty("AppURL_TN_PDL_Rule");
					UserName = prop.getProperty("UserName_TN_PDL_Rule");
					Password = prop.getProperty("Password_TN_PDL_Rule");
					StoreId = prop.getProperty("StoreID_TN_PDL_Rule");
					}
					if(StateID.equals("FL")){
						
						AppURL = prop.getProperty("AppURL_FL_PDL_Rule");
						UserName = prop.getProperty("UserName_FL_PDL_Rule");
						Password = prop.getProperty("Password_FL_PDL_Rule");
						StoreId = prop.getProperty("StoreID_FL_PDL_Rule");
						
					}
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
					String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest(Header+"Scenario_No_119"+"_"+PayFrequency+"_"+CollateralType,"Login-->Home screen-->Borrower-->Registration-->New loan");
					SetCurrentDate.SetCurrentDate(SSN, FileName);
					Login.Login(UserName,Password,StoreId);				
					RegistrationPage_NewLoan_PDL.RegistrationPage_NewLoan_PDL(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					 if(StateID.equals("FL")){
						 AgeStore.AgeStore(SSN, FileName, 0);
						    DrawerDeassign.DrawerDeassign(SSN, FileName);
							UncheckRecord_EODProcessing.UncheckRecord_EODProcessing(SSN, FileName);
							StoreInfo.StoreInfo(SSN, FileName);						     
							Safeassign.Safeassign(SSN, FileName);
							Drawerassign.Drawerassign(SSN, FileName);
							AgeStore_ACHEffectiveDate.AgeStore_ACHEffectiveDate(SSN, FileName, -7);
							ACHEffectivedate_6DaysBeforeDuedate.ACHEffectivedate_6DaysBeforeDuedate(SSN, FileName,-7);
					 }
					 else{
							
					AgeStore.AgeStore(SSN, FileName, -6);
					PrenoteDeposit_6DaysBeforeDuedate.PrenoteDeposit_6DaysBeforeDuedate(SSN, FileName,-7);
					
					 }
				
					
				}		
			}
		}
		
	


	

	

	
	

	
	






	
	
	@AfterMethod(alwaysRun = true)

	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			// test.log(LogStatus.FAIL, "Test Case Failed is
			// "+result.getThrowable());

			String screenshotPath = getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		reports.flush();
		// driver.quit();

	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		// TakesScreenshot ts = (TakesScreenshot) driver;
		// File source = ts.getScreenshotAs(OutputType.FILE);

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/ExecutionReports/LOC/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		// Ending Test
		reports.endTest(test);

		// writing everything into HTML report
		reports.flush();
	}

	@AfterClass(alwaysRun = true)
	public void quit() {
		// Closing browser
		driver.quit();

	}

	public void takeScreenShot(WebDriver driver, String filePath) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass(alwaysRun = true)
	public synchronized void initialize() {
		// Create an instance of ExtentsReports class and pass report storage
		// path as a parameter
		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try {
			BufferedReader reader;
			reader = new BufferedReader(

					new FileReader("C:/AA_Batch/AA_PDL/src/test/java/pack/Config.properties"));

			prop = new Properties();
			prop.load(reader);
			reader.close();

		}

		catch (Exception e) {

			System.out.println("Object proprties file not found");
		}

		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		// Date D = new Date();

		String kfilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

		reports = new ExtentReports(
				System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + kfilename, true);
		/*
		 * reports = new ExtentReports(System.getProperty("user.dir") +
		 * "/ExecutionReports/CO_ILP/AA_CO_ILP_Generic Scenarios_" + timestamp +
		 * ".html", true); reports.addSystemInfo("Browser Version", "IE 11.0");
		 */
	}

	@BeforeTest(alwaysRun = true)
	public void setup_Grid() throws IOException, InterruptedException {

		try {
			BufferedReader reader;
			reader = new BufferedReader(

					new FileReader("C:/AA_Batch/AA_PDL/src/test/java/pack/Config.properties"));

			prop = new Properties();
			prop.load(reader);
			reader.close();

		}

		catch (Exception e) {

			System.out.println("Object proprties file not found");
		}

		Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
		Thread.sleep(5000); // Allow OS to kill the process
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * String Node = "http://192.168.2.123:5555/wd/hub"; DesiredCapabilities
		 * cap = DesiredCapabilities.internetExplorer();
		 * 
		 * 
		 * System.setProperty("webdriver.ie.driver",System.getProperty(
		 * "user.dir")+"/IEDriverServer.exe");
		 * 
		 * driver = new RemoteWebDriver(new URL(Node), cap);
		 */
		/*
		 * System.setProperty("webdriver.ie.driver",System.getProperty(
		 * "user.dir")+"/IEDriverServer.exe"); driver = new
		 * InternetExplorerDriver();
		 */
	}

	public boolean IsElementExits(String Value) {
		int secondsToWait = 5;

		try {
			new WebDriverWait(driver, secondsToWait)
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Value)));
			return true;
		} catch (org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	public static WebElement Field(WebDriver driver) {

		try {
			Thread.sleep(500);
			WebElement element = (new WebDriverWait(driver, 9)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/table")));
			return element;
		} catch (Exception e) {
			return null;
		}
	}

	public void proc(String ReturnFormat) throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");

		// Open a connection
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2",
					"QFUNDX_LOCAL_AUTOMATION", "QFUNDX_LOCAL_AUTOMATION");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");

		try {
			String A = null;

			String content;

			String fw = "E:\\AdminLogin.txt";
			// String content = "\r\n";

			// content=A;
			// fw = "E:\\AdminLogin.txt";

			appendUsingFileWriter(fw, ReturnFormat);
			// appendUsingFileWriter(fw,"\r\n");
			// appendUsingFileWriter(fw,content);

			// String str = content.readLine();

			fw.replaceAll("[0-9,a-z,A-Z]{17,21}", A);

			// fw.close();

			System.out.println("after query");

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}

	private static void appendUsingFileWriter(String filePath, String text) {
		File file = new File(filePath);
		FileWriter fr = null;
		try {
			// Below constructor argument decides whether to append or override
			fr = new FileWriter(file);
			fr.write(text);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	

}
