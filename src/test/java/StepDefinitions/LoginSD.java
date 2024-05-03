package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.Base.BaseClass;
import com.PageObject.LoginPage;
import com.Utils.Excel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSD {
	
	public static WebDriver driver;
	String invalid_url;
	LoginPage login;
	
	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() throws IOException, InterruptedException {
		Thread.sleep(3000);
		driver = BaseClass.launchApp();
		
	}
	@When("Admin enter valid credentials  and clicks login button from {string} and {int}")
	public void admin_enter_valid_credentials_and_clicks_login_button_from_and(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		System.out.println("I am in When");
		Excel xl = new Excel();
		List<Map<String,String>> testData= xl.getData("src\\test\\resources\\DataFiles\\Team16_TestingCru.xlsx", SheetName);
		//List<Map<String,String>> testData= xl.getData("C://Users//Ranji//OneDrive//Documents//Team16_TesingCru.xlsx", SheetName);
		System.out.println("Value in testData" +testData);
		String usrnme=testData.get(0).get("User");
		String pswd = testData.get(0).get("Password");
		System.out.println("Username from excel is " +usrnme);
		System.out.println("Password from excel is " +pswd);
	    Thread.sleep(3000);
	    LoginPage login = new LoginPage(driver);
		login.loginValidCredential(usrnme, pswd);
	}


	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() throws InterruptedException
	{
		
		  Thread.sleep(5000); 
		  LoginPage login = new LoginPage(driver);
		  Assert.assertEquals( "Manage Program",login.managepgm());
		 System.out.println(login.managepgm());
		 	
		
	}
	
	
		
}