package gous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignInPage {
	private static WebElement element;

	public SignInPage() {
		super();
	}

	public static WebElement yourTrip_Btn() {
		element = BaseClass.getDriver().findElement(By.xpath(".//span[text()='Your trips']"));
		return element;
	}

	public static WebElement SignIn_Btn() {
		element = BaseClass.getDriver().findElement(By.id("SignIn"));
		return element;
	}

	public static WebElement username_Txtbox() {
		element = BaseClass.getDriver().findElement(By.xpath("//input[@id='email']"));
		return element;
	}

	public static WebElement password_Txtbox() {
		element = BaseClass.getDriver().findElement(By.xpath("//input[@id='password']"));
		return element;
	}
	
	public static WebElement Sign_Btn() {
		element = BaseClass.getDriver().findElement(By.xpath("//button[@id='signInButton']"));
		return element;
	}

	public static void clickSign_Btn() {
		BaseClass.wait(Sign_Btn());
		Sign_Btn().click();
	}
	
	
	public static void enter_Username() throws Exception {
		BaseClass.getDriver().switchTo().frame("modal_window");
		BaseClass.wait(username_Txtbox());
		BaseClass.readPropertiesFile();
		username_Txtbox().sendKeys(BaseClass.getUserName());
	}

	public static void enter_Password() throws Exception {
//		BaseClass.getDriver().switchTo().frame("modal_window");
		BaseClass.wait(password_Txtbox());
		BaseClass.readPropertiesFile();
		password_Txtbox().sendKeys(BaseClass.getPassword());
	}

	public static void click_YourTripButton() throws Exception {
		BaseClass.wait(yourTrip_Btn());
		yourTrip_Btn().click();
	}

	public static void click_SignInButton() throws Exception {
		BaseClass.wait(SignIn_Btn());
		SignIn_Btn().click();
	}

	public static void openApplication() throws Exception {
		BaseClass.openBrowser();
	}

	public static void openApplication(String username, String password) throws Exception {
		BaseClass.readPropertiesFile();
	}
}
