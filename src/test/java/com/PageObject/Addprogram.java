package com.PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.ReUsableMethods;
import com.Utils.Excel;

public class Addprogram {
	WebDriver driver;
	WebDriverWait wait;
	
	public Addprogram(WebDriver driver) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="new")
	public WebElement newProgram;
	@FindBy(xpath="//div[@role='dialog']")
	public WebElement dialogBox;
	@FindBy(xpath="//button[@label='Save']")
	public WebElement saveBtn;
	@FindBy(xpath="//button[@label='Cancel']")
	public WebElement cancelBtn;
	@FindBy(xpath="//input[@id='programName']")
	public WebElement nameBox;
	@FindBy(xpath="//input[@id='programDescription']")
	public WebElement descriptionBox;
	@FindBy(xpath="//label[@for='programName']")
	public WebElement nameField;
	@FindBy(xpath="//label[@for='programDescription']")
	public WebElement descriptionField;
	@FindBy(xpath="//div[@class='p-radiobutton p-component']")
	public List<WebElement> radioBtn;
	@FindBy(css="button[class*='p-dialog-header-close'] span")
	public WebElement closeIcon;
	@FindBy(css="div[class*='p-dialog-header'] span[id='pr_id_2-label']")
	public WebElement dialogTitle;
	@FindBy(css="*[class='p-invalid ng-star-inserted']")
	public List<WebElement> errorMsg;
	@FindBy(xpath="//small[normalize-space()='Description is required.']")
	public WebElement descriptionErrorMsg;
	@FindBy(xpath="//div[@class='p-field ng-star-inserted'] //small[@class='p-invalid ng-star-inserted']")
	public WebElement nameErrorMsg;
	@FindBy(xpath="small[normalize-space()='Program name is required.']")
	public WebElement nameErrorMsg1;
	//.p-toast-detail.ng-tns-c90-15
	@FindBy(css="div[class*='p-toast-detail']")
	//@FindBy(xpath="//div[@class='p-toast-detail ng-tns-c90-10']")
	public WebElement successMsg;
	
	
	       
	
	public void newProgram()
	{
		newProgram.click();
	}
	public void getCancelBtn()
	{
		cancelBtn.click();
	}
	public void getSaveBtn()
	{
		saveBtn.click();
	}
	public void enterProgName(String name)
	{
		nameBox.sendKeys(name);
		saveBtn.click();
	}
	public void enterProgDesc(String description) throws InterruptedException
	{

		descriptionBox.sendKeys(description);
		ReUsableMethods.waitForElementToBeVisible(driver,saveBtn);
		saveBtn.click();
	}
	public List<Map<String, String>> exceldata(String sheetName,int rowNumber) throws InvalidFormatException, IOException
	{
		Excel xl = new Excel();
		List<Map<String,String>> testData= xl.getData("src\\test\\resources\\DataFiles\\Team16_TestingCru.xlsx", sheetName);
		//List<Map<String,String>> testData= xl.getData("C:\\Users\\Ranji\\OneDrive\\Documents\\Team16_TestingCru.xlsx", sheetName);
	
	return testData;
	}
	public void allRequiredField(String sheetName,int rowNumber) throws InvalidFormatException, IOException, InterruptedException
	
	{
		Excel xl = new Excel();
		List<Map<String,String>> testData= xl.getData("src\\test\\resources\\DataFiles\\Team16_TestingCru.xlsx", sheetName);
		//List<Map<String,String>> testData= xl.getData("C:\\Users\\Ranji\\OneDrive\\Documents\\Team16_TestingCru.xlsx", sheetName);
		String name=testData.get(rowNumber).get("ProgramName");
		String description = testData.get(rowNumber).get("ProgramDescription");
	    //Thread.sleep(3000);
	    nameBox.sendKeys(name);
	    descriptionBox.sendKeys(description);
	    radioBtn.getFirst().click();
	    ReUsableMethods.waitForElementToBeVisible(driver,saveBtn);
		saveBtn.click();
		
	}
	

public void invalidField(String sheetName,int rowNumber) throws InvalidFormatException, IOException, InterruptedException

{
	Excel xl = new Excel();
	List<Map<String,String>> testData= xl.getData("src\\test\\resources\\DataFiles\\Team16_TestingCru.xlsx", sheetName);
	//List<Map<String,String>> testData= xl.getData("C:\\Users\\Ranji\\OneDrive\\Documents\\Team16_TestingCru.xlsx", sheetName);
	String name=testData.get(rowNumber).get("InvalidName");
	String description = testData.get(rowNumber).get("InvalidDescription");
    //Thread.sleep(3000);
    nameBox.sendKeys(name);
    descriptionBox.sendKeys(description);
    radioBtn.getFirst().click();
    ReUsableMethods.waitForElementToBeVisible(driver,saveBtn);
	saveBtn.click();
	
}
public List<String> invalid_errorMsg(String sheetName,int rowNumber) throws InvalidFormatException, IOException
{
Excel xl = new Excel();
List<Map<String,String>> testData= xl.getData("src\\test\\resources\\DataFiles\\Team16_TestingCru.xlsx", sheetName);
//List<Map<String,String>> testData= xl.getData("C:\\Users\\Ranji\\OneDrive\\Documents\\Team16_TestingCru.xlsx", sheetName);
	String nameErrormsg=testData.get(0).get("InvalidNameError");
	String descriptionErrormsg = testData.get(0).get("InvalidDescError");
	List<String> errorList=new ArrayList();
	errorList.add(nameErrormsg);
	errorList.add(descriptionErrormsg);
	
	return errorList;
}
}
