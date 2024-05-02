package com.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Base.BaseClass;
import com.Utils.ReUsableMethods;

public  class  SingleDeletePage extends BaseClass
{
	
	
@FindBy (xpath="(//button[@id=\"deleteProgram\"])[1]")
WebElement delete;


@FindBy(xpath="//span[text()='No']")
 WebElement no;


@FindBy(xpath="//span[text()='Yes']")
WebElement yes;;

@FindBy(xpath="//span[text()='Confirm']")
WebElement del_Confirm_popUp;

@FindBy(xpath="//*[text()='Program Deleted']")
 WebElement del_MSG;

@FindBy(xpath="//*[@class=\"p-confirm-dialog-message ng-tns-c133-4\"]")
WebElement areYouSure_msg;

@FindBy(xpath="//*[@class=\"ng-trigger ng-trigger-animation ng-tns-c133-4 p-dialog p-confirm-dialog p-component ng-star-inserted\"]")
	WebElement deletePopUpWindow;



//@FindBy(xpath="(//button[@type=\"button\"])[10]")
  @FindBy(xpath="//*[@class=\"pi pi-times ng-tns-c133-4\"]")
    WebElement cancel_closeIcon;

//*[@class="ng-trigger ng-trigger-animation ng-tns-c133-4 p-dialog p-confirm-dialog p-component ng-star-inserted"]

//*[@class="ng-trigger ng-trigger-animation ng-tns-c133-4 p-dialog p-confirm-dialog p-component ng-star-inserted"]


   public SingleDeletePage(WebDriver driver) { 
	
	  PageFactory.initElements(driver,this);
	  }
   
   public void clickOnDeleteButton()
   {
	   
	   
	   delete.click(); 
   }
   
  public void  validate_deleted_successfully()
    {
    	yes.click();
    }
  
  public  void  validateNoButton()
  {
  	no.click();
  }
  
  public void validateDeleteConfirmaWindow(String cnfirm)
  {
	  String actual=del_Confirm_popUp.getText();
	  Assert.assertEquals(actual, cnfirm);
	  
  }
  public void validateDeleteMSG(String successfullt_del)
  {
	 String expected="Successful Program Deleted";
	  
	  Assert.assertEquals(successfullt_del, expected);
  }
  
  
  public void validateAreYouSureMSG(String successfullt_del)
  {
	  String expected="Are you sure you want to delete <Program name>?";
	  
	  Assert.assertEquals(successfullt_del, expected);
  }
  
  
  public void validatePopupWindow()
  {
	  
	  String actual=del_Confirm_popUp.getText();
	  Assert.assertEquals(actual, "Confirm");
	//boolean flag=  del_Confirm_popUp.isDisplayed();
	
	//System.out.println("user is on delete pop up window"+flag);
  }
  
  public void clickONCloseIcon()
  {
	  
//	  Actions a = new Actions(driver);
//      a.moveToElement(cancel_closeIcon).
//      build().perform();
	  //cancel_closeIcon.click();
	  
	  ReUsableMethods.javaScriptClickMethod(driver, cancel_closeIcon);
  }
 }
