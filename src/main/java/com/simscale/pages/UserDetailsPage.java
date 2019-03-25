package com.ha.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class UserDetailsPage extends PageBase {
	By EmailCreate_input = By.xpath("//input[@id='email_create']");
	By CreateAnAccount_Button = By.xpath("//button[@id='SubmitCreate']");
	By TitleMr_radio = By.xpath("//input[@id='id_gender1']");
	By TitleMrs_radio = By.xpath("//input[@id='id_gender2']");
	By FirstName_input = By.xpath("//input[@id='customer_firstname']");
	By LastName_input = By.xpath("//input[@id='customer_lastname']");
	By Email_input = By.xpath("//input[@id='email']");
	By Password_input = By.xpath("//input[@id='passwd']");
	By DOB_Day_dropdown = By.xpath("//select[@id='days']");
	By DOB_Month_dropdown = By.xpath("//select[@id='months']");
	By DOB_Year_dropdown = By.xpath("//select[@id='years']");
	By AddressFirstName_input = By.xpath("//input[@id='customer_firstname']");
	By AddressLastName_input = By.xpath("//input[@id='customer_lastname']");
	By AddressCompanyName_input = By.xpath("//input[@id='company']");
	By AddressLine1_input = By.xpath("//input[@id='address1']");
	By AddressLine2_input = By.xpath("//input[@id='address2']");
	By AddressCity_input = By.xpath("//input[@id='city']");
	By AddressState_dropdown = By.xpath("//select[@id='id_state']");
	By AddressZipCode_input = By.xpath("//input[@id='postcode']");
	By AddressCountry_dropdown = By.xpath("//select[@id='id_country']");
	By AddressAdditionalInfo_input = By.xpath("//label[(text()='Additional information')]/following-sibling::textarea");
	By AddressHomePhone_input = By.xpath("//input[@id='phone']");
	By AddressMobilePhone_input = By.xpath("//input[@id='phone_mobile']");
	By AddressAlias_input = By.xpath("//input[@id='alias']");
	By Register_button = By.xpath("//button[@id='submitAccount']");
	By OrderMessage_input = By.xpath("ordermessage = //div[@id='ordermsg']//textarea");
	By TermsOfServices_button = By.xpath("//form[@id='form']//input[@id='cgv']");
	By ProceedToCheckout_button = By.xpath("//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]");
	By form_form = By.xpath("//form[@id='form']");
	
	////////////////Consolidate functions//////////////

	public void registerAccount(HashMap<String, String> userDetails, HashMap<String, String> addressDetails) {
		enter(EmailCreate_input, userDetails.get("email"));
		click(CreateAnAccount_Button);
		if (userDetails.get("title").contains("Mrs"))
			click(TitleMrs_radio);
		else
			click(TitleMr_radio);
		enter(FirstName_input, userDetails.get("firstName"));
		enter(LastName_input, userDetails.get("lastName"));
		enter(Email_input, userDetails.get("email"));
		enter(Password_input, userDetails.get("password"));
		String arr[] = userDetails.get("dob").split("-");
		Select day = new Select(getWebDriver().findElement(DOB_Day_dropdown));
		day.selectByValue(arr[0]);
		Select month = new Select(getWebDriver().findElement(DOB_Month_dropdown));
		month.selectByValue(arr[1]);
		Select year = new Select(getWebDriver().findElement(DOB_Year_dropdown));
		year.selectByValue(arr[2]);
		addAddress(addressDetails);
		click(Register_button);
	}
	
	public void addAddress(HashMap<String, String> addressDetails) {
		enter(AddressFirstName_input, addressDetails.get("firstName"));
		enter(AddressLastName_input, addressDetails.get("lastName"));
		enter(AddressCompanyName_input, addressDetails.get("company"));
		enter(AddressLine1_input, addressDetails.get("address1"));
		enter(AddressLine2_input, addressDetails.get("address2"));
		enter(AddressCity_input, addressDetails.get("city"));
		Select state = new Select(getWebDriver().findElement(AddressState_dropdown));
		state.selectByVisibleText(addressDetails.get("state"));
		enter(AddressZipCode_input, addressDetails.get("zip"));
		Select country = new Select(getWebDriver().findElement(AddressCountry_dropdown));
		country.selectByVisibleText(addressDetails.get("country"));
		enter(AddressAdditionalInfo_input, addressDetails.get("info"));
		enter(AddressHomePhone_input, addressDetails.get("homePhone"));
		enter(AddressMobilePhone_input, addressDetails.get("mobilePhone"));
		enter(AddressAlias_input, addressDetails.get("alias"));
	}

		
	public void enterOrderMessageAndProceed(String message) {
		enter(OrderMessage_input, message);
		proceedToCheckout();
	}
	
	public void acceptTermAndProceed() {
		JavascriptExecutor js = (JavascriptExecutor)getWebDriver();
		js.executeScript("arguments[0].click();", getWebDriver().findElement(TermsOfServices_button));
		proceedToCheckout();
	}
	
	private void proceedToCheckout() {
		waitUntilElementIsClickable(ProceedToCheckout_button);
		click(ProceedToCheckout_button);		
	}
}
