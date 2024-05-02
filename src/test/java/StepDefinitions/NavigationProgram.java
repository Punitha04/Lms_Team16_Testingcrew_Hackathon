package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Base.BaseClass;
import com.Utils.ReUsableMethods;
import com.PageObject.Addprogram;
import com.PageObject.Manageprogram;
import com.PageObject.Navigationprogram;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationProgram extends BaseClass{
	Navigationprogram navigationprogram;
	Manageprogram manageprogram;
	Addprogram addprogram;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));;
	
	public NavigationProgram() {
		navigationprogram = new Navigationprogram(driver);
	}

	@Given("Admin on Manage Program page")
	public void admin_on_manage_program_page() throws InterruptedException {
		addprogram=new Addprogram(driver);
	}
	@When("Admin clicks on {string} on Manage Program page")
	public void admin_clicks_on_on_manage_program_page(String link) {
		
	    switch (link) {
        case "Batchlink":
        	//wait.until(ExpectedConditions.elementToBeClickable(navigationprogram.batch));
        	wait.until(ExpectedConditions.invisibilityOf(addprogram.successMsg));
            navigationprogram.batch.click();
            break;
        case "Userlink":
        	navigationprogram.user.click();
            break;
        case "Logout link":
        	navigationprogram.logout.click();
            break;
        default:
            throw new IllegalArgumentException("Invalid link text: " + link);
            }
   
}
	
	@Then("Admin is re-directed to {string}")
	public void admin_is_re_directed_to(String page) throws InvalidFormatException, IOException {
		switch (page) {
        case "Batch page":
           Assert.assertEquals(driver.getCurrentUrl(), "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/batch");
           driver.navigate().back();
           break;
        case "User page":
        	Assert.assertEquals(driver.getCurrentUrl(), "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/user");
        	 driver.navigate().back();	
            break;
        case "login page":
        	Assert.assertEquals(driver.getCurrentUrl(), "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login");
        	navigationprogram.loginCredential();
        	
            break;
        default:
            throw new IllegalArgumentException("Invalid url text: " + page);}
	}
	

}
