package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.Base.BaseClass;
import com.PageObject.LoginPage;
import com.PageObject.EditProgramDetailsPage;
import com.Utils.Excel;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditProgrameDetailStep extends BaseClass
{
	//WebDriver driver=new ChromeDriver();
	EditProgramDetailsPage pg=new EditProgramDetailsPage(driver);
	
	
	//ExcelReader reader = new ExcelReader();
	@Given("Admin is on Manage Program Page")
	public void admin_is_on_program_page()
	{
	String actualTitle=driver.getTitle();
	String expectedTitle="LMS";
	Assert.assertEquals(actualTitle, expectedTitle);
	}
	public void admin_is_on_manage_program_page() 
	{
	    pg.verifyPageTitle();
	    
	}

	@When("Admin clicks Edit button on the data table for any row")
	public void admin_clicks_edit_button_on_the_data_table_for_any_row() {
		pg.clickEditButton();	
	    
	}

	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() 
	{
	   pg.verifyPopUpWindow();
	}

	@Given("Admin is on Program Details Popup window to Edit")
	public void admin_is_on_program_details_popup_window_to_edit() {
	    
	}
	@When("Admin edits the Name {string}  and {int} column and clicks save button")
	public void admin_edits_the_name_and_column_and_clicks_save_button(String sheetname, Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
			//Excel xl = new Excel();
		//pg.clickEditButton();
		String data=	pg.xlDataReader(sheetname, rownumber,"program_name");
		pg.editProgramName(data);

	    
	   
	}
	
   @Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String string) 
   {
	    pg.verifySuccessMessage(string);
	}
	
	
	@When("Admin edits the Description {string} and {int} and clicks save button")
	public void admin_edits_the_description_and_and_clicks_save_button(String program_description_sheet, Integer rownum) throws InvalidFormatException, IOException, InterruptedException {
		pg.clickEditButton();
		String program_Desc=	pg.xlDataReader(program_description_sheet, rownum,"programDescription");
		pg.editProgramDescription(program_Desc);
	}
	@Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String string) {
	  
		pg.verifySuccessMessage(string);
	    
	  System.out.println("updated successfully");
	}

	@When("Admin changes the Status and clicks save button")
	public void admin_changes_the_status_and_clicks_save_button() throws InterruptedException {
		//pg.clickEditButton();
		pg.clickonRadioButton();
		Thread.sleep(1000);
		pg.saveProgramme();
	    
	}

	@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) {
	    
	     pg.verifySuccessMessage(string);
	}
	
	@When("Admin enters only numbers or special char in name  {string} and {int} and clicks save button and desc column")
	
	public void admin_enters_only_numbers_or_special_char_in_name_and_and_clicks_save_button_and_desc_column
	(String validationsheet, Integer rownum) throws InvalidFormatException, IOException, InterruptedException 
	{
		pg.clickEditButton();
		String program_Desc=	pg.xlDataReader(validationsheet, rownum,"invalidValue");
		pg.verifyInvalidDataMessage(program_Desc);
//		//pg.cancel();
		
   }

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() 
	{
	   pg.verifyErrorMsg();
	 	   
	   }
	@Then("Click Cancel button")
	public void click_cancel_button() 
	{
		pg.closePopUpWindow();
	}
	


@When("Admin click Cancel button on edit popup")
public void admin_click_cancel_button_on_edit_popup() {
    pg.closePopUpWindow();
}

	@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() 
	{
	    
	}

	@When("Admin clicks <Save>button on edit popup")
	public void admin_clicks_save_button_on_edit_popup() 
	{
	  pg.clickEditButton();
	  pg.saveProgramme();
	}

	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String string) 
	{
	   pg.verifySuccessMessage(string);
	}
}
