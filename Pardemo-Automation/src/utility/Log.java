 package utility;
 
import org.apache.log4j.Logger;
 
 public class Log {
 
// Initialize Log4j logs
 
	 private static Logger Log = Logger.getLogger(Log.class.getName());//
 
// Print logs for start of test case
 public static void startTestCase(String sTestCaseName){
 
	Log.info("************************************************");
	Log.info("*************" +sTestCaseName+ "Starts ***************");
	Log.info("************************************************");
	}
 
// Print logs for end of test case
 
 public static void endTestCase(String sTestCaseName){
 
		Log.info("************************************************");
		Log.info("*************" +sTestCaseName+ "Ends ***************");
		Log.info("************************************************");
	}
 
	// Need to create these methods, so that they can be called  
 
 public static void info(String message) {
 
		Log.info(message);
 
		}
 
 public static void warn(String message) {
 
    Log.warn(message);
 
	}
 
 public static void error(String message) {
 
    Log.error(message);
 
	}
 
 public static void fatal(String message) {
 
    Log.fatal(message);
 
	}
 
 public static void debug(String message) {
 
    Log.debug(message);
 
	}
 
}

