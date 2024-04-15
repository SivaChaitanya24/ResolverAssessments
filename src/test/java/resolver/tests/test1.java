package resolver.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 extends BaseTest {
	private WebDriver driver;

	// Verify elements of pages is visible or not
	@Test
	public void testLoginPageElementsVisibility() {
		// Navigate to home page
		driver.findElement(resolver.pages.HomePage.HomeLink).click();

		boolean emailaddress = driver.findElement(resolver.pages.HomePage.emailAddress).isDisplayed();
		boolean password = driver.findElement(resolver.pages.HomePage.password).isDisplayed();
		boolean signInButton = driver.findElement(resolver.pages.HomePage.signInButton).isDisplayed();
		Assert.assertEquals(emailaddress, true);
		Assert.assertEquals(password, true);
		Assert.assertEquals(signInButton, true);
	}
}
