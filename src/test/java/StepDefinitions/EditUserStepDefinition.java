package StepDefinitions;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.Base.BaseClass;
import com.PageObject.AddNewUserpom;
import com.PageObject.EditUserPom;

import com.PageObject.UserPageValidationpom;
import com.Utils.Excel;
import com.Utils.Logger;
import com.Utils.ReUsableMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditUserStepDefinition extends BaseClass {
	EditUserPom editUserpom;
	public EditUserStepDefinition() {
		editUserpom = new EditUserPom(driver); 
  }
	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
		Logger.info("Admin is in Mange user Page");
		ReUsableMethods.waitForElementToBeVisible(driver, editUserpom.getUserBtn());
		editUserpom.getUserBtn().click();
		
		
	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() throws InvalidFormatException {
		Logger.info("Admin click on  edit user Page");
		List<Map<String, String>> testData;
		try {
		    testData = Excel.getData("src\\test\\resources\\DataFiles\\Team16_TesingCru.xlsx", "User");
		    System.out.println("Excel Data: " + testData);
		} catch (IOException e) {
		    e.printStackTrace();
		    return;
		}
		if (testData.isEmpty()) {
	        System.out.println("No test data found in the Excel sheet.");
	        return;
	    }
		
		for (Map<String, String> testDataMap : testData) {
			editUserpom.getMangeUserSearch().sendKeys(testDataMap.get("EditUser"));
		}
		ReUsableMethods.waitForElementToBeVisible(driver, editUserpom.EditIcon);
		editUserpom.EditIcon.click();
	}

	@Then("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears() {
		Logger.info("A new pop up with User details appears");
		
	}

	@Given("Admin is on User details pop up")
	public void admin_is_on_user_details_pop_up() {
		Logger.info("Admin is on User details pop up");
		
		
	}

	@When("Update the fields with valid data and click submit")
	public void update_the_fields_with_valid_data_and_click_submit() throws InvalidFormatException {
		List<Map<String, String>> testData;
		try {
		    testData = Excel.getData("src\\\\test\\\\resources\\\\DataFiles\\\\Team16_TestingCru.xlsx", "User");
		    System.out.println("Excel Data: " + testData);
		} catch (IOException e) {
		    e.printStackTrace();
		    return;
		}
		if (testData.isEmpty()) {
	        System.out.println("No test data found in the Excel sheet.");
	        return;
	    }
		
		for (Map<String, String> testDataMap : testData) {
			editUserpom.getUpdateEmailaddress().sendKeys(testDataMap.get("UpdateEmail"));
			editUserpom.getUpdateLastNameField().sendKeys(testDataMap.get("UpdateLastName"));
			editUserpom.getUpdateLinkedinUrlField().sendKeys(testDataMap.get("UpdatelinkedIn"));
			editUserpom.getUpdaterMiddleNameField().sendKeys(testDataMap.get("UpdateMiddleName"));
			
		}
		ReUsableMethods.scrollToElement(driver, editUserpom.Submit());
		editUserpom.Submit().click();
	}

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
		
	}

	@When("Update the fields with invalid values and click submit")
	public void update_the_fields_with_invalid_values_and_click_submit() {
		
		
	}

	@Then("Admin should get Error message")
	public void admin_should_get_error_message() {
		Logger.info("Admin should get Error message");
	}

	@When("Update the mandatory fields with valid values and click submit")
	public void update_the_mandatory_fields_with_valid_values_and_click_submit() {
	    
	}

	@When("Update the optional fields with valid values and click submit")
	public void update_the_optional_fields_with_valid_values_and_click_submit() {
	    
	}

	@When("Admin enters only numbers or special char in the text fields")
	public void admin_enters_only_numbers_or_special_char_in_the_text_fields() {
	    
	}

	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
	    
	}

	@Then("Admin can see the User details popup disappears and can see nothing changed for particular User")
	public void admin_can_see_the_user_details_popup_disappears_and_can_see_nothing_changed_for_particular_user() {
	    
	}

}
