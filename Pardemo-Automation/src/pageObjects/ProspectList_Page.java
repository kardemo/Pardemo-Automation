package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Log;

public class ProspectList_Page {

	private static WebElement element = null;

	public static WebElement prospectList(WebDriver driver) throws Exception {
			
		//WebElement pHoverLink = driver.findElement(By.xpath(Constant.pXpath));
		element = driver.findElement(By.xpath(Constant.pXpath));
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Log.info("Initializing Actions");

		//actions.moveToElement(pHoverLink).perform();
		actions.moveToElement(element).perform();
		Log.info("Menu Prospect Hover Link");

		// Hover over Prospect menu and click on Prospect->List
		//WebElement moveonMenu = driver.findElement(By.xpath(mXpath));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constant.pListXpath)));
	
		//actions.moveToElement(submenuHoverLink).moveToElement(driver.findElement(By.xpath(msListXpath))).click().perform();
		element = driver.findElement(By.xpath(Constant.pListXpath));
		element.click();
		Log.info("Menu Prospect->List Hover Link");

		return element;
	}
	
	 public static WebElement prospectList_AddClickList(WebDriver driver) throws Exception {
			
			WebDriverWait wait = new WebDriverWait(driver, 60);

		 	// Wait for Prospect->List page to load and click on Add New Prospect
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constant.pListCreateXpath)));
			element = driver.findElement(By.xpath(Constant.pListCreateXpath));
			element.click();
			
			Log.info("Clicking on Prospect->List->AddProspect Link");
			
			return element;
	 }
	 
	 public static WebElement prospectList_fillFormList(WebDriver driver, String emailID) throws Exception {
			
		 // Wait for the Add New Prospect form to load
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
			Log.info("Waiting for Prospect->List->AddProspect New form");

			// Fill out Add New Prospect Form
			
			element = driver.findElement(By.xpath("//input[@id='email']"));
			element.sendKeys(emailID);
			
			Log.info("--- Filling AddProspect form ---- ");

			// Select a campaign option
			Log.info("Filling AddProspect form Selecting Campaign");

			Select campaignDropdown = new Select(driver.findElement(By.xpath("//select[@id='campaign_id']")));
			List <WebElement> campaignWeblist = campaignDropdown.getOptions();
			int cCnt = campaignWeblist.size();
			Log.info("Total campaignWeblist is " + cCnt);
		
			Random cnum = new Random();
			int cSelect = cnum.nextInt(cCnt);
			campaignDropdown.selectByIndex(cSelect);
			Log.info("Selected campaignWeblist " + cSelect);
		
			Thread.sleep(10);
			// Select a profile option

			Select profileDropdown = new Select(driver.findElement(By.xpath("//select[@id='profile_id']")));
			List <WebElement> profileWeblist = profileDropdown.getOptions();
			int pCnt = profileWeblist.size();
			Log.info("Total profileWeblist is " + pCnt);
		
			Random pnum = new Random();
			int pSelect = pnum.nextInt(pCnt);
			profileDropdown.selectByIndex(pSelect);
			Log.info("Selected profileWeblist " +pSelect);
			Thread.sleep(10);
		
			// Clear and Enter a Score Value
			element = driver.findElement(By.xpath("//input[@id='score']"));
			element.clear();
			
			element = driver.findElement(By.xpath("//input[@id='score']"));
			element.sendKeys(Constant.scoreVal);;
			Log.info("Enter Score Value " +Constant.scoreVal);
						
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(.,'test03@gmail.com')]")));			
			return element;

	 }
	 
	public static WebElement prospectList_saveProspect(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		element = driver.findElement(By.xpath("//input[@value='Create prospect']"));
		element.click();
		Log.info("Click on Save to Create New Prospect");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constant.logOutXpath)));
		Log.info("Waiting for prospect page title to contain id");
		wait.until(ExpectedConditions.urlContains("id"));

		return element;
	}
	
	public static WebElement prospectList_AddProspectToList(WebDriver driver, String randomName, String emailID) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		// Assumption - The newly created Prospect List is always on 1st Row
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//*[@id='prospect_row_a0']/td[3]/a"), emailID));
		Log.info(driver.findElement(By.xpath(".//*[@id='prospect_row_a0']/td[3]/a")).getText());
		Log.info(driver.findElement(By.xpath(".//*[@id='prospect_row_a0']/td[3]/a")).getAttribute("href"));
		
		String ProspectID = driver.findElement(By.xpath(".//*[@id='prospect_row_a0']/td[3]/a")).getAttribute("href");
		Log.info(ProspectID);
		
		int endIndex = ProspectID.lastIndexOf("/");
		int length = driver.findElement(By.xpath(".//*[@id='prospect_row_a0']/td[3]/a")).getAttribute("href").length();
		
		System.out.println("endIndex is " +endIndex);
		String ActProspectID = ProspectID.substring(endIndex+1);
		System.out.println("ActProspectID is " +ActProspectID);

		if (endIndex !=-1) {
			if(!(ActProspectID.contains("#"))) {
				//ProspectID = driver.getCurrentUrl().substring(endIndex+1, length);
				Log.info("Prospect id doesn't contain # " +ProspectID);
			}
		}
		
		driver.get("https://pi.pardot.com/list/prospect/prospect_id/"+ActProspectID);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Select a list to add...')]")));
		
		WebElement listDropDown = driver.findElement(By.xpath("//span[contains(.,'Select a list to add...')]"));
		listDropDown.click();
		
		driver.findElement(By.xpath("//li[text()='"+randomName+"']")).click();
		wait.until(ExpectedConditions.textToBePresentInElement(listDropDown, "Select a list to add..."));
		driver.findElement(By.xpath("//span[contains(.,'Select a list to add...')]")).submit();			
	
		return element;
	}

}
