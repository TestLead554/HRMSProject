package handleAlertsandPopups;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleMultipleWindows {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://kosmiktechnologies.com/seleniumLiveProject/kosmik-hms/");
		driver.findElement(By.name("username")).sendKeys("kosmik");
		driver.findElement(By.name("password")).sendKeys("kosmik");
		driver.findElement(By.name("submit")).click();
		
		//Identify the welcome text
		String text = driver.findElement(By.xpath("//h3[contains(text(),'Welcome, kosmik' )]")).getText();
		System.out.println("Welcome text = "  +text);
		
		if(text.equals("Welcome, kosmik Logout"))
		{
			System.out.println("welcome page is successfully opened");
		}
		else
		{
			System.out.println("Welcome page is not opened");
		}
		
		//click on feefback link
		driver.findElement(By.className("selected")).click();
		
		
		//count total no of windows
		Set<String> totalWindows = driver.getWindowHandles();
		
	    System.out.println("Total windows = " +totalWindows.size());
	    
	    //store all the windows in arraylist 
	    ArrayList<String> allWindows = new ArrayList<String>(totalWindows);
		 
	     //switch to child window
	     driver.switchTo().window(allWindows.get(1));
		  
	     //Do some action
	     System.out.println("Title of the child window = " +driver.getTitle());
	     
	     //close the child window
	     driver.close();
	     
	     //again switch to main window
	     driver.switchTo().window(allWindows.get(0));
	     
	     //do some action
	     System.out.println("Title of the Main window = " +driver.getTitle());
	     
	     //close the main window
	     driver.close();
		
		
		}

}
