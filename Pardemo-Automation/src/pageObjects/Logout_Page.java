package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import utility.Constant;
import utility.Log;

public class Logout_Page {
	
	private static WebElement element = null;
	  
	 public static WebElement lnk_LogOut(WebDriver driver) {
	 
			Actions actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			// Identify loggedIn userName
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constant.loggedInUserXpath)));
			//WebElement logOutHover = driver.findElement(By.xpath(Constant.loggedInUserXpath));
			
			element = driver.findElement(By.xpath(Constant.loggedInUserXpath));
			actions.moveToElement(element).perform();
			
			//actions.moveToElement(logOutHover).perform();		
			Log.info("Move mouse to LogOut");
			// Identify logOutxPath element
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constant.logOutXpath)));
			driver.findElement(By.xpath(Constant.logOutXpath)).click();
			Log.info("Clicked on LogOut link");
			
			wait.until(ExpectedConditions.titleIs(Constant.logOutTitle));
			
			return element;
	 
	 }
}