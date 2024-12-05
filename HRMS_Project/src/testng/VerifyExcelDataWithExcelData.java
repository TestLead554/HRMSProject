package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class VerifyExcelDataWithExcelData {
	WebDriver driver;
	
  @Test
  public void VerifyExcelDatawithExcelData() throws IOException 
  {
	  //Access Sheet2 Excel data into eclipse
	  
	  //Access excel data file into eclipse
	  FileInputStream fis = new FileInputStream("C:\\\\Sirisha\\\\KOSMIK_Eclipse_Practice tests and programs\\Data.xlsx");	  
	  
	  //Access workbook into eclipse
	  XSSFWorkbook wb1 = new XSSFWorkbook(fis); 
	  
	  //Access Excel Sheet2 into eclipse
	  XSSFSheet sh2 = wb1.getSheet("Sheet2");
	  
	  //Count no of rows in Sheet2
	  int total_rows_sh2 = sh2.getLastRowNum()+1;
	  System.out.println("The total no of rows in Sheet2 = " +total_rows_sh2);
	  
	  //Count total no of columns Sheet2
	  int total_columns_sh2 = sh2.getRow(0).getLastCellNum();
	  System.out.println("The total no columns in Sheet2 = " +total_columns_sh2);
	  
	  //Count the size of the data in Sheet2
	  int sheet2_size = total_rows_sh2 * total_columns_sh2;
	  System.out.println("Size of the data in Sheet2 = " +sheet2_size);
	  
	  System.out.println("-----------------------------------");
	  //Access Sheet3 Excel data into eclipse
	  
	  //Access the Sheet3 into eclipse
	  XSSFSheet sh3 = wb1.getSheet("Sheet3");
	  
	  //Count total no of rows in Sheet3
	  int total_rows_sh3 = sh3.getLastRowNum()+1;
	  System.out.println("The total no of rows in Sheet3 = "  +total_rows_sh3);
	  
	  //Count total no of columns in Sheet3
	  int total_columns_sh3 = sh3.getRow(0).getLastCellNum();
	  System.out.println("The total no columns in Sheet3 = " +total_columns_sh3);
	  
	  //count the size of the data in sheet3
	  int sheet3_size = total_rows_sh3*total_columns_sh3;
	  System.out.println("Size of the data in Sheet3 = " +sheet3_size);
	  
	  //Create ArrayList for Sheet2
	  ArrayList<String> a1 = new ArrayList<String>();
	  
	  for(int i=0;i<total_rows_sh2;i++)
	  {
		  for(int j=0;j<total_columns_sh2;j++)
		  {
			  //read the data from excel sheet and store arraylist variabe a1
			   a1.add(sh2.getRow(i).getCell(j).getStringCellValue());
		  }
		  System.out.println(a1);
	  }
	 
	  
	  System.out.println("-----------------------------");
	  //Create ArrayList for sheet3
	  ArrayList<String> a2 = new ArrayList<String>();
	  
	  for(int m=0;m<total_rows_sh3;m++)
	  {
		  for(int n=0;n<total_columns_sh3;n++)
		  {
			//read the data from excel sheet and store arraylist variabe a2
			  a2.add(sh3.getRow(m).getCell(n).getStringCellValue());
			  
		  }
		  System.out.println(a2);
	  }
	  
	  //Compare Sheet2 with Sheet3
	  if(sheet2_size==sheet3_size)
	  {
		  for(int k=0;k<a1.size();k++)
		  {
			  for(int l=0;l<a2.size();l++)
			  {
				  if(a1.get(k).equals(a2.get(l)))
				  {
					  System.out.println(a1.get(k) +"  is matched with  " +a2.get(l));
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
	  	  
  }
  @AfterClass
  public void closeBrowser() {
  }

}
