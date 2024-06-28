package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtils;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1.by locators and page objects

	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By forgotpwdlink = By.linkText("Forgotten Password");
	private By loginbtn = By.xpath("//input[@value='Login']");
	private By registerlink = By.linkText("Register");

	// 2.public constructor to initialize the driver when object of login page is
	// created

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3.Page actions/methods

	@Step("getting login page title")
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleToBe(AppConstants.LOGIN_PAGE_TITLE, TimeUtils.DEFAULT_TIME);
		System.out.println("login page title " + title);
		return title;
	}

	@Step("getting login page URL")
	public String getLoginPageURL() {

		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_FRACTION_URL, TimeUtils.DEFAULT_TIME);
		System.out.println("login page url " + url);
		return url;
	}

	@Step("getting the stateof forgot pwd link exist...")
	public boolean checkForgotPwdLinkExist() {
		return eleUtil.doIsDisplayed(forgotpwdlink);
	}

	@Step("login to application with username: {0} and password: {1}")
	public AccountPage doLogin(String username, String pwd) {
		eleUtil.doSendKeys(emailId, username, TimeUtils.DEFAULT__MEDIUM_TIME);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginbtn);
		return new AccountPage(driver);
	}

	@Step("navigating to register page.....")
	public RegistrationPage navigateToRegisterPage() {
		eleUtil.doClick(registerlink, TimeUtils.DEFAULT_TIME);
		return new RegistrationPage(driver);
	}

}
