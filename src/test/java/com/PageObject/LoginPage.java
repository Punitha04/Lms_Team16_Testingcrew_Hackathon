package com.PageObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.BaseClass;
import com.Utils.Excel;


public class LoginPage {

WebDriver driver ;


	WebDriverWait wait;

	 public LoginPage(WebDriver driver) { 
			
		  PageFactory.initElements(driver,this);
		  }
	
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
		@FindBy(xpath="//input[@id='password']")
		WebElement password;
		@FindBy(xpath="//button[@id='login']")
		WebElement LoginBtn;
		@FindBy(xpath="//div[@class='box']")
		WebElement dashboardtext;
		
		 
		 
		public void loginValidCredential(String usrnme,String pswd) 
		{
			username.sendKeys(usrnme);
			password.sendKeys(pswd);
			LoginBtn.click();
			System.out.println("Page object user" +usrnme);
			} 
		
		public String managepgm() {
			String headtext = dashboardtext.getText();
			//System.out.println(headtext);
			return headtext;
		}
}