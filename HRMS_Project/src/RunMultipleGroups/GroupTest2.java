package RunMultipleGroups;

import org.testng.annotations.Test;

public class GroupTest2 {
	
	  @Test(groups = "Smoke", priority =0)
	  public void composeMail()
	  {
		  System.out.println("Compose mail done successfully");
	  }
	  
	  @Test(groups = "Sanity",priority =2)
	  public void checkDrafts()
	  {
		  System.out.println("checking drafts done successfully");
	  }
	  
	  @Test(groups = "Sanity", priority =3)
	  public void sentMail()
	  {
		  System.out.println("Mail sent successfully");
	  }
	  
	  @Test(groups = "Smoke",priority =1)
	  public void deleteMail()
	  {
		  System.out.println("Delete mail done successfully");
	  }
}
