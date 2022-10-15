package com.pages.pkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaleButtonPage extends HeaderPage{
	@FindBy(xpath = "//li[@class='leaf has-sub']//li[1]//a[1]")
	WebElement saleButton;
	
	public SalePage clickSaleButton() {
		click(saleButton, "Click on Hot deals > Sale button");
		return new SalePage();
	}
}
