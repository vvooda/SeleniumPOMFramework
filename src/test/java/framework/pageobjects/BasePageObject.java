package framework.pageobjects;
import org.openqa.selenium.WebDriver;

import framework.logging.Log;
import framework.utilities.WebDriverUtilities;
import framework.logging.*;

public class BasePageObject {
	
	protected WebDriver webDriver;
	protected WebDriverUtilities webUtils;
	

		public BasePageObject(WebDriver webDriver) {
			this.webDriver = webDriver;
			this.webUtils = new WebDriverUtilities(webDriver);
		}
	}

