package com.ha.pages;

import org.openqa.selenium.By;

public class PaymentPage extends PageBase{
	By PaymentMethodCheque_link = By.xpath("//a[@class='cheque']");
	By ConfirmOrder_button = By.xpath("//span[contains(text(),'I confirm my order')]");
	By SuccessAlert_label = By.xpath("//p[@class='alert alert-success']");

	////////////////Consolidate functions//////////////

	public void payByCheque() {
		waitUntilElementIsClickable(PaymentMethodCheque_link);
		click(PaymentMethodCheque_link);
	}
	
	public void confirmOrder() {
		waitUntilElementIsClickable(ConfirmOrder_button);
		click(ConfirmOrder_button);
	}
	
	public String getOrderStatus() {
		waitTillElementVisible(SuccessAlert_label);
		return getText(SuccessAlert_label);
	}
}
