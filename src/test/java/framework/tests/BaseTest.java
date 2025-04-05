package framework.tests;
import org.openqa.selenium.WebDriver;
import framework.utilities.CommonUtilities;



public class BaseTest extends Connection {
	protected CommonUtilities commonUtil = null;
	
	protected WebDriver getDriver() {
		getConnection();	
		commonUtil = new CommonUtilities(driver);
		return driver;

		
	}
	
	/**
	 * To get page title 
	 * 
	 */
	protected String getTitle() {

        return driver.getTitle();

    }

	
	/**
	 * To close all browsers initiated by Selenium 
	 * 
	 * 
	 */
    protected void quit() {
        driver.quit();

    }

	
}
