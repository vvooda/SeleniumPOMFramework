package framework.pageobjects;
import org.openqa.selenium.WebDriver;
import framework.utilities.WebDriverUtilities;


public class BasePageObject {
	
	protected WebDriver webDriver;
	protected WebDriverUtilities webUtils;
	

		public BasePageObject(WebDriver webDriver) {
			this.webDriver = webDriver;
			this.webUtils = new WebDriverUtilities(webDriver);
		}
	}

