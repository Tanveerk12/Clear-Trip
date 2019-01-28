package TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gous.BaseClass;
import gous.CommonMethods;
import gous.HomePage;
import gous.ItineraryPage;
import gous.SelectFlight;
import gous.SignInPage;

public class TC_02_Flight_Booking {

	@BeforeTest
	public static void open() throws Exception {
		SignInPage.openApplication();
	}

	@Test()
	public static void bookTicket() throws Exception {
		HomePage.enter_From(CommonMethods.readExcel(1, 0));
		HomePage.enter_To(CommonMethods.readExcel(1, 1));
		HomePage.selectDepartOn();
		HomePage.clickSearchFlights();
//		Thread.sleep(5000);
		BaseClass.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		SelectFlight.clickBook();
		ItineraryPage.click_insuranceConfirm_Btn();
		ItineraryPage.click_Continue_Btn();
	}
}
