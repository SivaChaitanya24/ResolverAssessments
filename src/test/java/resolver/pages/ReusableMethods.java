package resolver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReusableMethods {
	public WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	public String baseUrl = "file:///" + projectPath + "/temp/QE-index.html";
	public void setupDriver() {

		String chromeDriverPath = projectPath + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	public void quitDriver() {
		driver.quit();
	}

}
