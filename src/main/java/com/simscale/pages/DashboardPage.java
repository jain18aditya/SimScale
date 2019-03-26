package com.simscale.pages;

import java.util.List;

import org.openqa.selenium.By;
import com.simscale.base.PageBase;

public class DashboardPage extends PageBase {

	By NewProject_button = By.xpath("//button[@id='newProject']");
	By ProjectTitle_input = By.xpath("//input[@id='projectTitle']");
	By ProjectDescription_input = By.xpath("//textarea[@id='projectDescription']");
	By ProjectCategory_dropdown = By.xpath("//div[@id='projectCategory']");
	By AddTag_input = By.xpath("//span[@class='tagify__input']");
	By AdvancedSettings_button = By.xpath("//h5[@class='collapseTitle collapsed']");
	By measurement_dropdown = By.xpath("//div[@id='measurements']");
	By createProjet_button = By.xpath("//button[@class='btn btn-medium btn-primary btn-create-new-project inputSubmit']");
	By addFiles_Button = By.xpath("//button[@id='btn-add-files']");
	By closeProjectWindow_button = By.xpath("//button[@class='close']");
	By createNewProjectTitle_label = By.xpath("//div[@class='modal-header']//h3[text()='Create New Project']");
	By projectList_label = By.xpath("//section[@class='projects-list']//p[@class='project-title']");
	
	public void clickNewProject() {
		waitTillElementVisible(NewProject_button);
		click(NewProject_button);
	}

	public void enterProjectTitle(String title) {
		enter(ProjectTitle_input, title);
	}

	public void enterDescription(String desc) {
		enter(ProjectDescription_input, desc);		
	}

	public void selectProjectCategory(String category) {
		By locator = By.xpath("//div[@class='selectOption']/input[@id='"+ category.toUpperCase() +"']"); 
		click(ProjectCategory_dropdown);
		waitUntilElementIsClickable(locator);
		click(locator);
	}

	public void enterTag(String tag) {
		enter(AddTag_input, tag);
	}

	public void clickAdvanceSetting() {
		waitUntilElementIsClickable(AdvancedSettings_button);
		click(AdvancedSettings_button);
	}
	
	public void selectMeasurement(String measurementType) {
		By locator = By.xpath("//input[@id='"+measurementType.toUpperCase()+"']/following-sibling::label");
		click(measurement_dropdown);
		waitUntilElementIsClickable(locator);
		click(locator);
	}

	public void clickCreateProject() {
		click(createProjet_button);
	}
	
	public void closeProjectWindow() {
		click(closeProjectWindow_button);
	}

	public List<String> getProjectList(){
		waitTillElementVisible(projectList_label);
		return getTexts(projectList_label);
	}
	//////////////// Consolidate functions//////////////

	public void createNewProject(String title, String desc, String category, String tag, String measurementType) {
		waitTillElementVisible(createNewProjectTitle_label);
		clickNewProject();
		enterProjectTitle(title);
		enterDescription(desc);
		if (category!="")
			selectProjectCategory(category);
		if (tag!="")
			enterTag(tag);
		if (measurementType!="") {
			clickAdvanceSetting();
			selectMeasurement(measurementType);
		}
		clickCreateProject();
	}
}