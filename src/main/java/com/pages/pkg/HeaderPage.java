package com.pages.pkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.pkg.EcomBaseTest;

public class HeaderPage extends EcomBaseTest {

	@FindBy(xpath = "//div[@class=\"header_bar-sign_in\"]//span[text()=\"Sign in / sign up\"]")
	WebElement singnInButton;

	@FindBy(xpath = "//form[@id=\"form-1644764300807\"]//input[@placeholder=\"Search items...\"]")
	WebElement searchField;

	@FindBy(xpath = "//ul[@class=\"nav navbar-nav top-main-menu\"]/li[@class=\"leaf first active\"]/following-sibling::li[@class=\"leaf has-sub\"]/span[text()='Hot deals']")
	WebElement hotDealsButton;

	public LoginPage clickOnSignInButton() {
		click(singnInButton, "Click SignIn button");
		return new LoginPage();
	}

	public void searchProducts(String productTitle) {
		sendKeys(searchField, productTitle, "Searching " + productTitle + " product in search bar");
	}

	public SaleButtonPage moveOnHotDealsButton() {
		moveToElement(hotDealsButton, "Move to Hot deals");
		return new SaleButtonPage();
	}
}
