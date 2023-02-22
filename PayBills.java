package ExcelR.ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class PayBills {
  @Test
  public void PayBill() throws InterruptedException {
	
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
	  
	  WebElement BPay = driver.findElement(By.xpath("//a[contains(text(),'Bill Pay')]"));
	  BPay.click();
	  
	  Thread.sleep(1000);
	  
	  
	  String title3 = driver.getTitle();
	  String ActTitle3 = "ParaBank | Bill Pay";
	  if(title3.equals(ActTitle3)) {
		  System.out.println("Bill Payment Page verified");
	  }
	  else {
		  System.out.println("Bill Payment Page NOT verified");
	  }
	  
	  WebElement PayeName = driver.findElement(By.xpath("//input[@name='payee.name']"));
	  PayeName.sendKeys("Ram Kadam");

	  WebElement PayeAdrs = driver.findElement(By.xpath("//input[@name='payee.address.street']"));
	  PayeAdrs.sendKeys("Hadapsar,Pune");

	  WebElement PayeCty = driver.findElement(By.xpath("//input[@name='payee.address.city']"));
	  PayeCty.sendKeys("Pune");

	  WebElement PayeState = driver.findElement(By.xpath("//input[@name='payee.address.state']"));
	  PayeState.sendKeys("MH");

	  WebElement PayeZip = driver.findElement(By.xpath("//input[@name='payee.address.zipCode']"));
	  PayeZip.sendKeys("410047");

	  WebElement PayePhn = driver.findElement(By.xpath("//input[@name='payee.phoneNumber']"));
	  PayePhn.sendKeys("1024262");
	  
	  WebElement PayeAcNo = driver.findElement(By.xpath("//input[@name='payee.accountNumber']"));
	  PayeAcNo.sendKeys("42223");

	  WebElement PayeAcNoCNF = driver.findElement(By.xpath("//input[@name='verifyAccount']"));
	  PayeAcNoCNF.sendKeys("42223");
	  
	  WebElement PayAmt = driver.findElement(By.xpath("//input[@name='amount']"));
	  PayAmt.sendKeys("100");
	  
	  Select ACCNo = new Select(driver.findElement(By.xpath("//select[@name='fromAccountId']")));
	  ACCNo.selectByVisibleText("13788");
	  
	  driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
	  
	  Thread.sleep(1000);
	  
	  Boolean Display = driver.findElement(By.xpath("//h1[contains(text(),'Bill Payment Complete')]")).isDisplayed();

	  System.out.println("Bill Payment Completed page :"+Display);
	 	  
		
  }
}
