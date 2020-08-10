package pageOpjectModel;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.library.BaseClass;
import com.library.Library;
import com.library.ObjectMap;

public class HomePage extends BaseClass {

	final static Logger logger = Logger.getLogger(HomePage.class);
	
	

	public HomePage navigateToHomePage() {

		try {
			driver.get("https://www.weightwatchers.com/us/");
			String expectedTitle = "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA";
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			Assert.assertTrue(expectedTitle.equals(actualTitle));

		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return this;

	}

	public HomePage findaWorkshop() {
		try {
			
			WebElement workshop = driver.findElement(map.getLocator("workshop"));
			selLib.clickButton(workshop);
			selLib.customWait(2);
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			
			String expectedTitle = "Find WW Studios & Meetings Near You | WW USA";
			Assert.assertTrue(expectedTitle.equals(actualTitle));

			
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return this;
	}

}
