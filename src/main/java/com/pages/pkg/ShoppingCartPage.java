package com.pages.pkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends ViewCartPage {

	@FindBy(xpath = "//a[@class=\"remove\"]")
	WebElement removeCart;
	
	@FindBy(xpath = "//img[@src=\"/assets/web/customer/images/spacer.gif\"]")
	WebElement closeButton;
	
	

	public EmptyCartPage clickRemoveProductFromCart() {
		click(removeCart, "Click on Hot deals > Sale > addToCart button > View Cart Button > Remove Product from Cart");
		return new EmptyCartPage();
	}
	
	public EmptyCartPage clickCloseDialog() {
		click(closeButton, "Click on Hot deals > Sale > addToCart button > View Cart Button > Remove Product from Cart > close dialog");
		return new EmptyCartPage();
	}

//	public void salePageMsg() {
//		System.out.println("Message from Sales Page");
//
//	}
}
