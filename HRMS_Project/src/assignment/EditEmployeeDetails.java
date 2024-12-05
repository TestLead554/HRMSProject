package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EditEmployeeDetails {

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
	    
	    //2.Search for the employee to be edited.
	    //Click on "Employee list"
	    driver.findElement(By.xpath("//*[@id=\"pim\"]/a/span")).click();
	    
	    Thread.sleep(1000);
	    
	    //Switch to Employee Information frame
	    driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	    
	    //3.Click on the employee’s name to view details.
	    driver.findElement(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr[1]/td[3]/a")).click();
	    Thread.sleep(1000);
	   //Switch to Personal details frame
	
	    //4.Click the "Edit" button.
	    driver.findElement(By.id("btnEditPers")).click();
	    
	    Thread.sleep(1000);
	    
	    //5.Modify employee details 
	    WebElement radio1 = driver.findElement(By.id("gender2"));
	    radio1.click();
	     
	    driver.findElement(By.id("txtEmpLastName")).clear();
	    driver.findElement(By.id("txtEmpLastName")).sendKeys("gsirisha");
	    
	    WebElement dropdown = driver.findElement(By.id("cmbMarital"));
	    
	    List<WebElement> droplist = driver.findElements(By.tagName("option"));
	    
	    Select s = new Select(dropdown);
	    s.selectByIndex(2);
	    	    
	    //CLick on the save button
	    driver.findElement(By.id("btnEditPers")).click();
	    
	    driver.switchTo().defaultContent();
	    
	    //unable to edit the job details
	    driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"jobLink\"]/span")));
	    
	    driver.findElement(By.id("jobLink")).click();
	    driver.findElement(By.xpath("//*[@id=\"job\"]/div[1]/div[2]/div[1]/h2")).click();
	    
	    driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	    driver.findElement(By.id("backbutton")).click();
	    
	    //after click on the save button, I was not able to write for view the updated employee details
	    
	    
	    

	}

}
