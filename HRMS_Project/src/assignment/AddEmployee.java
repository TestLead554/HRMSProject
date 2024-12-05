package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AddEmployee {

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
	    
	    //2.Click on "Add Employee".
	    driver.findElement(By.xpath("//*[@id=\"pim\"]/ul/li[2]/a/span")).click();
	    
	    Thread.sleep(1000);
	    
	    //Switch to Add employee frame
	    driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	    
	    //verify Add Employee welcome text
	    String addEmpText = driver.findElement(By.xpath("//*[@id=\"frmEmp\"]/div/div[1]/div[2]/div[1]/h2")).getText();
	   
	    
	    if(addEmpText.equals("PIM : Add Employee"))
	    {
	    	System.out.println("Add Employee text is verified successfully");
	    }
	    else
	    {
	    	System.out.println("Add Employee text is not verified");
	    }
	    
	    //3.Enter required employee details (e.g., first name, last name, employee ID).
	    
	    driver.findElement(By.id("txtEmployeeId")).clear();
	    
	    driver.findElement(By.id("txtEmployeeId")).sendKeys("11");
	    driver.findElement(By.id("txtEmpLastName")).sendKeys("Santhi");
	    driver.findElement(By.name("txtEmpFirstName")).sendKeys("K");
	    
	    //Click "Save".
	    driver.findElement(By.id("btnEdit")).click();
	    
	    //driver.switchTo().defaultContent();
	    Thread.sleep(5000);
	    
	    
	    //Click on back buton
	    driver.findElement(By.className("backbutton")).click();
	    Thread.sleep(8000);
	    driver.switchTo().defaultContent();
	    
	    //Navigate to the "PIM" module.
	    act.moveToElement(driver.findElement(By.id("pim"))).perform();
	    	    
	    Thread.sleep(5000);
	    //Click on "Employee list"
	    driver.findElement(By.xpath("//*[@id=\"pim\"]/a/span")).click();
	    
	    Thread.sleep(1000);
	    
	   //Verify New Employee is displayed in the Employee list or not
	    String empName = driver.findElement(By.xpath("//a[text()='K  Santhi']")).getText();
	    System.out.println(empName);
	    if(empName.equals("K  Santhi"))
	    {
	    	System.out.println("Emp id is added successfully");
	    }
	    else {
	    	System.out.println("Emp Id is not added");
	    }
	    	
	    
	    
	    
	    
	    
		
		
		
		
		
		
		
		
		
		
	}

}
