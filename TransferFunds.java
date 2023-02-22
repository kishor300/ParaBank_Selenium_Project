package ExcelR.ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TransferFunds {
  @Test
  public void TransferFunds() throws InterruptedException {
	  
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
	  
	  WebElement TFLink = driver.findElement(By.xpath("//a[contains(text(),'Transfer Funds')]"));
	  TFLink.click();
	  
	  Thread.sleep(3000);
	  
	  String title3 = driver.getTitle();
	  String ActTitle3 = "ParaBank | Transfer Funds";
	  if(title3.equals(ActTitle3)) {
		  System.out.println("Transfer Funds Page Verified");
	  }
	  else {
		  System.out.println("Transfer Funds Page not Verified");
	  }
	  
	  WebElement Amount = driver.findElement(By.id("amount"));
	  Amount.sendKeys("80");
	  
	  Select FrmAcc = new Select(driver.findElement(By.xpath("//select[@id='fromAccountId']")));
	  FrmAcc.selectByValue("14007");
	  
	  driver.findElement(By.xpath("//select[@id='toAccountId']")).click();
	  
	  Select ToAcc = new Select(driver.findElement(By.xpath("//select[@id='toAccountId']")));
	  ToAcc.selectByValue("14007");
	  
	  driver.findElement(By.xpath("//input[@value='Transfer']")).click();
	  
	boolean text = driver.findElement(By.xpath("//h1[contains(text(),'Transfer Complete!')]")).isDisplayed();
    System.out.println("Transfer Complete : "+text);
    
  }
}



