package seleniumjavatests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentOnHRM {

	public static void main(String[] args) {
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
	    
	    //Switch to frame
	    driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	    
	    //Identify the dropdown
	    WebElement dropdown = driver.findElement(By.id("loc_code"));
	    
	    //Identify dropdownlist
	    List<WebElement> droplist = driver.findElements(By.tagName("option"));
	    
	    //Find the size of the drooplist
	    int size = droplist.size();
	    System.out.println("Count of the droplist = " +size);
	    
	    //print the elements in dropdown list
	    System.out.println("Webelements in dropdownlist");
	    System.out.println("-----------------------------");
	    for(int i=0; i<size; i++)
	    {
	    	System.out.println(droplist.get(i).getText());
	    }
	    System.out.println("-------------------------------");
	   //creating select object for selecting the dropdown value from dropdown list
	    Select s = new Select(dropdown);
	    s.selectByIndex(3);
	    s.selectByIndex(4);
	    s.selectByIndex(5);
	    s.selectByVisibleText("Sub-Division");
	    s.selectByValue("1");
	    
	    //verify whether particular dropdown value is selected or not
	    
	    String selected_text = s.getFirstSelectedOption().getText();     
	    if(selected_text.equals("Emp. First Name"))
	    {
	    	System.out.println("Dropdown value is selected successfully");
	    }
	    else
	    {
	    	System.out.println("Dropdown value is not selected");
	    }
	    
	    //exit from the frame
	    driver.switchTo().defaultContent();
	    
	    driver.close();
	}
	

}
