package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class VerifyDropdownwithExcelInTizag {
	WebDriver driver;
	
  @Test
  public void VerifyDropDownValues() throws IOException 
  {
	  //Identify Dropdown
	  WebElement dropdown = driver.findElement(By.name("selectionField"));
	  
	  //Identify Dropdown list of elements
	  List<WebElement> droplist = dropdown.findElements(By.tagName("option"));
	  
	  //Find the size of dropdown list
	  int droplist_size = droplist.size();
	  System.out.println("Count of dropdown values = " +droplist_size);
	  
	  //Display the dropdown values
	  for(int i=0;i<droplist_size;i++)
	  {
		  System.out.println(droplist.get(i).getText());
	  }
	  
	  //create arraylist for dropdown 
	  ArrayList<String> ddvalues = new ArrayList<String>();
	  
	  //Adding dropdown values into ArrayList
	  for(int i=0;i<droplist_size;i++)
	  {
		  ddvalues.add(droplist.get(i).getText());
	  }
	  
	  //Access excel file into eclipse
	  FileInputStream fis = new FileInputStream("C:\\Sirisha\\KOSMIK_Eclipse_Practice tests and programs\\tizag.xls");
	  
	  //Get the workbook from tizag excel file
	  HSSFWorkbook workbook = new HSSFWorkbook(fis);
	  
	  //Get the worksheet from the workbook
	  HSSFSheet sheet = workbook.getSheet("Sheet1");	  
	  
	  //count the total rows in Sheet1
	  int total_rows = sheet.getLastRowNum()+1;
	  System.out.println("Total rows in Sheet1 = " +total_rows);
	  
	  //Creat ArrayList for excel data in Sheet1
	  ArrayList<String> xlvalues = new ArrayList<String>();
	  
	  //Add excel data into Arraylist
	  for(int j=0;j<total_rows; j++)
	  {
		  xlvalues.add(sheet.getRow(j).getCell(0).getStringCellValue()); //read the data from excel sheet
	  }
	  
	  //Comparing Actual data(Application - tizag) with Expected data(Excel)
	  if(droplist_size==total_rows)
	  {
		  for(int k=0;k<xlvalues.size();k++)
		  {
			  for(int l=0;l<ddvalues.size();l++)
			  {
				  if(xlvalues.get(k).equals(ddvalues.get(l)))
				  {
					  System.out.println(xlvalues.get(k)+ " is matched with " +ddvalues.get(l));
					  break;
				  }
			  }
		  }
	  }
	  else
	  {
		  System.out.println("size is not matched");
	  }
	  
	    
  }
  @BeforeClass
  public void launchBrowser() 
  {
	driver = new FirefoxDriver();  //launch the browser
	driver.get("http://www.tizag.com/htmlT/htmlselect.php"); //Navigate to the Application url
  
  }

  @AfterClass
  public void closeBrowser() 
  {
	  driver.close();
  }

}
