package TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gous.BaseClass;
import gous.HomePage;
import gous.SignInPage;

public class TC_01_SignIn {
	@BeforeTest
	public static void open() throws Exception {
		SignInPage.openApplication();
	}

	@Test
	public static void login() throws Exception {
		SignInPage.click_YourTripButton();
		SignInPage.click_SignInButton();
		SignInPage.enter_Username();
		SignInPage.enter_Password();
		SignInPage.clickSign_Btn();
		BaseClass.getDriver().switchTo().defaultContent();
		HomePage.verfiyTitle();
	}

	@AfterTest(enabled=false)
	public static void close() throws Exception {
		BaseClass.closBrowser();
	}
}
