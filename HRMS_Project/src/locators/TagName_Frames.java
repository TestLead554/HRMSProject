package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TagName_Frames {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Sirisha/KOSMIK_Selenium/Videos/frames.html");
		
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("Total no of frames = " +totalFrames.size());
		
		
		
		
		
	}

}
