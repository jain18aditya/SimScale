package com.simscale.pages;

import org.openqa.selenium.By;
import com.simscale.base.PageBase;

public class DashboardPage extends PageBase {

	By NewProject_button = By.xpath("//button[@id='newProject']");
	
	
	
	public void clickNewProject() {
		click(NewProject_button);
	}
	//////////////// Consolidate functions//////////////

}