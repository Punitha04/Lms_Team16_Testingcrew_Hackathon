package StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.Base.BaseClass;
import com.PageObject.PaginationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaginationSteps extends BaseClass{
 
	
		//WebDriver driver;
	
	PaginationPage pp=new PaginationPage(driver);
	
	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() throws InterruptedException 
	{
		pp.nextPageLink();
	}

	@Then("Admin should see the Pagination has {string} active link")
	public void admin_should_see_the_pagination_has_active_link(String next) {
	  pp.isnextButtonActiveLink();
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() 
	{
	   pp.clickOnLastButton();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() 
	{
	    pp.clickOnLastButton();
	}

	@Given("Admin is on last page of Program table")
	public void admin_is_on_last_page_of_program_table() 
	{
	    System.out.println("admin is on last page");
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() throws InterruptedException {
		pp.firstPageLink();
	    
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() 
	{
		 System.out.println("admin see all the data"); 
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
		System.out.println("admin is on previus page");
	}

	@When("Admin clicks Start page link")
	public void admin_clicks_start_page_link() throws InterruptedException {
	   pp.startPageLink();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
		pp.startPageLinkDisabled();
	}

}
