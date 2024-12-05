package assignment;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ViewEmployeeList {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
		
	    driver.findElement(By.name("txtUserName")).sendKeys("Gsiri554");
	    driver.findElement(By.name("txtPassword")).sendKeys("Gsiri@884554");
	    driver.findElement(By.name("Submit")).click();
	    
	    //verify whether the welcome page is successfully opened or not
	    String text = driver.findElement(By.xpath("//*[@id=\"option-menu\"]/li[1]")).getText();
	    
	    if(text.equals("Welcome Gsiri554"))
	    {
	    	System.out.println("Welcome page is successfully opened");
	    }
	    else
	    {
	    	System.out.println("Welcome page is not opened");
	    }
	    
	    Actions act = new Actions(driver);
	    
	    //1.Navigate to the "PIM" module.
	    act.moveToElement(driver.findElement(By.xpath("//*[@id=\"pim\"]/a/span"))).perform();
	    Thread.sleep(2000);
	    
	    //2.Click on "Employee List".
	    driver.findElement(By.xpath("//*[@id=\"pim\"]/a/span")).click();
	    
	    Thread.sleep(1000);
	    
	    //Switch to the frame
	    driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	    
	    //Identify the list 
	    //To identify the rows
	    int total_rows = driver.findElements(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr/td")).size();
	    System.out.println(total_rows);
	    
	    //To identify the columns
	    int total_columns= driver.findElements(By.xpath("//*[@id=\"standardView\"]/table/thead/tr[1]/td")).size();
	    System.out.println(total_columns);
	    
	    //find the size of the data
	    int size = total_rows*total_columns;
	    System.out.println(size);
	    
	    //Create ArrayList
	    //ArrayList<String> al = new ArrayList<String>();
	   
	    
	    for(int i=1;i<=total_rows;i++)
	    {
	    	for(int j=1;j<=total_columns;j++)
	    	{
	    		String data = driver.findElement(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr[" +i+ "]/td[" +j+ "]")).getText();
				  System.out.print(data+   "  ");  //storing webpage rows and columns into the arraylist reference variable wvalues				  
	    	}	
	    	System.out.println();
	    }
	    //System.out.println(al);
	    driver.close();
	}

}
