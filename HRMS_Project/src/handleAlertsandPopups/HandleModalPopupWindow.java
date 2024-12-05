package handleAlertsandPopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleModalPopupWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://mdbootstrap.com/docs/standard/components/modal/#docsTabsOverview");
		
		Thread.sleep(1000);
		
		//Get the current popup window
		driver.switchTo().window(driver.getWindowHandle());
		
		//click on "Accept Cookies"
		driver.findElement(By.id("accept_cookies_btn")).click();
		
		Thread.sleep(1000);
		
		//Identify login button
		driver.findElement(By.xpath("//*[@id=\"gtmDC-login-button\"]/a[2]")).click();
		
		//switch to window 
		driver.switchTo().window(driver.getWindowHandle());
		Thread.sleep(1000);
		
		//do some action
		driver.findElement(By.xpath("//*[@id=\"navbarLogin\"]/div/div/div[2]/button")).click();
		
		
		
		
		
		
	}

}
