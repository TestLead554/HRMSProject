package keyboardevents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AboutInGoogle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/");
		
		//identify about in google.com
		WebElement about = driver.findElement(By.className("MV3Tnb"));
		
		//create actions class object
		Actions act = new Actions(driver);
		act.contextClick(about).perform();
		
		//Here if we want to click on "open link in new Tab" then we are already in right click option, 
		//its not possible to do again right click , here we need to use "Action class" and
		//we need to click on open link in new tab means only one action so we should use "sendKeys method"
		
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).click().perform(); //click on open link in new window
		Thread.sleep(2000);
		//driver.close();
	}

}
