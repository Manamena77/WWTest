package automationTesting;

import org.testng.annotations.Test;

import com.library.BaseClass;

import pageOpjectModel.FindaWorkShop;
import pageOpjectModel.HomePage;
import pageOpjectModel.MeetingDetails;

public class SmokeTest extends BaseClass {
	HomePage homePage = new HomePage();
	FindaWorkShop work = new FindaWorkShop();
	MeetingDetails details = new MeetingDetails();

	@Test
	public void test_101() {
		homePage.navigateToHomePage();
		homePage.findaWorkshop();
		work.enterLocation();
		work.results();
		details.verifyResult();
		details.getTodaysTimes();
		//details.numberOfMeetings();
		details.frequency();
	}

}