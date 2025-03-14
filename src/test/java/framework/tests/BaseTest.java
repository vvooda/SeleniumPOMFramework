package framework.tests;
import framework.logging.Log;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest extends Connection {
	
	
	protected WebDriver getDriver() {
		getConnection();		
		return driver;

		
	}
	
	
	protected String getTitle() {

        return driver.getTitle();

    }

	
	
    protected void quit() {
        driver.quit();

    }

	
}
