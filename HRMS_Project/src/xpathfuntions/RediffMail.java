package xpathfuntions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RediffMail {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[starts-with(@name,'name')]")).sendKeys("Sirisha");		
		driver.findElement(By.xpath("//input[starts-with(@name, 'login') ]")).sendKeys("siri1234@gmail.com");
		driver.findElement(By.xpath("//input[ starts-with(@name,'btnchkavail')]")).click();
		driver.findElement(By.xpath("//input[ starts-with(@name, 'passwd')]")).sendKeys("siri@1234");
		driver.findElement(By.xpath("//input[starts-with(@name, 'confirm_passwd')]")).sendKeys("siri@1234");
		driver.findElement(By.xpath("//input[starts-with(@name, 'altemail') ] ")).sendKeys("siri4321@gmail.com");
		
				
	    //driver.findElement(By.xpath("//input[ starts-with(@name, 'chk_altemail' )]")).click();
	    
	    
	   /* WebElement dropdown_mobile = driver.findElement(By.xpath("//div[contains(@id, 'country_id' )]"));
	    
	    List<WebElement>  mobile_list = driver.findElements(By.tagName("input"));
	    System.out.println("size of the mobile droplist = " +mobile_list.size());
	    
	    Select s = new Select(dropdown_mobile);
	    s.selectByIndex(2);
	    driver.findElement(By.xpath("//input[contains(@id, 'mobno')]")).sendKeys("123456789");
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    
	   /* WebElement dropdown1 = driver.findElement(By.xpath("//span[ starts-with(@id, 'lbl_txt')]"));
	    
	    List<WebElement> droplist =  driver.findElements(By.tagName("span"));
	    System.out.println("Size of the dropdown = " +droplist.size());
	    
	    Select s = new Select(dropdown);
	    s.selectByIndex(1);
	    
	    driver.findElement(By.xpath("//input[contains(@name, 'mobnod') ]")).sendKeys("123456789");*/
	    
	    driver.close();
	    
	    
	    
	    
	    
	}

}