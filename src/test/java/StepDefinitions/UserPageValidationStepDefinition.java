package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.BaseClass;
import com.PageObject.UserPageValidationpom;
import com.Utils.ReUsableMethods;

public class UserPageValidationStepDefinition extends BaseClass {
	UserPageValidationpom  userpom;
    public UserPageValidationStepDefinition() {
    	  userpom = new UserPageValidationpom(driver); 
    }
	@Given("Admin is dashboard page after Login")
	public void admin_is_dashboard_page_after_login() {
		
	}
	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_user_from_navigation_bar(String linkText) {
		 ReUsableMethods.waitForElementToBeVisible(driver, userpom.userBtn);
		    userpom.userBtn.click();
	}
	@Then("Admin should see the Manage User in the URL")
	public void admin_should_see_the_manage_user_in_the_url() {
		String currentUrl=driver.getCurrentUrl();
		assertTrue(currentUrl.contains("ManageUser"),"Mange user is not present in the URL");
	}
	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String string) {
		assertTrue(ReUsableMethods.isElementDisplayed(driver, userpom.ManageUserHeader), "Manage User heading is not displayed");
		
	}
	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table. x- starting record number on that page y-ending record number on that page z-Total number of records")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table_x_starting_record_number_on_that_page_y_ending_record_number_on_that_page_z_total_number_of_records() {
		assertTrue(ReUsableMethods.isElementDisplayed(driver, userpom.pagenationText),"Pagination text is not displayed at the bottom");
	}
	@Then("Admin Should see the data table with column names {string}, {string}, {string}, {string}, {string}")
	public void admin_should_see_the_data_table_with_column_names(String columnName1, String columnName2, String columnName3, String columnName4, String columnName5) {
	   // List<String> expectedColumnNames = List.of(columnName1, columnName2, columnName3, columnName4, columnName5);
		List<String> expectedColumnNames = Arrays.asList(columnName1, columnName2, columnName3, columnName4, columnName5);

	    List<WebElement> columnElements = userpom.getColumnElements();
	    List<String> actualColumnNames = ReUsableMethods.extractColumnNames(columnElements);

	    for (String expectedColumnName : expectedColumnNames) {
	        ReUsableMethods.assertColumnPresent(actualColumnNames, expectedColumnName);
	    }
	}
	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		assertTrue(ReUsableMethods.isElementDisplayed(driver, userpom.Deletbutton), "Delete button is not displayed");
	    assertFalse(userpom.Deletbutton.isEnabled(), "Delete button is not disabled");
	    
	}

	@Then("Admin should be able to see the {string} button above the data table")
	public void admin_should_be_able_to_see_the_button_above_the_data_table(String buttonText) {
		WebElement button;
	    switch (buttonText) {
	        case "+ Add New User":
	            button = userpom.AddNewUserBtn;
	        case "+ Assign Student":
	            button = userpom.AssignStudentBtn;
	            break;
	        case "+ Assign Staff":
	            button = userpom.AssignStaffBtn;
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid button text: " + buttonText);
	    }
	    assertNotNull(button, "Button with text '" + buttonText + "' is not found in the user page");
	    assertTrue(button.isDisplayed(), buttonText + " button is not displayed above the data table");
	}
    
    @Then("Admin should be able to see the search text box above the data table")
    public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table() {
    	assertTrue(ReUsableMethods.isElementDisplayed(driver, userpom.UserSearchBar), "SearchBar is not displayed");
	    
    }

    @Then("Admin should see two records displayed on the data table")
    public void admin_should_see_two_records_displayed_on_the_data_table() {
        int actualRecord= userpom.getRecordCount();
        assertTrue(actualRecord>=2,"Record count int the table lessthan 2records");
    }

    @Then("Each row in the data table should have checkbox")
    public void each_row_in_the_data_table_should_have_checkbox() {
    	List<WebElement> checkboxes = userpom.checkboxes();

        assertTrue(checkboxes.size() > 0, "No checkboxes found in the data table");

        for (WebElement checkbox : checkboxes) {
            assertTrue(checkbox.isDisplayed(), "Checkbox is not displayed");
            
        }
    }
    @Then("Each row in the data table should have a {string} icon that is enabled")
    public void each_row_in_the_data_table_should_have_a_icon_that_is_enabled(String string) {
    	List<WebElement> EditandDeletes= userpom.EditandDelete();
        
        assertTrue(EditandDeletes.size() > 0, "No Data found in the data table");
        for (WebElement EditandDelete : EditandDeletes) {
            assertTrue(EditandDelete.isDisplayed(), "EditandDelete is not displayed");
        }
    }
    @When("Admin enters user name into search box")
    public void admin_enters_user_name_into_search_box() {
        
    }

    @Then("Admin should see user displayed with the entered name")
    public void admin_should_see_user_displayed_with_the_entered_name() {
        
    }

    @When("Admin enters the keywords not present in the data table on the Search box")
    public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box() {
        
    }

    @Then("Admin should see zero entries on the data table")
    public void admin_should_see_zero_entries_on_the_data_table() {
        
    }





}
