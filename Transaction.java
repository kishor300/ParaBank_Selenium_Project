package ExcelR.ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Transaction {
  @Test
  public void FindTransactions() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  
	  
	  driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	  
	  	  
	  String Title = driver.getTitle();
	  String ActTitle = "ParaBank | Welcome | Online Banking";
	  if(Title.equals(ActTitle)) {
		  System.out.println("Home Page verified");
	  }
	  else {
		  System.out.println("Page not verified");
	  }
	  
	    
	  WebElement Usrnme = driver.findElement(By.xpath("//input[@name='username']"));
	  Usrnme.sendKeys("kishor");
	  WebElement Passwrd = driver.findElement(By.xpath("//input[@name='password']"));
	  Passwrd.sendKeys("password");
	  WebElement LoginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
	  LoginBtn.click();

	  	  
	  String title2 = driver.getTitle();
	  String ActTitle2 = "ParaBank | Accounts Overview";
	  if(title2.equals(ActTitle2)) {
		  System.out.println("Login Successfull");
	  }
	  else {
		  System.out.println("Login Failed");
	  }
	  
  
	  WebElement FindTr = driver.findElement(By.xpath("//a[contains(text(),'Find Transactions')]"));
	  FindTr.click();
	  
	  Thread.sleep(1000);
	  	  
	  Boolean FindTrPage = driver.findElement(By.xpath("//h1[contains(text(),'Find Transactions')]")).isDisplayed();
	  System.out.println("Find Transaction Page Verified :"+FindTrPage);
	  
	  	  
	  Select Accountno = new Select(driver.findElement(By.id("accountId")));
	  Accountno.selectByVisibleText("13788");
	  
  
	   WebElement id = driver.findElement(By.id("criteria.transactionId"));
	  id.sendKeys("14922");
	  WebElement findTraBtn1 = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
	  findTraBtn1.click();
	  
	  
	  WebElement date = driver.findElement(By.xpath("//input[@id='criteria.onDate']"));
	  date.sendKeys("02-21-2023");
	  WebElement findTraBtn2 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
	  findTraBtn2.click();
	  
	  WebElement DateRange1 = driver.findElement(By.id("criteria.fromDate"));
      	  DateRange1.sendKeys("02-15-2023");
     	  WebElement DateRange2 = driver.findElement(By.id("criteria.toDate"));
     	  DateRange2.sendKeys("02-21-2023");
	  WebElement findTraBtn3 = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
	  findTraBtn3.click(); 
	  

	   WebElement Amount = driver.findElement(By.id("criteria.amount"));
	   Amount.sendKeys("200");
	   WebElement findTraBtn4 = driver.findElement(By.xpath("(//button[@type='submit'])[4]"));
	   findTraBtn4.click();
		
	  Thread.sleep(1000);
	  
	  Boolean TrnFound = driver.findElement(By.xpath("//h1[contains(text(),'Transaction Results')]")).isDisplayed();
	  System.out.println("Transaction Results :"+TrnFound);
	  
	 	
  }
}
