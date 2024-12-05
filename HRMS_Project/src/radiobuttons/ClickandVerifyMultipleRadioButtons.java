package radiobuttons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickandVerifyMultipleRadioButtons {
	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.guru99.com//test/radio.html");
		
		//Identify all the Radio buttons
		List<WebElement> allradiobuttons = driver.findElements(By.xpath("(//input[@type='radio'])"));
		
		
		//count the size of the radio butttons
		int countofradiobuttons = allradiobuttons.size();
		System.out.println("Count of the Radio buttons = " +countofradiobuttons);
		
		
		//Click and verify the radio buttons
		for(int i=0;i<countofradiobuttons;i++)
		{
			//click the radio buttons
			allradiobuttons.get(i).click();
			
			//verify whether particular radio button is successfully clicked or not
			if(allradiobuttons.get(i).isSelected())
			{
				System.out.println("Radio Button" +i+ " is selected successfully");
			}
			else
			{
				System.out.println("Radio Button1" +i+ " is not selected");
			}
		}
		
		driver.close();
	}

}
