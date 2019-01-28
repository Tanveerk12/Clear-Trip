package gous;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Hotels {

	private static WebElement element;
	private static String currentDay;

	public static WebElement search_Hotel() {
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='SearchHotelsButton']"));
		return element;
	}

	public static WebElement where_Txtbox() {
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='Tags']"));
		return element;
	}

	public static WebElement checkInDate() {
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='CheckInDate']"));
		return element;
	}

	public static WebElement checkOutDate() {
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='CheckOutDate']"));
		return element;
	}

	public static WebElement viewDetails_Button() {
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='showNearByBox']//following::button[1]"));
		return element;
	}

	public static void click_viewDetails_Button() {
		BaseClass.wait(viewDetails_Button());
		viewDetails_Button().click();
	}

	public static void click_SearchHotel() {
		BaseClass.wait(search_Hotel());
		search_Hotel().click();
	}

	public static void clickCheckInDate() {
		BaseClass.wait(checkInDate());
		checkInDate().click();
	}

	public static void clickCheckOutDate() {
		BaseClass.wait(checkOutDate());
		checkOutDate().click();
	}

	public static void enterValue_WhereTxtbox(String value) {
		BaseClass.wait(where_Txtbox());
		where_Txtbox().sendKeys(value);
		CommonMethods.clickEnter();
	}

	public static void selectCheckInDate() {
		clickCheckInDate();
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody"));
		List<WebElement> elements = element.findElements(By.tagName("td"));
		currentDay = HomePage.getCurrentDay();

		for (WebElement element : elements) {
			if (element.getText().equals(currentDay)) {
				element.click();
				break;
			}

		}
	}

	public static void selectCheckOutDate() {
		clickCheckOutDate();
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody"));
		List<WebElement> elements = element.findElements(By.tagName("td"));
		getCheckOutDay();

		for (WebElement element : elements) {
			if (element.getText().equals(currentDay)) {
				element.click();
				break;
			}

		}
	}

	public static String getCheckOutDay() {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Date date = calendar.getTime();
		int currentday = calendar.get(Calendar.DATE);
		currentday++;
		currentDay = Integer.toString(currentday);
//		System.out.println("Current Day is:: " + currentDay);
		return currentDay;
	}

}