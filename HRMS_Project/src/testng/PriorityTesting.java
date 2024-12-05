package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class PriorityTesting {
	
  @Test(priority=0)
  public void login() 
  {
	  System.out.println("login is successfully done");
  }
  
  @Test(priority=1)
  public void checkMail() 
  {
	  System.out.println("check mail is successfully done");
  }
  
  @Test(priority=2)
  public void searchMail() 
  {
	  System.out.println("search mail  is successfully done");
  }
  
  //For skipping the Testcase in Testcase level
  /* @Test(priority=2, enabled = false)
  public void searchMail() 
  {
	  System.out.println("search mail  is successfully done");
  }*/ 
  
  @Test(priority=3)
  public void logout() 
  {
	  System.out.println("logout is successfully done");
  }
    
  
  @BeforeClass
  public void launchBrowser() {
  }

  @AfterClass
  public void closeBrowser() {
  }

}
