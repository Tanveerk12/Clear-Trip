package gous;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

	private static String title;
	private static WebElement element;
	private static String currentDay;
	static int currentday;

	public static WebElement hotelsButton() {
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='FromTag']//preceding::a[9]"));

		return element;
	}

	public static WebElement departOn() {
		BaseClass.getDriver().findElement(By.xpath(".//*[@id='DepartDate']")).click();

		return element;
	}

	public static WebElement searchFlights() {
		BaseClass.getDriver().findElement(By.xpath(".//*[@id='SearchBtn']"));

		return element;
	}

	public static void click_HotelsButton() {
		BaseClass.wait(hotelsButton());
		hotelsButton().click();
	}

	public static void clickSearchFlights() {
		BaseClass.wait(searchFlight_Button());
		searchFlight_Button().click();
	}

	public static WebElement from() {
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='FromTag']"));
		return element;
	}

	public static WebElement To() {
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='ToTag']"));
		return element;
	}

	public static void clickDepartOn() {
		BaseClass.wait(departOn());
		departOn().click();

//		for (int i = 1; i <= 4; i++) {
//			element = BaseClass.getDriver()
//					.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[" + i + "]/a"));
//			System.out.println(element.getText());
//		}

	}

	public static void enter_From(String value) throws Exception {
		BaseClass.wait(from());
		from().sendKeys(value);
	}

	public static void enter_To(String value) throws Exception {
		BaseClass.wait(To());
		To().sendKeys(value);
	}

	public static WebElement searchFlight_Button() {
		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='SearchBtn']"));
		return element;
	}

	public static String verfiyTitle() {
		title = BaseClass.getDriver().getTitle();
		System.out.println("Title is :" + title);
		return title;
	}

	public static void selectDepartOn() {

		getCurrentDay();
		BaseClass.getDriver().findElement(By.xpath(".//*[@id='DepartDate']")).click();

		element = BaseClass.getDriver().findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody"));

		List<WebElement> columns = element.findElements(By.tagName("td"));

		for (WebElement cell : columns) {
//			System.out.println(cell.getText());
			if (cell.getText().equals(currentDay)) {
				cell.click();
				break;
			}
		}
	}

	public static String getCurrentDay() {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Date date = calendar.getTime();
		currentday = calendar.get(Calendar.DATE);
		currentDay = Integer.toString(currentday);
//		System.out.println("Current Day is:: " + currentDay);
		return currentDay;
	}

}
