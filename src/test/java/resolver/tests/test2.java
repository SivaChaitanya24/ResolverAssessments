package resolver.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test2 extends BaseTest {
	private WebDriver driver;

	// Validation of third test in the assessment
	@Test
	public void Test3_DropDown() {
		// Navigate to home page
		driver.findElement(resolver.pages.HomePage.HomeLink).click();

		WebElement dropdownElement = driver.findElement(resolver.pages.HomePage.dropdown);

		// Scrolling webpage until element is found
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dropdownElement);

		// Use the Select class to interact with the dropdown element
		Select dropdown = new Select(dropdownElement);

		// Assert that "Option 1" is the default selected value in the test 3 div
		String defaultselectedvalue = dropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(defaultselectedvalue, "Option 1");

		// Select "Option 3" from the dropdown
		dropdown.selectByVisibleText("Option3");

		// Verifying whether "Option 3" which is selected is displayed in selected value
		String actualSelectedValue = driver.findElement(resolver.pages.HomePage.dropdown).getText();
		Assert.assertEquals(actualSelectedValue.trim(), "Option 3");

	}
}
