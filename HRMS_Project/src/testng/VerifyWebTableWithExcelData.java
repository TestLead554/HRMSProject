package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class VerifyWebTableWithExcelData {
	
	WebDriver driver;
	
  @Test
  public void VerifyWebTableData() throws IOException 
  {
	//To identify total rows from webtable
	  int total_rows = driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
	  System.out.println(total_rows);
	  
	  //To identify total coloumns from webtable
	  int total_columns = driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/td")).size();
	  System.out.println(total_columns);
	  
	  //To find the webpage table size 
	  int webpage_table_size = total_rows*total_columns;
	  System.out.println("Size of the webpage table = " +webpage_table_size);
	  
	  //create ArrayList for Webpage table 
	  ArrayList<String> wvalues = new ArrayList<String>();
	  	  
	  for(int m=1;m<=total_rows;m++)
	  {
		  for(int n=1;n<=total_columns;n++)
		  {
			  String data = driver.findElement(By.xpath("/html/body/table/tbody/tr[" +m+ "]/td [" +n+ "]")).getText();
			  wvalues.add(data);  //storing webpage rows and columns into the arraylist reference variable wvalues
			  
		  }
	  }
	  System.out.println(wvalues);
	  
	  //Access the excel file into eclipse
	  FileInputStream fis = new FileInputStream("C:\\Sirisha\\KOSMIK_Eclipse_Practice tests and programs\\Data.xlsx");
	  		  
	  //Create XSSFWorkbook for accessing xlsx file
	  XSSFWorkbook workbook = new XSSFWorkbook(fis);
	  
	  //create  XSSFsheet for accessing  particular sheet
	  XSSFSheet sheet = workbook.getSheet("Sheet1");
	  
	  //Read the no of excel data rows into eclipse
	  int total_rows1 = sheet.getLastRowNum()+1;
	  
	  //Total rows from excel sheet
	  System.out.println("Total rows in excel sheet = " +total_rows1);
	  
	  //Read the no of excel columns into eclipse
	  int total_columns1 = sheet.getRow(0).getLastCellNum();
	  
	  //Print Total columns from excel sheet
	  System.out.println("Total columns in excel sheet = " +total_columns1);
	  
	  //find the excel table size
	  int excel_table_size = total_rows1*total_columns1;
	  
	  //Create ArrayList for Excel
	  ArrayList<String> xlvalues = new ArrayList<String>();
	  
	  for(int i=0;i<total_rows1;i++)
	  {
		  for(int j =0;j<total_columns1;j++)
		  {
			  //print the excel data
			  //System.out.print(sheet.getRow(i).getCell(j).getStringCellValue());
			  
			  //read the data from excel sheet and store arraylist variabel
			  xlvalues.add(sheet.getRow(i).getCell(j).getStringCellValue());
		  }
		  
	  }
	  
	  //print the arralist excel data
	  System.out.println(xlvalues);
	  
	  
	  //compare the excel data size with webpage table data
	  if(excel_table_size == webpage_table_size)
	  {
		  
	  //compare excel data with webtable data
	    for(int a=1;a<excel_table_size;a++)
	    {
		  for(int b=1;b<webpage_table_size;b++)
		  {
			 if(xlvalues.get(a).equals(wvalues.get(b)))
			 {
				System.out.println(xlvalues.get(a) +"  is matched with "+wvalues.get(b));
			 }
			 /*else
			 {
				 System.out.println(xlvalues.get(a)+" is not matched with" +wvalues.get(b));
			 }*/
					 
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
	  driver = new FirefoxDriver();
	  driver.get("file:///C:/Sirisha/KOSMIK_Selenium/Videos/webtable.html");
	  
  }

  @AfterClass
  public void closeBrowser()
  {
	  driver.close();
  }

}
