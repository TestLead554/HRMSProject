package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class VerifyOrangeHRMExcelData {
   WebDriver driver;	

  @Test
  public void verifyDropDown() throws IOException 
  {
	  driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	  driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("Gsiri554");
	  driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Gsiri@884554");
	  driver.findElement(By.xpath("//input[@name='Submit']")).click();
	  
	  //switch to frame
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='rightMenu']")));
	  
	  //Identify the dropdown
	  WebElement dropdown = driver.findElement(By.xpath("//select[@id='loc_code']"));
	  
	  //Identify list of elements in dropdown
	  List<WebElement> droplist = driver.findElements(By.tagName("option"));
	  
	  //find the size of the droplist
	  int dropdown_size = droplist.size();
	  System.out.println("Size of the droplist = " +dropdown_size);
	  
	  //Display the list of elements in the droplist
	  for(int i=0; i<dropdown_size; i++)
	  {
		  System.out.println(droplist.get(i).getText());
	  }
	  
	  //Create ArrayList for dropdown 
	  ArrayList<String> ddvalues = new ArrayList<String>();
	  
	  //Adding dropdown values into ArrayList
	  for(int i=0;i<dropdown_size;i++)
	  {
		  ddvalues.add(droplist.get(i).getText());
	  }
	  
	  
	  //getting the excel data into eclipse
	  //Acess the excel doc into eclipse
	  FileInputStream fis = new FileInputStream("C:\\Sirisha\\KOSMIK_Selenium\\Excelsheets\\HRM.xls");
	  
	  //Get the workbook from Excel
	  HSSFWorkbook workbook = new HSSFWorkbook(fis);	  
	  
	  
	  //Get the worksheet from workbook
	  HSSFSheet sheet = workbook.getSheet("Sheet1");
	  
	  //count total rows in Sheet1
	  int total_rows = sheet.getLastRowNum()+1;
	  System.out.println("Total no of rows in Sheet1 = " +total_rows);
	  
	  
	  //Create ArrayList for Excel data
	  ArrayList<String> xlvalues = new ArrayList<String>();
	  
	  //Adding excel data into xlvalues ArrayList
	  for(int j=0; j<total_rows;j++)
	  {
		  xlvalues.add(sheet.getRow(j).getCell(0).getStringCellValue()); //read the data from excel sheet
	  }
	  
	  //Comparing Actual data(dropdown values) with Expected data(Excel data)
	  
	  
	  if(dropdown_size==total_rows)  //Check the size of dropdown and excel data
	  {
		  //To read the xlvalues
	    for(int l=0; l<xlvalues.size(); l++)
	    {
	    	//To read the drop down values
		  for(int m=0; m<ddvalues.size();m++)
		  {
			  if(xlvalues.get(l).equals(ddvalues.get(m)))
			  {
				  System.out.println(xlvalues.get(l)+" is matched with  " +ddvalues.get(l));
				  break;  //here break means exit from inner for loop
			  }
			 else
			  {
				  System.out.println("The value in dropdown is not matched to the Excel data");
			  }
		  }
	    }
	  }
	  else
	  {
	   System.out.println("Size is not matched");
	  }
	  
    }
	  
  
  @BeforeClass
  public void launchBrowser() 
  {
	  driver = new FirefoxDriver();
  }

  @AfterClass
  public void afterClass() 
  {
	  driver.close();
	  
  }

}
