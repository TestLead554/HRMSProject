package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDoubleClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Sirisha/KOSMIK_Selenium/Videos/doubleClickMe.html");
		
		//Identify copy Text button element
		WebElement copyText = driver.findElement(By.xpath("/html/body/button"));
		
		Actions act = new Actions(driver);
		
		act.doubleClick(copyText).perform();
		
		Thread.sleep(2000);
		
		//verify the text is copied successfully or not
		String text = driver.findElement(By.id("field2")).getAttribute("value");
		System.out.println(text);
		
		if(text.equals("Hello World!"))
		{
			System.out.println("Entered text is verified sucessfully");
		}
		else
		{
			System.out.println("Entered text is not verified");
		}
		
		//close the current browser
		driver.close();
	}

}
