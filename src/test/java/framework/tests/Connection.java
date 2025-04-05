package framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import framework.utilities.UtilityConstants;

public class Connection {
	
	protected WebDriver driver;
	protected static String browserType;
	
	
	protected static String getBrowserType() {
		browserType = UtilityConstants.BROWSER_TYPE;
		return browserType;
	}
	
	/**
	 * To get WebDriver  
	 * 
	 * 
	 */
    public void getConnection() {
    	
    	getBrowserType();
    	
    	if(browserType.contains("CHROME")) {
        driver = new ChromeDriver();
        
    	}
    	else {
    		driver = new EdgeDriver();	
    	}

    }

	

}
