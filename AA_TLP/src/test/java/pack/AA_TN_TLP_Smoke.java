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

public class AA_TN_TLP_Smoke extends AA_TLP {

	
	@Test(priority=0,groups = "revathi_TN_TLP_Smoke")

	public void RegistrationTest() throws Exception 
{
		String FileName= "AA_BorrowerRegistration_NewLoan_Txn_Testdata.xls";
		
		//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName);
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");
				UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");
				Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");
				StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("AA_BorrowerRegistration_NewLoan_Txn_"+Header, "Login_Home screen_Borrower_Registration_New loan");
				

				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
			}
		}
	}
	
@Test  (priority=1,groups = "revathi_TN_TLP_Smoke")

		public void BorrowerRegistration_NewLoan_PartialPayment() throws Exception 
	{
			String FileName= "AA_BorrowerRegistration_NewLoan_PartialPaymentTxn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName);   
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{	AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");
					UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");
					Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");
					StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("AA_BorrowerRegistration_NewLoan_PartialPaymentTxn_"+Header, "TitleLoan_partialpaymentandstoptherenewal(beforeRenewalLettergenerate)_tryingtogenerateRenewalLetter10daysbeforeduedate_shouldnotgeneratetheRenewalLetter_RunEODon1stinstallmentDuedate_TitleLoanshouldnotberenew_PayofftheTitleLoanOn2ndinsDueate_payoffamountshouldbalanceprinciple,1stinstremaininginterest,feesonly");
					

	
					Login.Login(UserName, Password, StoreId);
					
					RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName, +5);
					PartialPayment.PartialPayment(SSN, FileName);
					//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, -10, 2);
					AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName, -10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					Renewal_Status.Renewal_Status(SSN, FileName);
					//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
					AgeStore_1stInst_DueDate.AgeStore_1stInst_DueDate(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					Renewal_Status.Renewal_Status(SSN, FileName);
					AgeStore2ndInst_Duedate.AgeStore2ndInst_Duedate(SSN, FileName, 0);
					Inst_Payoff.Inst_Payoff(SSN, FileName);
				}
			}
		}

	@Test (priority=2,groups = "revathi_TN_TLP_Smoke")

		public void BorrowerRegistration_NewLoan_MakePayment() throws Exception 
		{
			String FileName= "AA_BorrowerRegistration_NewLoan_MakePayment_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName);   
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");
					UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");
					Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");
					StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					
					test = reports.startTest("AA_BorrowerRegistration_NewLoan_MakePaymentTxn_"+Header, "TitleLoan_ generateletter10daysbeforeDuedate_makepayment_to_apportinate_principle_then_TitleLoan_shouldbeRescheduled");
					
	
					Login.Login(UserName, Password, StoreId);
					
					RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, -10, 2);
					AgeStore.AgeStore(SSN, FileName, -10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					Before_Payment_InstNO.Before_Payment_InstNO(SSN, FileName);
					Payment.Payment(SSN, FileName);
					After_Payment_InstNO.After_Payment_InstNO(SSN, FileName);
				}
			}
		}


@Test (priority=3,groups = "revathi_TN_TLP_Smoke")

		public void BorrowerRegistration_NewLoan_Miss1stInst_Default_WriteOff() throws Exception 
		{
			String FileName= "AA_BorrowerRegistration_NewLoan_Miss1stInst_Default_WriteOff_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName); 
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{

					AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");
					UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");
					Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");
					StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("AA_BorrowerRegistration_NewLoan_Miss1stInst_Default_WriteOffTxn_"+Header, "TitleLoan_ generateletter10daysbeforeDuedate_Missedthe1stInstallmentpayment_RunEODon1stinstallmentDuedate_Renewthe2ndinst_RunDefaultProcedureon2ndInstallmentDuedate_LoangetsDefault(MissedInst_PLUS_30 days)_RunWriteOffProcedureon60daysfromDefaultdate_LoangetsWriteOff");
					

	
					Login.Login(UserName, Password, StoreId);
					
					RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName);
					//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, -10, 2);
					AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName, -10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					Renewal_Status.Renewal_Status(SSN, FileName);
					//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
					AgeStore_1stInst_DueDate.AgeStore_1stInst_DueDate(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					Renewal_Status.Renewal_Status(SSN, FileName);
					//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 3);
					AgeStore_2BatchProcess.AgeStore_2BatchProcess(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					Loan_Status.Loan_Status(SSN, FileName);
					AgeStore_WriteOff60Days.AgeStore_WriteOff60Days(SSN, FileName, +60);
					WriteOff_Status.WriteOff_Status(SSN, FileName);
				}
			}
			
	}
		
		
@Test (priority=4,groups = "revathi_TN_TLP_Smoke")

	public void NewLoanMultiDIsb_Void() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_NewLoanMultiDIsb_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		//int lastrow=TestData.getLastRow("Borrower");
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			//System.out.println(RunFlag);
			if(RunFlag.equals("Y"))
			{	
				//driver.get(appUrl);
				//test.log(LogStatus.INFO, "Application is launched");
				//driver.manage().window().maximize();
				AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");
				UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");
				Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest("AA_NewLoanMultiDIsb_Void"+Header, "loanwithmultipledisbursement(cash&check)_voidwithOriginalcheck");
				


				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan1.NewLoan1(SSN, FileName);
				Void.Void(SSN, FileName);
			}
		}
		
	}
	
@Test (priority=5,groups = "revathi_TN_TLP_Smoke")

	public void partialPayment_StopRenewal_1stinstpmton2ndinstpmt() throws Exception 
	{

		String FileName= "AA_partialPayment_StopRenewal_1stinstpmton2ndinstpmt_Txn_Testdata.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName); 

		int lastrow=TestData.getLastRow("NewLoan");

		String sheetName="NewLoan";

		System.out.println(lastrow);

		for(int row=2;row<=lastrow;row++)

		{

			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))

			{
				AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");

				UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");

				Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");

				StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");

				String ProductID = TestData.getCellData(sheetName,"ProductID",row);

				String StateID = TestData.getCellData(sheetName,"StateID",row);

				String SSN = TestData.getCellData(sheetName,"SSN",row);

				String Header = StateID+ "_" + ProductID;

				test = reports.startTest("AA_partialPayment_StopRenewal_1stinstpmton2ndinstpmtTxn_"+Header, "Title Loan _ partial payment and stop the renewal(before letter generate) _ trying to generate letter 10 days before due date _ should not generate the letter _ Run EOD on 1st inst due date _ Title Loan should not be renew _ make 1st installment payment on 2nd installment duration and cancel the stop renewal_ Renewal should be posted and payment should apply.");

				


				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName, +5);
				PartialPayment.PartialPayment(SSN, FileName);
				//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, -10, 3);
				AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Renewal_Status.Renewal_Status(SSN, FileName);
				AgeStore_1stInst_DueDate.AgeStore_1stInst_DueDate(SSN, FileName, 0);
				Renewal_Status.Renewal_Status(SSN, FileName);
				AgeStore1_2.AgeStore1_2(SSN, FileName, -5);
				Payment.Payment(SSN, FileName);
				Renewal_StatusEnd.Renewal_StatusEnd(SSN, FileName);
			}
		}
	}



@Test (priority=6,groups = "revathi_TN_TLP_Smoke")

	public void Miss1stInst_RunDefaulton2ndInst() throws Exception 
{
		String FileName= "AA_Miss1stInst_RunDefaulton2ndInst_Txn_Testdata.xls";//AA_Miss1stInst_RunDefaulton2ndInst_Txn_Testdata
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");
				UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");
				Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");
				StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("AA_Miss1stInst_RunDefaulton2ndInstTxn_"+Header, "Title Loan _ generate letter 10 days before due date _ Missed the 1st Installment payment _ Run EOD on 1st installment due date _ Renew the 2nd inst._ Run Default Procedure on 2nd Installment due date -_ Loan gets Default(Missed Inst + 30 days)");
				


				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, -10, 2);
				AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Renewal_Status.Renewal_Status(SSN, FileName);
			//	EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				AgeStore_1stInst_DueDate.AgeStore_1stInst_DueDate(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Renewal_Status.Renewal_Status(SSN, FileName);
			//	EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 3);
				AgeStore_2BatchProcess.AgeStore_2BatchProcess(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Loan_StatusEnd.Loan_StatusEnd(SSN, FileName);
			}
		}
	}



	//@Test (priority=7,groups = "revathi_TN_TLP_Smoke")

	public void Default_CurePayment() throws Exception 
	{
		String FileName= "AA_Default_CurePayment_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");
				UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");
				Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");
				StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("AA_Default_CurePayment_Txn_"+Header, "TitleLoan_Generateletter10daysbeforeduedate_RunEODonDuedateof1stInstallment_RunEODon2ndInstallmentdateandcustomerstatuschangedtodefault_agethestore_PerformDefaultPaymentWithCureAmountOnly_LoanStatuschangedtoCurrent");

				

				Login.Login(UserName, Password, StoreId);
				/*
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);*/
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, -10, 2);
				AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Renewal_Status.Renewal_Status(SSN, FileName);
			//	EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
				AgeStore_1stInst_DueDate.AgeStore_1stInst_DueDate(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);  				
				Renewal_Status.Renewal_Status(SSN, FileName);
				//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 3);
				AgeStore_2BatchProcess.AgeStore_2BatchProcess(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Loan_Status.Loan_Status(SSN, FileName);
				AgeStore_CureDate.AgeStore_CureDate(SSN, FileName, 3);
				CurePayment.CurePayment(SSN, FileName);
				Loan_StatusEnd.Loan_StatusEnd(SSN, FileName);
			}
		}
	}

 //@Test (priority=8,groups = "revathi_TN_TLP_Smoke")
		public void Newloan_1stinstTo3rdinstPayment_check4thinstpayment() throws Exception 
		{
			String FileName= "AA_Newloan_1stinstTo3rdinstPayment_check4thinstpayment_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName); 
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan";   
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{	
					AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");
					UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");
					Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");
					StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("AA_Loan_1stTo3rdInstPayment_checkthe4thinstAmount"+Header, "Title Loan _ generate letter 10 days before due date _ customer made 1st installment payment_ Run EOD on due date _ Loan should Renewed._ same way pay upto 3rd installment_ Run EOD on 3rd inst due date _ Renew the Loan _ at the time of 4th installment renewal, Principle reduction should be apply(5% of Title Loan amount).");
					
					
	
					Login.Login(UserName, Password, StoreId);
					
					RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
					NewLoan.NewLoan(SSN, FileName); 
					//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, -10, 2);
					AgeStore_1stInst.AgeStore_1stInst(SSN, FileName, -10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					Payment.Payment(SSN, FileName);
					EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 2);
					AgeStore_1stInst.AgeStore_1stInst(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName); 
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName); 
					//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, -10, 3);
					AgeStore_2ndInst.AgeStore_2ndInst(SSN, FileName, -10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					//EODProcessing.EODProcessing(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName); 
					Payment.Payment(SSN, FileName);
				//	EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 3);
					AgeStore_2ndInst.AgeStore_2ndInst(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName); 
					//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, -10, 4);
					AgeStore_3rdInst.AgeStore_3rdInst(SSN, FileName, -10);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName); 
					Payment.Payment(SSN, FileName);
					//EOD_BatchProcess_DueDate.EOD_BatchProcess_DueDate(SSN, FileName, 0, 4);
					AgeStore_3rdInst.AgeStore_3rdInst(SSN, FileName, 0);
					DrawerDeassign.DrawerDeassign(SSN, FileName);
					StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
					StoreInfo.StoreInfo(SSN, FileName);
					Safeassign.Safeassign(SSN, FileName);
					Drawerassign.Drawerassign(SSN, FileName);
					PrincipalReduction_4thInst.PrincipalReduction_4thInst(SSN, FileName);
				}
			}
		}

	//@Test (priority=9,groups = "revathi_TN_TLP_Smoke")

		public void OneCustomer_TwoVINs_FourLoans() throws Exception
	{
			String FileName= "AA_OneCustomer_TwoVINs_FourLoans_Txn_Testdata.xls";
			TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName); 
			int lastrow=TestData.getLastRow("NewLoan");
			String sheetName="NewLoan"; 
			System.out.println(lastrow);
			for(int row=2;row<=lastrow;row++)
			{
				String RunFlag = TestData.getCellData(sheetName,"Run",row);
				if(RunFlag.equals("Y"))
				{
					AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");
					UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");
					Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");
					String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
					String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
					StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String StateID = TestData.getCellData(sheetName,"StateID",row);
					String SSN = TestData.getCellData(sheetName,"SSN",row);	
					String Header = StateID+ "_" + ProductID;
					test = reports.startTest("AA_OneCustomer_TwoVINs_FourLoans"+Header, "Register customer _ Originate two loans on one VIN _ Originate another two Loans on Second VIN _ Four loans should be originated for the customer.");
					
	
					Login.Login(UserName, Password, StoreId);
					
					RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
					NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
					NewLoanWithVIN2.NewLoanWithVIN2(SSN, FileName,NewVIN);
					NewLoanWithVIN2_1.NewLoanWithVIN2_1(SSN, FileName,NewVIN2);
					NewLoanWithVIN2.NewLoanWithVIN2(SSN, FileName,NewVIN2);
				}
			}
		}

//@Test (priority=10,groups = "revathi_TN_TLP_Smoke")
//default issue

	 public void TwoLoans_OneVIN_OneDefault() throws Exception 
	 {
		String FileName= "AA_TwoLoans_OneVIN_OneDefault_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";  
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
		if(RunFlag.equals("Y"))
		{
				AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");
				UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");
				Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");
		        StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		        test = reports.startTest("TwoLoans_OneVIN_OneDefault"+Header, "Originate two Loans on Same VIN_make one loan to Default_Other loan should not become Default.");
		        
		        
		        Login.Login(UserName, Password, StoreId);
		     
		        RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
		        NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
				LoanDate_Agestore_C.LoanDate_Agestore_C(SSN, FileName,5);
		        NewLoanWithVIN3.NewLoanWithVIN3(SSN, FileName,NewVIN);
		       // EOD_BatchProcess_1_1_C.EOD_BatchProcess_1_1_C(SSN, FileName, 0);
		        AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
		        DrawerDeassign.DrawerDeassign(SSN, FileName);
		        StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
		        StoreInfo.StoreInfo(SSN, FileName);
		        Safeassign.Safeassign(SSN, FileName);
		        Drawerassign.Drawerassign(SSN, FileName);
		      //  EOD_BatchProcess_2_1_C.EOD_BatchProcess_2_1_C(SSN, FileName, 0);
		        AgeStore2_1_C.AgeStore2_1_C(SSN, FileName, 0);
		        DrawerDeassign.DrawerDeassign(SSN, FileName);
		        StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
		        StoreInfo.StoreInfo(SSN, FileName);
		        Safeassign.Safeassign(SSN, FileName);
		        Drawerassign.Drawerassign(SSN, FileName);
		        AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);// Pradeep
		        DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);
		}
	}
}
	
	
	//@Test (priority=11,groups = "revathi_TN_TLP_Smoke")
	
	 public void TwoLoans_OneVIN_OneDefault_Repossession() throws Exception 
	{
		String FileName= "AA_TwoLoans_OneVIN_OneDefault_Repossession_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_Smoke_path_revathi") + FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
		if(RunFlag.equals("Y"))
		{	
				AppURL = prop.getProperty("AppURL_TN_TLP_Smoke_revathi");
				UserName = prop.getProperty("UserName_TN_TLP_Smoke_revathi");
				Password = prop.getProperty("Password_TN_TLP_Smoke_revathi");
		        StoreId = prop.getProperty("StoreID_TN_TLP_Smoke_revathi");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		        test = reports.startTest("AA_TwoLoans_OneVIN_OneDefault_Repossession"+Header, "Originate two Loans on Same VIN_make one loan to Default_Other loan should not become Default_Make Repossession for one loan_Repossession should post for Other Loan also_Make Auction for the Loan_Make Sale for the Loan with amout just more than two loans Total Due_Two loans shld be closed_Remaining amount should be Refunded to Custmr through  first loan.");
		        
		        
		       
		        Login.Login(UserName, Password, StoreId);
		     
		        RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
		        NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN); //1st loan issue
				LoanDate_Agestore_C.LoanDate_Agestore_C(SSN, FileName,5); //update store date to 5 days from loan date
		        NewLoanWithVIN3.NewLoanWithVIN3(SSN, FileName,NewVIN); //2nd loan issue
		       // EOD_BatchProcess_1_1_C.EOD_BatchProcess_1_1_C(SSN, FileName, 0);
		        AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); //1st loan due date update
		        DrawerDeassign.DrawerDeassign(SSN, FileName);
		        StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
		        StoreInfo.StoreInfo(SSN, FileName);
		        Safeassign.Safeassign(SSN, FileName);
		        Drawerassign.Drawerassign(SSN, FileName);
		       // EOD_BatchProcess_2_1_C.EOD_BatchProcess_2_1_C(SSN, FileName, 0);
		        AgeStore2_1_C.AgeStore2_1_C(SSN, FileName, 0); //2nd loan due date update
		        DrawerDeassign.DrawerDeassign(SSN, FileName);
		      //EODProcessing.EODProcessing(SSN, FileName);
		        StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
		        StoreInfo.StoreInfo(SSN, FileName);
		        Safeassign.Safeassign(SSN, FileName);
		        Drawerassign.Drawerassign(SSN, FileName); 
		        AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);//1st Loan default date batch process //pradeep
		        DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);	//Fetching Loan Status of 2 loans
	            OutToRepo.OutToRepo(SSN, FileName, 1); //Out to Repo submission
		        Repossession.Repossession(SSN, FileName, 0); //repossession date = default date
		        DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName); //Fetching Loan Status of 2 loans
		        AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 21);//age store to 21 days from default date
                Auction.Auction(SSN, FileName, 21);
		        Sale.Sale(SSN, FileName, 21);
			    CustomerRefund.CustomerRefund(SSN, FileName);
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

			test.log(LogStatus.PASS, result.getName() + "Test Case is Passed");
		}
		reports.flush();
		//driver.quit();

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

					new FileReader("C:/AA_Batch/AA_ILP/src/test/java/pack/Config.properties"));

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
	
	public static void IETaskKiller() throws IOException, InterruptedException {

		Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
		Thread.sleep(2000); //Allow OS to kill the process
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");
		driver = new InternetExplorerDriver();		
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

