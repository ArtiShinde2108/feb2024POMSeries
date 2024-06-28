package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtils;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeyes = By.xpath("(//label[@class='radio-inline'])[1]/input[@type='radio']");
	private By subscribeno = By.xpath("(//label[@class='radio-inline'])[2]/input[@type='radio']");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private By succesMsg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public boolean userRegister(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {
		eleUtil.doSendKeys(this.firstname, firstName, TimeUtils.DEFAULT__MEDIUM_TIME);
		eleUtil.doSendKeys(this.lastname, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmpassword, password);

		if (subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeyes);
		} else {
			eleUtil.doClick(subscribeno);
		}

		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(continueButton);

		String sucessMsg = eleUtil.waitForElementVisible(succesMsg, TimeUtils.DEFAULT__MEDIUM_TIME).getText();
		System.out.println(sucessMsg);

		if (sucessMsg.contains(AppConstants.USER_REGISTER_SUCCESS_MESG)) {
			eleUtil.doClick(logoutLink);
			eleUtil.doClick(registerLink);
			return true;
		} else {
			return false;
		}

	}

}
