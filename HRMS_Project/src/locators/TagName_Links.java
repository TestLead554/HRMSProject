package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TagName_Links {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Sirisha/KOSMIK_Selenium/Videos/Links.html");
		
		List<WebElement> totalLinks = driver.findElements(By.tagName("a")); //identify all the links in the webpage
		System.out.println("No of links in the webpage = " +totalLinks.size());
		

	}

}
