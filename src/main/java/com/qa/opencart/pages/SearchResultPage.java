package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtils;

public class SearchResultPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By searchResult = By.cssSelector("div.product-thumb");

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public int getSearchResultsCount() {
		List<WebElement> resulstList = eleUtil.waitForVisibilityOfElementsLocated(searchResult,
				TimeUtils.DEFAULT__MEDIUM_TIME);
		int resultCount = resulstList.size();
		System.out.println("Product Search result count " + resultCount);
		return resultCount;
	}

	public ProductInfoPage selectProduct(String productName) {
		eleUtil.doClick(By.linkText(productName), TimeUtils.DEFAULT_TIME);
		return new ProductInfoPage(driver);

	}

}
