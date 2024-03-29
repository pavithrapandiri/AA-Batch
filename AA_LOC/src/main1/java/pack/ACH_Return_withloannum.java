package pack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ACH_Return_withloannum extends AA_LOC {
	public static void ACH_Return_withloannum(String SSN,String FileName) throws Exception
	{

	//Excel TestData = new Excel("E:/QC_Workspace/AA_Automation/TestData/LOC/"+FileName);	
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
			////String StoreId = TestData.getCellData(sheetName,"StoreId",row);
			//String AdminURL=TestData.getCellData(sheetName,"AdminURL",row);
			//String age_store = TestData.getCellData(sheetName, "AgeStore",row);
			//int Age_store = Integer.parseInt(age_store);
			//System.out.println(Age_store);
			//System.out.println("age_store:::"+age_store);
			//int Days= Integer.parseInt(age_store);
		////////////////////	
			/*String Loannmb1=null;
			String LoanNmb2=null;*/
			System.out.println(AdminURL);
			//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
			
			Login.Login(UserName, Password, StoreId);
			String SSN1 = SSN.substring(0, 3);
			String SSN2 = SSN.substring(3,5);
			String SSN3 = SSN.substring(5,9);
			Thread.sleep(5000);
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


			if(ProductID.equals("LOC"))
			{


				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();

				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
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
			if(ProductID.equals("LOC"))
			{
				driver.findElement(By.name("button")).click(); 
			}

			for( String winHandle1 : driver.getWindowHandles())
			{
				driver.switchTo().window(winHandle1);
			}			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			String DueDate=null;

			for(String winHandle : driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
		//	DueDate = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[11]/td[3]/span[2]")).getText();
			//test.log(LogStatus.PASS, "Capture Cure End Dtae"+DueDate);
			//                                            //*[@id="revolvingCreditHistTable"]/tbody/tr[3]/td[1]/span[2]
			String  Loannmb1 =driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[3]/td[1]/span[2]")).getText();
			//String  Loannmb1 =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[9]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")).getText();
	          
			test.log(LogStatus.PASS, "Capture Cure End Dtae"+Loannmb1);//       /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[2]
			driver.close();
			
			
			
			///////////////////
			
		

			driver = new InternetExplorerDriver();
			driver.get(AdminURL);
			// storeupdate(UserName,Password,StoreId,DueDate,AdminURL);


			DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");		
			driver.findElement(By.name("loginRequestBean.userId")).sendKeys("admin");
			test.log(LogStatus.PASS, "Username is entered: admin");			        
			driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);
			test.log(LogStatus.PASS, "Password is entered: "+Password);					  	        			   
			//Click Login Button
			driver.findElement(By.name("login")).click();
			test.log(LogStatus.PASS, "Clicked on Submit button");
			Thread.sleep(8000);
			
		
			driver.switchTo().defaultContent();
			driver.switchTo().frame("topFrame");
			driver.findElement(By.xpath("//*[contains(text(),'Transactions')]")).click();	
			test.log(LogStatus.PASS, "Clicked on Transactions");
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
			driver.findElement(By.linkText("ACH")).click();
			test.log(LogStatus.PASS, "Clicked on ACH");
			Thread.sleep(5000);
			driver.findElement(By.linkText("LOC")).click();
			test.log(LogStatus.PASS, "Clicked on LOC");
			
			driver.findElement(By.linkText("ACH Return")).click();
			test.log(LogStatus.PASS, "Clicked on ACH Return");
			
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
			driver.findElement(By.linkText("QA Jobs")).click();
			test.log(LogStatus.PASS, "Clicked on QA Jobs");
			Thread.sleep(5000);
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");

			driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreId);
				test.log(LogStatus.PASS, "StoreId is entered: "+StoreId);					  	        			   
				//Click Login Button
				driver.findElement(By.name("submit")).click();
				test.log(LogStatus.PASS, "Clicked on Submit button");

				for( String winHandle1 : driver.getWindowHandles())
				{
				    driver.switchTo().window(winHandle1);
				}			
				 driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");

				 ////////////////////
				 List<WebElement> options = driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/td/table[2]/tbody/tr"));
				 int RTNRecs = options.size();

				 for(int i=3; i<=RTNRecs; i++)
				 {   

					 
					 String LoanNmb2 =driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table[2]/tbody/tr["+i+"]/td[4]")).getText();

					 if(Loannmb1.contains(LoanNmb2.trim()))
					 {
						System.out.println(LoanNmb2); 
					 driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table[2]/tbody/tr["+i+"]/td[1]/input[2]")).click();
						test.log(LogStatus.PASS, "Customer Record CheckBox Selected");
					 // /html/body/table/tbody/tr[1]/td/table[2]/tbody/tr[3]/td[10]/select
					 driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table[2]/tbody/tr["+i+"]/td[10]/select")).sendKeys("R01-Insufficient Funds");
					 test.log(LogStatus.PASS, "Return Reason Selected as ::  R01-Insufficient Funds");
					 }
				 }
				 Thread.sleep(2000);

				 /////////////////
				 //  /html/body/table/tbody/tr[1]/td/table[2]/tbody/tr/
				 /*	driver.findElement(By.name("requestBean.chkName")).click();
						test.log(LogStatus.PASS, "Customer Record CheckBox Selected");					  	        			   
						//Click Login Button
						driver.findElement(By.name("rtnReasonId")).sendKeys("R01-Insufficient Funds");
						test.log(LogStatus.PASS, "Return Reason Selected as ::  R01-Insufficient Funds");*/
				 driver.findElement(By.name("CmdReturnPosting")).click();
				 test.log(LogStatus.PASS, "Clicked on RCC Return Posting button");
				 for( String winHandle1 : driver.getWindowHandles())
				 {
					 driver.switchTo().window(winHandle1);
				 }			
				 driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");

				 if(driver.findElement(By.name("Ok")).isDisplayed())
				 {
					 driver.findElement(By.name("Ok")).click();
					 test.log(LogStatus.PASS, "ACH Return Posting Done Successfull");	
				 }


		}
	}
	}

	 				}
