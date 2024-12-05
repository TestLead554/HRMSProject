package keyboardevents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SingleAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN); //Press arrow down
		act.sendKeys(Keys.ARROW_UP);   //Press arrow up
		act.sendKeys(Keys.ENTER);    //Click
		act.sendKeys(Keys.DELETE);  //for delete
		act.sendKeys(Keys.F12); 
		
		// search HTML in google search box
		driver.findElement(By.name("q")).sendKeys("HTML");
		
		Thread.sleep(2000);
		
		//select HTML Text(perform ctrl+a
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		driver.close();
		
		
		
		
		
		
		
		//Enter HTML in google searchbox
		

	}

}
