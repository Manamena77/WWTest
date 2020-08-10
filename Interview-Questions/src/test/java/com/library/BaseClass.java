package com.library;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	final static Logger logger = Logger.getLogger(BaseClass.class);

	public static WebDriver driver;
	public static Library selLib;
	public static ObjectMap map;
	private String myBrowser;
	private String myDemoMode;
	

	@BeforeMethod // this method will run before every single test method
	public void set_up() {
		try {
			logger.info("Start a single test...");

			if (myDemoMode.toLowerCase().contains("true")) {
				selLib.setDemoMode(true);
				driver = selLib.startBrowser(myBrowser);

			} else {
				driver = selLib.startBrowser(myBrowser);
			}
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	@AfterMethod // this method will run after every single test OR after test
					// method fails
	public void tearDown(ITestResult result) {
		try {
			logger.info("End a single test...");
			if (ITestResult.FAILURE == result.getStatus()) {

			}
			if (driver != null) {
				driver.close();
			}
			Thread.sleep(5 * 1000);

		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	@AfterClass // this method will run only one time after all the tests are
				// completed
	public void afterAllTests() {
		try {
			if (driver != null) {
				driver.quit();
			}
			logger.info("All the test is completed...");

		} catch (Exception e) {
			logger.error("Error: ", e);
			// assertTrue(false);
		}
	}

	@BeforeClass // this method will run only one time right before all tests
					// starts
	public void beforeAllTests() {
		try {
			logger.info("Starting all the tests...");
			PropertiesManager properties = new PropertiesManager("src/test/resources/config.properties");
			map = new ObjectMap("src/test/resources/locators.properties");
			myBrowser = properties.readProperty("browserType");
			myDemoMode = properties.readProperty("demoMode");
			
			if (myDemoMode.toLowerCase().contains("true")) {
				logger.info("Demo mode is ON ....");
			} else {
				logger.info("Demo mode is OFF ...");
			}

			PropertiesManager propSession = new PropertiesManager("src/test/resources/configOutput.properties");
			selLib = new Library(driver);
			String tempSessionTime = selLib.getCurrentTime();
			propSession.setProperty("sessionTime", tempSessionTime);
			logger.info("Session Time: " + tempSessionTime);

		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}
}
