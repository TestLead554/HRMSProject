package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DeleteEmployee {

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
	    
	    Actions act = new Actions(driver);
	    
	    //1.Navigate to the "PIM" module.
	    act.moveToElement(driver.findElement(By.xpath("//*[@id=\"pim\"]/a/span"))).perform();
	    
	    Thread.sleep(2000);
	    //click on the Employee list
	    driver.findElement(By.xpath("/html/body/div[4]/ul/li[2]/ul/li[1]/a/span")).click();
	    
	    //switch to frame
	    driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	    
	    //select the employee you want to delete
	    driver.findElement(By.xpath("//input[@value='0059']")).click();
	    //checkbox.click();
	    
	    
	}

}
