package gous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItineraryPage {
	private static WebElement element;

	public static WebElement insuranceConfirm_Btn() {

		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='insurance_confirm']"));
		return element;
	}

	public static WebElement itinerary_Btn() {
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='itineraryBtn']"));
		return element;
	}

	public static void click_Continue_Btn() {
		BaseClass.wait(itinerary_Btn());
		itinerary_Btn().click();

	}

	

	public static void click_insuranceConfirm_Btn() {
		BaseClass.wait(insuranceConfirm_Btn());
		insuranceConfirm_Btn().click();

	}

}
