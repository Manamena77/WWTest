package pageOpjectModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.library.BaseClass;
import com.library.ObjectMap;

public class MeetingDetails extends BaseClass {

	final static Logger logger = Logger.getLogger(HomePage.class);

	public MeetingDetails verifyResult() {
		try {
			String expctedResult = FindaWorkShop.result;
			String expectedAddress = FindaWorkShop.address;
			WebElement actualResult = driver.findElement(map.getLocator("actualResult"));
			WebElement actualAddress = driver.findElement(map.getLocator("actualAddress"));
			String visibileAddress = actualAddress.getText();
			String visibleResult = actualResult.getText();
			Assert.assertEquals(visibleResult, expctedResult);
			Assert.assertEquals(visibileAddress, expectedAddress);

		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return this;
	}

	public MeetingDetails getTodaysTimes() {
		try {
			Calendar calendar = Calendar.getInstance();
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			WebElement dayArea = driver.findElement(By.xpath(dayLocator(dayOfWeek)));
			selLib.scrollToElement(dayArea);
			List<WebElement> dayElements = dayArea.findElements(By.tagName("span"));

			System.out.println("**** Today's Hours Of Operation are: ");
			for (WebElement element : dayElements) {

				String operHours = element.getText();

				if (!(operHours.contains("."))) {

					System.out.println(operHours);

				} else {

				}

			}

		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return this;

	}

	public String dayLocator(int day) {

		String locator = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[4]/div[" + day + "]";
		return locator;

	}

	public MeetingDetails numberOfMeetings() {
		try {

			int weekDays = 7;
			for (int i = 1; i < weekDays; i++) {

				WebElement dayArea = driver.findElement(By.xpath(dayLocator(i)));
				List<WebElement> dayElements = dayArea.findElements(By.tagName("span"));

				for (WebElement element : dayElements) {

					String operHours = element.getText();
					// if (!(operHours.contains("."))) {
					System.out.println(operHours);

					// } else {

				}
			}

		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return this;
	}

	public MeetingDetails frequency() {
		try {
			List<String> sun = new ArrayList<String>();
			List<String> mon = new ArrayList<String>();
			List<String> tue = new ArrayList<String>();
			List<String> wed = new ArrayList<String>();
			List<String> thu = new ArrayList<String>();
			List<String> fri = new ArrayList<String>();
			List<String> sat = new ArrayList<String>();
			int weekDays = 7;
			for (int i = 1; i <= weekDays; i++) {

				WebElement dayArea = driver.findElement(By.xpath(dayLocator(i)));
				List<WebElement> dayElements = dayArea.findElements(By.tagName("span"));

				for (WebElement element : dayElements) {

					String operHours = element.getText();
					if (operHours.contains(":")) {

					} else {
						switch (i) {
						case 1:
							sun.add(operHours);
							break;
						case 2:
							mon.add(operHours);
							break;
						case 3:
							tue.add(operHours);
							break;
						case 4:
							wed.add(operHours);
							break;
						case 5:
							thu.add(operHours);
							break;
						case 6:
							fri.add(operHours);
							break;
						case 7:
							sat.add(operHours);
							break;

						}

					}
				}

			}

			iterator(sun);
			iterator(mon);
			iterator(tue);
			iterator(wed);
			iterator(thu);
			iterator(fri);
			iterator(sat);

		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return this;
	}

	public void iterator(List list) {
		try {
			HashSet<String> set = new HashSet();
			for (int i = 1; i < list.size(); i++) {
				set.add((String) list.get(i));
			}
			System.out.println(list.get(0));
			System.out.println(set);
			Iterator<String> names = set.iterator();
			while (names.hasNext()) {

				int countA = Collections.frequency(list, names.next());
				System.out.println(countA);

			}
		} catch (Exception e) {
			logger.error("Error: ", e);
		}

	}
}