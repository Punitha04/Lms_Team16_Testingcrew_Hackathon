package com.PageObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Dashboardpom {
      WebDriver driver;
	  WebDriverWait wait;
	  @FindBy(xpath="//input[@id='username']")
		WebElement username;
		@FindBy(xpath="//input[@id='password']")
		WebElement password;
		@FindBy(xpath="//button[@id='login']")
		WebElement LoginBtn;
	 By txtUser=By.id("username");
	 By txtpassword=By.id("password");
	 By btnlogin=By.id("login");
	 By btnLogout=By.linkText("Logout");
	 By header=By.className("box");
	 By titleLMS=By.linkText("LMS-Learning Management System");
	 By btnProgram=By.id("program");
	 By btnBatch=By.linkText("Batch");
	 By btnUser=By.id("user");
	 By navigationbartext=By.xpath("//mat-toolbar[@colour='primary')");
	 String errorMsg;
	 public Dashboardpom(WebDriver driver){
		 wait= new WebDriverWait(driver,Duration.ofSeconds(20));
       this.driver= driver;
			PageFactory.initElements(driver,this);
			}
     public void enterUser(String User){
	driver.findElement(txtUser).sendKeys("sdetorganizers@gmail.com");
}
	public void enterpassword(String password) {
		driver.findElement(txtpassword).sendKeys("UIHackathon@02");
	}
	public void clicklogin() {
		driver.findElement(btnlogin).click();
	}
	public void clickLogout(){
   driver.findElement(btnLogout).click();
    }
	public void txtManageprogram() {
	driver.findElement(header).getText();
	return;
	}
	public void txtLMS(String LMS) {
		driver.findElement(titleLMS).isDisplayed();
	return;
	}
	
	public void clickProgram() {
		driver.findElement(btnProgram).click();
		return;
	}
	public void clickBatch() {
		driver.findElement(btnBatch).click();
		return;
}
	public void clickUser() {
		driver.findElement(btnUser).click();
		return;
	}
	
	public static boolean isManageProgramHeaderDisplayed() {
		
		return false;
	}
	
	public String BrokenURL(Integer statusCode) throws InterruptedException, IOException
	{
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(int i=1;i<links.size();i++)
		{
		WebElement element = links.get(i);
		String Url = element.getAttribute("href");
		URL urlLink = new URL(Url);
		
		HttpURLConnection httpConn =  (HttpURLConnection) urlLink.openConnection();
		
		Thread.sleep(3000);
		httpConn.connect();
		int rspnsecode = httpConn.getResponseCode();
		if (rspnsecode >=400)
		{
		System.out.println(Url+ " is broken link");	
		errorMsg="URL is broken link.";
		}
		else {
			System.out.println(Url+ " is valid link");
			errorMsg="URL is valid link.";
		}
		}			
		
		return errorMsg ;
	}
	public String getNavigationBarText() {
		return "Program, Batch,User,Logout";

	}


	

public boolean isAdminSeeingCorrectLmsTitle(String actualTitle, String expectedTitle) {
    return actualTitle.equals(expectedTitle);
}

public boolean isAdminSeeingProgramFirst(List<String> wordList, String Program) {
    if (!wordList.isEmpty()) {
        String firstWord = wordList.get(0);
        return firstWord.equals(Program);
    }
    return false; // Word list is empty
}
public boolean isAdminSeeingBatchSecond(List<String> wordList, String Batch) {
    if (!wordList.isEmpty()) {
        String SecondWord = wordList.get(1);
        return SecondWord.equals(Batch);
    }
    return false; 
}
public boolean isAdminSeeingUserThird(List<String> wordList, String User) {
    if (!wordList.isEmpty()) {
        String ThirdWord = wordList.get(2);
        return ThirdWord.equals(User);
    }
    return false; 
}
public boolean isAdminSeeingLogoutFourth(List<String> wordList, String Logout) {
    if (!wordList.isEmpty()) {
        String FourthWord = wordList.get(3);
        return FourthWord.equals(Logout);
    }
    return false; 
}
public void loginCredential() throws InvalidFormatException, IOException 
{
/*Excel xl = new Excel();
		List<Map<String,String>> testData= xl.getData("C://Users//Ranji//OneDrive//Documents//Team16_TesingCru.xlsx", "Login");
	 String usrnme=testData.get(0).get("User");
     String pswd = testData.get(0).get("Password");*/
	username.sendKeys("sdetorganizers@gmail.com");
	password.sendKeys("UIHackathon@02");
	LoginBtn.click();
	
	} 
}


	//}
	 // public static boolean isManageProgramHeaderDisplayed() {

		//WebElement header = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box")));
		//  return header.isDisplayed();


