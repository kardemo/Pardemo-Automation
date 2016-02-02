package appModule;
 
import org.openqa.selenium.WebDriver;

import pageObjects.Login_Page;
 
 
 public class SignIn_Action{
 
   public static void Execute(WebDriver driver,String sUsername, String sPassword){
  
   Login_Page.txtbx_UserName(driver).sendKeys(sUsername);
 
   Login_Page.txtbx_Password(driver).sendKeys(sPassword);
 
   Login_Page.btn_LogIn(driver).click();
 
   }
 
}

