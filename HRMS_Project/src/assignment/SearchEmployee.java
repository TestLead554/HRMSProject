package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SearchEmployee {

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
	    
	    //Click on "Employee List".
	    driver.findElement(By.xpath("//*[@id=\"pim\"]/a/span")).click();
	    
	    Thread.sleep(1000);

	    //2.Enter the employee name or ID in the search field.
	    //Switching to Frame
	  	driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	  		
	  	//Identify dropdown
	  	WebElement dropdown = driver.findElement(By.name("loc_code"));
	    
	  	//Dropdown list
	  	List<WebElement> droplist = driver.findElements(By.tagName("option"));
	  	
	  	Select s = new Select(dropdown);
	  	s.selectByVisibleText("Emp. ID");
	  	
	  	//Give the emp id value in seacrh bar
	  	driver.findElement(By.id("loc_name")).sendKeys("2");
	  
	  	//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"standardView\"]/div[2]/input[2]")));
	  	
	  	driver.findElement(By.className("plainbtn")).click();
	    //act.moveToElement(driver.findElement(By.className("plainbtn"))).perform();
	  	
	  	driver.switchTo().defaultContent();
	}
}