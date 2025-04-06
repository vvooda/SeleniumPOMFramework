package framework.tests;

import org.testng.Assert;

import framework.logging.Log;
import framework.pageobjects.BaseBlaze;
import framework.utilities.UtilityConstants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ButtonDemo extends BaseTest{

	private BaseBlaze bb;
	
	@Before
	public void setup() {
		 bb = new BaseBlaze(getDriver());
	}
	
	@Given("User is on selenium playbook base page")
	public void user_is_on_selenium_playbook_base_page() {
	    // Write code here that turns the phrase above into concrete actions
    	bb.openUrl(UtilityConstants.URL, UtilityConstants.title);    	
    	Log.info("openURL test completed");
	}
	
	@When("Click on Add Remove link")
	public void click_on_add_remove_link() {
    	bb.clickAddRemove();
    	Log.info(" Button Demo Completed");
	}
	@Then("validate Button page")
	public void validate_button_page() {
	    // Write code here that turns the phrase above into concrete actions
		String pageTitle = getTitle();
		Assert.assertEquals(pageTitle.contains(UtilityConstants.title),true,"Page title mismatch");
	}
	
	@After
	public void cleanUp() {
		quit();
	}
}
