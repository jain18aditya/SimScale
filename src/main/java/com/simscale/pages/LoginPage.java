package com.simscale.pages;

import org.apache.log4j.Level;
import org.openqa.selenium.By;

import com.simscale.base.PageBase;

public class LoginPage extends PageBase {

	By Input_Email = By.xpath("//input[@id='emailInput']");
	By Input_password = By.xpath("//input[@id='passInput']");
	By Button_Login = By.xpath("//button[@id='authClick']");
	By Login_link = By.xpath("//li[@class='notLoggedIn btnLogin']/a");
	By Logout_link = By.xpath("//a[text()='Log Out']");
	By User_link = By.xpath("//li[@class='sub-menu ']/a[@data-hj-suppress='']");

	private void enterUsername(String userName) {
		waitTillElementVisible(Input_Email);
		enter(Input_Email, userName);
	}

	private void enterPassword(String password) {
		waitTillElementVisible(Input_password);
		enter(Input_password, password);
	}

	private void clickLoginButton() {
		waitTillElementVisible(Button_Login);
		click(Button_Login);
	}

	/*
	 * private void navigateToLoginPage() { waitTillElementVisible(Login_link);
	 * click(Login_link); }
	 */
	private void clickLogoutButton() {
		waitTillElementVisible(User_link);
		mouseHover(User_link, Logout_link);
	}

	///////////////////// Consolidate Methods/////////////////////

	public void launchApplication(String url) {
		getWebDriver().get(url);
	}

	public void navigateToURL(String url) {
		getWebDriver().navigate().to(url);
	}

	public void login(String userName, String password) {
		// navigateToLoginPage();
		enterUsername(userName);
		enterPassword(password);
		clickLoginButton();
	}

	public void logout() {
		clickLogoutButton();
		s_logs.log(Level.INFO, "Logout is sucessful");
	}
}
