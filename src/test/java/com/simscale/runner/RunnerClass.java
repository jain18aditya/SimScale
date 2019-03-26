package com.simscale.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/html/cucumber.html", "json:target/html/cucumber.json",},
		features = {"src/test/resources/features/SimScaleTest.feature" }, 
		glue = {"com.simscale.stepdefinition", "com.simscale.hooks" }, 
		monochrome = true)

public class RunnerClass {

}
