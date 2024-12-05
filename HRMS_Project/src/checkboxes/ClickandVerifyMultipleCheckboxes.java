package checkboxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickandVerifyMultipleCheckboxes {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.guru99.com//test/radio.html");
		
		//Identify all the checkboxes in webpage
		List<WebElement> totalcheckboxes = driver.findElements(By.xpath("(//input[@type='checkbox'])"));
		
		//count the total no of checkboxes
		System.out.println("Total checkboxes = " +totalcheckboxes.size());
		/*int c = totalcheckboxes.size();
		System.out.println("Total checkboxes = "+c);*/
		
		// click and verify all the checkboxes
		for(int i =0; i<totalcheckboxes.size();i++)
		{
			//click the checkbox
			totalcheckboxes.get(i).click();
			
			//verify the checkbox is clicked or not
			if(totalcheckboxes.get(i).isSelected())
			{
				System.out.println("Checkbox" +i+"is selected successfully");
			}
			else
			{
				System.out.println("Checkbox" +i+"is not selected");
			}
		}
		driver.close();   
	    
	} 

}
