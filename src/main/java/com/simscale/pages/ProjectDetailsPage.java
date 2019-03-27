package com.simscale.pages;

import org.openqa.selenium.By;

import com.simscale.base.PageBase;

public class ProjectDetailsPage extends PageBase {
	By uploadTitle_label = By.xpath("//div[@class='modal-header']/h4[@class='modal-title']");

	public String getuploadTitle() {
		waitTillElementVisible(uploadTitle_label);
		return getText(uploadTitle_label);
	}
}
