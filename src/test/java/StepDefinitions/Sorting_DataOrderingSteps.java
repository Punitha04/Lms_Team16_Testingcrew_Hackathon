package StepDefinitions;

import com.Base.BaseClass;
import com.PageObject.Sorting_DataOrdering;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Sorting_DataOrderingSteps extends BaseClass
{
	
	String order;
	
	Sorting_DataOrdering sortData=new Sorting_DataOrdering(driver);
	
	@Given("Admin is on Manage Program page")
	public void admin_is_on_manage_program_page() 
	{
		
	}

	@When("Admin clicks the sort icon of program name column")
	public void admin_clicks_the_sort_icon_of_program_name_column() throws InterruptedException
	{
		sortData.clickOnProgramName();
	}
	

   @Then("The data get sorted on the table based on the program name column values in descending order")
    public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() 
   {
    
	   sortData.veryfyDataSorted(order);
     }

	@Then("The data get sorted on the table based on the program name column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() 
	{
	   System.out.println("data is in acending order");
	}

	@Given("The data is in the ascending order on the table based on Program Name column")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column() {
		 System.out.println("data is in acending order");
	}

	@When("Admin clicks the sort icon of program Desc column")
	public void admin_clicks_the_sort_icon_of_program_desc_column() throws InterruptedException {
		
		
		Thread.sleep(2000);
		sortData.clickOnProgramDescription();
	   
	}

	@Then("The data get sorted on the table based on the program description column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() 
	{
	    System.out.println("data is sorted");
	}

	@Given("The data is in the ascending order on the table based on Program Description column")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column() 
	{
	    System.out.println("data is in ascending order");
	}

	@Then("The data get sorted on the table based on the program description column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() {
	  
	}

	@When("Admin clicks the sort icon of program Status column")
	public void admin_clicks_the_sort_icon_of_program_status_column() {
		sortData.clickOnProgramStatus();
	}

	@Then("The data get sorted on the table based on the program status column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order()
	{
	    System.out.println("data get sorted on the table based on the program status");
	}

	@Given("The data is in the ascending order on the table based on Program Status column")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_status_column() 
	{
	    System.out.println("data is in asecending order based on program status");
	}

	@Then("The data get sorted on the table based on the program status column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() {
	    
		System.out.println("data is not in descending order");
		
	}}



