package resolver.tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test5 extends BaseTest {
	private WebDriver driver;

	// Validation of fifth test in the assessment
	@Test
	public void Test5_SucessMessageValidation() {
		// Navigate to the home page
		driver.findElement(resolver.pages.HomePage.HomeLink).click();

		// In the test 5 div, wait for a button to be displayed (note: the delay is
		// random) and then click it
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(resolver.pages.HomePage.Button));

		WebElement buttonElement = driver.findElement(resolver.pages.HomePage.Button);

		buttonElement.click();

		// Once you've clicked the button, assert that a success message is displayed
		Assert.assertTrue(driver.findElement(resolver.pages.HomePage.successMsg).isDisplayed());

		// Assert that the button is now disabled
		Assert.assertFalse(driver.findElement(resolver.pages.HomePage.Button).isEnabled());
	}
}
