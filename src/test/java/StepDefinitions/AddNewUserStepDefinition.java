package StepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Base.BaseClass;
import com.PageObject.AddNewUserpom;
import com.Utils.Excel;
import com.Utils.ReUsableMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class AddNewUserStepDefinition extends BaseClass {
	private static Logger logger = LogManager.getLogger("AddNewUserStepDefinition.java");
	AddNewUserpom AddNewUserpom;
	public AddNewUserStepDefinition() {
	AddNewUserpom = new AddNewUserpom(driver); 
  }
	@Then("Admin is in Manage user Page")
	public void admin_is_in_manage_user_page() {
		logger.info("Admin is in manager user");
	}

	@Given("Admin is in Manage User Page")
	public void admin_is_in_manage_user_page1() {
		logger.info("Admin is in manager user");
	}

	@When("Admin clicks  Add New User button")
	public void admin_clicks_add_new_user_button() {
		logger.info("Admin click ADD NEW USER user");
		ReUsableMethods.scrollToElement(driver,AddNewUserpom.AddNewuserBtn);
		ReUsableMethods.waitForElementToBeClickable(driver, AddNewUserpom.AddNewuserBtn);
		AddNewUserpom.AddNewuserBtn.click();
		
	}
	
	@Then("Admin should see pop up heading {string}")
	public void admin_should_see_pop_up_heading(String expectedHeading) {
		
		logger.info("Admin shouls see Heading"+expectedHeading);
		WebElement UserpopupHeader=AddNewUserpom.UserPopUpHeader;
		String popupheader = UserpopupHeader.getAttribute("header");
		assertTrue(popupheader.equals(expectedHeading), "Pop-up heading does not match");
		AddNewUserpom.close.click();
	}
	@Then("Admin should see pop up open for user details with First Name,Middle name, Last Name, Location, phone, email, linkedin url, User Role, Role status, visa status,Undergraduate, postgraduate,time zone ,user comments and user fields along with Cancel , Submit and close buttons")
	public void admin_should_see_pop_up_open_for_user_details_with_first_name_middle_name_last_name_location_phone_email_linkedin_url_user_role_role_status_visa_status_undergraduate_postgraduate_time_zone_user_comments_and_user_fields_along_with_cancel_submit_and_close_buttons() {
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.UserFirstNamePlaceHolder), "First Name field Name is not displayed");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.UserMiddlenamePlaceHolder),"Middle name field Name is not diplsyed ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.UserLastnamePlaceHolder),"LastName feild Name is not displyed");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.UserLocationPlaceHolder),"Location field Name is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.UserPhonenoPlaceHolder),"PhoneNumber field Name is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.UserLinkedInUrlPlaceHolder),"LinkedInUrl field Name is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.EmailaddressPlaceHolder),"Email field Name is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.UserRolestatusLabel),"UserRolestatusLabel is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.UserVisaStatuslabel),"UserVisaStatuslabel is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.UnderGraduatePlaceHolder),"UnderGraduatePlaceHolder is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.PostGraduatePlaceHolder),"PostGraduatePlaceHolder is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.TimeZonePlaceHolder),"TimeZonePlaceHolder is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.UserCommentsPlaceHolder),"UserCommentsPlaceHolder is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.Submit),"Submit is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.Cancel),"Cancel is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.close),"close is not displaying ");
		AddNewUserpom.close.click();
	}
	@Then("Admin should see  text boxes for the fields First Name, Middle name, Last Name, Location,phone, email, linkedin url, Undergraduate, postgraduate,time zone ,user comments\"")
	public void admin_should_see_text_boxes_for_the_fields_first_name_middle_name_last_name_location_phone_email_linkedin_url_undergraduate_postgraduate_time_zone_user_comments() {
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getFirstNameInputField()), "firstNameInputField is not displayed");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getUserMiddleNameField()),"Middle name field Name is not diplsyed ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getUserLastNameField()),"LastName feild Name is not displyed");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getUserLocationField()),"Location field Name is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getUserPhoneNumberField()),"PhoneNumber field Name is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getUserLinkedinUrlField()),"LinkedInUrl field Name is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getEmailaddress()),"Email field Name is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getUnderGraduate()),"UnderGraduatePlaceHolder is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getPostGraduate()),"PostGraduatePlaceHolder is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getTimeZone()),"TimeZonePlaceHolder is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getUserComments()),"UserCommentsPlaceHolder is not displaying ");
		AddNewUserpom.close.click();
	}

	@Then("Admin should see drop downs for the fields User Role,Role status, visa status on user details pop up")
	public void admin_should_see_drop_downs_for_the_fields_user_role_role_status_visa_status_on_user_details_pop_up() {
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getUserRoleDropdown()),"UserRoleDropdown is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getUserRolestatusDropdown()),"UserRoleStatusDropdown is not displaying ");
		assertTrue(ReUsableMethods.isElementDisplayed(driver, AddNewUserpom.getUserVisaStatusDropdown()),"UserVisaStatusDropdown is not displaying ");
		AddNewUserpom.getClose().click();
	}

	@Given("Admin is on  User details pop up")
	public void admin_is_on_user_details_pop_up() {
		ReUsableMethods.scrollToElement(driver,AddNewUserpom.AddNewuserBtn);
		ReUsableMethods.waitForElementToBeClickable(driver, AddNewUserpom.AddNewuserBtn);
		AddNewUserpom.AddNewuserBtn.click();
	}

	@When("Admin enters mandatory fields in the form and clicks on submit button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_submit_button() throws InvalidFormatException {
		List<Map<String, String>> testData;
		try {
		    testData = Excel.getData("C:\\Users\\Ranji\\OneDrive\\Documents\\Team16_TestingCru.xlsx", "User");
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
			 System.out.println("Test Data: " + testDataMap);
	        AddNewUserpom addNewUserPage = new AddNewUserpom(driver);
	        addNewUserPage.getFirstNameInputField().sendKeys(testDataMap.get("FirstName"));
	        addNewUserPage.getUserMiddleNameField().sendKeys(testDataMap.get("MiddleName"));
	        addNewUserPage.getUserLastNameField().sendKeys(testDataMap.get("LastName"));
	        addNewUserPage.getUserLinkedinUrlField().sendKeys(testDataMap.get("LinkedInUrl"));
	        addNewUserPage.getUserLocationField().sendKeys(testDataMap.get("Location"));  
	        String phoneNumberString = testDataMap.get("PhoneNumber").replaceAll("[^0-9]", "");
	        long phoneNumber = Long.parseLong(phoneNumberString);
	        addNewUserPage.getUserPhoneNumberField().sendKeys(String.valueOf(phoneNumber));
	        
	        //addNewUserPage.getUserPhoneNumberField().sendKeys(testDataMap.get("PhoneNumber"));
	        addNewUserPage.getEmailaddress().sendKeys(testDataMap.get("Email"));
	        addNewUserPage.getUnderGraduate().sendKeys(testDataMap.get("UG"));
	        addNewUserPage.getPostGraduate().sendKeys(testDataMap.get("PG"));
	        addNewUserPage.getTimeZone().sendKeys(testDataMap.get("TimeZone"));
	     
	        addNewUserPage.getUserRoleDropdown().click(); 
	        addNewUserPage.selectUserRole(testDataMap.get("UserRole"));
	        addNewUserPage.getUserRolestatusDropdown().click(); 
	        addNewUserPage.selectUserStatus(testDataMap.get("RoleStatus"));
	        addNewUserPage.getUserRolestatusDropdown().click(); 
	        addNewUserPage.selectVisaStatus(testDataMap.get("VisaStatus"));
	        addNewUserPage.getUserVisaStatusDropdown().click(); 
	        addNewUserPage.getUserComments().sendKeys(testDataMap.get("Comments"));
	        addNewUserPage.getSubmit().click();
	    }

		//AddNewUserpom.close.click();
	}

	
	@Then("Admin gets message User added Successfully")
	public void admin_gets_message_user_added_successfully() {
	    
	}
	@Given("Admin is on  User details pop up window")
	public void admin_is_on_user_details_pop_up_window() {
		//AddNewUserpom.close.click();
	}

	@When("Admin skips to add value in mandatory field")
	public void admin_skips_to_add_value_in_mandatory_field() {
		ReUsableMethods.waitForElementToBeClickable(driver, AddNewUserpom.Submit);
		//AddNewUserpom.Submit.click();
		
	}

	@Then("Admin should see error message below the test field and the field will be highlighed in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() throws InterruptedException {
		 AddNewUserpom addNewUserPage = new AddNewUserpom(driver);
		List<WebElement> inputFields = Arrays.asList(
		        addNewUserPage.getFirstNameInputField(),
		        addNewUserPage.getUserMiddleNameField(),
		        addNewUserPage.getUserLastNameField(),
		        addNewUserPage.getUserLocationField(),
		        addNewUserPage.getUserPhoneNumberField(),
		        addNewUserPage.getUserLinkedinUrlField(),
		        addNewUserPage.getEmailaddress(),
		        addNewUserPage.getUnderGraduate(),
		        addNewUserPage.getPostGraduate(),
		        addNewUserPage.getTimeZone(),
		        addNewUserPage.getUserComments()
		    );
		List<WebElement> errorMessages = Arrays.asList(
		        driver.findElement(By.xpath("//*[@id='mat-error-190']")),
		        driver.findElement(By.xpath("//*[@id='mat-error-191']")),
		        driver.findElement(By.xpath("//*[@id='mat-error-192']")),
		        driver.findElement(By.xpath("//*[@id='mat-error-193']")),
		        driver.findElement(By.xpath("//*[@id='mat-error-194']")),
		        driver.findElement(By.xpath("//*[@id='mat-error-195']")),
		        driver.findElement(By.xpath("//*[@id='mat-error-196']")),
		        driver.findElement(By.xpath("//*[@id='mat-error-197']")),
		        driver.findElement(By.xpath("//*[@id='mat-error-198']")),
		        driver.findElement(By.xpath("//*[@id='mat-error-199']")),
		        driver.findElement(By.xpath("//*[@id='mat-error-200']"))
		    );
		    for (int i = 0; i < errorMessages.size(); i++) {
		        WebElement errorMessage = errorMessages.get(i);
		        WebElement inputField = inputFields.get(i);
		        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed for field: " + inputField.getAttribute("id"));
		        String inputFieldBorderColor = inputField.getCssValue("border-color");
		        assertEquals(inputFieldBorderColor, "rgb(255, 0, 0)", "Input field is not highlighted in red color for field: " + inputField.getAttribute("id"));
		    }
		    Thread.sleep(2000);
		    AddNewUserpom.Cancel.click();
	}

	@When("Admin enters invalid data in all of the  fields in the form and clicks on submit button")
	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_submit_button() throws InterruptedException {
		/*Thread.sleep(2000);
	    AddNewUserpom.Cancel.click();
		AddNewUserpom.AddNewuserBtn.click();
		ReUsableMethods.waitForElementToBeClickable(driver, AddNewUserpom.Submit);
		AddNewUserpom.Submit.click();*/
	}

	@Then("Admin gets error message and user is not created")
	public void admin_gets_error_message_and_user_is_not_created() {
		logger.info("Admin gets error message and user is not created");
	}

	@When("Admin clicks on submit button without entering data")
	public void admin_clicks_on_submit_button_without_entering_data() {
		AddNewUserpom.AddNewuserBtn.click();
		ReUsableMethods.waitForElementToBeClickable(driver, AddNewUserpom.Submit);
		AddNewUserpom.Submit.click();
	}

	@Then("user wont be created and Admin gets error message")
	public void user_wont_be_created_and_admin_gets_error_message() {
		logger.info("Admin gets error message and user is not created");
	}

	@When("Admin clicks Cancel or Close\\(X) Icon on User Details form")
	public void admin_clicks_cancel_or_close_x_icon_on_user_details_form() {
	    AddNewUserpom.getClose().click();
	}

	@Then("User Details popup window should be closed without saving")
	public void user_details_popup_window_should_be_closed_without_saving() {
		logger.info("User Details popup window should be closed without saving");
	}

	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		logger.info("Admin clicks Cancel button");
	}

	@Then("Admin can see the User details popup disappears without adding any user")
	public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() {
		logger.info("Admin can see the User details popup disappears without adding any user");
	}

	@When("Fill in all the fields with valid values and click submit")
	public void fill_in_all_the_fields_with_valid_values_and_click_submit() {
	    
	}

	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {
	    
	}

}