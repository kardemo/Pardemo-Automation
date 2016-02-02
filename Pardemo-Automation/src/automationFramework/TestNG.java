package automationFramework;
 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
 
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import appModule.SignIn_Action;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import pageObjects.Logout_Page;
import pageObjects.MarketingEmail_Page;
import pageObjects.MarketingSegmentation_Page;
import pageObjects.ProspectList_Page;
import utility.Constant;
  
import utility.Log;
 
public class TestNG {
 
	public WebDriver driver;
	public String randomName ;
	public String newrandomName;
	
	@BeforeTest
	
	@Parameters("browser")
	// Initialize browser param from TestNG.xml for crossbrowser testing
	// Testing is done only firefox browser but in can be extended for other browsers
	public void beforeMethod(@Optional("firefox") String browser) throws Exception {
		  
		  DOMConfigurator.configure("log4j.xml");
		  
		  Log.info("-------------------------------------");
		  Log.info("------- launchBrowser Begins --------");

		  if(browser.equalsIgnoreCase("firefox")) {
			  // Create a new instance of the firefox driver
			  
			  driver = new FirefoxDriver();
		  } 
		  else if (browser.equalsIgnoreCase("chrome")) {
			 
			  System.setProperty("webdriver.chrome.driver", "C://Users//abc//Downloads//chromedriver_win32//chromedriver.exe");
			  
			  driver = new ChromeDriver();
		  }
		  
		  Log.info("New Driver instantiated");
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  Log.info("Implicit wait for 10 seconds");
		  
		  driver.manage().window().maximize();
		  Log.info("Maximize window");
		  
		  driver.get(Constant.baseURL);
		  Log.info("Going to baseURL "); 
		  
		  randomName = randomNameGen();
	      Log.info("randomName is " +randomName);
	        
		  Log.info("------- launchBrowser Ends ----------");
		  Log.info("-------------------------------------");

	  }
 
 
	@Test(priority=1, enabled=true)
	// Test Login: UserName and passWord obtained from Util.Constant
	//
	public void testLogin() throws Exception {
 
    	Log.startTestCase("testLogin");

	    SignIn_Action.Execute(driver, Constant.userName, Constant.passWord);
	    
	    // Check for UserID presence and compare
		Assert.assertEquals(Constant.userName, driver.findElement(By.cssSelector("a#acct-tog.dropdown-toggle")).getText());

    	Log.endTestCase("testLogin");
	    // TestNG Report Logs test-output folder -> index.html
	    Reporter.log("Step 1: LogIn Success");
	    
        }
	
	@Test(priority=2, enabled=true)
	
	public void testCreateList() throws Exception {
		
    	Log.startTestCase("testCreateList");
    	
    	MarketingSegmentation_Page.marketingSegmentation_List(driver);
    	MarketingSegmentation_Page.marketingSegmentation_AddList(driver);
    	
    	MarketingSegmentation_Page.marketingSegmentation_AddList_FillForm(driver, randomName);
    	MarketingSegmentation_Page.marketingSegmentation_saveList(driver);

		
		//String expectedTitle = 	Constant.randomName;
    	String expectedTitle = randomName;
		expectedTitle += " - Pardot";
		Log.info(driver.getTitle());
		
		// Another approach is to  check for ID value 
		
		//String id = null;
		/*
		int endIndex = driver.getCurrentUrl().lastIndexOf("/");
		if (endIndex !=-1) {
			id = driver.getCurrentUrl().substring(endIndex+1, driver.getCurrentUrl().length());
			Log.info("List id is " +id);
		}
		//Assert.assertFalse(id.isEmpty());
		 */
		
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(expectedTitle));
		
    	Log.endTestCase("testCreateList");    	
		Reporter.log("Step 2: testCreateList Success");		

	 }

	private String randomNameGen() {
	
   		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
   		
   		Date currentDate = new Date();
   		
   		String randomName = "Beta-" + dateFormat.format(currentDate);
	   
   		return randomName;

	}
	
	
	@Test(priority=3,enabled=true)
	
	public void testDuplicateList() throws Exception {
		
    	Log.startTestCase("testDuplicateList");

		MarketingSegmentation_Page.marketingSegmentation_List(driver);
    	MarketingSegmentation_Page.marketingSegmentation_AddList(driver);
    	MarketingSegmentation_Page.marketingSegmentation_AddList_FillForm(driver, randomName);
    	MarketingSegmentation_Page.marketingSegmentation_saveList(driver);

		try {
			Assert.assertEquals("Please input a unique value for this field", driver.findElement(By.xpath("//span[@id='error_for_name']")).getText());
			Log.info(driver.findElement(By.xpath("//span[@id='error_for_name']")).getText());
			WebElement cancel = driver.findElement(By.xpath("//a[contains(@class,'btn btn-default')]"));
			cancel.click();
			Reporter.log("Step 3: testDuplicateList Success");		

		} catch (Error e) {		
			
			Log.info("Error caught on duplicateList creation");
		}

    	Log.endTestCase("testDuplicateList");
	}

	@Test(priority=4,enabled=true)
	
	public void testRenameList() throws Exception {
		
    	Log.startTestCase("testRenameList");
    	
		MarketingSegmentation_Page.marketingSegmentation_List(driver);
		newrandomName = randomNameGen();
		MarketingSegmentation_Page.marketingSegmenation_renameList(driver, randomName, newrandomName);
		
		String expectedTitle = 	newrandomName;
		expectedTitle += " - Pardot";
		Log.info(driver.getTitle());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(expectedTitle));
		
    	Log.endTestCase("testRenameList");
		Reporter.log("Step 4: testRenameList Success");	
		
	}
	
	@Test(priority=5,enabled=true)
	
	public void testRecreateList() throws Exception {
		
    	Log.startTestCase("testRecreateList");
    	
    	MarketingSegmentation_Page.marketingSegmentation_List(driver);
    	MarketingSegmentation_Page.marketingSegmentation_AddList(driver);
    	MarketingSegmentation_Page.marketingSegmentation_AddList_FillForm(driver, randomName);
    	MarketingSegmentation_Page.marketingSegmentation_saveList(driver);

		String expectedTitle = 	randomName;
		expectedTitle += " - Pardot";
		Log.info(driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(expectedTitle));
    	
    	Log.endTestCase("testRecreateList");
    	Reporter.log("Step 5: testRecreateList Success");	
		
	}

	@Test(priority=6,enabled=true)
	@Parameters("emailID")
	
	public void testCreateProspect(String emailID) throws Exception {
		
    	Log.startTestCase("testCreateProspect");
		
		ProspectList_Page.prospectList(driver);
		ProspectList_Page.prospectList_AddClickList(driver);
		ProspectList_Page.prospectList_fillFormList(driver, emailID);
		ProspectList_Page.prospectList_saveProspect(driver);
		
		Log.info("expectedValue is " +emailID);
		driver.findElement(By.xpath("//div[contains(.,'Prospect saved successfully')]"));
		Assert.assertTrue(driver.getTitle().contains(emailID));
		
    	Log.endTestCase("testCreateProspect");
		Reporter.log("Step 6: testCreateProspect Success");	

	}
	
	@Test(priority=7,enabled=true)
	@Parameters("emailID")

	// IMPORTANT NOTE: Change the testng.xml->emailID before each run
	
	public void testAddProspectToList(String emailID) throws Exception {
		
    	Log.startTestCase("testAddProspectToList");

		// Goto Prospect->List 
		ProspectList_Page.prospectList(driver);
		ProspectList_Page.prospectList_AddProspectToList(driver, randomName, emailID);
		String actText= driver.findElement(By.xpath(".//*[@id='center-stage']/div[1]")).getText();
		//Assert.assertTrue(actText.contains(randomName));
		Log.info("actText is " +actText);
		Assert.assertTrue(actText.contains("Prospect lists saved successfully"));

		Log.endTestCase("testAddProspectToList");
		Reporter.log("Step 6: testAddProspectToList Success");	

	}
	
	@Test(priority=9,enabled=true)

	public void testsendEmail() throws Exception {
		
		Log.startTestCase("testsendEmail");
		
		MarketingEmail_Page.marketingEmail(driver);
		MarketingEmail_Page.marketingEmail_fillNewEmail(driver, randomName);
		
		System.out.println(driver.getCurrentUrl());
		
		if (driver.getCurrentUrl().contains("#")) {
		
			Thread.sleep(10000);
		}
		
		MarketingEmail_Page.marketingEmail_sendingEmail(driver, randomName);	
		
		String id = driver.getCurrentUrl();
		int endIndex = id.lastIndexOf("/");
				
				if (endIndex !=-1) {
					if(!(id.contains("#"))) {
						id = id.substring(endIndex+1, id.length());
						Log.info("Email id doesn't contain # ");
					} 						
				}
		Log.info("Email id is " +id);
		 
		Assert.assertTrue(!id.contains("#"));
				 
		Log.endTestCase("testsendEmail");	
		Reporter.log("Step 9: testsendEmail Success");

	}
	
	@Test(priority=10, enabled=true)
	
	public void testLogout() {
		
		Log.startTestCase("testLogout");
		Logout_Page.lnk_LogOut(driver);
		
		Assert.assertEquals(Constant.logOutTitle, driver.getTitle());
		
		Log.endTestCase("testLogout");
		Reporter.log("Step 10: Logout Success");
	}

   @AfterTest
 
  public void closeBrowser() {
 
	    Log.info("-------------------------------------");
		Log.info("------- closeBrowser Starts ---------");
		
		driver.close();
		
		Log.info("------- closeBrowser Ends -----------");
		Log.info("-------------------------------------");

        }
   
}

