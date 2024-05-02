package com.PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.Excel;

public class Navigationprogram {
	WebDriver driver;
	WebDriverWait wait;
	
	public Navigationprogram(WebDriver driver) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[@id='program']")
	public WebElement programBtn;
	@FindBy(xpath="//button[@id='batch']")
	public WebElement batch;
	@FindBy(xpath="//button[@id='user']")
	public WebElement user;
	@FindBy(xpath="//button[@id='logout']")
	public WebElement logout;
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	@FindBy(xpath="//button[@id='login']")
	WebElement LoginBtn;
	@FindBy(xpath="//div[@class='box']")
	WebElement dashboardtext;
	
	
	
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
