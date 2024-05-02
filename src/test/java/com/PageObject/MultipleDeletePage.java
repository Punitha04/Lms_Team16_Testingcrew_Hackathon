package com.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MultipleDeletePage {
	
	
	
	WebDriver driver;
	//WebDriverWait wait;
	//DeletePage dp=new DeletePage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
			
   @FindBy (xpath="(//div[@role=\"checkbox\"])[2]")
    WebElement single_checkox;

     @FindBy (xpath="(//div[@role=\"checkbox\"])[1]")
       WebElement multiple_checkBox;


	
	
	@FindBy (xpath="//*[@class=\"p-checkbox-box\"]")
	WebElement mult_checkox;
	
	@FindBy (xpath="(//span[@class=\"p-button-label\"])[1]")
	WebElement multiple_Del_BTN;

	
	@FindBy(xpath="//span[text()='No']")
	 WebElement no;
	
	
	@FindBy(xpath="//span[text()='Yes']")
	 WebElement yes;
	
	//DeletePage dp=new DeletePage(driver);
	   
	public MultipleDeletePage(WebDriver driver) 
	   {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.driver=driver;
		PageFactory.initElements(driver,this);
				
			}
	   
	   public void clickSingleCheckbox()
	   {
		   single_checkox.click();
		   
	   }
	   
	   
	   public void clicMultipleleCheckboxes()
	   {
		   multiple_checkBox.click();
		   
	   }
	   public void deleteButtonEnabled()
	   {
		   boolean btnEnable=multiple_Del_BTN.isEnabled();
		   Assert.assertEquals(btnEnable,true);
		   
		   System.out.println("butto Enabled *************** "+btnEnable);
	   }
	   public void  clickNoButton() throws InterruptedException
	   {
		   multiple_Del_BTN.click();
		   Thread.sleep(1000);
		   no.click();
	   	
	   	System.out.println("No button clicked");
	   }
	   
	   public void clickonMultipleDeleteButton() throws InterruptedException {

		   Thread.sleep(1000);
		      
		   
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", multiple_Del_BTN);
		   
		   
		   //multiple_Del_BTN.click();
	   }
	   
	   public void clickOnYesButton()
	   {
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
			  executor.executeScript("arguments[0].click();", yes);
		  // yes.click();
	   }
	   
	   public void click_NoButton() throws InterruptedException
	   {
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
			  executor.executeScript("arguments[0].click();", no);
			  
			  
			  
		   //no.click();
	   }
	   
	   public void uncheckSingleCheckBOx()
	   {
		   if(single_checkox.isSelected());
			  {
				  single_checkox.click();  
			  }
	   }
	   
	   
	   public void uncheckMultipleleCheckBOx()
	   {
		   if(mult_checkox.isSelected())
		   {
			   mult_checkox.click();
		   }
	   
	   }

	   
	   
	   
	

}
