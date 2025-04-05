package framework.logging;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import framework.utilities.CommonUtilities;



public class UITestListener implements ITestListener {
	
	 
	@Override
	  public void onTestFailure(ITestResult tr ) {
		System.out.println("****onTestFailure - capture screenshot***");
		CommonUtilities.captureScreenshot(tr.getName());
		Log.info("**Test Failed** - " +tr.getName());
	}


	@Override
	public void onFinish(ITestContext tr) {
		Log.info("===============================");
		Log.info("**Test Finished**" + tr.getName());
		Log.info("===============================");
	}


	@Override
	public void onStart(ITestContext arg0) {
		
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestSkipped(ITestResult arg0) {
		Log.info("**Skipped test** - " +arg0.getName());
		
	}


	@Override
	public void onTestStart(ITestResult arg0) {
		
	}


	@Override
	public void onTestSuccess(ITestResult tr) {
		Log.info("**Successfully executed test** - " +tr.getName());
	}
	
}
