package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {
	WebDriver driver;
	DriverFactory df;
	protected LoginPage loginPage;
	protected Properties prop;
	protected AccountPage accPage;
	protected SearchResultPage searchResultPage;
	protected ProductInfoPage productInfoPage;
	protected RegistrationPage RegisPage;

	protected SoftAssert softAssert;

	@Parameters({ "browser", "browserversion", "testname" })
	@BeforeTest
	public void setup(@Optional("chrome") String browserName, @Optional String browserversion,
			@Optional String testName) {
		df = new DriverFactory();
		prop = df.initProp();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
			prop.setProperty("browserversion", browserversion);
			prop.setProperty("testname", testName);
		}
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
