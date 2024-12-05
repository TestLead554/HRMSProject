import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scrolling {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
		
		//scrolling from top to bottom
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,5000)");
		
		
		
		//scrolling from bottom to top
		//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-2000)");	
		
		//scrolling into particular element
		((JavascriptExecutor)driver).executeScript("arguments[0],scrollIntoView();",driver.findElement(By.xpath("//a[contains(text(),'Sell on Amazon')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Sell on Amazon')]")).click();
		
		//driver.close();
		

	}

}
