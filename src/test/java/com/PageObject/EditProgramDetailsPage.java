package com.PageObject;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Utils.Excel;
import com.Utils.ReUsableMethods;



public class EditProgramDetailsPage 
{
	WebDriver driver;
	WebDriverWait wait;

	//By DescriptionBox = By.id("programDescription");
	//By NameBox = By.id("programName");
	//By editbutton=By.id("editProgram");
	
	//WebDriver driver;
	@FindBy(id="programDescription")
	WebElement descriptionBox;


	@FindBy(id="editProgram")
	WebElement editbutton;
	
	@FindBy(id="programName")
	WebElement program_name;
	
	
	@FindBy(id="saveProgram")
	WebElement save_Program;
	
	@FindBy(id="Active")
	WebElement activeRadioBtn;
	
	@FindBy(xpath="//*[@class=\"p-radiobutton-box\"]")
	WebElement inActiveRadioBtn;
	
	@FindBy(xpath="//*[@role=\"dialog\"]")
	WebElement popupWndow;
	
	
	@FindBy(xpath="//*[text()=\"Program Updated\"]")
	WebElement success_MSG;
	
	@FindBy(xpath="//*[@class=\"p-invalid ng-star-inserted\"]")
	WebElement err_msg;
	
	
	@FindBy(xpath="//button[@label=\"Cancel\"]")
	WebElement cancel;
	
	
	
	List<WebElement>  elements;
	
	Excel xl=new Excel();
	
	
	
	public EditProgramDetailsPage(WebDriver driver) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.driver=driver;
		PageFactory.initElements(driver,this);
				
			}
	
	public void verifyPageTitle()
	{
		String actual=driver.getTitle();
		String expectedTitle="LMS";
		Assert.assertEquals(actual, expectedTitle);
	}
	
	public void clickEditButton()
	{
    elements=driver.findElements(By.id("editProgram"));
		System.out.println("list of element    "+elements.size());
		
		
		editbutton.click();
	}
	
	public void verifyPopUpWindow()
	{
		
		//Assert.asser
		boolean flag=popupWndow.isDisplayed();
		Assert.assertEquals(flag, true);
	}
	
	public void editProgramName(String programname)
	{
		
		 elements=driver.findElements(By.id("editProgram"));
			System.out.println("list of element    "+elements.size());
			
		
					program_name.clear();
					//elements.get(i).sendKeys("biology descibes about human body");
					program_name.sendKeys(programname);
					save_Program.click();
					
			
		//program_name.clear();
		//program_name.sendKeys("Biology");
		//save_Program.click();
	}
	public void editProgramDescription(String prog_Description)
	{
		 elements=driver.findElements(By.id("editProgram"));
		
				descriptionBox.clear();
				//elements.get(i).sendKeys("biology descibes about human body");
				descriptionBox.sendKeys(prog_Description);
				save_Program.click();
			
	}
	
	
	
	public void clickonRadioButton() throws InterruptedException
	{
		
		 //elements=driver.findElements(By.id("editProgram")).cl;
//			for (int i=0; i<elements.size();i++){
//				
//				if(i==3)
//				{
		 
		 editbutton.click();
		 Thread.sleep(1000);
		if(activeRadioBtn.isSelected()) {
		
			inActiveRadioBtn.click();
			
		}
		
		else {
			activeRadioBtn.click();
			}
		
		//save_Program.click();
	}//}
	
	public void verifySuccessMessage(String msg)
	{
		String actual=success_MSG.getText();
		System.out.println("success msg %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  "+actual);
		String expected_msg="Successful Program Updated";
		
		Assert.assertEquals(msg, expected_msg);

	}
	
	
	
	public void verifyInvalidDataMessage(String invalid_data)
	{
		
		program_name.clear();
		program_name.sendKeys(invalid_data);
		//cancel.click();
	//String str=	err_msg.getText();
	
	//System.out.println("Error message @@@@@@@@@@@@@@@@@    "+str);
	}
	
	public String xlDataReader(String SheetName,Integer rowNumber, String program_columnName) throws InvalidFormatException, IOException, InterruptedException
	{
	
		
		//String xlPath="C:\\Users\\mayan\\eclipse-workspace1\\Team16_TesingCru\\src\\test\\resources\\DataFiles\\demo.xlsx";
		//List<Map<String,String>> testData= xl.getData(xlPath,SheetName);
		List<Map<String,String>> testData= xl.getData("src\\test\\resources\\DataFiles\\Team16_TesitngCru.xlsx", SheetName);
		
		String data=testData.get(rowNumber).get(program_columnName);
			
				Thread.sleep(2000);
				
				return data;
	}
	
	
	public void verifyErrorMsg()
	{
	String actual=	err_msg.getText();
	
	 Assert.assertEquals(actual,"This field should start with an alphabet, no special char and min 2 char.");

	}
	
	public void closePopUpWindow()
	{
		
		//ReUsableMethods.waitForElementToBeClickable(driver, cancel);
	//	cancel.click();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", cancel);
	}
	
	
	
	
	public void saveProgramme()
	{
		save_Program.click();
	}

	
	
}
