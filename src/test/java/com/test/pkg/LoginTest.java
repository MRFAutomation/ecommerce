package com.test.pkg;

import org.testng.annotations.Test;

import com.base.pkg.EcomBaseTest;
import com.pages.pkg.EmptyCartPage;
import com.pages.pkg.HeaderPage;
import com.pages.pkg.LoginPage;
import com.pages.pkg.SaleButtonPage;
import com.pages.pkg.SalePage;
import com.pages.pkg.ShoppingCartPage;
import com.pages.pkg.ViewCartPage;
import com.utils.pkg.StringConstants;

public class LoginTest extends EcomBaseTest {
	HeaderPage headerPage;
	LoginPage loginPage;
	SaleButtonPage saleButtonPage;
	SalePage salePage;
	ViewCartPage viewCartPage;
	ShoppingCartPage shoppingCartPage;
	EmptyCartPage emptyCartPage;

	@Test
	public void login() {

		driver.get(StringConstants.DEMO_STORE_URL);
		headerPage = new HeaderPage();

		loginPage = headerPage.clickOnSignInButton();
		headerPage = loginPage.loginToStore(StringConstants.DEMO_STORE_UN, StringConstants.DEMO_STORE_PW);
		addPauseInSeconds(2);
		saleButtonPage = headerPage.moveOnHotDealsButton();
		salePage = saleButtonPage.clickSaleButton();
		salePage.moveToProduct();
		viewCartPage = salePage.addToCartProduct();
		shoppingCartPage = viewCartPage.clickToViewCart();
		emptyCartPage = shoppingCartPage.clickRemoveProductFromCart();
	}
}
