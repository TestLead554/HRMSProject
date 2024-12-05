package seleniumjavatests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleOptionsFromListbox {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://apps.fas.usda.gov/esrquery/esrq.aspx");
		
		//Identify Listbox
		WebElement droplist = driver.findElement(By.id("ctl00_MainContent_lbCommodity"));
		Select s = new Select(droplist);
		s.selectByIndex(1);
		s.selectByVisibleText("Wheat - SRW");
		s.selectByVisibleText("Wheat - White");
		s.selectByValue("201");
		s.selectByIndex(6);
		
		//Verify whether multiple options selected or not
		if(s.isMultiple())		
		{
			System.out.println("Multiple options are selected from the list");
		}
		else
		{
			System.out.println("Multiple options are not selected");
		}
				
		
		//Identify Listbox
		WebElement droplist1 = driver.findElement(By.id("ctl00_MainContent_lbCountry"));
		
		//Select multiple options from Listbox
		Select s1 = new Select(droplist1);
		System.out.println("Size of the droplist = " +droplist1.getSize());
		s1.selectByIndex(3);
		s1.selectByVisibleText("AMERICAN SAMOA");
		s1.selectByVisibleText("ANGOLA");
		
			//verify multiple selections are allowed
		if(s1.isMultiple())
		{
			System.out.println("Multiple selections allowed");
		}
		else
		{
			System.out.println("Multiple selections not allowed");
		}
		
		
		

	}

}
