package checkboxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickandVerifySingleCheckbox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.guru99.com//test/radio.html");
		
		//Identify checkbox
		WebElement checkbox1 = driver.findElement(By.id("vfb-6-0"));
		checkbox1.click();
		Thread.sleep(1000);
		WebElement checkbox2 = driver.findElement(By.id("vfb-6-1"));
		checkbox2.click();
		Thread.sleep(1000);
		WebElement checkbox3 = driver.findElement(By.id("vfb-6-2"));
		checkbox3.click();
		
		
		//Verify whether checkboxe1 is selected or not
		
		if(checkbox1.isSelected())
		{
			System.out.println("Checkbox1 is selected successfully");
		}
		else
		{
			System.out.println("Checkbox1 is not selected");
		}
		
		//Verify whether checkbox2 is selected or not
		if(checkbox2.isSelected())
		{
			System.out.println("Checkbox2 is selected successfully");
		}
		else
		{
			System.out.println("Checkbox2 is not selected");
		}
		//Verify whether checkbox3 is selected or not
		if(checkbox3.isSelected())
		{
			System.out.println("Checkbox3 is selected successfully");
		}
		else
		{
			System.out.println("Checkbox3 is not selected");
		}
	}
	

}
