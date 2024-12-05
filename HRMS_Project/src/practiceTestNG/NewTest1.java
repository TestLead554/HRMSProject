package practiceTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class NewTest1 {
	 WebDriver driver;
	
  @Test
  public void getUrl() 
  {
	  String url = driver.getCurrentUrl();
	  System.out.println("Url of the current website = " +url);
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
