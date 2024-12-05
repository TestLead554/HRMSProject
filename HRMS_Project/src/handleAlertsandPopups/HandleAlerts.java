package handleAlertsandPopups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.findElement(By.name("uid")).sendKeys("mngr595517");
		driver.findElement(By.name("password")).sendKeys("EsagEse");
		driver.findElement(By.name("btnLogin")).click();
		
		//Identify Welcome text
		String text = driver.findElement(By.xpath("/html/body/div[2]/h2")).getText();
		System.out.println(text);
		
		//Verify whether welcome page is successfully opened or not
		if(text.equals("Guru99 Bank"))
		{
			System.out.println("Welcome page is successfully opened");
		}
		else
		{
			System.out.println("Welcome page is not opened");
		}
		
		//click on logout button
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
		
		Thread.sleep(1000);
		
		//switch to alert 
		Alert alt = driver.switchTo().alert();
		
		//get the text from alert popup
		String alt_text = alt.getText();
		System.out.println(alt_text);
		
		//Verify alert text
		if(alt_text.equals("You Have Succesfully Logged Out!!"))
		{
			System.out.println("Alert text is verified successfully");
		}
		else
		{
			System.out.println("Alert text is not verified");
		}
		//click on ok
		alt.accept();
				
		//alt.dismiss();  //click on cancel
		//alt.sendKeys("sirisha"); //enter the text into the textbox in alert
	}
	

}
