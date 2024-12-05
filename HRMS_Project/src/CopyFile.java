import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyFile {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
 
		driver.findElement(By.name("txtUserName")).sendKeys("Gsiri554");
	    driver.findElement(By.name("txtPassword")).sendKeys("Gsiri@884554");
	    driver.findElement(By.name("Submit")).click();
	    
	    String text = driver.findElement(By.xpath("//*[@id=\"option-menu\"]/li[1]")).getText();
	    
	    if(text.equals("Welcome Gsiri554"))
	    {
	    	System.out.println("Welcome text is verified successfully");
	    }
	    else
	    {
	    	System.out.println("Welcome text is not verified");
	    }
	    
	    //create Actions class object act
	    Actions act = new Actions(driver);
	    
	    //Mouse over or move the cursor on PIM and perform or execute
	    act.moveToElement(driver.findElement(By.xpath("//*[@id=\"pim\"]/a/span"))).perform();
	    
	    //Click on Add Employee sub menu
	    driver.findElement(By.xpath("//*[@id=\"pim\"]/ul/li[2]/a/span")).click();
	    
	    Thread.sleep(1000);
	    
	    //Switch to Add Employee frame
	    driver.switchTo().frame("rightMenu");
	    
	    //identify and Verify the Add Employee text and store into the addEmp variable
	    String addEmp = driver.findElement(By.xpath("//*[@id=\"frmEmp\"]/div/div[1]/div[2]/div[1]/h2")).getText();
	    System.out.println("Welcome text of Add Employee = " +addEmp);
	    
	    if(addEmp.equals("PIM : Add Employee"))
	    {
	    	System.out.println("Add Employee welcome text is verified successfully");
	    }
	    else
	    {
	    	System.out.println("Add Employee welcome text is not verified ");
	    }
	    
	    //Give the Last Name
	    driver.findElement(By.id("txtEmpLastName")).sendKeys("Kavya");
	    
	    //Give the First Name
	    driver.findElement(By.name("txtEmpFirstName")).sendKeys("HRS");
	    
	    Thread.sleep(1000);
	    //upload the file using sendkeys method
	    driver.findElement(By.id("photofile")).sendKeys("C:\\Sirisha\\Sample.HEIC");
	    Thread.sleep(2000);
	    
	    //Exit from frame
	    driver.switchTo().defaultContent();
	    
	    //logout
	    driver.findElement(By.xpath("//*[@id=\"option-menu\"]/li[3]/a")).click();
	    
	    driver.close();
	    
	    
	    
	    
	    
	}

}
