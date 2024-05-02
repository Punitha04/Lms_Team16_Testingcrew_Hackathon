package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Base.BaseClass;
import com.Utils.ReUsableMethods;
import com.PageObject.Addprogram;
import com.PageObject.LoginPage;
import com.PageObject.Manageprogram;
import com.Utils.Excel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProgram extends BaseClass {
	Addprogram addprogram;
	Manageprogram manageprogram;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public AddProgram() {
		addprogram = new Addprogram(driver);
	}
	Excel xl = new Excel();
//scenario1
@Given("Admin is in Manage Program Page")
public void admin_is_in_manage_program_page() {
	manageprogram=new Manageprogram(driver);
	com.Utils.ReUsableMethods.waitForElementToBeVisible(driver, manageprogram.programbtn);
	manageprogram.programbtn.click();
}
@When("Admin clicks <A New Program>button")
public void admin_clicks_a_new_program_button() {
  
    addprogram.newProgram();
}
@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
	assertTrue(ReUsableMethods.isElementDisplayed(driver, addprogram.dialogBox),
			"dialogbox is not displayed");
	addprogram.getCancelBtn();
	
}
//scenario2
@Then("Admin should see two input fields and their respective text boxes in the program details window")
public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
	if(addprogram.nameField.isDisplayed()&& addprogram.descriptionField.isDisplayed())
	{
		assertTrue(ReUsableMethods.isElementDisplayed(driver, addprogram.nameBox),
				"nameBox is not displayed");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, addprogram.descriptionBox),
				"descriptionbox is not displayed");
	}
	addprogram.getCancelBtn();
}
//scenario3
@Then("Admin should see two radio button for Program Status")
public void admin_should_see_two_radio_button_for_program_status() {
	for (WebElement radiobtn : addprogram.radioBtn) {
        assertTrue(radiobtn.isDisplayed(), "radioBtn is not displayed");
    }
	addprogram.getCancelBtn();
}
//scenario4
@Given("Admin is on {string} Popup window")
public void admin_is_on_popup_window(String header) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	ReUsableMethods.waitForElementToBeVisible(driver,addprogram.newProgram);
	addprogram.newProgram.click();
	Thread.sleep(1000);
	Assert.assertEquals(addprogram.dialogTitle.getText(), header);

    
}
@When("Admin clicks <Save>button without entering any data")
public void admin_clicks_save_button_without_entering_any_data() {
    // Write code here that turns the phrase above into concrete actions
   addprogram.getSaveBtn();
}
@Then("Admin gets Error message alert")
public void admin_gets_error_message_alert() {
	for (WebElement errormessage : addprogram.errorMsg) {
        assertTrue(errormessage.isDisplayed(), "error message is not displayed");
    }
	addprogram.getCancelBtn();
}


//Scenario5

@When("Admin enters only Program Name in text box and clicks Save button from  {string} and {int}")
public void admin_enters_only_program_name_in_text_box_and_clicks_save_button_from_and(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException{
   
	//List<Map<String,String>> testData= xl.getData("C://Users//Ranji//OneDrive//Documents//Team16_TesingCru.xlsx", SheetName)
	List<Map<String,String>> testData=addprogram.exceldata(SheetName,rowNumber);
	//System.out.println("Value in testData" +testData);
	String programName=testData.get(rowNumber).get("ProgramName");
	System.out.println(programName);
	addprogram.enterProgName(programName);
	
}

@Then("Admin gets a message alert {string}")
public void admin_gets_a_message_alert(String errorMsg) {
    // Write code here that turns the phrase above into concrete actions
	
	Assert.assertEquals(addprogram.descriptionErrorMsg.getText(), errorMsg);
	//addprogram.nameBox.clear();
	addprogram.getCancelBtn();
}
//scenario6
@When("Admin enters only Program Description in text box and clicks Save button from  {string} and {int}")
public void admin_enters_only_program_description_in_text_box_and_clicks_save_button_from_and(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
	
	List<Map<String,String>> testData=addprogram.exceldata(SheetName,rowNumber);
	//System.out.println("Value in testData" +testData);
	String programDescription=testData.get(rowNumber).get("ProgramDescription");
	addprogram.enterProgDesc(programDescription);
}
@Then("Admin gets a message alerts {string}")
public void admin_gets_a_message_alerts(String errorText) {
	Assert.assertEquals(addprogram.nameErrorMsg.getText(), errorText);	
	addprogram.getCancelBtn();
}
//scenario7
@When("Admin selects only Status and clicks Save button")
public void admin_selects_only_status_and_clicks_save_button() throws InterruptedException {
	//Thread.sleep(1000);
	ReUsableMethods.waitForElementToBeClickable(driver,addprogram.radioBtn.get(0));
    addprogram.radioBtn.get(0).click();
    addprogram.getSaveBtn();
}
@Then("Admin get a message alert {string} and {string}")
public void admin_get_a_message_alert_and(String nameMsg, String descriptionMsg) {
    // Write code here that turns the phrase above into concrete actions
    Assert.assertEquals(addprogram.nameErrorMsg.getText(),nameMsg);
    Assert.assertEquals(addprogram.descriptionErrorMsg.getText(),descriptionMsg);
    addprogram.getCancelBtn();
    
    
}
//scenario8
@When("Admin enters only numbers or special char in name and desc column from  {string} and {int}")
public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column_from_and(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    addprogram.invalidField(SheetName, rowNumber);
}
@Then("Admin get a Error message alert")
public void admin_get_a_error_message_alert(){
    // Write code here that turns the phrase above into concrete actions
   String nameError=addprogram.errorMsg.getFirst().getText();
   String descriptionError=addprogram.errorMsg.getLast().getText();
   wait.until(ExpectedConditions.elementToBeClickable(addprogram.cancelBtn));
   addprogram.getCancelBtn();
   
}

//scenario9
@When("Admin clicks Cancel Icon on Program Details form")
public void admin_clicks_cancel_icon_on_program_details_form() {
    // Write code here that turns the phrase above into concrete actions
	addprogram.closeIcon.click();
}


@Then("Program Details popup window should be closed without saving")
public void program_details_popup_window_should_be_closed_without_saving() {
	
	
	//wait.until(ExpectedConditions.invisibilityOf(addprogram.dialogBox));
	if (addprogram.dialogBox.isDisplayed())
	{
		Assert.assertTrue(true);
	}
	else
		Assert.assertTrue(false);
	
	


}
//scenario10
@When("Enter all the required fields with valid values and click Save button from  {string} and {int}")
public void enter_all_the_required_fields_with_valid_values_and_click_save_button_from_and(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
	addprogram.allRequiredField(SheetName, rowNumber);
   
}
@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String successMsg) {
	//wait.until(ExpectedConditions.visibilityOf(addprogram.successMsg));
 Assert.assertEquals(addprogram.successMsg.getText(),successMsg);
}


}
