package com.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.ReUsableMethods;

//import Utils.BaseClass;

public class AddNewUserpom  {
	WebDriver driver;
	WebDriverWait wait;
	
	
	//@FindBy(xpath="//button[@id='user']")
	//private WebElement userBtn;
	//@FindBy(xpath="//button[@label='Add New User']")
	@FindBy(xpath="//*[@class='box']//button[@label='Add New User']")
	public WebElement AddNewuserBtn;
	@FindBy(xpath="//*[@header='User Details']")
	public WebElement UserPopUpHeader;
	@FindBy(xpath="//input[@data-placeholder='First name']")
	public WebElement UserFirstNamePlaceHolder;
	@FindBy(xpath="//input[@data-placeholder='Middle name']")
	public WebElement UserMiddlenamePlaceHolder;
	@FindBy(xpath="//input[@data-placeholder='Last name']")
	public WebElement UserLastnamePlaceHolder;
	@FindBy(xpath="//input[@data-placeholder='Location']")
	public WebElement UserLocationPlaceHolder;
	@FindBy(xpath="//input[@data-placeholder='Phone no']")
	public WebElement UserPhonenoPlaceHolder;
	@FindBy(xpath="//input[@data-placeholder='LinkedIn Url']")
	public WebElement UserLinkedInUrlPlaceHolder;
	@FindBy(xpath="//label[text()='User Role']")
	public WebElement UserRoleLabel;
	@FindBy(xpath="//label[text()='User Role Status']")
	public WebElement UserRolestatusLabel;
	@FindBy(xpath="//label[text()='User Visa Status']")
	public WebElement UserVisaStatuslabel;
	@FindBy(xpath="//input[@placeholder='Email address']")
	public WebElement EmailaddressPlaceHolder;
	@FindBy(xpath="//input[@data-placeholder='Under Graduate']")
	public WebElement UnderGraduatePlaceHolder;
	@FindBy(xpath="//input[@data-placeholder='Post Graduate']")
	public WebElement PostGraduatePlaceHolder;
	@FindBy(xpath="//input[@data-placeholder='Time Zone']")
	public WebElement TimeZonePlaceHolder;
	@FindBy(xpath="//input[@data-placeholder='User Comments']")
	public WebElement UserCommentsPlaceHolder;
	
	@FindBy(xpath="//input[@formcontrolname='userFirstName']")
	private WebElement firstNameInputField;
	@FindBy(xpath="//input[@formcontrolname='userMiddleName']")
    private WebElement UserMiddleNameField;
	@FindBy(xpath="//input[@formcontrolname='userLastName']")
    private WebElement UserLastNameField;
	@FindBy(xpath="//input[@formcontrolname='userLocation']")
	private WebElement UserLocationField;
	@FindBy(xpath="//input[@formcontrolname='userPhoneNumber']")
	private WebElement UserPhoneNumberField;
	@FindBy(xpath="//input[@formcontrolname='userLinkedinUrl']")
	private WebElement UserLinkedinUrlField;
	@FindBy(xpath="//input[@placeholder='Email address']")
	private WebElement Emailaddress;
	@FindBy(xpath="//input[@data-placeholder='Under Graduate']")
	private WebElement UnderGraduate;
	@FindBy(xpath="//input[@data-placeholder='Post Graduate']")
	private WebElement PostGraduate;
	@FindBy(xpath="//input[@data-placeholder='Time Zone']")
	private WebElement TimeZone;
	@FindBy(xpath="//input[@data-placeholder='User Comments']")
	private WebElement UserComments;
	@FindBy(xpath="//span[text()='Submit']")
	public WebElement Submit;
	@FindBy(xpath="//span[text()='Cancel']")
	public WebElement Cancel;
	@FindBy(xpath="//span[@class='p-dialog-header-close-icon ng-tns-c132-6 pi pi-times']")
	public WebElement close;
	@FindBy(xpath="//*[@id='roleId']")
	private WebElement UserRoleDropdown;
	@FindBy(xpath="//*[@id='userRoleStatus']")
	private WebElement UserRolestatusDropdown;
	@FindBy(xpath="//*[@id='userVisaStatus']")
	private WebElement UserVisaStatusDropdown;
	
	public WebElement getUnderGraduatePlaceHolder() {
		return UnderGraduatePlaceHolder;
	}

	public WebElement getPostGraduatePlaceHolder() {
		return PostGraduatePlaceHolder;
	}

	public WebElement getTimeZonePlaceHolder() {
		return TimeZonePlaceHolder;
	}

	public WebElement getFirstNameInputField() {
		return firstNameInputField;
	}

	public WebElement getUserMiddleNameField() {
		return UserMiddleNameField;
	}

	public WebElement getUserLastNameField() {
		return UserLastNameField;
	}

	public WebElement getUserLocationField() {
		return UserLocationField;
	}

	public WebElement getUserPhoneNumberField() {
		return UserPhoneNumberField;
	}

	public WebElement getUserLinkedinUrlField() {
		return UserLinkedinUrlField;
	}

	public WebElement getEmailaddress() {
		return Emailaddress;
	}

	public WebElement getUnderGraduate() {
		return UnderGraduate;
	}

	public WebElement getPostGraduate() {
		return PostGraduate;
	}

	public WebElement getTimeZone() {
		return TimeZone;
	}

	public WebElement getUserComments() {
		return UserComments;
	}

	public WebElement getSubmit() {
		return Submit;
	}

	public WebElement getCancel() {
		return Cancel;
	}

	public WebElement getClose() {
		return close;
	}

	public WebElement getUserRoleDropdown() {
		
		 UserRoleDropdown.click();
		 return UserRoleDropdown;
	}
	

	public WebElement getUserRolestatusDropdown() {
		UserRolestatusDropdown.click();
		return UserRolestatusDropdown;
	}

	public WebElement getUserVisaStatusDropdown() {
		UserVisaStatusDropdown.click();
		return UserVisaStatusDropdown;
	}
	public void selectUserRole(String userRole) {
        ReUsableMethods.selectOptionFromDropdown(UserRoleDropdown, userRole);
    }

    public void selectUserStatus(String userStatus) {
        ReUsableMethods.selectOptionFromDropdown(UserRolestatusDropdown, userStatus);
    }

    public void selectVisaStatus(String visaStatus) {
        ReUsableMethods.selectOptionFromDropdown(UserVisaStatusDropdown, visaStatus);
    }


	
	public AddNewUserpom(WebDriver driver) {
		 wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	

}
