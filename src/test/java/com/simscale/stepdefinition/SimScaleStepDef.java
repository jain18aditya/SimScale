package com.simscale.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import com.simscale.pages.DashboardPage;
import com.simscale.pages.LoginPage;
import com.simscale.pages.ProjectDetailsPage;
import com.simscale.utils.ConfigUtil;
import com.simscale.utils.LoggerUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SimScaleStepDef {

	LoginPage loginPage = new LoginPage();
	DashboardPage dashboardPage = new DashboardPage();
	ProjectDetailsPage projectDetailsPage = new ProjectDetailsPage();
	Logger s_logs = LoggerUtil.logger();
	int projectsCount = 0, deleteProjectCount = 0;
	boolean status = false;

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

	@When("^user creates new project with inputs \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void createProject(String title, String desc, String category, String tag, String measurementType) {
		projectsCount = dashboardPage.getProjectList().size();
		dashboardPage.createNewProject(title, desc, category, tag, measurementType);
	}

	@Then("Project should be displayed on \"([^\"]*)\" with \"([^\"]*)\"$")
	public void validateProject(String url, String title) {
		List<String> projectList = new ArrayList<String>();
		Assert.assertEquals("Invalid title is displayed", "Upload", projectDetailsPage.getuploadTitle());
		s_logs.log(Level.INFO, "Project created successfully with name " + title);
		loginPage.navigateToURL(ConfigUtil.getProperty(url));
		projectList = dashboardPage.getProjectList();
		s_logs.log(Level.INFO, "Total project list is " + projectList);
		Assert.assertEquals("Invalid project count is displayed", projectsCount + 1, projectList.size());
		Assert.assertEquals("Project added is not present in the list", true, projectList.contains(title));
	}

	@When("User deletes {string}")
	public void deleteProject(String projectName) {
		deleteProjectCount = dashboardPage.getProjectList().size();
		if(deleteProjectCount > 0)
			dashboardPage.deleteProject(projectName);
		else
			s_logs.log(Level.INFO, "No projects are present to delete");			
	}

	@Then("validate {string} is deleted")
	public void validateDeletion(String projectName) {
		List<String> projectList = new ArrayList<String>();
		projectList = dashboardPage.getProjectList();
		int expectedCount = 0;
		if (!projectName.equals("All")) 
			expectedCount = deleteProjectCount -1;
		s_logs.log(Level.INFO, "Total project list is " + projectList);
		Assert.assertEquals("Invalid project count is displayed", expectedCount, projectList.size());
	}
	
	@Then("^Logout the user$")
	public void logoutUser() throws Throwable {
		loginPage.logout();
	}
}