package com.pages.pkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HeaderPage {

	@FindBy(id = "login-email")
	WebElement usernameField;

	@FindBy(id = "login-password")
	WebElement passwordField;

	@FindBy(xpath = "//button[@class=\"btn  regular-button  submit\"]/span[text()='Sign in']")
	WebElement signInButton;

	/*
	 * public LoginPage enterUserName(String un) { sendKeys(usernameField, un);
	 * return this; }
	 * 
	 * public LoginPage enterPassword(String pw) { sendKeys(passwordField, pw);
	 * return this; }
	 * 
	 * public HeaderPage clickSignInButton() { click(signInButton); return new
	 * HeaderPage(); }
	 */
	
	public HeaderPage loginToStore(String un, String pw) {
		sendKeys(usernameField, un, "Enter username on login form");
		sendKeys(passwordField, pw, "Enter password on login form");
		click(signInButton, "Click SignIn button on login form");
		return new HeaderPage();
	}
}
