package pack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class RPP_Status extends AA_LOC {
	public static void RPP_Status(String SSN,String FileName) throws Exception{

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
				System.out.println(AdminURL);
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				System.out.println(ESign_CollateralType);
				test.log(LogStatus.INFO, "RPP(Starts)");

				System.out.println(ProductID);	
				//String AppURL = TestData.getCellData(sheetName,"AppURL",row);
				
				Login.Login(UserName, Password, StoreId);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);
				Thread.sleep(5000);

				Thread.sleep(5000);
				Thread.sleep(1000);
				driver.switchTo().frame("topFrame");
				driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				test.log(LogStatus.INFO,"Navigated To Loan Transaction Screen");

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='911101']")).click();			
				test.log(LogStatus.PASS, "Clicked on Transactions");		
				driver.switchTo().frame("main");	
				test.log(LogStatus.INFO,"Navigate to Transactions Screen");

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
				test.log(LogStatus.INFO,"Navigate to Customer Record Screen");

				//driver.findElement(By.name("button")).click();
				driver.findElement(By.xpath("//input[(@name='button') and (@value='Go')]")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}				    
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				test.log(LogStatus.INFO,"Navigate to Line Of Credit History Screen");



				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
				driver.findElement(By.xpath("//input[(@name='button') and (@value='Go')]")).click();
				//  driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on GO Button");
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				test.log(LogStatus.INFO,"Navigate to Transaction List Screen");

				driver.findElement(By.name("transactionList")).sendKeys("History");
				test.log(LogStatus.INFO,"Navigate to History Credit Table Screen");

				driver.findElement(By.name("button")).click();
				test.log(LogStatus.INFO,"Transaction Selection Go Button Click");

				//button
				String CheckStatus=null;
				CheckStatus = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[14]/td[1]/span[2]")).getText();
				if(CheckStatus.equals("Y")){
					test.log(LogStatus.PASS,"Loan in RPP : "+CheckStatus);
					test.log(LogStatus.INFO,"RPP Transaction Done Successfully");
					System.out.print(CheckStatus);	
					//driver.close();
				}
				String CheckStatus1=null;
				CheckStatus1 = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[13]/td[1]/span[2]")).getText();
				if(CheckStatus1.equals("Y")){
					test.log(LogStatus.INFO,"Payment Status After RPP Is $ Loan In RCC $ : "+CheckStatus1);
					System.out.print(CheckStatus1);	

				}

				String CheckStatus2=null;
				CheckStatus2 = driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr[2]/td[2]/span[2]")).getText();
				if(CheckStatus2.equals("Y")){
					test.log(LogStatus.INFO,"  Status After RPP Is $ ACH/RCC Revoke Flag $: "+CheckStatus2);
					System.out.print(CheckStatus2);	

				}

			}	

		}
		//driver.close();

	}



	 				}
