package com.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class UserPageValidationpom  {
	
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//button[@id='user']")
	public WebElement userBtn;
	@FindBy(xpath="//div[text()=' Manage User']")
	public WebElement ManageUserHeader;
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']")
	public WebElement pagenationText;
	@FindBy(xpath="//thead[@class='p-datatable-thead']/tr/th")
	List<WebElement>  UserTableHeadings;
	@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	public WebElement Deletbutton;
	@FindBy(xpath="//button[@id='new']")
	public WebElement AddNewUserBtn;
	@FindBy(xpath="//button[@label='Assign Student']")
	public WebElement AssignStudentBtn;
	@FindBy(xpath="//button[@label='Assign Staff']")
	public WebElement AssignStaffBtn;
	@FindBy(xpath="//input[@id='filterGlobal']")
	public WebElement UserSearchBar;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr")
    private List<WebElement> UsertableRows;
	@FindBy(xpath = "//tbody[@class='p-datatable-tbody']//div[@class='p-checkbox p-component']")
    private List<WebElement> UserTablecheckboxes;
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']/tr/td/*[@class='action']")
	private List<WebElement> EditAndDeleteBtn;
	
	public UserPageValidationpom(WebDriver driver) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public List<WebElement> getColumnElements() {
        return  UserTableHeadings;
	}
	public int getRecordCount() {
        return UsertableRows.size();
    }
	public List<WebElement> checkboxes() {
        return UserTablecheckboxes;
    }
	public List<WebElement> EditandDelete(){
		return EditAndDeleteBtn;
	}
}
