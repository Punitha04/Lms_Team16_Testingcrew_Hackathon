package com.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Manageprogram {
	

	WebDriver driver;
	WebDriverWait wait;
	
	public Manageprogram(WebDriver driver) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		//mat-focus-indicator mat-button mat-button-base
		@FindBy(xpath="//button[@id='program']")
		public WebElement programbtn;
		//@FindBy(xpath="//div[text()=' Manage Program']")
		@FindBy(xpath="//div[@class='box']")
		public WebElement headerText;
		@FindBy(css="span[class*='paginator-current']")
		public WebElement paginationText;
		//p-datatable-footer ng-star-inserted
		@FindBy(xpath="//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
		public WebElement footerText;
		@FindBy(id="new")
		public WebElement newProgram;
		@FindBy(xpath="//td[2]")
		public List<WebElement> numberofData;
		@FindBy(xpath="//div[@class='box'] //button[@class='p-button-danger p-button p-component p-button-icon-only']")
		public WebElement deleteBtn;
		@FindBy(id="filterGlobal")
		public WebElement search;
		@FindBy(xpath="//thead[@class='p-datatable-thead']/tr/th")
		public List<WebElement>  columnTitle;
		@FindBy(xpath="//tbody[@class='p-datatable-tbody']//div[@class='p-checkbox p-component']")
		public List<WebElement> checkbox;
		@FindBy(xpath="//tbody[@class='p-datatable-tbody']/tr/td/div[@class='action']")
		public List<WebElement> editDltBtn;
		@FindBy(xpath="//*[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
		public List<WebElement> sortIcon;
		
		public void manageProgram()
		{
			
			programbtn.click();
			
		}
		public WebElement getheader()
		{
			return headerText;
		}
		public WebElement pagination()
		{
			return paginationText;
		}
		public WebElement getFooter()
		{
			
			return footerText;
			 
		}
		public WebElement newProgram()
		{
			return newProgram;
		}
		
		public int getdata()
		{
			return numberofData.size();
		}
		public WebElement getDeleteBtn()
		{
			return deleteBtn;
		}
		public String getsearch()
		{
			return search.getAttribute("placeholder");
		}
		public List<WebElement> getColumn()
		{
			return columnTitle;
		}
		public List<WebElement> checkbox()
		{
			return checkbox;
		}
		public List<WebElement> sortIcon()
		{
			return sortIcon;
		}
		
	
	}