package framework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import framework.logging.Log;

public class CommonUtilities {
	public static WebDriver driver = null;
	static int scrCapNumber;
	
	public CommonUtilities(WebDriver driver){
		CommonUtilities.driver = driver;
	}
	
	/**
	 * Takes screenshot
	 * 
	 * @param filename
	 */
	public static void captureScreenshot(String filename) {
		scrCapNumber++;
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		filename = scrCapNumber + "_" + filename + "_"+ dateFormat.format(new Date());

		File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Log.info("File Name for the exception: " + filename);
			String relativePath = "screenshots/";
			FileUtils.copyFile(tempFile, new File(relativePath + File.separator + filename + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
