# Pardemo-Automation

Importing the Project into Eclipse IDE

1. Import as new Git project into Eclipse [Need to have Git plugin and TestNG plugin installed]

2. Add jars (Java Build Path-> External jar's [log4j, selenium] , library [TestNG]

3. testng.xml [Contains all the params that will be used by the TestNG Framework]

4. log4j.xml [Contains logging config for log4j]

In case, there is difficulty in importing the project using the above 4 steps then Scroll to end of this README.md file for optional section.

Running the Test:

5. Open testng.xml and change the parameter emailID value to "test22@email.com" 
    [You need to change this value after each test suite run. Eg: subsequent runs you want to enter "test23@email.com", test24@email.com]

6. Right click on testng.xml and choose RunAs->TestNG Suite

7. Now TestNG.java is the file that will drive all the workflow tests

8. TestNG.java [Contains test steps that are prioritized in order for easy understanding and execution]

Test Reports:

9. After the test suite successfully runs

10. Goto test-folder->index.html ->open with web browser 
    [if you're running this first time, then you might need to refresh the project after your test run for the folder to show up]

11. On browser(index.html) click on ReporterOutput :Screenshot of a sample TestReport:

12. All loggings are in logfile.log

///////////////////////////////////// OPTIONAL ////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

In case you find it difficult to import the project into Eclipse then the simplest thing to do would be…these….

1a. Install TestNG plugin for Eclipse. Download the Pardemo-Automation.zip and extract its contents.
1b. Download the selenium jar, log4j jar
http://selenium-release.storage.googleapis.com/2.50/selenium-java-2.50.1.zip
http://mirror.stjschools.org/public/apache/logging/log4j/1.2.17/log4j-1.2.17.zip
1c. Unzip them

2a. Create a new Java Project named 'Pardemo-Automation'
2b. RightClick on 'Pardemo-Automation' -> Properties -> Java build path -> Add external Jars
2c. Select the selenium jar and alse the jars from lib folder in selenium that you unzipped in step 1c.
2d. Select the log4j jar that you unzipped in step 1c.
2e. RightClick on 'Pardemo-Automation' -> Properties -> Java build path -> Add library
Select TestNG and click OK button

3. We need to create 4 packages
   a. Create a new package -> appModule
   b. Create a new package -> automationFramework
   c. Create a new package -> pageObjects
   d. Create a new package -> utility

4. Next, we want to create java class under these packages
   a. Create a new java class under appModule named SignIn_Action.java
   a. Create a new java class under automationFramework named TestNG.java
   a. Create a new java classes under pageObjects named (Login_Page.java, Logout_Page.java, MarketingEmail_Page.java, MarketingSegmentation_Page.java, ProspectList.java)
   a. Create a new java classes under utility named (Constant.java, Log.java)

5. Copy the contents of the extracted downloaded files into the corresponding new files that we created in step 4.

6. In eclipse Create new files under 'Pardemo-Automation' project named [testng.xml, log4j.xml] 

7. Copy the contents of the extracted downloaded files into the corresponding new files [testng.xml, log4j.xml]

Done !!!

Next, Follow steps on how to run the project.
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
