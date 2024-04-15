package resolver.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import resolver.pages.ReusableMethods;

public class BaseTest {

	private ReusableMethods reusableMethods;

	@BeforeMethod
	public void setUp() {
		reusableMethods = new ReusableMethods();
		reusableMethods.setupDriver();
	}

	@AfterMethod
	public void tearDown() {
		reusableMethods.quitDriver();
	}

}
