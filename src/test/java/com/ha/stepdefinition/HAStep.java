package com.ha.stepdefinition;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.ha.pages.HomePage;
import com.ha.pages.LoginPage;
import com.ha.pages.PaymentPage;
import com.ha.pages.ProductDetails;
import com.ha.pages.UserDetailsPage;
import com.ha.utils.ConfigUtil;
import com.ha.utils.LoggerUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HAStep {
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	UserDetailsPage userDetailsPage = new UserDetailsPage();
	ProductDetails productDetailsPage = new ProductDetails();
	PaymentPage paymentPage = new PaymentPage();
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

	@When("^search \"([^\"]*)\" and select product$")
	public void searchAndSelectProduct(String productName) throws Throwable {
		homePage.searchProduct(ConfigUtil.getProperty(productName));
		homePage.selectProduct(ConfigUtil.getProperty(productName));
	}

	@When("^Select product details and add to cart$")
	public void selectDetailsAndAdd() throws Throwable {
		productDetailsPage.selectQuantity(2);
		productDetailsPage.selectSize("M");
		productDetailsPage.addToCart();
		productDetailsPage.proceedToCheckout();
		productDetailsPage.proceedToCheckoutCart();
	}

	@When("^Register new user$")
	public void registerNewUser() throws Throwable {
		userDetailsPage.registerAccount(getUserDetails(), getAddressDetails());
	}

	@When("^Proceed to payment$")
	public void proceedToPayment() throws Throwable {
		productDetailsPage.proceedToCheckoutCart();
		userDetailsPage.acceptTermAndProceed();
	}

	@When("^Complete the payment details$")
	public void completePaymentDetails() throws Throwable {
		paymentPage.payByCheque();
		paymentPage.confirmOrder();
	}

	@Then("^Order should be placed successfully$")
	public void verifyOrderStatus() throws Throwable {
		Assert.assertEquals(paymentPage.getOrderStatus(), "Your order on My Store is complete.");
	}

	@Then("^Logout the user$")
	public void logoutUser() throws Throwable {
		loginPage.logout();
	}
	
	//////////////functions////////////////
	
	private HashMap<String, String> getUserDetails() {
		HashMap<String, String> userDetails = new HashMap<String, String>();
		userDetails.put("email", ConfigUtil.getProperty("user.email"));
		userDetails.put("password", ConfigUtil.getProperty("password"));
		userDetails.put("title", ConfigUtil.getProperty("title"));
		userDetails.put("firstName", ConfigUtil.getProperty("first.name"));
		userDetails.put("lastName", ConfigUtil.getProperty("last.name"));
		userDetails.put("dob", ConfigUtil.getProperty("dob"));
		return userDetails;
	}
	
	private HashMap<String, String> getAddressDetails() {
		HashMap<String, String> addressDetails = new HashMap<String, String>();
		addressDetails.put("firstName", ConfigUtil.getProperty("first.name"));
		addressDetails.put("lastName", ConfigUtil.getProperty("last.name"));
		addressDetails.put("company", ConfigUtil.getProperty("company"));
		addressDetails.put("address1", ConfigUtil.getProperty("address1"));
		addressDetails.put("address2", ConfigUtil.getProperty("address2"));
		addressDetails.put("city", ConfigUtil.getProperty("city"));
		addressDetails.put("state", ConfigUtil.getProperty("state"));
		addressDetails.put("country", ConfigUtil.getProperty("country"));
		addressDetails.put("zip", ConfigUtil.getProperty("zip"));
		addressDetails.put("info", ConfigUtil.getProperty("info"));
		addressDetails.put("homePhone", ConfigUtil.getProperty("home.phone"));
		addressDetails.put("mobilePhone", ConfigUtil.getProperty("mobile.phone"));
		addressDetails.put("alias", ConfigUtil.getProperty("alias"));
		return addressDetails;
	}
}
