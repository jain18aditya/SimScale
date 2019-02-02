package com.ha.pages;

import org.openqa.selenium.By;

public class LoginPage extends PageBase {

	By Input_Email = By.xpath("//input[@id='email']");
	By Input_password = By.xpath("//input[@id='passwd']");
	By Button_Login = By.xpath("//button[@id='SubmitLogin']");
	By Login_link = By.xpath("//a[@class='login']");
	By Logout_link = By.xpath("//a[@class='logout']");
	
	private void enterUsername(String userName){
		enter(Input_Email, userName);
	}

	private void enterPassword(String password){
		enter(Input_password, password);
	}

	private void clickLoginButton(){
		click(Button_Login);
	}
	
	private void navigateToLoginPage(){
		click(Login_link);
	}

	private void clickLogoutButton() {
		click(Logout_link);
	}

	///////////////////// Consolidate Methods/////////////////////

	public void launchApplication(String url) {
		getWebDriver().get(url);
	}

	public void login(String userName, String password) {
		navigateToLoginPage();
		enterUsername(userName);
		enterPassword(password);
		clickLoginButton();
	}
	
	public void logout() {
		clickLogoutButton();
	}
}
