package com.PageObject;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Base.BaseClass;


public class Sorting_DataOrdering extends BaseClass
{
	WebDriver driver;
	//WebDriverWait wait;
	//DeletePage dp=new DeletePage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
@FindBy (xpath="//*[text()='Program Name ']")
WebElement program_name;

@FindBy (xpath="//*[text()='Program Description ']")
WebElement program_description;

@FindBy (xpath="//*[text()='Program Status ']")
WebElement program_status;
@FindBy(xpath="//*[@aria-sort=\"ascending\"]")
WebElement sorted;

String [] data;


//@FindBy(xpath="//*/p-table/div/div[1]/table/tbody/tr[1]/td[2]")
//WebElement nameList;

public Sorting_DataOrdering (WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

  public void clickOnProgramName() throws InterruptedException
  {
	  
//	  
//	  List<WebElement> names=driver.findElements(By.xpath("//*/p-table/div/div[1]/table/tbody/tr/td[2]"));
//	  //String [] count= new String[names.size()];
//	  String [] beforeSortName;
//	  beforeSortName= new String[names.size()];
//	  
//	  for (int i=0;i<names.size();i++)
//		{
//			beforeSortName[i]=names.get(i).getText().trim();
//			System.out.println("****before sorting ****     "+beforeSortName[i]);
//			
//			}
//	 
//
////	  for(int i=0;i<count.length;i++)
////		{
////			System.out.println(" after  ****  "+count[i]);
////		}
//	  Arrays.sort(beforeSortName);
//	 // print(beforeSortName);
//	  
//	  for(int j=0;j<beforeSortName.length;j++)
//		{
//			System.out.println(" after sorting   "+beforeSortName[j]);
//			//Team07TechTestersProgram01, Team2LMSCh345, aaaaaaaaaaaaaaa, reee, xpath123]
//		}
	  
	  program_name.click();
	  Thread.sleep(2000);
	  
//	  List<WebElement> sorted_names=driver.findElements(By.xpath("//*/p-table/div/div[1]/table/tbody/tr/td[2]"));
//	  //String [] count= new String[names.size()];
//	  String []   afterSortName= new String[sorted_names.size()];
//	 // print(afterSortName);
//		  
//	  for (int k=0;k<sorted_names.size();k++)
//		{
//			afterSortName[k]=sorted_names.get(k).getText().trim();
//			System.out.println("****  button clicked sorted name  ****      "+afterSortName[k]);
//			
//			}
//	  
//	  Assert.assertEquals(beforeSortName, afterSortName);
	  
	
    //  data=   DataSorting.ascendingData() ; 
	 
	  }
  
  
  private void print(String[] beforeSortName) {
	for(int i=0;i<beforeSortName.length;i++)
	{
		System.out.println("after sorting"+beforeSortName[i]);
	}
	
}

public void clickOnProgramDescription()
  {
	  program_description.click();
  }
  
  
  public void clickOnProgramStatus()
  {
	  program_status.click();
  }
  
  public void veryfyDataSorted(String sort )
  {
	  
//	  String [] count;
//	  List<WebElement> names=driver.findElements(By.xpath("//*/p-table/div/div[1]/table/tbody/tr/td[2]"));
//	  count= new String[names.size()];
//	  
//	  for (int i=0;i<names.size();i++)
//		{
//			count[i]=names.get(i).getText().trim();
//			System.out.println("****before sorting ****  "+count[i]);
//			
//			}
	  
	  
//	  for(int i=0;i<count.length;i++)
//		{
//			System.out.println(" after  ****  "+count[i]);
//		}
//	  Arrays.sort(count);
	
  // Assert.assertEquals(data, count);
   
   
   
   System.out.println("verified ascending sorting      ******************");
   
   
	
//	for (int i=0;i<names.size();i++)
//	{
//		count[i]=names.get(i).getText().trim();
//		System.out.println("before sorting -----------  "+count[i]);
//	}
//	Arrays.sort(count);
//	
//	printSorting(count);
//	
//	//System.out.println("after sorting **********************  "+count);
//	
//  }
//
//private void printSorting(String[] arr) 
//{
//	for(int i=0;i<arr.length;i++)
//	{
//		System.out.println("after sorting   ++++++++   "+arr[i]);
//	}
	
}
  
}
