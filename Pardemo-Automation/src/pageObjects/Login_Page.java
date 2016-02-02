 package pageObjects;
 
import org.openqa.selenium.*;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
 
public class Login_Page {
 
        private static WebElement element = null;
 
    public static WebElement txtbx_UserName(WebDriver driver){
 
    	 element = driver.findElement(By.id("email_address"));
    	
         return element;
 
         }
 
     public static WebElement txtbx_Password(WebDriver driver){
 
    	 element = driver.findElement(By.id("password"));
 
         return element;
 
         }
 
     public static WebElement btn_LogIn(WebDriver driver){
 
         element = driver.findElement(By.cssSelector("input.btn.btn-primary"));
 
         return element;
 
         }
 
}

