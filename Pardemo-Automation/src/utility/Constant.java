package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Constant {
 
       public static final String baseURL = "https://pi.pardot.com";
 
       public static final String userName = "pardot.applicant@pardot.com";
 
       public static final String passWord = "Applicant2012";
       
       public static final String loggedInUserXpath = "//a[contains(.,'pardot.applicant@pardot.com')]";
 
       public static final String logOutXpath = "//a[@href='/user/logout']";
       
       public static final String logOutTitle = "Sign In - Pardot";
       
       // Marketing->Segmentation->List Names Constants
       public static final String mXpath = "//span[contains(.,'Marketing')]";
       
       public static final String msXpath = "//a[@href='/segmentation']";
       
       public static final String msListXpath = "//a[@href='/list']";

       public static final String addListXpath = "//a[@id='listxistx_link_create']";

       public static final String mEmailXpath = "//a[@href='/email']";

       public static final String mEmailNewEmailXpath = ".//*[@id='dropmenu-marketing']/li[7]/ul/li[9]/a";
       
       public static final String pXpath = "//span[contains(.,'Prospects')]";
       public static final String pListXpath = "//a[@href='/prospect']";
       public static final String pListCreateXpath = "//a[@id='pr_link_create']";

       public static final String scoreVal = "5";

   }

