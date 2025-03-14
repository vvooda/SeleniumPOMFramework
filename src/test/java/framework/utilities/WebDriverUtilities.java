package framework.utilities;

import java.io.File;

import framework.logging.Log;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtilities {
    
    WebDriver driver;

    @SuppressWarnings("deprecation")
	public WebDriverUtilities(WebDriver driver){
    	this.driver = driver;
        driver.manage().window().maximize();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(UtilityConstants.PAGE_LOAD, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(UtilityConstants.IMPLICIT_LOAD, TimeUnit.SECONDS);

    }


    public void openUrl(String url) {
        driver.get(url);
    }


    public void clickOnElement(WebElement element) {
    	
        if (isElementClickable(element)) {	
        	element.click();
        	}
        
        }
        

    public String getTitle(){
        return driver.getTitle();
    }




	/**
	 * Select an option from drop down using its Visible text
	 * 
	 * @param selectParentId
	 * @param visibleText
	 */
	public void selectOptionDropDownByVisibleText(WebElement we,
			String visibleText) {
			if (isElementVisible(we)) {
				Select dropdown = getSelectFromWebElement(we);
				dropdown.selectByVisibleText(visibleText);
			}
	 }



	/**
	 * De -Select any selected option from drop down.
	 * 
	 * @param selectParentId
	 */
	public void deselectAdropDownOptions(WebElement we) {
		Select selectBox = getSelectFromWebElement(we);
		selectBox.deselectAll();
	}
	
	private Select getSelectFromWebElement(WebElement we) {
		return new Select(we);
	}
	
	/**
	 * This method captures screenshot and put in the defined location
	 * 
	 * @throws IOException
	 */
	public void captureScreenshot(String testName)  {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			//FileUtils.copyFile(scrFile, new File(UtilityConstants.SCREENSHOT_FOLDER));
			Files.copy(scrFile, new File(UtilityConstants.SCREENSHOT_FOLDER));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Method to check visibility of an element
	 * 
	 * @param wes
	 * @return
	 */
	public boolean isElementVisible(WebElement... wes) {
		boolean isElementPresent = false;
		 Wait<WebDriver> wait
         = new FluentWait<>(driver)
               .withTimeout(Duration.ofSeconds(UtilityConstants.MINUTE_INTERVAL))
               .pollingEvery(Duration.ofSeconds(UtilityConstants.TIMEOUT))
               .ignoring(TimeoutException.class);

		for (WebElement we : wes) {
			
			 try {
				 wait.until(ExpectedConditions.visibilityOf(we));
				 isElementPresent = true;
			 }
		        
		        catch (Exception ex) {
		        	captureScreenshot("EleNotVisible");
		            Log.info("Element not visible");
		            ex.printStackTrace();
		        }
			
			
		}
		 return isElementPresent;

	}	

	
	/**
	 * Method to check visibility of an element
	 * 
	 * @param wes
	 * @return
	 */
	public boolean isElementClickable(WebElement... wes) {
		boolean isElementClickable = false;
		 Wait<WebDriver> wait
         = new FluentWait<>(driver)
               .withTimeout(Duration.ofSeconds(UtilityConstants.MINUTE_INTERVAL))
               .pollingEvery(Duration.ofSeconds(UtilityConstants.TIMEOUT))
               .ignoring(TimeoutException.class);

		for (WebElement we : wes) {
			
			 try {
				 wait.until(ExpectedConditions.elementToBeClickable(we));
				 isElementClickable = true;
			 }
		        
		        catch (Exception ex) {
		        	captureScreenshot("EleNotClickable");
		            Log.info("Element not clickable");
		            ex.printStackTrace();

		        }
			
			
		}
		 return isElementClickable;

	}	

}
