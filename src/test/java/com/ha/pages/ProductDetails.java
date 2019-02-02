package com.ha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ProductDetails extends PageBase{

	By Quantity_input = By.xpath("//input[@id='quantity_wanted']");
	By SelectSize_dropdown = By.xpath("//select[@id='group_1']");
	By AddToCart_button = By.xpath("//p[@id='add_to_cart']/button");
	By ProceedToCheckout_button = By.xpath("//span[contains(text(),'Proceed to checkout')]");
	By ProceedToCheckoutCart_button = By.xpath("//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]");
	
	////////////////Consolidate functions//////////////

	public void selectQuantity(int quantity) {
		waitTillElementVisible(Quantity_input);
		enter(Quantity_input, Integer.toString(quantity));
	}
	
	public void selectSize(String size) {
		Select sizes = new Select(getWebDriver().findElement(SelectSize_dropdown));
		sizes.selectByVisibleText(size);
	}
	
	public void addToCart() {
		click(AddToCart_button);
	}
	
	public void proceedToCheckout() {
		waitTillElementVisible(ProceedToCheckout_button);
		waitUntilElementIsClickable(ProceedToCheckout_button);
		click(ProceedToCheckout_button);
	}

	public void proceedToCheckoutCart() {
		waitTillElementVisible(ProceedToCheckoutCart_button);
		waitUntilElementIsClickable(ProceedToCheckoutCart_button);
		click(ProceedToCheckoutCart_button);
	}
}
