package ExcelR.ParaBank;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Register {
  @Test
  public void Registation() {
	 
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
	  
	  
	  WebElement Register = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
	  Register.click();
	  
	  String title2 = driver.getTitle();
	  String ActTitle2 = "ParaBank | Register for Free Online Account Access";
	  if(title2.equals(ActTitle2)) {
		  System.out.println("Registration page verified");
	  }
	  else {
		  System.out.println("Page not verified");
	  }
		  
	  
	  
	  WebElement Firstname = driver.findElement(By.id("customer.firstName"));
	  Firstname.sendKeys("Kishor");
	  WebElement LastName = driver.findElement(By.id("customer.lastName"));
	  LastName.sendKeys("Deshmukh");
	  WebElement Address = driver.findElement(By.id("customer.address.street"));
	  Address.sendKeys("Kondhawa,Pune");
	  WebElement City = driver.findElement(By.id("customer.address.city"));
	  City.sendKeys("Pune");
	  WebElement State = driver.findElement(By.id("customer.address.state"));
	  State.sendKeys("MH");
	  WebElement ZipCode = driver.findElement(By.id("customer.address.zipCode"));
	  ZipCode.sendKeys("410048");
	  WebElement Phone = driver.findElement(By.id("customer.phoneNumber"));
	  Phone.sendKeys("124262");
	  WebElement SSN = driver.findElement(By.id("customer.ssn"));
	  SSN.sendKeys("100");
	 
	  WebElement Usrname = driver.findElement(By.id("customer.username"));
	  Usrname.sendKeys("kishor");
	  WebElement Pswd = driver.findElement(By.id("customer.password"));
	  Pswd.sendKeys("password");
	  WebElement CPswd = driver.findElement(By.id("repeatedPassword"));
	  CPswd.sendKeys("password");
	  
	  WebElement RegisterBtn = driver.findElement(By.xpath("//input[@value='Register']"));
	  RegisterBtn.click();
	  
	  String Title3 = driver.getTitle();
	  String ActTitle3 = "ParaBank | Customer Created";
	  if(Title3.equals(ActTitle3)) {
		  System.out.println("Registred Successfully");
	  }
	  else {
		  System.out.println("Oops! Try Again!");
	  }
	  
	  
  }
}
