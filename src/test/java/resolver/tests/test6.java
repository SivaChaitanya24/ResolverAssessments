package resolver.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test6 extends BaseTest {
	private WebDriver driver;

	// Define method to get cell value
	public String getCellValue(int row, int column) {
		WebElement cell = driver
				.findElement(By.cssSelector("tr:nth-child(" + (row + 1) + ") td:nth-child(" + (column + 1) + ")"));
		return cell.getText();
	}

	@Test
	public void test() {
		// Navigate to home page
		driver.findElement(resolver.pages.HomePage.HomeLink).click();
		// Get cell value at coordinates 2, 2
		String cellValue = getCellValue(2, 2);
		// Assert that cell value is "Ventosanzap"
		Assert.assertEquals(cellValue, "Ventosanzap");

	}
}
