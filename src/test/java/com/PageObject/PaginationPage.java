package com.PageObject;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Base.BaseClass;
import com.Utils.ReUsableMethods;

public class PaginationPage
{

	WebDriverWait wait;
	WebDriver driver;
	
	@FindBy (xpath="(//button[@type=\"button\"])[8]")
	WebElement nextBtn;
	
	
	@FindBy (xpath="(//button[@type=\"button\"])[8]")
	WebElement firstBtn;
	
	@FindBy (xpath="//*[@class=\"p-paginator-icon pi pi-angle-double-right\"]")
	WebElement doubleRightBtn;
	
	@FindBy (xpath="//*[@class=\"p-paginator-icon pi pi-angle-double-left\"]")
	WebElement startPageButton;
	
	
	
	
	public PaginationPage(WebDriver driver) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}

	
	
	public void startPageLink() throws InterruptedException
	{
		//startPageButton.click();
		Thread.sleep(2000);
		
		ReUsableMethods.javaScriptClickMethod(driver,startPageButton);
		//ReUsableMethods.waitForElementToBeClickable(driver, startPageButton);
	}
	
	public void startPageLinkDisabled()
	{
	boolean flag=	startPageButton.isEnabled();
	System.out.println(" start page button disable " +flag);
	}
	
	public void firstPageLink() throws InterruptedException 
	{
		Thread.sleep(2000);
		//firstBtn.click();
		ReUsableMethods.javaScriptClickMethod(driver,firstBtn);
		
	}
	public void nextPageLink() throws InterruptedException 
	{
		Thread.sleep(2000);
		ReUsableMethods.javaScriptClickMethod(driver,nextBtn);
		
		
      
		
	}
	
	public void isnextButtonActiveLink()
	{
		boolean flag=nextBtn.isEnabled();
		Assert.assertEquals(flag, true);
	}
	
	public void clickOnLastButton()
	{
//		 JavascriptExecutor executor = (JavascriptExecutor)driver;
//		  executor.executeScript("arguments[0].click();", yes);
		ReUsableMethods.javaScriptClickMethod(driver,doubleRightBtn);
		
		  //ReUsableMethods.javaScriptClickMethod(driver,doubleRightBtn);
		  
		//ReUsableMethods.waitForElementToBeClickable(driver, doubleRightBtn);
		//doubleRightBtn.click();
	}
	
	public void isLastButtonDisable()
	{
		boolean flag= doubleRightBtn.isEnabled();
		
		System.out.println(" is last button disable " +flag);
	}
	  public void isnextButtonDisable()
 {
	boolean flag=nextBtn.isEnabled();
	
	System.out.println(" is next button disable " +flag);
	
  // Assert.assertEquals(flag, false);
  
 }
	  
	 
}