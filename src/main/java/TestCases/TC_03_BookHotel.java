package TestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gous.CommonMethods;
import gous.HomePage;
import gous.Hotels;
import gous.SignInPage;

public class TC_03_BookHotel {

	@BeforeTest
	public static void open() throws Exception {
		SignInPage.openApplication();
	}

	
	@Test()
	public static void bookHotel() throws Exception {
		HomePage.click_HotelsButton();
		Hotels.enterValue_WhereTxtbox(CommonMethods.readExcel(1, 2));
		Thread.sleep(3000);
		CommonMethods.clickDown();
		Hotels.selectCheckInDate();
		Hotels.clickCheckOutDate();
		Hotels.selectCheckOutDate();
		Hotels.click_SearchHotel();
		Thread.sleep(5000);
		Hotels.click_viewDetails_Button();

	}
}
