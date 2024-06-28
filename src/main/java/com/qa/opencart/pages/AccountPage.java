package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtils;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By logoutLink = By.linkText("Logout");
	private By headers = By.xpath("//div[@id='content']/h2");
	private By search = By.name("search");
	private By searchIcon = By.xpath("//div[@id='search']//button");

	public String getAccPageTitle() {
		String title = eleUtil.waitForTitleToBe(AppConstants.ACCOUNTS_PAGE_TITLE, TimeUtils.DEFAULT_TIME);
		System.out.println("Account page title " + title);
		return title;
	}

	public String getAccPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.ACC_PAGE_FRACTION_VALUE, TimeUtils.DEFAULT_TIME);
		System.out.println("Accounts page url " + url);
		return url;
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);
	}

	public List<String> getAccPageHeaders() {
		List<WebElement> headersList = eleUtil.waitForVisibilityOfElementsLocated(headers,
				TimeUtils.DEFAULT__MEDIUM_TIME);
		List<String> list = new ArrayList<String>();
		for (WebElement e : headersList) {
			String header = e.getText();
			list.add(header);
		}
		return list;
	}

	public boolean isSearchExist() {
		return eleUtil.doIsDisplayed(search);
	}

	public SearchResultPage doSearch(String searchKey) {

		if (isSearchExist()) {
			eleUtil.doSendKeys(search, searchKey);
			eleUtil.doClick(searchIcon);
			return new SearchResultPage(driver);
		} else {
			System.out.println("Search field is not present on the page");
			return null;
		}
	}

}
