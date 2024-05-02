package com.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditUserPom {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//*[@icon='pi pi-pencil']")
	public WebElement EditIcon;
	@FindBy(xpath="//input[@id='filterGlobal']")
	public WebElement MangeUserSearch;
	@FindBy(xpath="//*[@class='box']//button[@label='Add New User']")
	public WebElement AddNewuserBtn;
	@FindBy(xpath="//button[@id='user']")
	public WebElement userBtn;
	@FindBy(xpath="//input[@formcontrolname='userFirstName']")
	private WebElement firstNameInputField;
	public WebElement getFirstNameInputField() {
		return firstNameInputField;
	}
	public WebElement getUpdaterMiddleNameField() {
		return UpdaterMiddleNameField;
	}
	public WebElement getUpdateLastNameField() {
		return UpdateLastNameField;
	}
	public WebElement getUpdateLocationField() {
		return UpdateLocationField;
	}
	public WebElement getUpdatePhoneNumberField() {
		return UpdatePhoneNumberField;
	}
	public WebElement getUpdateLinkedinUrlField() {
		return UpdateLinkedinUrlField;
	}
	public WebElement getUpdateEmailaddress() {
		return UpdateEmailaddress;
	}
	@FindBy(xpath="//input[@formcontrolname='userMiddleName']")
    private WebElement UpdaterMiddleNameField;
	@FindBy(xpath="//input[@formcontrolname='userLastName']")
    private WebElement UpdateLastNameField;
	@FindBy(xpath="//input[@formcontrolname='userLocation']")
	private WebElement UpdateLocationField;
	@FindBy(xpath="//input[@formcontrolname='userPhoneNumber']")
	private WebElement UpdatePhoneNumberField;
	@FindBy(xpath="//input[@formcontrolname='userLinkedinUrl']")
	private WebElement UpdateLinkedinUrlField;
	@FindBy(xpath="//input[@placeholder='Email address']")
	private WebElement UpdateEmailaddress;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement Submit;
	@FindBy(xpath="//span[text()='Cancel']")
	public WebElement Cancel;
	@FindBy(xpath="//span[@class='p-dialog-header-close-icon ng-tns-c132-6 pi pi-times']")
	public WebElement close;
	public WebElement getUserBtn() {
		return userBtn;
	}
	public EditUserPom(WebDriver driver) {
		 wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getEditIcon() {
		return EditIcon;
	}
	public WebElement getMangeUserSearch() {
		
		return MangeUserSearch;
	}
	public WebElement Submit() {
		return Submit;
		
	}
}
