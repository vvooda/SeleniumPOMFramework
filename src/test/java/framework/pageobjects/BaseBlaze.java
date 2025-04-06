package framework.pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import framework.utilities.UtilityConstants;
                           

public class BaseBlaze extends BasePageObject{

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Add/Remove Elements']")
    WebElement lnkAddRemove;
    

    public BaseBlaze(WebDriver webDriver) {
    	super(webDriver);
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, UtilityConstants.PAGE_LOAD), this);
        }

	/**
	 * To open specified URL
	 * @param url
	 * 
	 */
    public void openUrl(String url, String title) {
    	webUtils.openUrl(url,title);
    }


	/**
	 * To click on Button link
	 * 
	 */
    public void clickAddRemove() {

    	webUtils.clickOnElement(lnkAddRemove);
     }


	
}
