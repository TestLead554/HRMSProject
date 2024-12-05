package radiobuttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickandVerifySingleRadioButton {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.guru99.com//test/radio.html");
		
		//Identify Radio button
		WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
		radio1.click();
		
		WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
		radio2.click();
		
		WebElement radio3 = driver.findElement(By.id("vfb-7-3"));
		radio3.click();
		
		
		//verify wheter radio button1 is clicked or not
		if(radio1.isSelected())
		
		{
			System.out.println("radio button1 is selected");
		}
		else
		{
			System.out.println("radio button1 is not selected");
		}
		
		//verify wheter radio button2 is clicked or not
		if(radio2.isSelected())
		{
			System.out.println("radio button2 is selected");
		}
		else
		{
			System.out.println("radio button2 is not selected");
		}
		
		//verify wheter radio button3 is clicked or not
		if(radio3.isSelected())
			
		{
			System.out.println("radio butto3 is selected");
		}
		else
		{
			System.out.println("radio button3 is not selected");
		}
	}

}
