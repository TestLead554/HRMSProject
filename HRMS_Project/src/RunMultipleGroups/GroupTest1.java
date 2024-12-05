package RunMultipleGroups;

import org.testng.annotations.Test;

public class GroupTest1 {
	
	@Test(groups = "Smoke", priority=2)
  public void login()
  {
	  System.out.println("login done successfully");
  }
  
  @Test(groups = "Smoke", priority=0)
  public void userName()
  {
	  System.out.println("username given successfully");
  }
  
  @Test(groups = "Sanity", dependsOnMethods={"login"}, priority=3)
  
  public void searchMail()
  {
	  System.out.println("Searching mail successfully");
  }
  
  @Test(groups = "Smoke", priority=1)
  public void password()
  {
	  System.out.println("Password given successfully");
  }
  
	 @Test(groups = "Sanity", priority =4)
  public void checkMail()
  {
	  System.out.println("check mail done successfully");
  }
}
