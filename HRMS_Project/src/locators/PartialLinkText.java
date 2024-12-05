package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PartialLinkText {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.ebay.com/");
		
		driver.findElement(By.partialLinkText(" Rights Owner")).click();

	}

}
