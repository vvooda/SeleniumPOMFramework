package framework.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.logging.Log;
import framework.utilities.WebDriverUtilities;
                           

public class BaseBlaze extends BasePageObject{

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Add/Remove Elements']")
    WebElement lnkAddRemove;
    
 

    protected WebDriver webDriver;

    public BaseBlaze(WebDriver webDriver) {
    	super(webDriver);
        PageFactory.initElements(webDriver, this);
        }


    public void openUrl(String url) {
    	webUtils.openUrl(url);
    }



    public void clickAddRemove() {

    	webUtils.clickOnElement(lnkAddRemove);
     }


	
}
