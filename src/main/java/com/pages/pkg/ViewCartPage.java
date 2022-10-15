package com.pages.pkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCartPage extends SalePage {

	@FindBy(xpath = "//div[@class='item-buttons']//span[contains(text(),'View cart')]")
	WebElement viewCartButton;

	public ShoppingCartPage clickToViewCart() {
		click(viewCartButton, "Click on Hot deals > Sale > addToCart button > View Cart Button");
		return new ShoppingCartPage();
	}
}
