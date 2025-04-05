package framework.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	
	 //Initialize Log4j instance
    public static final Logger Log =  LogManager.getLogger(Log.class);
    
	/**
	 * Info Level Logs 
	 * @param message
	 * 
	 */
    public static void info (String message) {
        Log.info(message);
    }
    
	/**
	 * Error Level Logs 
	 * @param message
	 * 
	 */
    public static void error (String message) {
        Log.error(message);
    }
    
 
	/**
	 * Fatal Level Logs 
	 * @param message
	 * 
	 */
    public static void fatal (String message) {
        Log.fatal(message);
    }
    
    

	/**
	 * Debug Level Logs 
	 * @param message
	 * 
	 */
    public static void debug (String message) {
        Log.debug(message);
    }
}
