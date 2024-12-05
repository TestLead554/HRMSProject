package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseRightOrContextClick {
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.co.in/");
		
		//Identify "about" element
		WebElement about = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[1]"));
		
		Actions act = new Actions(driver);
		
		//Right click on about 
		act.contextClick(about).perform();
		
		
		//write in singel line code
		//new Actions(driver).contextClick(driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[1]")));
		
		driver.close();
		
		
		
		}

}
