package com.Utils;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReUsableMethods {
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public static boolean isElementDisplayed(WebDriver driver, WebElement element) {
	    try {
	        return element.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public static List<String> extractColumnNames(List<WebElement> columnElements) {
        List<String> columnNames = new ArrayList<>();
        for (WebElement columnElement : columnElements) {
            columnNames.add(columnElement.getText().trim());
        }
        return columnNames;
    }

    public static void assertColumnPresent(List<String> actualColumnNames, String expectedColumnName) {
        boolean columnFound = false;
        String trimmedExpectedColumnName = expectedColumnName.trim(); 
        for (String columnName : actualColumnNames) {
            String trimmedActualColumnName = columnName.trim(); 
            if (trimmedActualColumnName.equalsIgnoreCase(trimmedExpectedColumnName)) {
                columnFound = true;
                break;
            }
        }
        assertTrue(columnFound, "Column name '" + expectedColumnName + "' not found");
    }
    public static void javaScriptClickMethod(WebDriver driver, WebElement element)
    {
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", element);
    }
	public static void scrollToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
	public static void selectOptionFromDropdown(WebElement dropdown, String value) {
	    dropdown.click();
	    String optionXPath = "//*[text()='" + value + "']";
	    WebElement option = dropdown.findElement(By.xpath(optionXPath));
	    option.click();
	}
	public static void clickButton(WebDriver driver, String buttonText) {
	    String xpath = "//button[text()='"+buttonText+"']";
	    WebElement button = driver.findElement(By.xpath(xpath));
	    waitForElementToBeClickable(driver, button);
	    button.click();
	}


}
