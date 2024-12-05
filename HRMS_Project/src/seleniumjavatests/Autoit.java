package seleniumjavatests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Autoit {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
		driver.findElement(By.name("txtUserName")).sendKeys("Gsiri554");
		driver.findElement(By.name("txtPassword")).sendKeys("Gsiri@884554");
		driver.findElement(By.name("Submit")).click();
		
		//verfiy welcome page is successfully opened or not
		String text = driver.findElement(By.xpath("//*[@id=\"option-menu\"]/li[1]")).getText();
		System.out.println(text);
		
		if(text.equals("Welcome Gsiri554"))
		{
			System.out.println("Welcome page is verified successfully");
		}
		else
		{
			System.out.println("Welcome page is not opened");
		}
		
		//Create action class object for that driver
		Actions act = new Actions(driver);
		
		//Mouse over on PIM main module
		act.moveToElement(driver.findElement(By.id("pim"))).perform();
		
		//Click on Add Employee sub menu
		driver.findElement(By.xpath("//*[@id=\"pim\"]/ul/li[2]/a/span")).click();
		
		//switch to frame
		driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
		
		//Identify the addEmployee text and store into addEmployee variable
		String addEmp = driver.findElement(By.tagName("span")).getText();
		
		//Print the Add Employee text
		System.out.println(addEmp);
		
		//Verify the Add Employee page is successfully opened or not
		if(addEmp.equals("PIM : Add Employee"))
		{
			System.out.println("Add Employee page is successfuly opened");
		}
		else
		{
			System.out.println("Add Employee page is not opened");
		}
		
	}

}
