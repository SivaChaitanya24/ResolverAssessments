package resolver.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test4 extends BaseTest{
	private WebDriver driver;
	@Test
	public void Test4_ButtonEnabledDisableValidation() {
		// Navigate to the home page
		driver.findElement(resolver.pages.HomePage.HomeLink).click();

		WebElement firstButton = driver.findElement(resolver.pages.HomePage.button1);
		WebElement secondButton = driver.findElement(resolver.pages.HomePage.button2);

		// Scrolling webpage until element is found
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", firstButton);

		// Assert that the first button is enabled
		boolean FirstButton = firstButton.isEnabled();
		Assert.assertEquals(FirstButton, true);

		// Assert that the second button is disabled
		boolean SecondButton = secondButton.isEnabled();
		Assert.assertEquals(SecondButton, false);
	}
}
