package framework.utilities;



import framework.logging.Log;
import java.time.Duration;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WebDriverUtilities {
    
    WebDriver driver;

	public WebDriverUtilities(WebDriver driver){
    	this.driver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilityConstants.PAGE_LOAD));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilityConstants.IMPLICIT_LOAD));

    }


	/**
	 * Go to specified url 
	 * @param url
	 * 
	 */
    public void openUrl(String url) {
        driver.get(url);
        waitForPageToLoad();
    }

	/**
	 * Go to specified url and validate page title
	 * @param url
	 * @param title
	 * 
	 */
    public void openUrl(String url,String title) {
        driver.get(url);
        waitForPageToLoad();
        Assert.assertEquals(title, driver.getTitle(), "Page title not matching");
    }

	/**
	 * Check visibility of element and click on WebElement 
	 * @param we
	 */    
    public void clickOnElement(WebElement we) {
    	
        if (isElementClickable(we)) {	
        	we.click();
        	}
        
        }
        
	/**
	 * Retrieve title of page
	 */
    public String getTitle(){
        return driver.getTitle();
    }




	/**
	 * Select an option from drop down using its Visible text
	 * 
	 * @param we
	 * @param visibleText
	 */
	public void selectOptionDropDownByVisibleText(WebElement we,
			String visibleText) {
			if (isElementVisible(we)) {
				Select dropdown = getSelectFromWebElement(we);
				dropdown.selectByVisibleText(visibleText);
				
				String selectedText = dropdown.getFirstSelectedOption().getText();
				Assert.assertEquals(selectedText, visibleText, "Dropdown selection failed!");
			}
	 }



	/**
	 * De -Select any selected option from drop down.
	 * 
	 * @param we
	 */
	public void deselectAdropDownOptions(WebElement we) {
		Select selectBox = getSelectFromWebElement(we);
		selectBox.deselectAll();
	}
	
	/**
	 * Select any selected option from drop down.
	 * 
	 * @param we
	 */
	private Select getSelectFromWebElement(WebElement we) {
		return new Select(we);
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
               .ignoring(TimeoutException.class, NoSuchElementException.class);

		for (WebElement we : wes) {
			
			 try {
				 wait.until(ExpectedConditions.visibilityOf(we));
				 isElementPresent = true;
			 }
		        
		        catch (Exception ex) {
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
		            Log.info("Element not clickable");
		            ex.printStackTrace();

		        }
			
			
		}
		 return isElementClickable;

	}	
	
	/**
	 * Method to check whether page is in ready state
	 * 
	 */	
	public void checkPageIsReady() {

		  JavascriptExecutor js = (JavascriptExecutor)driver;


		  //Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   System.out.println("Page Is loaded.");
		   return; 
		  } 

		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<25; i++){ 
		   try {
		    Thread.sleep(1000);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   }   
		  }
		 }
	

	/**
	 * Method to wait for page to load
	 * 
	 */		
	public void waitForPageToLoad() {
	    new WebDriverWait(driver, Duration.ofSeconds(UtilityConstants.PAGE_LOAD)).until(
	        webDriver -> ((JavascriptExecutor) webDriver)
	            .executeScript("return document.readyState").equals("complete")
	    );
	}

}
