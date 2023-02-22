package ExcelR.ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

 class Invalidlogin {
  @Test
  public void InvalidLogin() { 

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
  Usrnme.sendKeys("hello");

  WebElement Passwrd = driver.findElement(By.xpath("//input[@name='password']"));
  Passwrd.sendKeys("password");

  WebElement LoginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
  LoginBtn.click();
  
  Boolean Display = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]")).isDisplayed();

  System.out.println("Error message displayed :"+Display);
  

  }
}
