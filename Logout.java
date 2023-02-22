package ExcelR.ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Logout {
  @Test
  public void LogOut() throws InterruptedException {
	
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
	 
	 Thread.sleep(1000);

 
	 WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
	  logout.click();
	  
	  String Title3 = driver.getTitle();
	  String ActTitle3 = "ParaBank | Welcome | Online Banking";
	  if(Title3.equals(ActTitle3)) {
		  System.out.println("User Logged Out Sucessfully");
	  }
	  else {
		  System.out.println("LogOut Failed");
	  }
	 
	  
  }
}
