package com.pages.pkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalePage extends HeaderPage {

	@FindBy(xpath = "//a[text()='Bluetooth Smartwatch with Touch Screen and Fitness Tracker']")
	WebElement product1;

	public SalePage moveToProduct() {
		moveToElement(product1, "Move to first product on Hot deals > Sale page");
		return this;
	}

	@FindBy(xpath = "//button[@class=\"btn  regular-button add-to-cart product-add2cart productid-33\"]/span[text()='Add to cart']")
	WebElement addToCart;

	public ViewCartPage addToCartProduct() {
		click(addToCart, "Click on Hot deals > Sale > addToCart button");
		return new ViewCartPage();
	}

//	public void salePageMsg() {
//		System.out.println("Message from Sales Page");
//
//	}
}
