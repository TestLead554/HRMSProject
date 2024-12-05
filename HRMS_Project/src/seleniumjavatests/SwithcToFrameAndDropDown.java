package seleniumjavatests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SwithcToFrameAndDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
		driver.findElement(By.name("txtUserName")).sendKeys("Gsiri554");
		driver.findElement(By.name("txtPassword")).sendKeys("Gsiri@884554");
		driver.findElement(By.name("Submit")).click();
		
		String text = driver.findElement(By.xpath("//*[@id=\"option-menu\"]/li[1]")).getText();
		System.out.println(text);
		
		if(text.equals("Welcome Gsiri554"))
		{
			System.out.println("Welcome text is verified successfully");
		}
		else
		{
			System.out.println("Welcome text is not verified");
		}
		//Switching to Frame
		driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
		
		//Identify dropdown
		WebElement dropdown = driver.findElement(By.name("loc_code"));
		
		//Dropdown list
		List<WebElement> droplist = driver.findElements(By.tagName("option"));
		
		//find the size of the dropdown
		System.out.println("Dropdown list size = " +droplist.size());
		
		for(int i=0;i<droplist.size();i++)
		{
			System.out.println(droplist.get(i).getText());
		}
		Select s = new Select(dropdown);
		s.selectByIndex(1);
		Thread.sleep(2000);
		s.selectByVisibleText("Emp. Middle Name");
		Thread.sleep(5000);
		s.selectByValue("8");
		
		//verify the selected value in dropdown list
		String selected_value = s.getFirstSelectedOption().getText();
		
		if(selected_value.equals("Supervisor"))
		{
			System.out.println("Selected value is verified successfully");
		}
		else
		{
			System.out.println("Selected value is not verified");
		}
		//For switching back from frame
		driver.switchTo().defaultContent(); //exit from frame
		
		
		//driver.close();
		

	}

}
