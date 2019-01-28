package gous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class SelectFlight {
	private static WebElement element;

	public static WebElement selectFlight() {

//		BaseClass.getDriver().switchTo().frame(0);
		element = BaseClass.getDriver().findElement(By
				.xpath(".//*[@id='flightForm']/section[2]/div[4]/div/nav/ul/li[1]/table/tbody[2]/tr[2]/td[3]/button"));
		return element;
	}

	public static void clickBook() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(BaseClass.getDriver()).withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(ElementNotVisibleException.class);

		WebElement element1 = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				WebElement element = BaseClass.getDriver().findElement(By.xpath(
						".//*[@id='flightForm']/section[2]/div[4]/div/nav/ul/li[1]/table/tbody[2]/tr[2]/td[3]/button"));
				element.click();
				return element;
			}
		});
	}

}
