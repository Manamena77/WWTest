package pageOpjectModel;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.library.BaseClass;
import com.library.Library;
import com.library.ObjectMap;

public class FindaWorkShop extends BaseClass {

	final static Logger logger = Logger.getLogger(FindaWorkShop.class);

	static String result;
	static String address;

	public FindaWorkShop enterLocation() {

		try {

			WebElement location = driver.findElement(map.getLocator("location"));
			selLib.enterText(location, "10011");
			WebElement searchLocation = driver.findElement(map.getLocator("searchLocation"));
			selLib.clickButton(searchLocation);

		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return this;

	}

	public FindaWorkShop results() {
		try {
			selLib.customWait(2);
			WebElement firstResult = driver.findElement(map.getLocator("firstResult"));
			selLib.customWait(1);
			selLib.scrollToElement(firstResult);
			result = firstResult.getText();
			System.out.println(result);
			WebElement distance = driver.findElement(map.getLocator("distance"));
			System.out.println("Distance is: " + distance.getText());
			WebElement firstAddress = driver.findElement(map.getLocator("firstAddress"));
			address = firstAddress.getText();
			System.out.println(address);
			selLib.clickHiddenElement(firstResult);

		} catch (Exception e) {
			logger.error("Error: ", e);
		}

		return this;

	}

}
