package seleniumjavatests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentOnHMS {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.kosmiktechnologies.com/seleniumLiveProject/kosmik-hms/");
		
		driver.findElement(By.name("username")).sendKeys("kosmik");
		driver.findElement(By.name("password")).sendKeys("kosmik");
		driver.findElement(By.name("submit")).click();
		
		//verfiy whether welcome page is successfully opened or not
		String text = driver.findElement(By.xpath("//h3[contains(text(),'Welcome, kosmik')]")).getText();
		
		
		System.out.println("Welcome text = "  +text);
		
		if(text.equals("Welcome, kosmik Logout"))
		{
			System.out.println("welcome page is successfully opened");
		}
		else
		{
			System.out.println("Welcome page is not opened");
		}
		
		driver.findElement(By.xpath("//*[@id=\"navigation\"]/li[1]/a")).click();
		
		//Identify "Patient Identifier" dropdown 
		WebElement dropdown = driver.findElement(By.name("PAT_IDENTITY"));
		
		//Identify "Patient Identifier " dropdown list
		List<WebElement> droplist = dropdown.findElements(By.tagName("option"));
		
		//find the size of dropdown list
		System.out.println("Size of the dropdown = " +droplist.size());
			 
		//Display all the list in the Patinet Identifier 
		System.out.println("Patinet Identifier dropdown list");
		System.out.println("----------------------------------");
		for(int i =0;i<droplist.size();i++)
		{
			System.out.println(droplist.get(i).getText());
		}
		
		//Select the dropdown list
		Select s = new Select(dropdown);
		
		s.selectByIndex(0);
		s.selectByIndex(1);
		s.selectByIndex(2);
		s.selectByIndex(3);
		s.selectByIndex(4);
		s.selectByVisibleText("PAN Card");
		
		//verify whether particular dropdown is selected or not
		
		String selected_text = s.getFirstSelectedOption().getText();
		System.out.println("Selected text = "  +selected_text);
		
		if(selected_text.equals("PAN Card"))
		{
			System.out.println("Selected value is verified successfully");
		}
		else
		{
			System.out.println("Selected value is not verified");
		}
		
		driver.close();
		
		
		

		
		
		
		
		
	}
	}


