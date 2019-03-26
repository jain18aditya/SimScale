package com.simscale.stepdefinition;

import org.apache.log4j.Logger;
import com.simscale.pages.HomePage;
import com.simscale.pages.LoginPage;
import com.simscale.utils.ConfigUtil;
import com.simscale.utils.LoggerUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SimScaleStepDef {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	Logger s_logs = LoggerUtil.logger();

	@Given("^Launch browser with url \"([^\"]*)\"$")
	public void launchBrowser(String url) throws Throwable {
		loginPage.launchApplication(ConfigUtil.getProperty(url));
	}

	@When("^User log in with UserName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void logIn(String userName, String password) throws Throwable {
		loginPage.login(ConfigUtil.getProperty(userName), ConfigUtil.getProperty(password));
	}

	@Then("^close the browser$")
	public void terminateBrowser() throws Throwable {
		loginPage.cleanUP();
	}

	@Then("^Logout the user$")
	public void logoutUser() throws Throwable {
		loginPage.logout();
	}
}