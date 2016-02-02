package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.Constant;
import utility.Log;

public class MarketingSegmentation_Page {

    private static WebElement element = null;
	 
    public static WebElement marketingSegmentation_List(WebDriver driver) throws Exception {

    	//Click on Marketing->Segmentation->List menu
    	Actions actions = new Actions(driver);
    	WebDriverWait wait = new WebDriverWait(driver, 60);
    	Log.info("Initializing Actions");
	
    	//WebElement marketHoverLink = driver.findElement(By.xpath(Constant.mXpath));
    	element = driver.findElement(By.xpath(Constant.mXpath));
    	//actions.moveToElement(marketHoverLink).perform();
    	actions.moveToElement(element).perform();
    	Log.info("Menu Market Hover Link");
	
    	//WebElement marketSegmentHoverLink = driver.findElement(By.xpath(Constant.msXpath));
    	element = driver.findElement(By.xpath(Constant.msXpath));
    	//actions.moveToElement(marketSegmentHoverLink).perform();
    	actions.moveToElement(element).perform();
    	Log.info("Menu Market->Segment Hover Link");
	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constant.msListXpath)));
		Log.info("Waiting for Market->Segment->List Link");
	
		driver.findElement(By.xpath(Constant.msListXpath)).click();
		Log.info("Clicking Market->Segment->List Link");
	
		return element;
    }
    
	 public static WebElement marketingSegmentation_AddList(WebDriver driver) throws Exception {
			
		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constant.addListXpath)));
		Log.info("Waiting for marketing->Segmentation->addListXpath");
		
		element = driver.findElement(By.xpath(Constant.addListXpath));
		element.click();
		
		Log.info("Click on marketing->Segmentation-> New AddList link");
		
		return element;
	 }

	 public static WebElement marketingSegmentation_AddList_FillForm(WebDriver driver, String randomName) throws Exception {
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
			Log.info("Waiting for createList dialog to open");
			
			element = driver.findElement(By.xpath("//input[@id='name']"));
			element.sendKeys(randomName);
			
			Log.info("Entered Random name is " +randomName);
			
			return element;
	}

	 public static WebElement marketingSegmentation_saveList(WebDriver driver) throws Exception {
			
		//WebDriverWait wait = new WebDriverWait(driver, 60);

		element = driver.findElement(By.xpath("//button[@id='save_information']"));
		element.click();
		
		Log.info("Clicking createList/saveList button ");
		
		// Not checking for other errors on mandatory inputs... But should in future 
		
		return element;
	 }
	 
		public static WebElement marketingSegmenation_renameList(WebDriver driver, String randomName, String newrandomName) throws Exception {
			 
			// Enter list name in Filter field
			WebDriverWait wait = new WebDriverWait(driver, 60);

			//WebElement webElement = driver.findElement(By.xpath("//input[contains(@id,'listx_table_filter')]"));
			element = driver.findElement(By.xpath("//input[contains(@id,'listx_table_filter')]"));
			element.sendKeys(randomName);
			//webElement.sendKeys(randomName);
			Log.info("Entering list name" +randomName);
					
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='listx_row_a0']/td[2]/a")));
					
			element = driver.findElement(By.xpath(".//*[@id='listx_row_a0']/td[2]/a"));
			element.click();
					
			Log.info("Clicking on list name link" +randomName);
					
			element = driver.findElement(By.xpath("//a[contains(@title,'Access key e')]"));
			element.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
			
			element = driver.findElement(By.xpath("//input[@id='name']"));
			element.clear();
			
			element = driver.findElement(By.xpath("//input[@id='name']"));
			element.sendKeys(newrandomName);
			
			element = driver.findElement(By.xpath("//button[@id='save_information']"));
			element.click();
					
			Log.info("rename Original List name" +newrandomName);

			return element;
			
		 	}
		

}
