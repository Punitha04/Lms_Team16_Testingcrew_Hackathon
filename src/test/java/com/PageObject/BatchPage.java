package com.PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Base.BaseClass;
import com.Utils.Excel;


public class BatchPage {
	
	@FindBy(xpath="//*[@id=\"batch\"]")WebElement batchBtn;
	@FindBy(xpath="/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[1]")WebElement manageBatchHeader;
	@FindBy(xpath="/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div")WebElement batchPagination;
	@FindBy(xpath="/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table")WebElement batchDataTable;
	@FindBy(xpath="/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th")List<WebElement> batchDataTableHeaders;
	@FindBy(xpath="/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[2]/div[1]/button")WebElement batchDeleteBtn;
	@FindBy(xpath="//*[@id=\"new\"]")WebElement newBatchButton;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']//div[@class='p-checkbox p-component']") List<WebElement> batchTablecheckboxes;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']//span[@class='p-button-icon pi pi-pencil']")List<WebElement> batchEditIcon;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']//span[@class='p-button-icon pi pi-trash']")List<WebElement> batchDeleteIcon;
	@FindBy(xpath="/html/body/app-root/app-batch/p-dialog/div/div")WebElement newBatchPopupWindow;
	@FindBy(xpath="//*[@id=\"batchName\"]")WebElement popupBatchName;
	@FindBy(xpath="//*[@id=\"batchDescription\"]")WebElement popupBatchDescription;
	@FindBy(xpath="//*[@id=\"programName\"]")WebElement popupBatchProgramNameDropdown;
	@FindBy(xpath="//div[@class='ng-tns-c132-14 p-dialog-content']//div[@class='p-radiobutton p-component']")List<WebElement> popupBatchStatusRadioBtn;
	@FindBy(xpath="//*[@id=\"batchNoOfClasses\"]")WebElement popupBatchNumberOfClasses;
	@FindBy(xpath="//*[@id=\"batchStatus\"]/div/div[2]")WebElement activeRadioBtn;
	@FindBy(xpath="//*[@id='programName']/div/div[2]")WebElement popupBatchProgramNameDropdownArrow;
	@FindBy(xpath="//*[@id='programName']/div/div[3]/div/ul/p-dropdownitem[1]")WebElement popupBatchProgramNameDropdownItem1;
	@FindBy(xpath = "//button[@class='p-button-rounded p-button-success p-button p-component ng-star-inserted']")WebElement batchSaveBtn;
	@FindBy(xpath="//*[@id=\"text-danger\"]")List<WebElement> batchErrorMessages;
	@FindBy(xpath="//*[@id=\"filterGlobal\"]")WebElement search;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']//tr") List<WebElement> batchDataTableRows;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']//tr[1]/td[2]") WebElement batchName;
	@FindBy(xpath="/html/body/app-root/app-batch/p-dialog/div/div/div[3]/button[1]")WebElement batchCancelBtn;
	@FindBy(xpath = "//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']")List<WebElement> batchRowDeleteButtons;
	@FindBy(xpath="//div[@class='p-dialog-footer ng-tns-c133-7 ng-star-inserted']")WebElement deleteAlertFooter;
	@FindBy(xpath="//span[text()='No']") WebElement deleteConfirmNo;
	@FindBy(xpath="//span[text()='Yes']") WebElement deleteConfirmYes;
	@FindBy(xpath="//button[@class='p-button-rounded p-button-success p-button p-component p-button-icon-only']")List<WebElement> batchRowEditButtons;
	@FindBy(xpath="//*[@id=\"batchStatus\"]/div")WebElement inactiveRadioBtn;
	@FindBy (xpath="(//div[@role=\"checkbox\"])[2]") WebElement single_checkox;
	@FindBy (xpath="(//div[@role=\"checkbox\"])[3]") WebElement checkox_row2;
	@FindBy (xpath="(//div[@role=\"checkbox\"])[1]") WebElement multiple_checkBox;
	@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")WebElement delete_multiple_button;
	
	WebDriver driver;
	WebDriverWait wait;
	
	//constructor
	public BatchPage(WebDriver driver) 
	{
		wait = new	WebDriverWait(driver, Duration.ofSeconds(5));
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void batchPageBtn()
	{
		batchBtn.click();
	}	
	
	public String getBatchURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String getBatchHeader()
	{
		return manageBatchHeader.getText();
	}
		
	public boolean batchPagination()
	{
		return batchPagination.isDisplayed();
	}
	
	public boolean validateBatchDataTableHeaders()
	{
		System.out.println("Number of columns " + batchDataTableHeaders.size());
		boolean status = false;
		int headerColumnCount = 0;
		for (WebElement ele:batchDataTableHeaders) 
		{
			String value=ele.getText();			
			
			switch(value) 
			  {
			   case "Batch Name":
				   headerColumnCount++;
				   System.out.println(value);
			       break;
			       
			   case "Batch Description":
				   headerColumnCount++;
				   System.out.println(value);
			       break;
			       
			   case "Batch Status":
				   headerColumnCount++;
				   System.out.println(value);
			       break;
			       
			   case "No Of Classes":
				   headerColumnCount++;
				   System.out.println(value);
			       break;
			       
			   case "Program Name":
				   headerColumnCount++;
				   System.out.println(value);
			       break;
			       
			   case "Edit / Delete":
				   headerColumnCount++;
				   System.out.println(value);
			       break;
			   
			   default:status=false;
			   System.out.println(value);		
			  }
		}
		if(headerColumnCount == batchDataTableHeaders.size()-1)
		{
			status = true;
		}
		return status;
	}
	
	
	public boolean isDeleteBtnDisable()
	{
		return batchDeleteBtn.isEnabled();
	}
	//-----Add New Batch--------
	public boolean isAddewBatchButtonAvailable()
	{
		return newBatchButton.isDisplayed();
	}
	
	public List<WebElement> getBatchTableCheckboxes() {
		
        return batchTablecheckboxes;
    }
	
    public List<WebElement> getBatchTableEditIcon() {
		
        return batchEditIcon;
    }
    
    public List<WebElement> getBatchTableDeleteIcon() {
		
        return batchDeleteIcon;
    }

    public void addNewBatchPopupWindow() {
	
	newBatchButton.click();
    }
	
    public boolean isAddNewBatchPopDisplay()
    {
    	return newBatchPopupWindow.isDisplayed();
    }
    
    //-----Add new batch-----------
    public String validateAllElementTypesOnPopup()
    {
    	String inValidTypes = "";
    	// popupBatchName;
    	if(!popupBatchName.getAttribute("type").equals("text"))
    	{
    		inValidTypes = inValidTypes + " BatchName is not a text Type";
    	}
    	if(!popupBatchDescription.getAttribute("type").equals("text"))
    	{
    		inValidTypes = inValidTypes + " Description is not a text Type";
    	}
    	if(!popupBatchProgramNameDropdown.isDisplayed())
    	{
    		inValidTypes = inValidTypes + " ProgramName is not a drop down";
    	}
    	for (WebElement radioButton : popupBatchStatusRadioBtn) {
    		if(!radioButton.isDisplayed())
    			{
    				inValidTypes = inValidTypes + " Batch Status is not RadioButton.";
    			}
        }
    	if(!popupBatchNumberOfClasses.getAttribute("type").equals("number"))
    	{
    		inValidTypes = inValidTypes + " Batch Number is not a number Type";
    	}
    	return inValidTypes;
    }
    
    public void addBatchFieldsNoDesc(String name, String classes)
     {
    	popupBatchName.sendKeys(name);
    	popupBatchProgramNameDropdownArrow.click();
    	popupBatchProgramNameDropdownItem1.click();
    	activeRadioBtn.click();    	
    	popupBatchNumberOfClasses.sendKeys(classes);
    	batchSaveBtn.click();
	} 
    
    public List<Map<String,String>> getBatchDataFromExcel(String SheetName) throws InvalidFormatException, IOException {
    	Excel xl = new Excel();
    	
    	List<Map<String,String>> testData= xl.getData("src\\test\\resources\\DataFiles\\Team16_TesingCru.xlsx", SheetName);
    	System.out.println("Value in testData " +testData);
    	return testData;
    }

    public List<WebElement> getBatchErrorMessages() {
    	return batchErrorMessages;
    }
    
    public List<WebElement> getAllDataTableRows()
    {
    	return batchDataTableRows;
    }
    
    public int dataTableRowsDisplayed() {
    	return batchDataTableRows.size();
    }
    
    public String getFirstRowBatchName()
    {
    	return batchName.getText();
    }
    public void addBatchAllFields(String description) {
    	popupBatchDescription.sendKeys(description);
        batchSaveBtn.click();
    }
    
    
    public void searchRecordByBatchName(String batchNameText) {
    	search.clear();
    	search.sendKeys(batchNameText);
    }
   
    public void clearSearch() {
    	//suppose "element" is an input field
    	search.clear();
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    	jsExecutor.executeScript("$(arguments[0]).change();", search);    	
    }
    
    public void addBatchInvalidFields(String name, String description, String classes) {
    	popupBatchName.sendKeys(name);
       	popupBatchDescription.sendKeys(description);
       	popupBatchProgramNameDropdownArrow.click();
       	popupBatchProgramNameDropdownItem1.click();
       	activeRadioBtn.click();    	
       	popupBatchNumberOfClasses.sendKeys(classes);
       	batchSaveBtn.click();
    }
    
    public void editBatchEraseMandatoryFields() {
    	 popupBatchDescription.clear();
	     popupBatchNumberOfClasses.clear();
	   	 batchSaveBtn.click();
    }
    
    public void editBatchEraseDiscriptionField() {
    	 popupBatchDescription.clear();
       	 batchSaveBtn.click();
    }
    

    public void cancelPopupWindow() {
    	batchCancelBtn.click();	
    }
  //----Delete batch-------
    public WebElement getDeleteButtonFromDataRow() {    	
    	if(batchRowDeleteButtons.size() > 0)
    	{
    		return batchRowDeleteButtons.get(0);
    	}
    	return null;
    }
    public boolean isDeleteAlertFooterAvailable()
    {
    	return deleteAlertFooter.isDisplayed();
    }
    
    public void deleteConfirmNoClick() {
    	ExpectedConditions.elementToBeClickable(deleteConfirmNo);
    	deleteConfirmNo.click();
    }
    
    public void deleteConfirmYesClick() throws InterruptedException {
    	deleteConfirmYes.click();	
    	Thread.sleep(1000);
    }
    
    
 // _________Edit Batch______________________ 
   
  
  
 
    public WebElement getEditButtonFromDataRow()
    {
    	if(batchRowEditButtons.size() > 0)
    	{
    		return batchRowEditButtons.get(0);
    	}
    	return null;
    }
    
    public void editBatchFields(String description , String classes) throws InterruptedException
    {
    	popupBatchDescription.clear();
   		popupBatchDescription.sendKeys(description);
    	activeRadioBtn.click();    	 
    	popupBatchNumberOfClasses.clear();
   		popupBatchNumberOfClasses.sendKeys(classes);
   		batchSaveBtn.click();
   		Thread.sleep(1000);
	} 
    
    
    

       
    
 // _________Delete Multiple Batches______________________
    public void clickSingleCheckbox(){
    single_checkox.click();
    }
    public void clickMultipleCheckbox(){
    single_checkox.click();
    checkox_row2.click();
    }
    public void deleteMultipleBatches() throws InterruptedException {
    if(delete_multiple_button.isEnabled())
    {
    System.out.println("Multiple Delete button enabled");
    delete_multiple_button.click();
    Thread.sleep(1000);
    deleteConfirmYes.click();
    }
    }
    
    
    
    
    
    
    
    
    
 
    
    
}

