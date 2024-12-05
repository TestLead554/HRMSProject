package keyboardevents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ControlAandDelete {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		
		Actions act = new Actions(driver);
		
		//search WebDriver in google search box
		driver.findElement(By.name("q")).sendKeys("WebDriver");
		
		Thread.sleep(2000);
		
		//Select webdriver text and DELETE(perform ctrl+a and DELETE)
		act.keyDown(Keys.CONTROL).sendKeys("a").keyDown(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);  //control +a
		
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);  //control +c
		
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);  //control +v
		  
		act.keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT);   //shift+a
		
		
		Thread.sleep(2000);
		
		driver.close();
		
		
		
		

	}

}
