package StepDefinitions;

import org.testng.Assert;

import com.Base.BaseClass;
import com.PageObject.SingleDeletePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SingleDeletePageStep extends BaseClass
{
	
	SingleDeletePage deletePage=new SingleDeletePage(driver);
	
//	@When("Admin clicks delete button under header after selecting multiple checkboxes in the data table")
//	public void admin_clicks_delete_button_under_header_after_selecting_multiple_checkboxes_in_the_data_table() {
//	    
//	}
	@When("Admin clicks <Delete> button on the data table for any row")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row() throws InterruptedException 
	{
		deletePage.clickOnDeleteButton();
		Thread.sleep(1000);
		//deletePage.validateCloseIcon();
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String cnfirm) {
	   deletePage.validateDeleteConfirmaWindow(cnfirm);
	   deletePage.clickONCloseIcon();
	   
	}

	@Then("Admin should see a message {string}\"")
	public void admin_should_see_a_message(String popupWith_yesOrNo) 
	{
		deletePage.validateAreYouSureMSG(popupWith_yesOrNo);
		deletePage.clickONCloseIcon();
	}

	@Given("Admin is on Manage Program Page after clicks Program on the navigation bar")
	public void admin_is_on_manage_program_page_after_clicks_program_on_the_navigation_bar() 
	{
		String actualTitle=driver.getTitle();
		String expectedTitle="LMS";
		Assert.assertEquals(actualTitle, expectedTitle);
	    //deletePage.validatePopupWindow();
	}

	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() throws InterruptedException {
		deletePage.clickOnDeleteButton();
		deletePage.validate_deleted_successfully();
		Thread.sleep(2000);
	   
	}

	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String successfullt_del) {
	   deletePage.validateDeleteMSG(successfullt_del);
	}

	@When("Admin clicks <NO> button on the alert")
	public void admin_clicks_no_button_on_the_alert() throws InterruptedException 
	{
		deletePage.clickOnDeleteButton();
		
		Thread.sleep(2000);
		
	    deletePage.validateNoButton();
	    
	    System.out.println("No button functinality executed");
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() 
	{
		 System.out.println("alert disappear without deleting");
	}

	@When("Admin clicks Cancel\\/Close\\(X) Icon on Deletion alert")
	public void admin_clicks_cancel_close_x_icon_on_deletion_alert() throws InterruptedException 
	{
		//deletePage.clickOnDeleteButton();
		//Thread.sleep(2000);
	   deletePage.clickONCloseIcon();
	   
	   
	   
	   System.out.println("clso icon validated ***********************************");
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() 
	{
		System.out.println("no changes ****");
	}
}
