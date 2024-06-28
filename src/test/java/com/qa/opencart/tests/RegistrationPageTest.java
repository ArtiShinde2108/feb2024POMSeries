package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void RegisterPageSetup() {
		RegisPage = loginPage.navigateToRegisterPage();
	}

	@DataProvider
	public Object[][] userRegisTestData() {
		return new Object[][] { { "Arti", "Automation", "9876453429", "Arti@123", "yes" },
				{ "Praful", "Automation", "9876458429", "Praful@123", "no" },
				{ "Madhu", "Automation", "9776458429", "Madhu@123", "yes" } };
	}

	@DataProvider
	public Object[][] userRegisTestDataFromSheet() {
		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);

	}

	@Test(dataProvider = "userRegisTestDataFromSheet")
	public void userRegistartionTest(String firstName, String lastName, String telephone, String password,
			String subscribe) {
		Assert.assertTrue(RegisPage.userRegister(firstName, lastName, StringUtils.getRandomEmailId(), telephone,
				password, subscribe), AppError.USER_REGIS_NOT_DONE);
	}

}
