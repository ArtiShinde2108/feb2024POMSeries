package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;
import com.qa.opencart.listeners.AnnotationTransformer;
import com.qa.opencart.listeners.ExtentReportListener;
import com.qa.opencart.listeners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ ExtentReportListener.class, TestAllureListener.class, AnnotationTransformer.class })
public class LoginPageTest extends BaseTest {

	@Description("Checking login page title test value----")
	@Severity(SeverityLevel.MINOR)
	@Owner("Naveen Automation Labs")
	@Issue("Login 123")
	@Feature("Login Page Title Feature")
	@Test(priority = 1)
	public void loginPpageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE, AppError.TITLE_NOT_FOUND);
	}

	@Description("Checking login page URL----")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Naveen Automation Labs")
	@Feature("Login Page URL Feature")
	@Test(priority = 2)
	public void loginPageURLTest() {
		String url = loginPage.getLoginPageURL();
		Assert.assertTrue(url.contains(AppConstants.LOGIN_PAGE_FRACTION_URL), AppError.URL_NOT_FOUND);
	}

	@Description("Checking forgot pwd link exist on the login page---")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Naveen Automation Labs")
	@Feature("Frogot pwd link exist Feature")
	@Test(priority = 3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.checkForgotPwdLinkExist(), AppError.ELE_NOT_FOUND);

	}

	@Description("checking user is able to login sucessfully")
	@Severity(SeverityLevel.BLOCKER)
	@Owner("Naveen Automation Labs")
	@Feature("Login Feature")
	@Test(priority = 4)
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE, AppError.TITLE_NOT_FOUND);

	}

}
