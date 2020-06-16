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

public class AA_TN_TLP extends AA_TLP {

	
	@Test (priority=0,groups = "chenna_TN_TLP")

	public void Loan_EncryptionKey_Void() throws Exception
	{
		String FileName= "AA_NewLoan_EncryptionKey_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";  
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_6"+"_"+PayFrequency+"_"+CollateralType,"Loan-->Void on next day with Encryption Key");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName, 5);
				EncryptionKey_Void.EncryptionKey_Void(SSN, FileName);
				IETaskKiller();
			}
		}


	}

   @Test (priority=1,groups = "chenna_TN_TLP")

	public void Loan_AgestoreRescindDays_Rescind() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_NewLoan_AgestoreRescindDays_Rescind_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"Scenario_No_8"+"_"+PayFrequency+"_"+CollateralType,"Loan–Age the store to Rescind days–Rescind");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,1); 
				Rescind.Rescind(SSN, FileName);
				IETaskKiller();

			}
		}


	}

	@Test (priority=2,groups = "chenna_TN_TLP")

	public void NewLoan_multiplel_disbursement_void() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_NewLoan_multiple disbursement__Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"Scenario_No_14"+"_"+PayFrequency+"_"+CollateralType,"loan with multiple disbursement (cash& check)->void with cash(Next day with encryption)");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan_MultipulDisbtypes.NewLoan_MultipulDisbtypes(SSN, FileName);
 				Void_MultipuldisbTypes.Void_MultipuldisbTypes(SSN, FileName);
				IETaskKiller();

			}
		}


	}




	@Test (priority=3,groups = "chenna_TN_TLP")

	public void NewLoan_Paymenttoapportinateprinciple_Void_Cancelreschudle() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_NewLoan_Payment_Void_CancelReschdule__Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"Scenario_No_19"+"_"+PayFrequency+"_"+CollateralType,"Title Loan --> generate letter 10 days before due date --> make payment to apportinate principle then Title Loan got rescheduled --> Void the payment then cancel the reschedule");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payment.Payment(SSN, FileName);
				Void_Payment.Void_Payment(SSN, FileName);
				IETaskKiller();

			}
		}


	}

   @Test (priority=4,groups = "chenna_TN_TLP")

	public void TwoLoansameVIN_OneLoanDefault_OutofReposhouldnotpostotherLoan() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_TwoLoans_OneVIN_OneDefault_OutofReposhouldnotpostotherLoan_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"Scenario_No_43"+"_"+PayFrequency+"_"+CollateralType, "Originate two Loans on Same VIN  –> make one loan to Default –> Other loan should not become Default –> Make Out of Repo for one loan –> Out of Repo should not effect for other Loan");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,5);
				NewLoanWithVIN2_2.NewLoanWithVIN2_2(SSN, FileName,NewVIN);//updated 
				AgeStore1_1.AgeStore1_1(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName); 
				AgeStore2_1.AgeStore2_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName); 
				AgeStore1_1BatchProcess.AgeStore1_1BatchProcess(SSN, FileName, 0);
				DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);	
				OutToRepo.OutToRepo(SSN, FileName, 1); 
				Loanstatus_1st.Loanstatus_1st(SSN, FileName);
				IETaskKiller();
			}
		}
	}


   @Test (priority=5,groups = "chenna_TN_TLP")

	public void TwoLoansameVIN_OneDefault_Repossession_RepossessionshouldposttwoLoans() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_TwoLoans_OneVIN_OneDefault_RepossessionShouldPostTwoLoans_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"Scenario_No_44"+"_"+PayFrequency+"_"+CollateralType, "Originate two Loans on Same VIN  –> make one loan to Default –> Other loan should not become Default –> Make Repossession for one loan –> Repossession should post for Other Loan also.");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,5);
				//NewLoanWithVIN.NewLoanWithVIN2(SSN, FileName,NewVIN);
				NewLoanWithVIN2_2.NewLoanWithVIN2_2(SSN, FileName,NewVIN);
				AgeStore1_1.AgeStore1_1(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1.AgeStore2_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName); 
				AgeStore1_1BatchProcess.AgeStore1_1BatchProcess(SSN, FileName, 0);
				DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);	
				OutToRepo.OutToRepo(SSN, FileName, 1);
				Repossession.Repossession(SSN, FileName, 0);
				DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);
				IETaskKiller();
		
			
			}
		}

	}


    @Test (priority=6,groups = "chenna_TN_TLP") 

	public void TwoLoansameVIN_Default_Repossion_repoPaymentmoreAmount_ShouldnoteffectotherLoan() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_TwoLoans_OneVIN_OneDefault_Repossession_RepoPayment_ShouldnoteffectotherLoan_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"Scenario_No_45"+"_"+PayFrequency+"_"+CollateralType,"Originate two Loans on Same VIN  –> make one loan to Default –> Other loan should not become Default –> Make Repossession for one loan –> Repossession should post for Other Loan also –> Make repo Payment for the Loan with more amount –> Amount should not effect to other loan..");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,5);
				NewLoanWithVIN2_2.NewLoanWithVIN2_2(SSN, FileName,NewVIN);//updated
				AgeStore1_1.AgeStore1_1(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1.AgeStore2_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName); 
				Drawerassign.Drawerassign(SSN, FileName); 
				AgeStore1_1BatchProcess.AgeStore1_1BatchProcess(SSN, FileName, 0);
				DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);	
				OutToRepo.OutToRepo(SSN, FileName, 1);
				Repossession.Repossession(SSN, FileName, 1);
				DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);
				RepoPayment.RepoPayment(SSN, FileName); 
				IETaskKiller();
		
			}
		}
		//Login.Login("CSR353","1234","353");

	}




	@Test (priority=7,groups = "chenna_TN_TLP") //Auction should consider system date to perform(done for past dates )

	
	public void TwoLoansonsameVin_Default_Repossession_OneLoanAcution_ShouldnoteffectotherLoan() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_TwoLoansonsameVin_Default_Repossession_OneLoanAcution_ShouldnoteffectotherLoan_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"Scenario_No_46"+"_"+PayFrequency+"_"+CollateralType,"Originate two Loans on Same VIN  –> make one loan to Default –> Other loan should not become Default –> Make Repossession for one loan –> Repossession should post for Other Loan also –> Make Auction for the Loan – Auction should not effect for other loan..");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,5);
				NewLoanWithVIN2_2.NewLoanWithVIN2_2(SSN, FileName,NewVIN);//updated
				AgeStore1_1.AgeStore1_1(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1.AgeStore2_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName); 
				Drawerassign.Drawerassign(SSN, FileName); 
				AgeStore1_1BatchProcess.AgeStore1_1BatchProcess(SSN, FileName, 0);
				DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);	
				OutToRepo.OutToRepo(SSN, FileName, 1);
				Repossession.Repossession(SSN, FileName, 1);
				DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);
				Verification1stLoanAMT_BeforeAcution2ndLoan.Verification1stLoanAMT_BeforeAcution2ndLoan(SSN, FileName);
				
				Auction.Auction(SSN, FileName, -120);
				Verification1stLoanAMT_AfterAcution2ndLoan.Verification1stLoanAMT_AfterAcution2ndLoan(SSN, FileName);
				IETaskKiller();
			}
		}
	}

	@Test (priority=8,groups = "chenna_TN_TLP")

	public void TwoLoansonsameVin_Default_saleLessAmount_RemainingAmountShouldbwaived() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_TwoLoansonsameVin_Default_saleLessAmount_RemainingAmountShouldbwaived_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"Scenario_No_47"+"_"+PayFrequency+"_"+CollateralType,"Originate two Loans on Same VIN–>make one loan to Default–>Other loan should not become Default –> Make Repossession for one loan–>Repossession should post for Other Loan also–>Make Auction for the Loan-->Make sale for the Loan with less amount–>Remaining amount should be waived–>Other Loan should also waived.");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,5);
				NewLoanWithVIN2_2.NewLoanWithVIN2_2(SSN, FileName,NewVIN);//updated
				AgeStore1_1.AgeStore1_1(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1.AgeStore2_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName); 
				Drawerassign.Drawerassign(SSN, FileName); 
				AgeStore1_1BatchProcess.AgeStore1_1BatchProcess(SSN, FileName, 0);
				DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);	
				OutToRepo.OutToRepo(SSN, FileName, 1);
				Repossession.Repossession(SSN, FileName, 1);
				DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);
				AgeStore1_1B.AgeStore1_1B(SSN, FileName, 22);
				Auction.Auction(SSN, FileName, 22); 
				Sale_LessAmount.Sale_LessAmount(SSN, FileName, 21);
				TwoLoansVerification_Waived.TwoLoansVerification_Waived(SSN, FileName);
				IETaskKiller();

			}
		}

	}


	
	
	@Test (priority=9,groups = "chenna_TN_TLP")

	public void TwoLoansonsameVin_Default_saleMoreAmount_RemainingAmountShouldbwaived() throws Exception 
{

		// Start test. Mention test script name
		String FileName= "AA_TwoLoansonsameVin_Default_saleMoreAmount_RemainingAmountShouldbwaived_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"Scenario_No_48"+"_"+PayFrequency+"_"+CollateralType,"Originate two Loans on Same VIN–>make one loan to Default–>Other loan should not become Default–>Make Repossession for one loan–>Repossession should post for Other Loan also–>Make Auction for the Loan-->Make sale for the Loan with amout just more than one loan Total Due–>Extra amount should post as sale transaction for other loan–>Remaining amount should be waived..");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,5);
				NewLoanWithVIN2.NewLoanWithVIN2(SSN, FileName,NewVIN);
				//NewLoanWithVIN2_2.NewLoanWithVIN2_2(SSN, FileName,NewVIN);
				AgeStore1_1.AgeStore1_1(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1.AgeStore2_1(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName); 
				Drawerassign.Drawerassign(SSN, FileName); 
				AgeStore1_1BatchProcess.AgeStore1_1BatchProcess(SSN, FileName, 0);
				DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);	
				OutToRepo.OutToRepo(SSN, FileName, 1);
				Repossession.Repossession(SSN, FileName, 1);
				DefaultPaymentStatus1.DefaultPaymentStatus1(SSN, FileName);
				AgeStore1_1B.AgeStore1_1B(SSN, FileName, 22);
				Auction.Auction(SSN, FileName, 22); 
				Sale_MoreAmount.Sale_MoreAmount(SSN, FileName, 21);
				TwoLoansVerification_Waived.TwoLoansVerification_Waived(SSN, FileName);
				IETaskKiller();
			}
		}
	}

	
     @Test (priority=10,groups = "chenna_TN_TLP")

	public void BorrowerNewLoan_Rule_TLP() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_BorrowerNewLoan_Rule_TLP_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				// System.out.println(Password);
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest(Header+"Scenario_No_02"+PayFrequency+"_"+CollateralType, "Login__customerhavingalreadyhavingOpenLoan__performNewLoandependsonrule");
				
				//Login.Login(UserName,Password,StoreId);
				
				Login.Login(UserName, Password, StoreId);
				
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
				//NewLoanWithVIN.NewLoanWithVIN2(SSN, FileName,NewVIN);
				NewLoanWithVIN2_2.NewLoanWithVIN2_2(SSN, FileName,NewVIN);
				//NewLoanWithVIN.NewLoanWithVIN2_1(SSN, FileName,NewVIN2);
				//NewLoanWithVIN.NewLoanWithVIN2(SSN, FileName,NewVIN2);
				NewLoanRule.NewLoanRule(SSN, FileName);
				IETaskKiller();
				
			}
		}
		//Login.Login("CSR353","1234","353");

	}

///////////////////////////////////////////////////////////////////////////////////////////////KIRAN
   @Test (priority=11,groups = "chenna_TN_TLP")//complete
	public void Loan_InstallmentPayment_Void_TLP() throws Exception 
	{
		String FileName= "AA_Loan__InstallmentPayment__Void_TLP_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"TN_TLP_SC.No:10"+PayFrequency+"_"+CollateralType, "Loan__Agethestoreuptosomedaysbeforeduedate__InstallmentPayment__Void");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_1stInst.AgeStore_1stInst(SSN, FileName, -1);
				Payment.Payment(SSN, FileName);
				Payment_Void.Payment_Void(SSN, FileName);
				IETaskKiller();
			}
		}
	}

    @Test (priority=12,groups = "chenna_TN_TLP")// completed

	public void AA_Loan__Payment__RenewLoanDueDate__shouldnotdisplayVoid() throws Exception
	{
		String FileName= "AA_Loan__Payment__RenewLoanDueDate__shouldnotdisplayVoid_TLP_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"TN_TLP_SC.No:11"+PayFrequency+"_"+CollateralType, "Loan__Agethestoreuptosomedaysbeforeduedate__InstallmentPayment__RenewtheloanonDuedate__shouldnotdisplayVoidoptionforPayment");
				
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_1stInst.AgeStore_1stInst(SSN, FileName, -1);
				Payment.Payment(SSN, FileName);
				AgeStore_1stInst.AgeStore_1stInst(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Check_Void.Check_Void(SSN, FileName, 0); //Confirm whether void should be displayed or not? -srikanth
				IETaskKiller();

			}
		}


	}


    @Test (priority=13,groups = "chenna_TN_TLP")//completed
	public void Loan_GenerateLetter_EOD1stInstDate_EOD2ndInstDate_Default_DefaultPmt_Void_CheckLoanStatus() throws Exception {

		String FileName= "AA_Loan_GenerateLetter_EOD1stInstDate_EOD2ndInstDate_Default_DefaultPmt_Void_CheckLoanStatus_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"SCenario_No_35"+PayFrequency+"_"+CollateralType, "Title Loan _ Generate letter 10 days before due date _ Run EOD on Due date of 1st Installment _ Run EOD on 2nd Installment date and customer status changed to default _ age the store _ Perform the Default payment full _ Void the default Payment _ Loan should Open");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, -10); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_2_C.AgeStore1_2_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				AgeStore1_2_C.AgeStore1_2_C(SSN, FileName, 1);
				DefaultPayment.DefaultPayment(SSN, FileName);
				DefaultPayment_Void.DefaultPayment_Void(SSN, FileName);
				Loan_Status.Loan_Status(SSN, FileName);
				IETaskKiller();

			}
		}
	}


    @Test (priority=14,groups = "chenna_TN_TLP")//completed

	public void Loan_Letter10days1stDuedate_Miss1stInstPmt_RenewLoan1stDuedate_Pay1stInstAmtAfterletterGeneration_AppApportionate() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Loan_Letter10days1stDuedate_Miss1stInstPmt_RenewLoan1stDuedate_Pay1stInstAmtAfterletterGeneration_ApplicationApportionate_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName); 
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"TN_TLP_SC.No:24"+PayFrequency+"_"+CollateralType, "Title Loan___ generate letter 10 days before due date ___ Missed the 1st Installment paymen t____ Renew the loan on due date __ Pay the 1st Installment amount after Renewal letter date__application should apportinate 1st and 2nd Installment Interest and then 1st and 2nd Installment Fee and letter date should be payment date");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, -10); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_2_C.AgeStore1_2_C(SSN, FileName, -10); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_2_C.AgeStore1_2_C(SSN, FileName, -11); 
				Payment.Payment(SSN, FileName);
				HistoryValidations.HistoryValidations(SSN, FileName);
				IETaskKiller();
			}
		}
	}

	
	//////////////////kiran
	
	
	
     @Test (priority=15,groups = "chenna_TN_TLP")//completed

	public void Loan_PaymentForInterestAmount_paymentForFee_paymentforPrincipleAmount_ReviseSchedule() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Loan_PaymentForInterestAmount_paymentForFee_paymentforPrincipleAmount_ReviseSchedule_TLP_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
		if(RunFlag.equals("Y"))			
		{		
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
		        StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String SSN = TestData.getCellData(sheetName,"SSN",row);	
		        String Header = StateID+ "_" + ProductID;
		        test = reports.startTest("TN_TLP_SC.No:22"+Header, "Title Loan --> Payment with interest amount( should effct to Intrst only) --> payment with fee amount(should effect to Fee amount only) --> payment(should effect to principal amout) – schedule should revised");
		        Assert.assertTrue(true);
		        		        
		    	
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName); 
				AgeStore.AgeStore(SSN, FileName, 0);
				Payment_InterestAmt.Payment_InterestAmt(SSN, FileName);
				Payment_FeeAmt.Payment_FeeAmt(SSN, FileName);
				Payment_PrincipleAmt.Payment_PrincipleAmt(SSN, FileName);
				HistoryValidations1.HistoryValidations1(SSN, FileName);
				IETaskKiller();

			}
		}
	}
	
	@Test (priority=16,groups = "chenna_TN_TLP")//completed

	public void AA_OneCustomer_OneVIN_TwoLoans_ThirdLoanNotOriginate_TLP() throws Exception {

		String FileName= "AA_OneCustomer_OneVIN_TwoLoans_ThirdLoanNotOriginate_TLP_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				test = reports.startTest(Header+"_S.No:39_"+PayFrequency+"_"+CollateralType, "Originate two loans on same VIN for one custmr _ try to originate loan for same custmr with third VIN _ Loan should not originated.");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
				NewLoanWithVIN4.NewLoanWithVIN4(SSN, FileName,NewVIN);
				NewLoanWithVIN_ThreeLoans.NewLoanWithVIN_ThreeLoans(SSN, FileName, NewVIN);
				IETaskKiller();
			}
		}
	}

   @Test (priority=17,groups = "chenna_TN_TLP")//completed

	public void TwoLoans_TwoCustomers_OneVIN_3rdLoanNotOriginate() throws Exception 
	{
		String FileName= "AA_TwoLoans_TwoCustomers_OneVIN_3rdLoanNotOriginate_TLP_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		test = reports.startTest("TN_TLP_S.No:40_Bi-Weekly_CASH", "Originate two loans on same VIN for two different custmrs __ try to originate third loan for another custmr with same VIN __ Loan should not originated");
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	

				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN_TwoCust.NewLoanWithVIN_TwoCust(SSN, FileName, NewVIN);
				//IETaskKiller();
			}
		}
	}

	
	@Test (priority=18,groups = "chenna_TN_TLP")//completed
	public void Loan_PartialPmtStopRenewal_LetterNotGenerate_EOD1stInsDueDate_LoanNotRenewed_Default_DFLTAmt() throws Exception 
	{

		String FileName= "AA_Loan_PartialPmtStopRenewal_LetterNotGenerate_EOD1stInsDueDate_LoanNotRenewed_Default_DFLTAmtEqualsPrincipleinterestandfee_Txn_Testdata.xls";
		//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				test = reports.startTest(Header+"_S.No:33_"+PayFrequency+"_"+CollateralType,"Title Loan __ partial payment and stop the renewal(before letter generate) __ trying to generate letter 10 days before due date __ should not generate the letter__ Run EOD on 1st inst due date __ Title Loan should not be renew __ Default__ Default amount should balance principle +1st installment remaining interest and fees only");

				//test = reports.startTest("Scenario_No_33_AA_"+Header, "Title Loan __ partial payment and stop the renewal(before letter generate) __ trying to generate letter 10 days before due date __ should not generate the letter__ Run EOD on 1st inst due date __ Title Loan should not be renew __ Default__ Default amount should balance principle +1st installment remaining interest and fees only");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName, 5);
				PartialPayment.PartialPayment(SSN, FileName);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, -10); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_2_C.AgeStore1_2_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				DefaultPayment_Validation.DefaultPayment_Validation(SSN, FileName);
				IETaskKiller();

			}
		}
	}
	//Leela
  @Test (priority=19,groups = "chenna_TN_TLP")//completed
	public void AA_TwoLoans_OneVIN_OneDefault_Repossession_Salvage_Refund() throws Exception {

		String FileName= "AA_TwoLoans_OneVIN_OneDefault_Repossession_Salvage_Refund_Testdata.xls";
		//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
				
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("Scenario_No_62_"+Header, "Originate two Loans on Same VIN_make one loan to Default_Other loan should not become Default_Make Repossession for one loan_Repossession should post for Other Loan also_Make Auction for the Loan_Make Sale for the Loan with amout just more than two loans Total Due_Two loans shld be closed_Remaining amount should be Refunded to Custmr through  first loan.");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
				LoanDate_Agestore_C.LoanDate_Agestore_C(SSN, FileName,5);
				NewLoanWithVIN3.NewLoanWithVIN3(SSN, FileName,NewVIN);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1_C.AgeStore2_1_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName); 
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				OutToRepo.OutToRepo(SSN, FileName, 1);
				Repossession.Repossession(SSN, FileName, 1);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);	
				AgeStore_After_Repo.AgeStore_After_Repo(SSN, FileName, 5);
				Salvage_Morethan_twoloans.Salvage_Morethan_twoloans(SSN, FileName, 21);
				DefaultLoanStatus_1.DefaultLoanStatus_1(SSN, FileName);
				DefaultLoanStatus_2.DefaultLoanStatus_2(SSN, FileName);
				CustomerRefund_secondloan.CustomerRefund_secondloan(SSN, FileName);
				IETaskKiller();
			}
		}
	}

	@Test (priority=20,groups = "chenna_TN_TLP")//completed	
	public void NewLoan_Agestore_beforeduedate_Partialpymt_Void() throws Exception
	{
		String FileName= "AA_NewLoan_Agestore_beforeduedate_Partialpymt_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:9"+"_"+PayFrequency+"_"+CollateralType,"Loan -- Age the store up to some days before due date --Partial Payment—Void");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -6);
				Partial_Payment.Partial_Payment(SSN, FileName);
				Void_Partial_Payment.Void_Partial_Payment(SSN, FileName);
				IETaskKiller();
			}
		}
	}

	@Test (priority=21,groups = "chenna_TN_TLP")	//complete
	public void NewLoan_Agestore_beforeduedate_Payoff_Void() throws Exception 
	{
		String FileName= "AA_NewLoan_Agestore_beforeduedate_Payoff_Void_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:12"+"_"+PayFrequency+"_"+CollateralType,"Loan -- Age the store up to some days before due date – PayOff – Void ");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore.AgeStore(SSN, FileName, -6);
				Payoff_Amount.Payoff_Amount(SSN, FileName);
				Void_Payoff_Payment.Void_Payoff_Payment(SSN, FileName);
				IETaskKiller();
			}
		}
	}

	@Test (priority=22,groups = "chenna_TN_TLP")	//complete
	public void NewLoan_Bi_Weekly_Frequency_Check_Duedate_30days() throws Exception 
	{
		String FileName= "AA_Newloan_Bi_Weekly_Frequency_Check_DueDate_30days_Txns_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:3"+"_"+PayFrequency+"_"+CollateralType,"Borrower -> Pay Frequency (ALL) -> New Loan ->Check Due Date --> Should be thirty days for All Pay Frequencies – Bi-Weekly");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				DueDate_History.DueDate_History(SSN, FileName);
				IETaskKiller();
			}
		}
	}

	@Test (priority=23,groups = "chenna_TN_TLP")//completed	
	public void TwoLoans_1VIN_1DFLT_2NotDFLT_Voluntary_Surrender_Auction_SalewithlessAmt_Waived_OtherloanWaived() throws Exception 
	{
		String FileName= "TwoLoans_1VIN_1DFLT_2NotDFLT_Voluntary_Surrender_Auction_SalewithlessAmt_Waived_OtherloanWaived_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);				
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_Scenario_No_52"+"_"+PayFrequency+"_"+CollateralType,"Originate two Loans on Same VIN–>make one loan to Default–>Other loan should not become Default–>Make Voluntary surrender for one loan–Voluntary Surrender should post for Other Loan also-->Make Auction for the Loan-->Make sale for the Loan with less amount–>Remaining amount should be waived–>Other Loan should also waived.");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName, NewVIN);
				LoanDate_Agestore_C.LoanDate_Agestore_C(SSN, FileName,5);
				NewLoanWithVIN3.NewLoanWithVIN3(SSN, FileName, NewVIN);	        
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1_C.AgeStore2_1_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				Voluntary_Surrender_After_Default.Voluntary_Surrender_After_Default(SSN, FileName);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				AgeStore_After_Repo.AgeStore_After_Repo(SSN, FileName, 22);
				Auction.Auction(SSN, FileName, 22);
				Sale_LessAmount.Sale_LessAmount(SSN, FileName, 0);
				Verify_Waived_History_1.Verify_Waived_History_1(SSN, FileName);
				IETaskKiller();
			}
		}
	}

	@Test (priority=24,groups = "chenna_TN_TLP")//completed	
	public void TwoLoans_1VIN_1DFLT_2NotDFLT_Voluntary_Surrender_Auction_Salewithmorethantwoloans_TotalDue_Waived_OtherloanWaived() throws Exception {

		// Start test. Mention test script name
		String FileName= "TwoLoans_1VIN_1DFLT_2NotDFLT_Voluntary_Surrender_Auction_Salewithmorethan_twoloans_TotalDue_RemainingRefund_thow1loan_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/PDL/"+FileName);
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

				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:54"+"_"+PayFrequency+"_"+CollateralType,"Originate two Loans on Same VIN –> make one loan to Default –> Other loan should not become Default –> Make Voluntary surrender for one loan – Voluntary Surrender should post for Other Loan also --> Make Auction for the Loan --> Make Sale for the Loan with amout just more than two loans Total Due --> Two loans shld be closed –> Remaining amount should be Refunded to Custmr through first loan.");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName, NewVIN);
				LoanDate_Agestore_C.LoanDate_Agestore_C(SSN, FileName,5);
				NewLoanWithVIN3.NewLoanWithVIN3(SSN, FileName, NewVIN);	        
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1_C.AgeStore2_1_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				Voluntary_Surrender_After_Default.Voluntary_Surrender_After_Default(SSN, FileName);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				AgeStore_After_Repo.AgeStore_After_Repo(SSN, FileName, 22);
				Auction.Auction(SSN, FileName, 0);
				Sale_MoreAmount.Sale_MoreAmount(SSN, FileName, 0);
				DefaultLoanStatus_1.DefaultLoanStatus_1(SSN, FileName);
				DefaultLoanStatus_2.DefaultLoanStatus_2(SSN, FileName);
				Check_CustomerRefund.Check_CustomerRefund(SSN, FileName);
				IETaskKiller();
			}
		}
	}

	@Test (priority=25,groups = "chenna_TN_TLP")//completed
	public void TwoLoans_1VIN_1DFLT_2NotDFLT_Voluntary_Surrender_Auction_Salewithmorethanoneloan_TotalDue_Remainingsaletootherloan_remainingamtWaived() throws Exception {

		// Start test. Mention test script name
		String FileName= "TwoLoans_1VIN_1DFLT_2NotDFLT_Voluntary_Surrender_Auction_Salewithmorethanoneloan_TotalDue_Remainingsaletootherloan_remainingamtWaived_Testdata.xls";
		//TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/PDL/"+FileName);
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:53"+"_"+PayFrequency+"_"+CollateralType,"Originate two Loans on Same VIN –> make one loan to Default –> Other loan should not become Default –> Make Voluntary surrender for one loan – Voluntary Surrender should post for Other Loan also -->Make Auction for the Loan --> Make sale for the Loan with amount just more than one loan Total Due –>Extra amount should post as sale transaction for other loan –> Remaining amount should be waived.");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName, NewVIN);
				LoanDate_Agestore_C.LoanDate_Agestore_C(SSN, FileName,5);
				NewLoanWithVIN3.NewLoanWithVIN3(SSN, FileName, NewVIN);	        
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1_C.AgeStore2_1_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				Voluntary_Surrender_After_Default.Voluntary_Surrender_After_Default(SSN, FileName);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				AgeStore_After_Repo.AgeStore_After_Repo(SSN, FileName, 22);
				Auction.Auction(SSN, FileName, 0);
				Sale_morethan_oneloan.Sale_morethan_oneloan(SSN, FileName, 0);
				Verify_Sold_Waived_History_Loan1.Verify_Sold_Waived_History_Loan1(SSN, FileName);
				Verify_Sold_Waived_History_Loan2.Verify_Sold_Waived_History_Loan2(SSN, FileName);
				IETaskKiller();
				
			}
		}
	}

    @Test (priority=26,groups = "chenna_TN_TLP")//completed	
	public void TwoLoans_singleVIN_OneDFLT_Other_ShouldNotDFLT_VoluntarySurrender() throws Exception {

		// Start test. Mention test script name
		String FileName= "TwoLoans_singleVIN_OneDFLT_Other_ShouldNotDFLT_VoluntarySurrender_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/PDL/"+FileName);
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				//test = reports.startTest("Scenario_No_51_"+Header, "New Loan");
				test = reports.startTest(Header+"_S.No:51"+"_"+PayFrequency+"_"+CollateralType,"Originate two Loans on Same VIN –> make one loan to Default –> Other loan should not become Default –> Make Voluntary surrender for one loan – Voluntary Surrender should post for Other Loan also.");				
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName, NewVIN);
				LoanDate_Agestore_C.LoanDate_Agestore_C(SSN, FileName,5);
				NewLoanWithVIN3.NewLoanWithVIN3(SSN, FileName, NewVIN);	        
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1_C.AgeStore2_1_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				Voluntary_Surrender_After_Default.Voluntary_Surrender_After_Default(SSN, FileName);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				IETaskKiller();

				//wait(100);
				// RegistrationPage.RegistrationPage(SSN);
			}
		}
		//Login.Login("CSR353","1234","353");

	}


	@Test (priority=27,groups = "chenna_TN_TLP")	//completed /// issues 
	public void TwoLoans_singleVIN_OneDFLT_Other_ShouldNotDFLT2_Voluntary_Surrender_Salvage_MorethanoneloanTotalDue_Waived() throws Exception {

		String FileName= "TwoLoans_singleVIN_OneDFLT_Other_ShouldNotDFLT2_Voluntary_Surrender_Salvage_morethanoneloanTotalDue_Waived_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/"+FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest(Header+"_S.No:56"+"_"+PayFrequency+"_"+CollateralType,"Originate two Loans on Same VIN –> make one loan to Default –> Other loan should not become Default –>Make Voluntary surrender for one loan – Voluntary Surrender should post for Other Loan also --> Make salvage for the Loan with amount just more than one loan Total Due –> Extra amount should post as sale Transaction for other loan –> Remaining amount should be waived.");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName, NewVIN);
				LoanDate_Agestore_C.LoanDate_Agestore_C(SSN, FileName,5);
				NewLoanWithVIN3.NewLoanWithVIN3(SSN, FileName, NewVIN);	        
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1_C.AgeStore2_1_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				Voluntary_Surrender_After_Default.Voluntary_Surrender_After_Default(SSN, FileName);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				AgeStore_After_Repo.AgeStore_After_Repo(SSN, FileName, 21);
				
				Salvage_Morethan_Oneloan.Salvage_Morethan_Oneloan(SSN, FileName, 0);
				Verify_Salvage_History_Loan1.Verify_Salvage_History_Loan1(SSN, FileName);
				Verify_Salvage_History_Loan2.Verify_Salvage_History_Loan2(SSN, FileName);
				IETaskKiller();
			}
		}
	}

   @Test (priority=28,groups = "chenna_TN_TLP")	
	public void TwoLoans_singleVIN_OneDFLT_Other_ShouldNotDFLT2_Voluntary_Surrender_Salvage_TwoloansTotalDue_2loansclosed_refund() throws Exception {

		// Start test. Mention test script name
		String FileName= "TwoLoans_singleVIN_OneDFLT_Other_ShouldNotDFLT2_Voluntary_Surrender_Salvage_TwoloansTotalDue_2loansclosed_refund_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/PDL/"+FileName);
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
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				//test = reports.startTest("Scenario_No_57_"+Header, "New Loan");
				test = reports.startTest(Header+"_S.No:57"+"_"+PayFrequency+"_"+CollateralType,"Originate two Loans on Same VIN –> make one loan to Default –> Other loan should not become Default –> Make Voluntary surrender for one loan – Voluntary Surrender should post for Other Loan also -->Make salvage for the Loan with amount just more than two loans Total Due --> Two loans shld be closed –> Remaining amount should be Refunded to Custmr through first loan.");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName, NewVIN);
				LoanDate_Agestore_C.LoanDate_Agestore_C(SSN, FileName,5);
				NewLoanWithVIN3.NewLoanWithVIN3(SSN, FileName, NewVIN);	        
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1_C.AgeStore2_1_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				Voluntary_Surrender_After_Default.Voluntary_Surrender_After_Default(SSN, FileName);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				AgeStore_After_Repo.AgeStore_After_Repo(SSN, FileName, 5);
				Salvage_Morethan_twoloans.Salvage_Morethan_twoloans(SSN, FileName, 0);
				DefaultLoanStatus_1.DefaultLoanStatus_1(SSN, FileName);
				DefaultLoanStatus_2.DefaultLoanStatus_2(SSN, FileName);
				CustomerRefund.CustomerRefund(SSN, FileName);
				IETaskKiller();
			}
		}
	}
	
    @Test (priority=29,groups = "chenna_TN_TLP")	
	public void TwoLoans_singleVIN_OneDFLT_Other_ShouldNotDFLT2_Voluntary_Surrender_Salvage_Waived() throws Exception {

		// Start test. Mention test script name
		String FileName= "TwoLoans_singleVIN_OneDFLT_Other_ShouldNotDFLT2_Surrender_Salvage_Waived_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				//test = reports.startTest("Scenario_No_55_"+Header, "New Loan");
				test = reports.startTest(Header+"_S.No:55"+"_"+PayFrequency+"_"+CollateralType,"Originate two Loans on Same VIN –> make one loan to Default –> Other loan should not become Default –> Make Voluntary surrender for one loan – Voluntary Surrender should post for Other Loan also --> Make salvage for the Loan with less amount –> Remaining amount should be waived –> Other Loan should also waived.");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName, NewVIN);
				LoanDate_Agestore_C.LoanDate_Agestore_C(SSN, FileName,5);
				NewLoanWithVIN3.NewLoanWithVIN3(SSN, FileName, NewVIN);	        
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1_C.AgeStore2_1_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				//EODProcessing.EODProcessing(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				Voluntary_Surrender_After_Default.Voluntary_Surrender_After_Default(SSN, FileName);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);
				AgeStore_After_Repo.AgeStore_After_Repo(SSN, FileName, 5);
				Salvage_lessamt.Salvage_lessamt(SSN, FileName, 0);
				Verify_Waived_History.Verify_Waived_History(SSN, FileName);
				IETaskKiller();
			}
		}
	}

// Venkey

	@Test (priority=30,groups = "chenna_TN_TLP")//complete
	
	public void BarrowRegistration_VerfyLoanAmountBased_BlockBookValueOrnot() throws Exception {

		//Start test. Mention test script name
		String FileName= "BarrowRegistration_VerfyLoanAmountBased_BlockBookValueOrnot_TextData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);
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

				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				// System.out.println(Password);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				//System.out.println(SSN);
				test = reports.startTest("AA_Scenario_No_04_"+Header, "Borrower_Registration_verify whether loan amount is based on BlackBook Value or not.");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan_BlackBookValue.NewLoan_BlackBookValue(SSN, FileName);
				IETaskKiller();
			}
		}
		//Login.Login("CSR353","1234","353");

	}
	
	@Test (priority=31,groups = "chenna_TN_TLP")

	public void Newloan_void() throws Exception {

		// Start test. Mention test script name
		String FileName= "BorrowerRegistration_NewLoan_Void_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("AA_Scenario_No_05_"+Header, "Loan_Void on same day");
				
				// MyCSRLoginpage login = new MyCSRLoginpage();
				
			    Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				Void.Void(SSN, FileName);
				
			}
		}
	}

	@Test (priority=32,groups = "chenna_TN_TLP")

	public void NewLoan_Rescind() throws Exception {

		// Start test. Mention test script name
		String FileName= "BorrowerRegistration_NewLoan_Rescind_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("AA_Scenario_No_07_"+Header, "Loan_Rescind on same day");
				
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				Rescind.Rescind(SSN, FileName);

			}
		}
	}

	@Test (priority=33,groups = "chenna_TN_TLP")

	public void NewLoan_EODon10DaysBeforeInstallmentDuedate_RenewalLaterShouldBePrinted() throws Exception {

		// Start test. Mention test script name
		String FileName= "NewLoan_EODon10DaysBeforeInstallmentDuedate_RenewalLaterShouldBePrinted_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("Scenario_No_15"+Header, "Loan_EOD on 10 days before Installment due date_Renewal Letter should be printed.");
				
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Renewal_Status.Renewal_Status(SSN, FileName);
			}
		}
		//Login.Login("CSR353","1234","353");

	}

	@Test (priority=34,groups = "chenna_TN_TLP")

	public void NewLoan_EODon10DaysBeforeInstallmentDuedate_RenewalLaterShouldBePrinted_OnDueDateEOD_Renewed() throws Exception {

		// Start test. Mention test script name
		String FileName= "NewLoan_EODon10DaysBeforeInstallmentDuedate_RenewalLaterShouldBePrinted_OnDueDateEOD_Renewed_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("Scenario_No_16"+Header, "Loan_EOD on 10 days before Installment due date_Renewal Letter should be printed_EOD On Due date_Loan should Renewed.");
				
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore_1stInst_ONDueDate.AgeStore_1stInst_ONDueDate(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);//this.EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Renewal_Status.Renewal_Status(SSN, FileName);
			}
		}
	}

	@Test (priority=35,groups = "chenna_TN_TLP")

	public void NewLoan_PartialPayment_GenerateRenewLater10DaysBeforeDueDate_ShouldnotgenerateTheRenewalLater() throws Exception {

		// Start test. Mention test script name
		String FileName= "NewLoan_PartialPayment_GenerateRenewLater10DaysBeforeDueDate_ShouldnotgenerateTheRenewalLater_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("Scenario_No_21"+Header, "Title Loan_partial payment and stop the renewal(before letter generate)_trying to generate Renewal Letter 10 days before due date_Should not generate the Renewal Letter");
				
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,+5);
				Payment_PartialAmount.Payment_PartialAmount(SSN, FileName);
				AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Renewal_Status1.Renewal_Status1(SSN, FileName);
			}
		}
	}

	@Test (priority=36,groups = "chenna_TN_TLP")

	public void NewLoan_PartialPayment_GenerateRenewLater10DaysBeforeDueDate_ShouldnotgenerateTheRenewalLater_PartialPayment() throws Exception {

		// Start test. Mention test script name
		String FileName= "NewLoan_PartialPayment_GenerateRenewLater10DaysBeforeDueDate_ShouldnotgenerateTheRenewalLater_PartialPayment_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("Scenario_No_23"+Header, "Title Loan_partial payment and stop the renewal(before letter generate)_trying to generate letter 10 days before due date_Should not generate the Renewal Letter_partial payment (Stp Rnwl = N)_Renewal Letter Should Print after Payment");
				
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,+5);
				Payment_PartialAmount.Payment_PartialAmount(SSN, FileName);
				AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payment_PartialAmount.Payment_PartialAmount(SSN, FileName);
				Renewal_Status1.Renewal_Status1(SSN, FileName);
			}
		}
	}



    @Test (priority=37,groups = "chenna_TN_TLP")

	public void NewLoan_PartialPayment_GenerateRenewLater10DaysBeforeDueDate_ShouldnotgenerateTheRenewalLater_1stand2ndinstallmentPayment_on2ndinstallmentdurationdate() throws Exception {

		// Start test. Mention test script name
		String FileName= "NewLoan_PartialPayment_GenerateRenewLater10DaysBeforeDueDate_ShouldnotgenerateTheRenewalLater_1stand2ndinstallmentPayment_on2ndinstallmentdurationdate_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
			
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("Scenario_No_27"+Header, "Title Loan_partial payment and stop the renewal(before letter generate)_trying to generate letter 10 days before due date_Should not generate the letter_Run EOD on 1st inst due date_Title Loan should not be renew_Make 1st installment payment on 2nd installment duration and again stop renewal_payment should be applied 1st installment only.");
				
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,+5);
				Payment_PartialAmount.Payment_PartialAmount(SSN, FileName);
				AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName,-10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName,0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);//this.EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				//AgeStore_.AgeStore_2ndInst_DueDate(SSN, FileName,0);
				Payment_1stInterestAmt_on2ndinstduration.Payment_1stInterestAmt_on2ndinstduration(SSN, FileName);
				Loan_1stinstallment_status.Loan_1stinstallment_status(SSN, FileName);
			}
		}
	}

    @Test (priority=38,groups = "chenna_TN_TLP")
	public void Loan_GenerateLetter_EOD1stInstDate_EOD2ndInstDate_Default_DefaultPmt_LoanShouldbeClosed() throws Exception {

		String FileName= "Loan_GenerateLetter_EOD1stInstDate_EOD2ndInstDate_Default_DefaultPmt_LoanShouldbeClosed_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("AA_Scenario_No_34"+Header, "Title Loan_Generate letter 10 days before due date_Run EOD on Due date of 1st Installment_Run EOD on 2nd Installment date and customer status changed to default_age the store_Perform the Default payment full_Loan should be closed.");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, -10); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);//this.EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_2_C.AgeStore1_2_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);//this.EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				AgeStore1_2_C.AgeStore1_2_C(SSN, FileName, 1);
				DefaultPayment.DefaultPayment(SSN, FileName);
				Loan_Status.Loan_Status(SSN, FileName);
			}
		}
	}

  @Test (priority=39,groups = "chenna_TN_TLP")
	public void TwoLoans_singleVIN_OneDFLT_Other_ShouldNotDFLT2_Surrender_Salvage_Waive1() throws Exception {

		String FileName= "TwoLoans_singleVIN_OneDFLT_Other_ShouldNotDFLT2_Surrender_Salvage_Waive_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("AA_Scenario_No_49_"+Header, "Originate two Loans on Same VIN_make one loan to Default_Other loan should not become Default_Make Repossession for one loan_Repossession should post for Other Loan also_Make salvage for the Loan with less amount_Remaining amount should be waived_Other Loan should also waived");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoanWithVIN.NewLoanWithVIN(SSN, FileName,NewVIN);
				LoanDate_Agestore_C.LoanDate_Agestore_C(SSN, FileName,5);
				NewLoanWithVIN3.NewLoanWithVIN3(SSN, FileName,NewVIN);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0); 
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore2_1_C.AgeStore2_1_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);//this.EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName); 
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);	
				OutToRepo.OutToRepo(SSN, FileName, 1);				
				Repossession.Repossession(SSN, FileName, 1);
				DefaultPaymentStatus1_C.DefaultPaymentStatus1_C(SSN, FileName);	
				LESS_Salvage.LESS_Salvage(SSN, FileName, 21);
				WAVE_Stastus1.WAVE_Stastus1(SSN, FileName);
				WAVE_Stastus2.WAVE_Stastus2(SSN, FileName);
			}
		}
	}

 @Test (priority=40,groups = "chenna_TN_TLP")

	public void Newloan_Default_Writeoff_WriteOffRecovery_LoanShouldClosed() throws Exception {
		//Start test. Mention test script name
		String FileName= "Newloan_Default_Writeoff_WriteOffRecovery_LoanShouldClosed_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				
				test = reports.startTest("Scenario_No_59"+Header, "Title Loan_Default_Write Off_Write Off Recovery payment_Loan should close.");
				
				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				AgeStore_Default_WriteOff60Days.AgeStore_Default_WriteOff60Days(SSN, FileName, +60);
				WO_Recovery.WO_Recovery(SSN, FileName);
				Loan_Status.Loan_Status(SSN, FileName);
			}
		}
	}

  @Test (priority=41,groups = "chenna_TN_TLP")

	public void Newloan_Default_Writeoff_WriteOffRecovery_void_LoanOpened() throws Exception {

		// Start test. Mention test script name
		String FileName= "Newloan_Default_Writeoff_WriteOffRecovery_void_LoanOpened_TestData.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
		
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("Scenario_No_60"+Header, " Title Loan_Default_Write Off_Write Off Recovery payment_Loan should close_Void WOR_Loan should Open.");
				
				Login.Login(UserName,Password,StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				AgeStore1_1_C.AgeStore1_1_C(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, 0);
				AgeStore_Default_WriteOff60Days.AgeStore_Default_WriteOff60Days(SSN, FileName, +60);
				WO_Recovery.WO_Recovery(SSN, FileName);
				Loan_Status.Loan_Status(SSN, FileName);
				WO_Void.WO_Void(SSN, FileName);
				Loan_Status.Loan_Status(SSN, FileName);
			}
		}
	}

	//Anji
	@Test (priority=42,groups = "chenna_TN_TLP")

	public void Newloan_1stinstTo3rdinstPayment_check4thinstpayment() throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_Newloan_1stinstTo3rdinstPayment_check4thinstpayment_Txn_Testdata.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("Scenario_No_17"+Header, "Title Loan --> generate letter 10 days before due date --> customer made 1st installment payment--> Run EOD on due date -- > Loan should Renewed.--> same way pay upto 3rd installment--> Run EOD on 3rd inst due date ---> Renew the Loan --> at the time of 4th installment renewal, Principle reduction should be apply(5% of Title Loan amount).");
				

				
				Login.Login(UserName, Password, StoreId);
				
				RegistrationPage_NewLoan_TLP.RegistrationPage_NewLoan_TLP(driver, test, AppURL, SSN, FileName);
				NewLoan.NewLoan(SSN, FileName); 
				AgeStore_1stInst.AgeStore_1stInst(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payment.Payment(SSN, FileName);
				AgeStore_1stInst.AgeStore_1stInst(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName); 
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);			
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName); 
				AgeStore_2ndInst.AgeStore_2ndInst(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);//this.EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName); 
				Payment.Payment(SSN, FileName);
				AgeStore_2ndInst.AgeStore_2ndInst(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName); 
				AgeStore_3rdInst.AgeStore_3rdInst(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);//this.EODProcessing(SSN, FileName);   
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName); 
				Payment.Payment(SSN, FileName);
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

	@Test (priority=43,groups = "chenna_TN_TLP")

	public void AA_NewLoan_PartialPayment_StopRenew_EODDuedate () throws Exception {

		String FileName= "AA_NewLoan_PartialPayment_StopRenew_EODDuedate_Txn.xls";

		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);

		int lastrow=TestData.getLastRow("NewLoan");

		String sheetName="NewLoan";

		for(int row=2;row<=lastrow;row++)

		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))

			{

				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");

				UserName = prop.getProperty("UserName_TN_TLP_chenna");

				Password = prop.getProperty("Password_TN_TLP_chenna");

				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");

				String ProductID = TestData.getCellData(sheetName,"ProductID",row);

				String StateID = TestData.getCellData(sheetName,"StateID",row);

				String SSN = TestData.getCellData(sheetName,"SSN",row);

				String Header = StateID+ "_" + ProductID;
				String PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);

				String CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

				test = reports.startTest("Scenario_No_25 "+Header, "Title Loan --> partial payment and stop the renewal(before letter generate) --> trying to generate letter 10 days before due date --> should not generate the letter--> Run EOD on 1st inst due date --> Title Loan should not be renewed");

				

				
				Login.Login(UserName, Password, StoreId);
				Biweek_due_RegistrationPage.Biweek_due_RegistrationPage(SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName, +5);
				PartialPayment.PartialPayment(SSN, FileName);
				AgeStore_1stInst_DueDate10DaysBefore.AgeStore_1stInst_DueDate10DaysBefore(SSN, FileName, -10);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);		

			}

		}



	}

	@Test (priority=44,groups = "chenna_TN_TLP")

	public void AA_NewLoan_PPayment_StpY_2inst_FeePriciple_PPayment () throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_NewLoan_PPayment_StpY_2inst_FeePriciple_PPayment_Txn.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	

				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;	        
				test = reports.startTest("Scenario_No_28"+Header, "Title Loan –> Partial Payment ( Stp Rnwl = Y)--> Auto Renewal not posted – 2nd Installment bucket : Payment with first Installment amount(stop Renewal = Y) –> should effect to principal & 1st Inst Fee amt –> prtl pmnt(Stp Rnwl = N) –> Missed Renewal letter & record should post with latest values.");
				
				Login.Login(UserName,Password,StoreId);
				Biweek_due_RegistrationPage.Biweek_due_RegistrationPage(SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,+5);
				Payment_PartialAmount.Payment_PartialAmount(SSN, FileName);
				AgeStore_1stInst_DueDate.AgeStore_1stInst_DueDate(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payment.Payment(SSN, FileName);
				Payment_PartialAmount_NO.Payment_PartialAmount_NO(SSN, FileName);
				Loan_Status_Inst.Loan_Status_Inst(SSN, FileName);
			}
		}
	}

	@Test (priority=45,groups = "chenna_TN_TLP")

	public void AA_NewLoan_PPayment_StpY_2ndInstDuration_Payment_StpN () throws Exception {

		// Start test. Mention test script name
		String FileName= "AA_NewLoan_PPayment_StpY_2ndInstDuration_Payment_StpN_Txn.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);   
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";
		
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);

			if(RunFlag.equals("Y"))
			{	

				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;	        
				test = reports.startTest("Scenario_No_29"+Header, "Title Loan ---> Partial Payment(Stop Renewal = Y) --> 2 Bckt : After renewal Letter Date make Payment with first installment amt(Stp Rnwl = N) --> Two Renewal Letters for 1 & 2 post with Payment date.");
				
				Login.Login(UserName,Password,StoreId);
				Biweek_due_RegistrationPage.Biweek_due_RegistrationPage(SSN, FileName);
				NewLoan.NewLoan(SSN, FileName);
				LoanDate_AgeStore.LoanDate_AgeStore(SSN, FileName,+5);
				Payment_PartialAmount.Payment_PartialAmount(SSN, FileName);
				AgeStore_1stInst_DueDate.AgeStore_1stInst_DueDate(SSN, FileName, 0);
				DrawerDeassign.DrawerDeassign(SSN, FileName);
				StatementGeneration_EODProcessing.StatementGeneration_EODProcessing(SSN, FileName);
				StoreInfo.StoreInfo(SSN, FileName);
				Safeassign.Safeassign(SSN, FileName);
				Drawerassign.Drawerassign(SSN, FileName);
				Payment_No.Payment_No(SSN, FileName);
			}
		}
	}

	@Test (priority=46,groups = "chenna_TN_TLP")

	public void AA_OneCustomer_OneVIN_TwoLoans_Writoff() throws Exception {

		String FileName= "AA_OneCustomer_OneVIN_TwoLoans_Writoff_Txn.xls";
		TestData = new Excel(System.getProperty("user.dir") + prop.getProperty("AA_Store_Test_data_TN_TLP_path_chenna") + FileName);  
		int lastrow=TestData.getLastRow("NewLoan");
		String sheetName="NewLoan";   
		System.out.println(lastrow);
		for(int row=2;row<=lastrow;row++)
		{
			String RunFlag = TestData.getCellData(sheetName,"Run",row);
			if(RunFlag.equals("Y"))
			{	
				AppURL = prop.getProperty("AppURL_TN_TLP_chenna");
				UserName = prop.getProperty("UserName_TN_TLP_chenna");
				Password = prop.getProperty("Password_TN_TLP_chenna");
				String NewVIN= TestData.getCellData(sheetName,"NewVIN",row);
				String NewVIN2= TestData.getCellData(sheetName,"NewVIN2",row);
				StoreId = prop.getProperty("StoreID_TN_TLP_chenna");
				String ProductID = TestData.getCellData(sheetName,"ProductID",row);
				String StateID = TestData.getCellData(sheetName,"StateID",row);
				String SSN = TestData.getCellData(sheetName,"SSN",row);	
				String Header = StateID+ "_" + ProductID;
				test = reports.startTest("Scenario_No_42"+Header, "Originate two Loans on Same VIN –> make one loan to Write Off – Other loan should also become Write Off");
				
				
				Login.Login(UserName, Password, StoreId);
				
				Biweek_due_RegistrationPage.Biweek_due_RegistrationPage(SSN, FileName);
				NewLoanWithVIN1.NewLoanWithVIN1(SSN, FileName,NewVIN);
				NewLoanWithVIN2.NewLoanWithVIN2(SSN, FileName,NewVIN);
				AgeStore1_1BatchProcess_C.AgeStore1_1BatchProcess_C(SSN, FileName, +90);				
				AgeStore_Default_WriteOff60Days.AgeStore_Default_WriteOff60Days(SSN, FileName, +60);
				Loan_Status_Loan1.Loan_Status_Loan1(SSN, FileName);
				Loan_Status_Loan2.Loan_Status_Loan2(SSN, FileName);

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

		try {
			BufferedReader reader;
			reader = new BufferedReader(

					new FileReader("C:/AA_Batch/AA_TLP/src/test/java/pack/Config.properties"));

			prop = new Properties();
			prop.load(reader);
			reader.close();

		}

		catch (Exception e) {

			System.out.println("Object proprties file not found");
		}

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

