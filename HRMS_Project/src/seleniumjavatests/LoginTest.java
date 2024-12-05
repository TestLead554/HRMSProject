package seleniumjavatests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
		String title = driver.getTitle();
		System.out.println("Title of the page = " +title);
		String url = driver.getCurrentUrl();
		System.out.println("Current url = " +url);
		
		if(title.equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Title is verified successfully");
		}
		else
		{
			System.out.println("Title is not vertified successfully");
		}	
		//identify User name and enter the User name	
	    driver.findElement(By.name("txtUserName")).sendKeys("Gsiri554");
	    
	    //identify pwd and enter the pwd
	    driver.findElement(By.name("txtPassword")).sendKeys("Gsiri@884554");
	    
	    //click on the login button
	    driver.findElement(By.name("Submit")).click();
	    
	    //Verify "Welcome Gsiri554" text on Orange HRM
	    String text = driver.findElement(By.xpath("/html/body/div[3]/ul/li[1]")).getText();
	    System.out.println(text);
	    
	    //verify Welcome Gsiri554
	    if(text.equals("Welcome Gsiri554"))
	    {
	    	System.out.println("Welcome page is verified successfully");
	    }
	    else 
	    {
	    	System.out.println("Welcom page is not verified successfully");
	    }
	    
	    
	    driver.findElement(By.xpath("/html/body/div[3]/ul/li[3]/a")).click();
	    driver.close();
	    
	}

}
