
  package StepDefinitions;
  
  import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
  
  import com.Base.BaseClass; 
  
  import   com.PageObject.MultipleDeletePage;
import com.Utils.ReUsableMethods;

import io.cucumber.java.en.Given; import io.cucumber.java.en.Then; import
  io.cucumber.java.en.When;
  
  public class MultipleDeletePageSteps extends BaseClass{
  
  MultipleDeletePage MD_Page=new MultipleDeletePage(driver);
  
  
  @Given("Admin is in Manage Program page") public void
  admin_is_in_manage_program_page() { String actualTitle=driver.getTitle();
  String expectedTitle="LMS"; Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @When("Admin clicks any checkbox in the data table") public void
  admin_clicks_any_checkbox_in_the_data_table() {
  MD_Page.clickSingleCheckbox(); }
  
  @Then("Admin should see common delete option enabled under header Manage Program"
  ) public void
  admin_should_see_common_delete_option_enabled_under_header_manage_program() {
  MD_Page.deleteButtonEnabled(); }
  
  
  @When("Admin clicks on single checkbox in the data table")
  public void admin_clicks_on_single_checkbox_in_the_data_table() 
  {
      
  }
  
  @Given("Admin is on Confirm Deletion alert") public void
  admin_is_on_confirm_deletion_alert() throws InterruptedException {
  //MD_Page.clickSingleCheckbox(); 
  Thread.sleep(2000);
  MD_Page.clickonMultipleDeleteButton();
  //MD_Page.clickNoButton();
  
  }
  
//  
//  @Given("Admin is on Manage Program Page")
//  public void admin_is_on_manage_program_page() {
//     
//  }
  
  
  @Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table"
  ) public void
  admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table
  () 
  {
  System.out.println("deleted");
  }
  
  @When("Admin clicks <No> button on the alert") 
  public void  admin_clicks_no_button_on_the_alert() throws InterruptedException {
  MD_Page.click_NoButton(); 
  System.out.println("no button selected");
  Thread.sleep(2000);
  MD_Page.uncheckSingleCheckBOx();
  
  }
  
  @Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
  public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table
  () 
  {
	  String actualTitle=driver.getTitle();
		String expectedTitle="LMS";
		Assert.assertEquals(actualTitle, expectedTitle);
  }
  
//  @Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table"
//  )
//  public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table
//  () {
//  
//  }
  
  

@When("Admin clicks on multiple checkbox in the data table")
public void admin_clicks_on_multiple_checkbox_in_the_data_table() 
{
	 MD_Page.clicMultipleleCheckboxes();
}
  

  
  @When("Admin clicks delete button under header after selecting multiple checkboxes in the data table")
  public void admin_clicks_delete_button_under_header_after_selecting_multiple_checkboxes_in_the_data_table() throws InterruptedException {
	 
	  //MD_Page.deleteButtonEnabled();
	  MD_Page.clickonMultipleDeleteButton();
	   }
//  @When("User clicks <YES> button on the alert")
//  public void user_clicks_yes_button_on_the_alert() {
//      MD_Page.clickOnYesButton();
//  }
  
  @When("Admin click on <YES> button on the alert")
  public void admin_click_on_yes_button_on_the_alert() throws InterruptedException {
	//MD_Page.clickOnYesButton();
	  //MD_Page.click_NoButton();
  }
  
  @Then("When Admin clicks on multiple checkbox in the data table")
  public void when_admin_clicks_on_multiple_checkbox_in_the_data_table() {
	  MD_Page.clicMultipleleCheckboxes();
  }
  
//  @When(" User Clicks on <No> button on the alert") 
//  public void  user_clicks_on_no_button_on_the_alert() throws InterruptedException {
//	  
//	
//  MD_Page.click_NoButton(); 
//  MD_Page.clicMultipleleCheckboxes();
//  System.out.println("no button selected");
//  
//  }
  
  

@When("User Clicks on <No> button on the alert")
public void user_clicks_on_no_button_on_the_alert() throws InterruptedException {
	MD_Page.click_NoButton(); 
	  MD_Page.clicMultipleleCheckboxes();
	  System.out.println("no button selected");
	  Thread.sleep(2000);
	  MD_Page.uncheckMultipleleCheckBOx();
}
  
  }
 