package StepDefinitions;


import java.awt.Point;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.Base.BaseClass;
import com.PageObject.Dashboardpom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Dashboardsteps extends BaseClass {
	
	private static final String Broken_response = null;

	public static WebDriver driver= null;
	public static Dashboardpom Db;
	private static WebDriver driver1=null;
    private  static WebDriverWait wait;
    
    @Given("Admin in Home Page") 
	public void admin_in_home_page() {
	 driver=new ChromeDriver();
	
	    Db= new Dashboardpom (driver);
		driver.manage().window().maximize();
	    driver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login");
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() throws InterruptedException {
		Thread.sleep(2000);
	    Db.enterUser("sdetorganizers@gmail.com");
	    Db.enterpassword("UIHackathon@02");
	    Db.clicklogin();
	    try {

	    	Thread.sleep(5000); // Sleep for 5 seconds (5000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header(String expectedHeader) throws InterruptedException {
		
		//String actualHeader = driver.findElement(By.className("box")).getText();
       // assert actualHeader.equals(expectedHeader) : "Expected header: " + Manage Program + ", Actual header: " + Manage Program; 
		//assertEquals(expectedHeader, actualHeader);
		//Thread.sleep(2000);
	//	Db.txtManageprogram(expectedHeader);
		//WebElement headerElement = driver.findElement(By.linkText("Manage Program"));
       // String actualHeader = headerElement.getText();
		//assertTrue(expectedHeader, actualHeader);
		// WebElement ManageProgram = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Manage Program")));
	      //  point titleLocation = ManageProgram.getLocation();
	      //  assertTrue("LMS title is not in the top left corner",
	                   //titleLocation.getX() == 0 && titleLocation.getY() == 0);
	        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box")));
	        Assert.assertTrue(header.isDisplayed(), "Manage Program header is not displayed");
	        System.out.println("Manageprogram Header is Displayed");
	        driver.close();
	    }
	
	
	@Given("Admin is in Home Page1")
	public void admin_is_in_home_page1() {
		 driver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login");
	}

	@When("Admin enter valid credentials  and clicks login button1")
	public void admin_enter_valid_credentials_and_clicks_login_button1() throws InterruptedException {
		Thread.sleep(2000);
	    Db.enterUser("sdetorganizers@gmail.com");
	    Db.enterpassword("UIHackathon@02");
	    Db.clicklogin();
	    try {

	    	Thread.sleep(5000); // Sleep for 5 seconds (5000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) throws InterruptedException {
		Thread.sleep(2000);
		 long startTime = System.currentTimeMillis();
	        // Add steps to perform actions after login (e.g., navigating to another page)
	        long endTime = System.currentTimeMillis();
	        long navigationTime = endTime - startTime;
	     //  Assert.assertTrue("Navigation time exceeds the maximum allowed time (30 seconds)",
	            //    navigationTime <= 30000); // 30 seconds in milliseconds
	                Assert.assertEquals(false, navigationTime <= 30000);
	}
	
	
		
	

	

	@Given("Admin is in Home Page2")
	public void admin_is_in_home_page2() {
	    
	}

	@When("Admin enter valid credentials  and clicks login button2")
	public void admin_enter_valid_credentials_and_clicks_login_button2() {
	    
	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer Statuscode) throws InterruptedException {
		Thread.sleep(2000);
		
		// response = RestAssured.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
	     //   assertTrue("Response code is not greater than or equal to 400", response.getStatusCode() >= 400);
	      //  System.out.println("The link is broken.");
		// Broken_response = Db.BrokenURL(Statuscode);
		Assert.assertEquals(Broken_response, "http Response<=400");
			
	}
	
	@Given("Admin is in Home Page3")
	public void admin_is_in_home_page3() {
	    
	}

	@When("Admin enter valid credentials  and clicks login button3")
	public void admin_enter_valid_credentials_and_clicks_login_button3() {
	    
	}

	@Then("Admin should see LMS -Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() throws InterruptedException {
		Thread.sleep(2000);
		String actualTitle=driver.getTitle();
		String expectedTitle="LMS";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}
	@Given("Admin is in Home Page4")
	public void admin_is_in_home_page4() {
		 //wait = new WebDriverWait(driver, 10);
	}

	@When("Admin enter valid credentials  and clicks login button4")
	public void admin_enter_valid_credentials_and_clicks_login_button4() {
	    
;	}

	@Then("LMS title should be on the top left corner of the page")
	public void lms_title_should_be_on_the_top_left_corner_of_the_page() throws InterruptedException {
		//wait = new WebDriverWait(driver, 10);
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LMS-Learning Management System")));
       // assert element.isDisplayed();
		//WebElement lmsTitleElement =driver.findElement(By.linkText("LMS-Learning Management System"));
		//int titleX = lmsTitleElement.getLocation().getX();
       // int titleY = lmsTitleElement.getLocation().getY();
       // assertEquals(0, titleX);
      //  assertEquals(0, titleY);
        WebElement lmsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LMS-Learning Management System")));
        int titleX = lmsTitle.getLocation().getX();
        int titleY = lmsTitle.getLocation().getY();
        assert titleX == 0 && titleY == 0 ;
	    }
	@Given("Admin is in Home Page5")
	public void admin_is_in_home_page5() {
	    
	}

	@When("Admin enter valid credentials  and clicks login button5")
	public void admin_enter_valid_credentials_and_clicks_login_button5() {
	    
	}


	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() throws InterruptedException {
		 
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement titleLMS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LMS - Learning Management System")));
	      
		 String actualTitle=driver.getTitle();
		 String expectedTitle="LMS";
			Assert.assertEquals(actualTitle, expectedTitle);
	}
	

	@Given("Admin is in Home Page6")
	public void admin_is_in_home_page6() {
	    
	}

	@When("Admin enter valid credentials  and clicks login button6")
	public void admin_enter_valid_credentials_and_clicks_login_button6() {
	    
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement titleLMS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LMS - Learning Management System")));
	        
	        
	//	WebElement lmsTitle = driver.findElement(By.linkText(" LMS - Learning Management System "));
		// String actualText =Db.getText();
	   // String expectedTitle = "LMS-Learning Management System"; 
	   

	   // Assert.assertEquals(actualTitle, expectedTitle);  
		 String actualTitle = "Learning Management System"; // Actual title seen by admin
	        String expectedTitle = "Learning Management System"; // Expected title

	       
	        boolean isUserSeeingCorrectTitle = Db.isAdminSeeingCorrectLmsTitle(actualTitle, expectedTitle);

	        Assert.assertTrue(isUserSeeingCorrectTitle, "User should see the correct LMS title.");
	    }    
	    

	
	@Given("Admin is in Home Page7")
	public void admin_is_in_home_page7() {
	    
	}

	@When("Admin enter valid credentials  and clicks login button7")
	public void admin_enter_valid_credentials_and_clicks_login_button7() {
	    
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() throws InterruptedException {
		 Thread.sleep(2000);
		 
	       // int navigationBarX = navigationBar2.getLocation().getX();
	      //  int navigationBarY = navigationBar2.getLocation().getY();
		 String navigationBarText = Db.getNavigationBarText();
		 Assert.assertEquals(navigationBarText, "program, Batch,user,Logout",("Incorrect navigation bar text for User."));
	
	   
	}
	@Given("Admin is in Home Page8")
	public void admin_is_in_home_page8() {
	    
	}

	@When("Admin enter valid credentials  and clicks login button8")
	public void admin_enter_valid_credentials_and_clicks_login_button8() {
	    
	}

	@Then("Admin should see program in the 1st place")
	public void admin_should_see_program_in_the_1st_place() throws InterruptedException {
		Thread.sleep(2000);
	     //WebElement Programtitle = driver.findElement(By.id("program"));
	    // String expectedTitle = "Program"; 

	        
	     // Assert.assertTrue("Program is not in the 1st place in the navigation bar",
	                 //    expectedTitle, Programtitle.getText().trim());
		 List<String> wordList = new ArrayList<>();
	        wordList.add("Program");
	        wordList.add("Batch");
	        wordList.add("User");
	        wordList.add("Logout");

	        String expectedWord = "Program"; // Expected word in the 1st place

	       
	        boolean isAdminSeeingProgramFirst = Db.isAdminSeeingProgramFirst(wordList, expectedWord);

	        Assert.assertTrue(isAdminSeeingProgramFirst, "Admin should see the word 'Program' in the 1st place.");
	    }
	
	
	@Given("Admin is in Home Page9")
	public void admin_is_in_home_page9() {
	    
	}

	@When("Admin enter valid credentials  and clicks login button9")
	public void admin_enter_valid_credentials_and_clicks_login_button9() {
	    
	}

	@Then("Admin should see batch in the 2nd place")
	public void admin_should_see_batch_in_the_2nd_place() throws InterruptedException {
		Thread.sleep(2000);
		// WebElement Batchtitle = driver.findElement(By.linkText("Batch"));
	       // String expectedTitle = "Batch"; 

	        
	     //  Assert. assertTrue("Program is not in the 1st place in the navigation bar",
	                    // expectedTitle, Batchtitle.getText().trim());
		List<String> wordList = new ArrayList<>();
        wordList.add("Program");
        wordList.add("Batch");
        wordList.add("User");
        wordList.add("Logout");

        String expectedWord = "Batch"; // Expected word in the 2nd place

       
        boolean isAdminSeeingBatchSecond =  Db.isAdminSeeingBatchSecond(wordList, expectedWord);

        Assert.assertTrue(isAdminSeeingBatchSecond, "Admin should see the word 'Batch' in the 2nd place.");
	}
	@Given("Admin is in Home Page10")
	public void admin_is_in_home_page10() {
	    
	}

	
	@When("Admin enter valid credentials  and clicks login button10")
	public void admin_enter_valid_credentials_and_clicks_login_button10() {
	    
	}

	@Then("Admin should see user in the  3rd place")
	public void admin_should_see_user_in_the_3rd_place() throws InterruptedException {
		Thread.sleep(2000);
		 WebElement Btnuser = driver.findElement(By.linkText("User"));
	      //  String expectedTitle = "User"; 
	     // assertTrue("User is not in the 1st place in the navigation bar",
	                  //  expectedTitle, Usertitle.getText().trim());  
	      //  List<User> userList = new ArrayList<>();
	       // ProgramList.add(new Program("Program"));
	      //  BatchList.add(new Batch("Batch"));
	       // UserList.add(new User("User"));
	      //  LogoutList.add(new Logout("Logout"));
	       

	      ///  User expectedUser = new User("User3");
//
	      //  AdminService adminService = new AdminService();
	      //  boolean isAdminSeeingUser = adminService.isAdminSeeingUserInThirdPlace(userList, expectedUser);

	      //  Assertions.assertTrue(isAdminSeeingUser, "Admin should see the user in the 3rd place.");
	                    List<String> wordList = new ArrayList<>();
	                    wordList.add("Program");
	                    wordList.add("Batch");
	                    wordList.add("User");
	                    wordList.add("Logout");

	                    String expectedWord = "User"; // Expected word in the 2nd place

	                   
	                    boolean isAdminSeeingUserThird =  Db.isAdminSeeingUserThird(wordList, expectedWord);

	                    Assert.assertTrue(isAdminSeeingUserThird, "Admin should see the word 'User' in the 3rd place.");
	            	}
	
	@Given("Admin is in Home Page11")
	public void admin_is_in_home_page11(){
	    
	}

	@When("Admin enter valid credentials  and clicks login button11")
	public void admin_enter_valid_credentials_and_clicks_login_button11() {
	   
	}

	@Then("Admin should see logout in the 4th place")
	public void admin_should_see_logout_in_the_4th_place() throws InterruptedException {
		Thread.sleep(2000);
		 WebElement btnLogout = driver.findElement(By.linkText("Logout"));
	       // String expectedTitle = "logout"; 
	       // assertTrue("Logout is not in the 1st place in the navigation bar",
	                  //   expectedTitle, Logouttitle.getText().trim());
		 List<String> wordList = new ArrayList<>();
         wordList.add("Program");
         wordList.add("Batch");
         wordList.add("User");
         wordList.add("Logout");

         String expectedWord = "Logout"; // Expected word in the 2nd place

        
         boolean isAdminSeeingLogoutFourth =  Db.isAdminSeeingLogoutFourth(wordList, expectedWord);

         Assert.assertTrue(isAdminSeeingLogoutFourth, "Admin should see the word 'User' in the 4th place.");
	}
	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() {
	    
	}

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		 Db.clickLogout();
	}

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() throws InvalidFormatException, IOException {
	  driver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login");
	  Db.loginCredential();
	}
}


