package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
		
		driver.findElement(By.name("txtUserName")).sendKeys("Gsiri554");
	    driver.findElement(By.name("txtPassword")).sendKeys("Gsiri@884554");
	    driver.findElement(By.name("Submit")).click();
	    
	    //verify whether the welcome page is successfully opened or not
	    String text = driver.findElement(By.xpath("//*[@id=\"option-menu\"]/li[1]")).getText();
	    
	    if(text.equals("Welcome Gsiri554"))
	    {
	    	System.out.println("Welcome page is successfully opened");
	    }
	    else
	    {
	    	System.out.println("Welcome page is not opened");
	    }
	    
	    //create actions class object act
	    Actions act = new Actions(driver);
	    
	    //Move the mouse cursor on PIM 
	    act.moveToElement(driver.findElement(By.xpath("//*[@id=\"pim\"]/a/span"))).perform();
	    
	    //click Add Employee
	    driver.findElement(By.xpath("//*[@id=\"pim\"]/ul/li[2]/a/span")).click();
	    
	    Thread.sleep(1000);
	    
	    //Switch to Add Employee frame
	    driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	    Thread.sleep(1000);
	    
	    //verify Add Employee welcome text
	    String addEmpText = driver.findElement(By.xpath("//*[@id=\"frmEmp\"]/div/div[1]/div[2]/div[1]/h2")).getText();
	    
	    System.out.println(addEmpText);
	    
	    if(addEmpText.equals("PIM : Add Employee"))
	    {
	    	System.out.println("Add Employee text is verified successfully");
	    }
	    else
	    {
	    	System.out.println("Add Employee text is not verified");
	    }
	    
	    //Back to main window
	    driver.switchTo().defaultContent();
	    
	    //logout
	    driver.findElement(By.xpath("//*[@id=\"option-menu\"]/li[3]/a")).click();
	    Thread.sleep(1000);
	    
	    driver.close();
	    
	    

	}

}
