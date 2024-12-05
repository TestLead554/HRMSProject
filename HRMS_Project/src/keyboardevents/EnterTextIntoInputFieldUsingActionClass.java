package keyboardevents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class EnterTextIntoInputFieldUsingActionClass {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		
		//identify search box in google.com
		WebElement searchbox = driver.findElement(By.name("q"));
		
		Actions act = new Actions(driver);
		
		//sending text into searchbox area using acion object
		act.sendKeys(searchbox, "HTML").sendKeys(Keys.ENTER).perform();
		
		
	}

}
