package framework.tests;



import framework.logging.Log;
import framework.pageobjects.BaseBlaze;
import framework.utilities.UtilityConstants;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class BlazeDemo extends BaseTest {
	 private BaseBlaze bb;

    @BeforeClass
    public void setup(){
        bb = new BaseBlaze(getDriver());
        
    }


    @Test(priority=1)
    public void openUrlPage(){
    	bb.openUrl(UtilityConstants.URL, UtilityConstants.title);
    	
    	Log.info("openURL test completed");
    }


    @Test(dependsOnMethods = { "openUrlPage" })
    public void buttonDemo(){
    	bb.clickAddRemove();
    	Log.info(" Button Demo Completed");
    }
    
    @AfterClass
    public void quitBrowser(){
       quit();
        
    }

}
