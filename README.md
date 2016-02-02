# Pardemo-Automation

Importing the Project into Eclipse IDE

1. Import as new Git project into Eclipse [Need to have Git plugin and TestNG plugin installed]
2. Add jars (Java Build Path-> External jar's [log4j, selenium] , library [TestNG]
3. testng.xml [Contains all the params that will be used by the TestNG Framework]
4. log4j.xml [Contains logging config for log4j]

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
11. On browser(index.html) click on ReporterOutput
12. All loggings are in logfile.log

Screenshot of a sample TestReport
