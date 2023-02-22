package ExcelR.ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Loan {
  @Test
  public void LoanRequest() throws InterruptedException {
	
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
	
	 
	 WebElement ReqLoan = driver.findElement(By.xpath("//a[contains(text(),'Request Loan')]"));
	  ReqLoan.click();
	  
	  Thread.sleep(1000);
	 
	 Boolean loanpage = driver.findElement(By.xpath("//h1[contains(text(),' Apply for a Loan')]")).isDisplayed();
	 System.out.println("Loan Application Page verified : "+loanpage);
	 
	 WebElement Amount = driver.findElement(By.id("amount"));
	  Amount.sendKeys("800"); 
	 
	  WebElement DwnPay = driver.findElement(By.id("downPayment"));
	  DwnPay.sendKeys("100"); 
	  
	  Select Account = new Select(driver.findElement(By.id("fromAccountId")));
	  Account.selectByVisibleText("13677");
	  
	  WebElement AplyLoan = driver.findElement(By.xpath("//input[@type='submit']"));
	  AplyLoan.click();
	  
	  Thread.sleep(1000);
	  
	  Boolean Loanpassed = driver.findElement(By.xpath("//p[contains(text(),'Congratulations, your loan has been approved.')]")).isDisplayed();
		 System.out.println("Loan Applied Successfully : "+Loanpassed);
		 
		 
		 
	  
	  
	 
	 
  }
}
