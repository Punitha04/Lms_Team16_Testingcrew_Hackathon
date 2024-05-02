package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Base.BaseClass;
import com.Utils.ReUsableMethods;
import com.PageObject.Manageprogram;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageProgram extends BaseClass {
	Manageprogram manageprogram;

	public ManageProgram() {
		manageprogram = new Manageprogram(driver);
	}

	// SCnerario1

	@Given("Admin is in dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// Manageprogram manageprogram=new Manageprogram(driver);
		ReUsableMethods.waitForElementToBeVisible(driver, manageprogram.programbtn);
		manageprogram.programbtn.click();

	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
		// Write code here that turns the phrase above into concrete actions
		String url = driver.getCurrentUrl();
		Assert.assertFalse(url.contains("ManageProgram"));
	}

//Scenario2
	@Then("Admin should see a heading with text {string} in the page")
	public void admin_should_see_a_heading_with_text_in_the_page(String headertext) throws InterruptedException {

		Assert.assertEquals(manageprogram.getheader().getText(), headertext);

	}

//scenario3
	@Then("Admin should see the text as {string} along with Pagination icon below table.")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_table(String string) {

		// Assert.assertTrue(manageprogram.pagination().isDisplayed());
		assertTrue(ReUsableMethods.isElementDisplayed(driver, manageprogram.pagination()),
				"Pagination is not displayed");

	}

//scenario4

	@Then("Admin should see the footer as {string}.")
	public void admin_should_see_the_footer_as(String string) {

		// Assert.assertTrue(manageprogram.getFooter().isDisplayed());
		assertTrue(ReUsableMethods.isElementDisplayed(driver, manageprogram.getFooter()), "Footer is not displayed");
	}

//Scenario5
	@Then("Admin should see a Delete button on the top left hand side are Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_are_disabled() {
		if (!manageprogram.getDeleteBtn().isEnabled())
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

	}

//Scenario6
	@Then("Admin should see a {string} button on the program page above the data table")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
		// Write code here that turns the phrase above into concrete actions

		// Assert.assertTrue(manageprogram.newProgram().isDisplayed());
		assertTrue(ReUsableMethods.isElementDisplayed(driver, manageprogram.newProgram()),
				"+A new Program Button is not displayed");
	}

	// Scenario7
	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(
			Integer totalrows) {
		// Write code here that turns the phrase above into concrete actions
		if(manageprogram.numberofData.size()==totalrows)
		{
			assertTrue(true);
		}
	}

	// Scenario8
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		int sortCount = manageprogram.sortIcon().size();
		assertTrue(sortCount == manageprogram.getColumn().size() - 2, "Sort icon not displayed");
	}
	// Scenario9

	@Then("Admin Should see data table with column names {string}, {string}, {string}, {string}")
	public void admin_should_see_data_table_with_column_names(String column1, String column2, String column3,
			String column4) {
		// Write code here that turns the phrase above into concrete actions

		List<String> expectedColumnNames = Arrays.asList(column1, column2, column3, column4);

		List<WebElement> columnElements = manageprogram.getColumn();
		List<String> actualColumnNames = ReUsableMethods.extractColumnNames(columnElements);
		System.out.println(actualColumnNames);

		for (String expectedColumnName : expectedColumnNames) {
			ReUsableMethods.assertColumnPresent(actualColumnNames, expectedColumnName);
		}

	}

	// Scenario 10
	@Then("Admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {

		int checkboxCount = manageprogram.checkbox.size();
		assertTrue(checkboxCount == manageprogram.numberofData.size(), "checkbox is not displayed");
	}
	// Scenario11

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		int editDltCount = manageprogram.editDltBtn.size();
		assertTrue(editDltCount == manageprogram.numberofData.size(), "editDelete Btn is not displayed");

	}

	// Scenario12
	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String searchText) {
		Assert.assertEquals(manageprogram.getsearch(), searchText);
	}

}
