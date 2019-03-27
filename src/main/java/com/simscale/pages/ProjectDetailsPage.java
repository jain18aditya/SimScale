package com.simscale.pages;

import org.openqa.selenium.By;

import com.simscale.base.PageBase;

public class ProjectDetailsPage extends PageBase {
	By uploadTitle_label = By.xpath("//div[@class='modal-header']/h4[@class='modal-title']");
	By deleteProject_button = By.xpath("//button[@title='Delete']");
	By deleteConfirm_button = By.xpath("//button[@class='btn btn-danger btn-delete-project']");
	By deleteSuccess_label = By.xpath("//div[contains(@class,'alert-success')]");

	public String getuploadTitle() {
		waitTillElementVisible(uploadTitle_label);
		return getText(uploadTitle_label);
	}

	public boolean deleteProject() {
		waitTillElementVisible(deleteProject_button);
		click(deleteProject_button);
		waitTillElementVisible(deleteConfirm_button);
		click(deleteConfirm_button);
		waitTillElementVisible(deleteSuccess_label);
		if(getText(deleteSuccess_label).equals("Project successfully deleted")) {
			return true;
		}
		return false;
	}
}
