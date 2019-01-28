package gous;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class CommonMethods {

	private static String value;
	private final static String path = "F:\\codingRound-master\\codingRound-master\\src\\main\\java\\TestCases\\Data.xlsx";

	public static String readExcel(int Row, int col) throws Exception {
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		value = sheet.getRow(Row).getCell(col).getStringCellValue();
		return value;

	}

	public static void fluentWait(WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(BaseClass.getDriver()).withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement element1 = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return null;
			}

		});
	}

	public static void waitForVisible(WebElement element) {

		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), 90);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void clickEnter() {
		Actions action = new Actions(BaseClass.getDriver());
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public static void clickDown() throws AWTException {
		Robot robot = new Robot(); // Robot class throws AWT Exception
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

}