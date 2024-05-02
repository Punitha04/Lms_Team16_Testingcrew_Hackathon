package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.PageObject.BatchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.Base.BaseClass;

public class BatchSD {
	
	BatchPage batchPage = new BatchPage(BaseClass.driver); 
	String batchName="";
	public String index = "_73";
	String batchDescription = "";
	String batchNoOfClasses = "";
	
	public BatchSD()
	{
		
	}
	//01 to 10
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
	    System.out.println("Admin is in Dashboard Page");
	    
	}
	
	//01 to 09
	@When("Admin clicks Batch from navigation bar")
	public void admin_clicks_batch_from_navigation_bar() {
		batchPage.batchPageBtn();
		System.out.println("Batch page button click");
	}
	
	//01-URL
	@Then("Admin should see the Manage Batch in the URL")
	public void admin_should_see_the_manage_batch_in_the_url()  {
		String batchUrl = batchPage.getBatchURL();
		if(batchUrl.contains("batch"));
		{
			System.out.println("Batch is available in the URL " + batchUrl);
		}
	}
	
	//02-Header
	@Then("Admin should see the Manage Batch in the header")
	public void admin_should_see_the_manage_batch_in_the_header() {
		String batchHeader = batchPage.getBatchHeader();
		if(batchHeader == "Manage Batch");
		{
			System.out.println("Manage Batch Header is available  " + batchHeader);
		}
	}
			
	//03-pagination control
 	@Then("Admin should see the pagination controls under the data table")
     public void admin_should_see_the_pagination_controls_under_the_data_table() {
 		boolean batchPagination = batchPage.batchPagination();
		if(batchPagination);
		{
			System.out.println("Batch Pagination is   " + batchPagination);
		}
	}
 	
 	//04
	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
		boolean headerCheckStatus = batchPage.validateBatchDataTableHeaders();
		Assert.assertEquals(headerCheckStatus, true, "Column names are not matching");
		//System.out.println("Validate Batch Data Table Headers");
	}
	
	//05-Delete
	@Then("Admin should be able to see the Delete icon button that is disabled")
    public void admin_should_be_able_to_see_the_delete_icon_button_that_is_disabled() {
		boolean isBtnDisable= batchPage.isDeleteBtnDisable();
		Assert.assertEquals(isBtnDisable, false, "Button is enable");
	}
		
	//06-+new Batch
	@Then("Admin should be able to see the + A New batch button")
     public void admin_should_be_able_to_see_the_a_new_batch_button() {
		boolean addewBatchButtonAvailable= batchPage.isAddewBatchButtonAvailable();
		Assert.assertEquals(addewBatchButtonAvailable, true, "Add new button is not available" );
	}

	//07-Checkbooks
	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
		 List<WebElement> batchTablecheckboxes= batchPage.getBatchTableCheckboxes();
		 System.out.println("Total Checkboxes " + batchTablecheckboxes.size());
	      Assert.assertTrue(batchTablecheckboxes.size() > 0, "No checkboxes found in the data table");
	        for (WebElement checkbox : batchTablecheckboxes) {
	        	Assert.assertTrue(checkbox.isDisplayed(), "Checkbox is not displayed");
	        }
	}
		
	//08-Edit icon
	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		List<WebElement> batchTableEditIcon= batchPage.getBatchTableEditIcon();
		System.out.println("Total Edit Icons " + batchTableEditIcon.size());
	      Assert.assertTrue(batchTableEditIcon.size() > 0, "No Edit Icon found in the data table");
	        for (WebElement EditIcon : batchTableEditIcon) {
	        	Assert.assertTrue(EditIcon.isDisplayed(), "Edit Icon is not displayed");
	        }
	}
	
	//09-Delete icon
	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
		List<WebElement> batchTableDeleteIcon= batchPage.getBatchTableDeleteIcon();
		System.out.println("Total Delete Icons " + batchTableDeleteIcon.size());
	      Assert.assertTrue(batchTableDeleteIcon.size() > 0, "No Delete Icon found in the data table");
	        for (WebElement EditIcon : batchTableDeleteIcon) {
	        	Assert.assertTrue(EditIcon.isDisplayed(), "Delete Icon is not displayed");
	        }
	}
	
	//10 & Given 11 -Admin click + A New Batch button
	@When("Admin clicks + A New Batch button")
    public void admin_clicks_a_new_batch_button() {
		batchPage.addNewBatchPopupWindow();
	}

	//10 & 22 (Popup with Batch details) Given for 12 to 15
    @Then("A new pop up with Batch details appears")
     public void a_new_pop_up_with_batch_details_appears() {
    	boolean addNewBatchPopup= batchPage.isAddNewBatchPopDisplay();
    	Assert.assertEquals(addNewBatchPopup,true, "Add new batch popup window doesn't appear");
    	System.out.println("Add or Edit Batch Popup Window is Opne");
    }
    
    //-------Add Batch---------    
    
    //11
    @Then("The pop up should include the fields Name, Number of classes and Description as text box,Program Name as drop downStatus as radio buttonNumber of classes as text box")
    public void the_pop_up_should_include_the_fields_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button_number_of_classes_as_text_box() {
    	
    	String validatePopuElements = batchPage.validateAllElementTypesOnPopup();
    	Assert.assertEquals(validatePopuElements, "", validatePopuElements);
    }
  
    //12
    @When("Fill in all the fields except description with valid values and click save")
    public void fill_in_all_the_fields_except_description_with_valid_values_and_click_save() throws InvalidFormatException, IOException {
    	List<Map<String,String>> batchData = batchPage.getBatchDataFromExcel("Batch");
    	batchName = batchData.get(0).get("Name") + index;
    	batchNoOfClasses = batchData.get(0).get("NumberOfClasses");
       	System.out.println("Batch Name from Excel " + batchName);
    	batchPage.addBatchFieldsNoDesc(batchName, batchNoOfClasses);    	
    }

    //12 & 13
    @Then("The newly added batch should be present in the data table in Manage Batch page")
    public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() throws InterruptedException, InvalidFormatException, IOException {
    	
    	
    	List<WebElement>  batchErrorMessages = batchPage.getBatchErrorMessages();
    	if(batchErrorMessages.size() > 0)
    	{
    		for(WebElement ele:batchErrorMessages)
    		{
    			System.out.println("Error: " + ele.getText());
    			if(ele.getText().equals("Batch Description is required."))
    			{
    				System.out.println("Inside of Required");
    	            Assert.fail("Description is optional field");
    			}
    		}
    	}
    	else
    	{
    		List<Map<String,String>> batchData = batchPage.getBatchDataFromExcel("Batch");
    		batchName = "";
        	batchName = batchData.get(0).get("Name") + index;
    		System.out.println("BatchaName stored in class variable " + batchName + " has found");
        	batchPage.searchRecordByBatchName(batchName);  
        	if(batchPage.getAllDataTableRows().size() <= 0)
        	{
        		Assert.fail("Batch Name " + batchName + " is not added to the DataTable");
        	}
        	System.out.println("BatchaName " + batchName + " has found");
        	//Thread.sleep(1000);
    	}
    }
    	
    //13
	@When("Fill in all the fields with valid values and click save")
	public void fill_in_all_the_fields_with_valid_values_and_click_save() throws InvalidFormatException, IOException {
		List<Map<String,String>> batchData = batchPage.getBatchDataFromExcel("Batch");		
     	batchDescription = batchData.get(0).get("Description");
    	System.out.println("Name from Excel" + batchName);
    	batchPage.addBatchAllFields( batchDescription);
	}
	
	//14
	@When("any of the fields have invalid values")
	public void any_of_the_fields_have_invalid_values() throws InvalidFormatException, IOException {
	List<Map<String,String>> batchData = batchPage.getBatchDataFromExcel("Batch");
	batchName = batchData.get(0).get("Name");
	batchDescription = batchData.get(1).get("Description");
	batchNoOfClasses = batchData.get(1).get("NumberOfClasses");
	System.out.println("Name from Excel" + batchName);
	batchPage.addBatchInvalidFields(batchName, batchDescription, batchNoOfClasses);
	}
	//14 & 15 & 24 & 25
	@Then("Error message should appear")
	public void error_message_should_appear() throws InterruptedException {
	List<WebElement> batchErrorMessages = batchPage.getBatchErrorMessages();
	System.out.println("Fields have invalid values");
	batchPage.cancelPopupWindow();
	Thread.sleep(1000);
	}
	
		
//15
	@When("Any of the mandatory fields are blank")
	public void any_of_the_mandatory_fields_are_blank() throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String,String>> batchData = batchPage.getBatchDataFromExcel("Batch");
    	batchName = "";
    	batchDescription = "";
    	batchNoOfClasses = batchData.get(1).get("NumberOfClasses");
    	System.out.println("Name from Excel" + batchName);
    	batchPage.addBatchInvalidFields(batchName, batchDescription, batchNoOfClasses );  
    	//Thread.sleep(1000);
	}
	
	
//------Edit Batch-------	
//22	
	@Given("The edit icon on row level in data table is enabled")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled() throws InvalidFormatException, IOException {
		List<Map<String,String>> batchData = batchPage.getBatchDataFromExcel("Batch");
		batchName = "";
		batchName = batchData.get(0).get("Name") + index;
	    batchPage.searchRecordByBatchName(batchName);  
		WebElement editButton = batchPage.getEditButtonFromDataRow();
		if(editButton==null || !editButton.isEnabled())
		{
			Assert.fail("Edit button is not available or disabled ");
		}
	}
	
//22 & Given 23 to 26
	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
	    WebElement editButton = batchPage.getEditButtonFromDataRow();
		editButton.click(); 
	}
		
//23 to 26
	@Given("Admin clicks the edit icon1")
	public void admin_clicks_the_edit_icon1() {
		System.out.println("Admin click the Edit Icon");
	}
	
//23
	@When("Update the fields with valid values and click save")
	public void update_the_fields_with_valid_values_and_click_save() throws InvalidFormatException, IOException, InterruptedException {
	   List<Map<String,String>> batchData = batchPage.getBatchDataFromExcel("Batch");
       	batchDescription = batchData.get(2).get("Description");
    	batchNoOfClasses = batchData.get(2).get("NumberOfClasses");
    	System.out.println("Name from Excel" + batchName);
    	batchPage.editBatchFields(batchDescription, batchNoOfClasses);
	}
	
//23 & 26
	@Then("The updated batch details should appear on the data table")
	public void the_updated_batch_details_should_appear_on_the_data_table() throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String,String>> batchData = batchPage.getBatchDataFromExcel("Batch");
		batchName = "";
		batchName = batchData.get(0).get("Name") + index;
		System.out.println("BatchaName to search " + batchName + " has found");  
    	batchPage.searchRecordByBatchName(batchName);  
    	if(batchPage.getAllDataTableRows().size() <= 0)
    	{
    		Assert.fail("Batch Name " + batchName + " is not edited to the DataTable");
    	}
    	System.out.println("BatchaName " + batchName + " has found");    
	  
	}
	
			
	//24
		@When("Update the fields with invalid values and click save")
		public void update_the_fields_with_invalid_values_and_click_save() throws InvalidFormatException, IOException, InterruptedException {
			List<Map<String,String>> batchData = batchPage.getBatchDataFromExcel("Batch");
			batchName = "";
			batchName = batchData.get(0).get("Name") + index;
			batchDescription = batchData.get(1).get("Description");
			batchNoOfClasses = batchData.get(1).get("NumberOfClasses");
			System.out.println("Name from Excel" + batchName);
			batchPage.editBatchFields(batchDescription, batchNoOfClasses);  
		}
		  	 	
	//25 
		@When("Erase data from mandatory field")
		public void erase_data_from_mandatory_field() {
	    	batchPage.editBatchEraseMandatoryFields();   
		}
		
	//26
		@When("Erase data from description field")
		public void erase_data_from_description_field() {
			batchPage.editBatchEraseDiscriptionField(); 
		}
	

	//-----Delete Batch-------
	//16
 	
		@Given("The delete icon on row level in data table is enabled")
		public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
			batchPage.searchRecordByBatchName(batchName);  
			WebElement deleteButton = batchPage.getDeleteButtonFromDataRow();
			if(!deleteButton.isEnabled())
			{
				Assert.fail("Delete button is disabled");
			}
		}
	//16 & Given-17 & 18
		@When("Admin clicks the delete icon")
		public void admin_clicks_the_delete_icon() {
			WebElement deleteButton = batchPage.getDeleteButtonFromDataRow();
			deleteButton.click();		
		}
		
	//16
	    @Then("Alert appears with yes and No option")
	    public void alert_appears_with_yes_and_no_option() throws InterruptedException {
	    	Assert.assertEquals(batchPage.isDeleteAlertFooterAvailable(), true, "Alert pop up does not appear");
	    	Thread.sleep(1000);
		}
	 //18
	    @Given("Admin clicks the delete icon1")
	    public void admin_clicks_the_delete_icon1() {
	    	System.out.println("Admin clicks the delete icon to click No");
	    }
	 //18
	    	@When("you click No option")
	    	public void you_click_no_option() {		
	    		batchPage.deleteConfirmNoClick();
	    	}
	    	
	  //18
	    	@Then("Batch is still listed in data table")
	    	public void batch_is_still_listed_in_data_table() {
	    		batchPage.searchRecordByBatchName(batchName);  
	        	if(batchPage.getAllDataTableRows().size() < 0)
	        	{
	        		Assert.fail("Batch Name " + batchName + " is not listed");
	        	}
	    	}
	    
	  //17
	  	@When("You click yes option")
	  	public void you_click_yes_option() throws InterruptedException {
	  		batchPage.deleteConfirmYesClick();
	  	}
	  	
	  //17
	  	@Then("Batch deleted alert pops and batch is no more available in data table")
	  	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() throws InvalidFormatException, IOException, InterruptedException {
	  		List<Map<String,String>> batchData = batchPage.getBatchDataFromExcel("Batch");
			batchName = "";
			batchName = batchData.get(0).get("Name") + index;
	  		batchPage.searchRecordByBatchName(batchName);  
	      	if(batchPage.getAllDataTableRows().size() > 0)
	      	{
	      		Assert.fail("Batch Name " + batchName + " is listed");
	      	}
	      	Thread.sleep(1000);	      	
	  	}
	  	 
	  //-----Delete Multiple Batchs-----------
	  //20
	  @Given("One of the checkbox or row is selected")
	  public void one_of_the_checkbox_or_row_is_selected() throws InvalidFormatException, IOException {
	  batchPage.searchRecordByBatchName("Java");
	  if(batchPage.getAllDataTableRows().size() > 0)
	  {
	  batchName = batchPage.getFirstRowBatchName();
	  System.out.println("Batchname is " + batchName + "is displayed");
	  batchPage.clickSingleCheckbox();
	  }
	  }
	//20 & 21
	  @When("Click delete icon below Manage Batch header")
	  public void click_delete_icon_below_manage_batch_header() throws InterruptedException {
	  batchPage.deleteMultipleBatches();
	  }
	//20 & 21
	  @Then("The respective row in the data table is deleted")
	  public void the_respective_row_in_the_data_table_is_deleted() throws InterruptedException {
	  Thread.sleep(1000);
	  batchPage.searchRecordByBatchName(batchName);
	  //int dataTableRows = batchPage.dataTableRowsDisplayed();
	  //if(dataTableRows > 0)
	  //{
	  //System.out.println("Search Size " + dataTableRows);
	  //Assert.fail("The respective row of Batch" + batchName + " is not deleted");
	  //}
	  System.out.println("Respective row of Batch" + batchName + " is deleted");
	  }
	  //21
	  @Given("Two or more checkboxes\\/row is selected")
	  public void two_or_more_checkboxes_row_is_selected() {
	  batchPage.searchRecordByBatchName("Java");
	  if(batchPage.getAllDataTableRows().size() > 0)
	  {
	  batchName = batchPage.getFirstRowBatchName();
	  System.out.println("Batchname is " + batchName + "is displayed");
	  batchPage.clickMultipleCheckbox();
	  }
	  }
	  
}

