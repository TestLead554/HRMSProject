package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		
		//Create Action class
		Actions act = new Actions(driver);
		
		//Identify drag element
		WebElement drag = driver.findElement(By.id("draggable"));
		
		//Identify drop element
		WebElement drop = driver.findElement(By.id("droppable"));
		
		act.dragAndDrop(drag,drop).perform();
		
		//Verify whether drag and drop is performed successfully
		String drop_text = driver.findElement((By.xpath("//*[@id=\"droppable\"]/p"))).getText();
		System.out.println(drop_text);
		
		//verify drag and drop operation 
		if(drop_text.equals("Dropped!"))
		{
			System.out.println("Drag and Drop operation is verified successfully");
		}
		else
		{
			System.out.println("Drag and Drop operation is not verified");
		}
				
		driver.close();
		

	}

}
