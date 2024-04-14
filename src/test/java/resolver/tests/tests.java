package resolver.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resolver.pages.LoginPage;

public class tests {
	private WebDriver driver;
	private LoginPage loginPage;
	private String baseUrl = "C:/Users/sivac/eclipse-workspace/MySeleniumTests/temp/QE-index.html";

	@BeforeClass
	public void setUp() {
		String projectPath = System.getProperty("user.dir");
		String chromeDriverPath = projectPath + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		loginPage = new LoginPage(driver);

		// Navigate to home page
		driver.findElement(By.xpath("//*[contains(@class,'nav-link') and contains(text(),'Home')]")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	// Verify elements of pages is visible or not
	@Test
	public void testLoginPageElementsVisibility() {
		Assert.assertTrue(loginPage.isEmailInputVisible());
		Assert.assertTrue(loginPage.isPasswordInputVisible());
		Assert.assertTrue(loginPage.isSignInButtonVisible());
	}

	// Providing both positive email and password
	@Test
	public void testValidLogin() {
		loginPage.loginVerification("validemail@example.com", "validpassword");
		// Add assertions or further test steps for successful login
	}

	// Providing both negative email and password
	@Test
	public void testInvalidLogin() {
		loginPage.loginVerification("invalidemail@example.com", "invalidpassword");
		// Add assertions or further test steps for unsuccessful login
	}

	// Providing positive email and negative password
	@Test
	public void testValidEmail() {
		loginPage.loginVerification("validemail@example.com", "invalidpassword");
		// Add assertions or further test steps for unsuccessful login
	}

	// Providing negative email and positive password
	@Test
	public void testValidPassword() {
		loginPage.loginVerification("invalidemail@example.com", "validpassword");
		// Add assertions or further test steps for unsuccessful login
	}

	// Validation of second test in the assessment
	@Test
	public void Test2_ListItem() {
		// In the test 2 div, assert that there are three values in the listgroup
		int expectedValues = 3;
		List<WebElement> actualListElements = driver.findElements(By.xpath(
				"//*[contains(@id,'test-2-div')]//*[contains(@class,'list-group')]/child::*[contains(@class,'group-item')]"));
		Assert.assertEquals(actualListElements.size(), expectedValues);

		// Assert that the second list item's value is set to "List Item 2"
		String actualListName = actualListElements.get(1).getText();
		Assert.assertEquals(actualListName.trim(), "List Item 2");

		// Assert that the second list item's badge value is 6
		int actualvalue = Integer.parseInt(driver.findElement(By.xpath(
				"//*[contains(@class,'list-group')]/child::*[contains(@class,'group-item')][2]//*[contains(@class,'badge')]"))
				.getText());
		Assert.assertEquals(actualvalue, 6);
	}

	// Validation of third test in the assessment
	@Test
	public void Test3_DropDown() {

		// Scrolling webpage until element is found
		WebElement dropDownElement = driver.findElement(By.xpath(
				"//*[contains(@id,'test-3-div')]//*[contains(@class,'btn-secondary') and contains(@id,'dropdownMenuButton')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dropDownElement);

		// In the test 3 div, assert that "Option 1" is the default selected value
		String actualDefaultValue = dropDownElement.getText();
		Assert.assertEquals(actualDefaultValue.trim(), "Option 1");

		// click on dropdown element and verifying drop down option is expanded with
		// list items
		driver.findElement(By.xpath(
				"//*[contains(@id,'test-3-div')]//*[contains(@class,'btn-secondary') and contains(@id,'dropdownMenuButton')]"))
				.click();
		Assert.assertTrue(false, driver.findElement(By.xpath(
				"//*[contains(@id,'test-3-div')]//*[contains(@class,'btn-secondary') and contains(@id,'dropdownMenuButton')]"))
				.getAttribute("aria-expanded"));
		System.out.println("Drop down Option is expanded");

		// Select "Option 3" from the select list cannot use select class methods as
		// drop down element is not implemented with <select> tag
		List<WebElement> dropDownElements = driver.findElements(By.xpath(
				"//*[contains(@id,'test-3-div')]//*[contains(@class,'dropdown-menu')]/child::*[contains(@class,'dropdown-item')]"));
		for (WebElement dropDownEle : dropDownElements) {
			String actualDropDownListName = dropDownEle.getText();
			if (actualDropDownListName.trim().equals("Option 3")) {
				dropDownEle.click();
				break;
			}
		}

		// Verifying whether "Option 3" which is selected is displayed in selected value
		String actualSelectedValue = driver.findElement(By.xpath(
				"//*[contains(@id,'test-3-div')]//*[contains(@class,'btn-secondary') and contains(@id,'dropdownMenuButton')]"))
				.getText();
		Assert.assertEquals(actualSelectedValue.trim(), "Option 3");

	}

	// Validation of fourth test in the assessment
	@Test
	public void Test4_ButtonEnabledDisableValidation() {
		// Navigate to the home page
		driver.findElement(By.xpath("//*[contains(@class,'nav-link') and contains(text(),'Home')]")).click();

		// Scrolling webpage until element is found
		WebElement enabledButton = driver
				.findElement(By.xpath("//*[contains(@id,'test-4-div')]//*[contains(@class,'btn-primary')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", enabledButton);

		// In the test 4 div, assert that the first button is enabled and that the
		// second button is disabled
		Assert.assertTrue(enabledButton.isEnabled());
		Assert.assertFalse(
				driver.findElement(By.xpath("//*[contains(@id,'test-4-div')]//*[contains(@class,'btn-secondary')]"))
						.isEnabled());
	}

	// Validation of fifth test in the assessment
	@Test
	public void Test5_SucessMessageValidation() {
		// Navigate to the home page
		driver.findElement(By.xpath("//*[contains(@class,'nav-link') and contains(text(),'Home')]")).click();

		// In the test 5 div, wait for a button to be displayed (note: the delay is random) and then click it
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(@id,'test-5-div')]//*[contains(@class,'btn-primary')]")));

		// Scrolling webpage until element is found
		WebElement buttonElement = driver
				.findElement(By.xpath("//*[contains(@id,'test-5-div')]//*[contains(@class,'btn-primary')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", buttonElement);

		buttonElement.click();

		// Once you've clicked the button, assert that a success message is displayed
		Assert.assertTrue(driver.findElement(By.xpath(
				"//*[contains(@id,'test-5-div')]//*[contains(@class,'alert-success') and contains(text(),'You clicked a button!')]"))
				.isDisplayed());

		// Assert that the button is now disabled
		Assert.assertFalse(
				driver.findElement(By.xpath("//*[contains(@id,'test-5-div')]//*[contains(@class,'btn-primary')]"))
						.isEnabled());
	}

	// Validation of sixth test in the assessment
	@Test
	public void Test6WebTable() {

		String expectedCellText = "Ventosanzap";

		// Scrolling webpage until element is found
		WebElement mytable = driver.findElement(By.xpath("//table/child::tbody"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", mytable);

		// To locate rows of the table
		List<WebElement> RowList = mytable.findElements(By.tagName("tr"));

		// To locate columns of that specific row
		List<WebElement> ColumnList = RowList.get(2).findElements(By.tagName("td"));

		// To retrieve text from that specific cell
		String actualCelText = ColumnList.get(2).getText();
		System.out.println("Cell Value is" + actualCelText);

		// Assert that the value of the cell is "Ventosanzap"
		Assert.assertEquals(actualCelText, expectedCellText);
	}

}
