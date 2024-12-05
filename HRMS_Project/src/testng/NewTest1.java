package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest1 {
	WebDriver driver;
	
  @Test
  public void verifyTitleOfWebpage() {
	  driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	  String title = driver.getTitle();
	  System.out.println(title);
	  driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("Gsiri554");
	  driver.findElement(By.xpath("//input[ @name='txtPassword']")).sendKeys("Gsiri@884554");
	  driver.findElement(By.xpath("//input[ @name='Submit']")).click();
	  
	  Assert.assertEquals(title, "OrangeHRM - New Level of HR Management");
	  
  }
  
  @BeforeClass
  public void launchBrowser() {
	  driver = new FirefoxDriver();
	  
  }

  @AfterClass
  public void closeBrowser() {
	  driver.close();
  }

}
