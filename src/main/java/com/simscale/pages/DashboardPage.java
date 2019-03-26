package com.simscale.pages;

import org.openqa.selenium.By;
import com.simscale.base.PageBase;

public class DashboardPage extends PageBase {

	By NewProject_button = By.xpath("//button[@id='newProject']");
	By ProjectTitle_input = By.xpath("//input[@id='projectTitle']");
	By ProjectDescription_input = By.xpath("//input[@id='projectDescription']");
	By ProjectCategory_dropdown = By.xpath("//input[@id='projectCategory']");
	By AddTag_input = By.xpath("//span[@class='tagify__input']");
	By AdvancedSettings_button = By.xpath("//h5[@class='collapseTitle collapsed']");
	By measurement_dropdown = By.xpath("//div[@id='measurements']");
	By createProjet_button = By.xpath("//button[@class='btn btn-medium btn-primary btn-create-new-project inputSubmit']");
	By addFiles_Button = By.xpath("//button[@id='btn-add-files']");
	By closeProjectWindow_button = By.xpath("//button[@class='close']");
	
	public void clickNewProject() {
		click(NewProject_button);
	}

	public void enterProjectTitle() {
		enter(ProjectTitle_input, "Test1");
	}

	public void enterDescription() {
		enter(ProjectDescription_input, "Test1");		
	}

	public void selectProjectCategory(String category) {
		click(ProjectCategory_dropdown);
		click(By.xpath("//div[@class='selectOption']/input[@id="+ category.toUpperCase() +"]"));		
	}

	public void addTag() {
		enter(AddTag_input, "TagTest1");
	}

	public void clickAdvanceSetting() {
		click(AdvancedSettings_button);
	}
	
	public void selectMeasurement(String measurementType) {
		click(measurement_dropdown);
		click(By.xpath("//input[@id='"+measurementType.toUpperCase()+"']/following-sibling::label"));		
	}

	public void clickCreateProject() {
		click(createProjet_button);
	}
	
	public void closeProjectWindow() {
		click(closeProjectWindow_button);
	}
	//////////////// Consolidate functions//////////////

}