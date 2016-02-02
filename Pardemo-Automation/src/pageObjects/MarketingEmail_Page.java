package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import automationFramework.List;
//import automationFramework.Random;
import utility.Constant;
import utility.Log;

public class MarketingEmail_Page {

    private static WebElement element = null;

	public static WebElement marketingEmail(WebDriver driver) throws Exception {
		
	 	Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);

	 	WebElement marketHoverLink = driver.findElement(By.xpath(Constant.mXpath));
		actions.moveToElement(marketHoverLink).perform();
		Log.info("Menu Marketing Hover Link");

		WebElement marketEmailLink = driver.findElement(By.xpath(Constant.mEmailXpath));
		actions.moveToElement(marketEmailLink).perform();
		Log.info("Menu Marketing->Email Hover Link");
		
		
		//WebElement moveonMenu = driver.findElement(By.xpath(mXpath));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constant.mEmailNewEmailXpath)));
		Log.info("Waiting for Marketing->Email->New Email Link");
		
		//actions.moveToElement(submenuHoverLink).moveToElement(driver.findElement(By.xpath(msListXpath))).click().perform();
		driver.findElement(By.xpath(Constant.mEmailNewEmailXpath)).click();
		Log.info("Clicking Marketing->Email->New Email Link");
		
		return element;
	}
	
	public static WebElement marketingEmail_fillNewEmail(WebDriver driver, String randomName) throws Exception {

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(randomName);
		driver.findElement(By.xpath("//input[@id='email_type_text_only']")).click();
		driver.findElement(By.xpath("//input[@id='from_template']")).click();
		
		driver.findElement(By.xpath("//button[@onclick='AssetChooserApp.chooseAsset(jQuery(this).parent());']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		//Search Bbox enter template
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ember467']")));
		driver.findElement(By.xpath("//input[@id='ember467']")).sendKeys("template");
		
		// select email template from it
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(.,' Email Template test')]")));
		driver.findElement(By.xpath("//h4[contains(.,' Email Template test')]")).click();
		
		// click on choose selected
		driver.findElement(By.xpath("//button[@id='select-asset']")).click();
		//driver.findElement(By.xpath("//button[contains(.,'Choose Selected')]")).isSelected();
		Log.info("Click on Choose");
		
		element = driver.findElement(By.xpath("//a[@id='save_information']"));
		element.click();
		Log.info("save fill email form");
		
		return element;
		
	}
	
	public static WebElement marketingEmail_sendingEmail(WebDriver driver, String randomName) throws Exception {

		
		WebDriverWait wait = new WebDriverWait(driver, 60);

		String ID = driver.getCurrentUrl();
	
		int endIndex = ID.lastIndexOf("/");
	
		System.out.println("endIndex is " +endIndex);
		String ActID = ID.substring(endIndex+1);
		System.out.println("ActID is " +ActID);

		driver.get("https://pi.pardot.com/email/draft/send/id/"+ActID);
	
		WebElement listDropDown = driver.findElement(By.xpath("//span[contains(.,'Select a list to add...')]"));
		listDropDown.click();
		Log.info("Clicked on LstDrop Down ");

		driver.findElement(By.xpath("//li[text()='1aS4vNiZsr']")).click();
		wait.until(ExpectedConditions.textToBePresentInElement(listDropDown, "Select a list to add..."));
	
		Select senderSelect = new Select(driver.findElement(By.xpath("//select[@name='a_sender[]']")));
		senderSelect.selectByVisibleText("Specific User");
		Log.info("Send to Specific User");		 
	
		driver.findElement(By.xpath("//input[@id='subject_a']")).sendKeys("Email Test send");;
		driver.findElement(By.xpath("//button[@id='save_footer']")).click();
		Log.info("Enter subject and click save");		 
	
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//button[@id='save_footer']"), "Save"));

	//	driver.findElement(By.xpath("//div[@id='schedule_sidebar']/a[text()='Send Now')]")).click();
		Log.info("click send email");
	
		return element;
	
	}

}
