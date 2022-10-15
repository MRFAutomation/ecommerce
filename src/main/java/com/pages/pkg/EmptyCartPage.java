package com.pages.pkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmptyCartPage extends ShoppingCartPage {

	@FindBy(id = "page-title")
	WebElement emptyCartText;

	public String cartText() {
		return emptyCartText.getText();
	}
}
