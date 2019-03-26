package com.simscale.hooks;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.simscale.utils.WebUIUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	static Logger log = Logger.getLogger(Hooks.class);

	@Before
	public void beforeScenario(Scenario scene) {
		log.log(Level.INFO, "************Scenario " + scene.getName() + " is started************");
	}

	@After
	public void afterScenario(Scenario scene) {
		log.log(Level.INFO, "Scenario " + scene.getName() + " is: " + scene.getStatus().toUpperCase());
		if (scene.isFailed()) {
			WebUIUtil.captureScreenShot(scene.getName().replace(" ", "") + System.currentTimeMillis());
		}
	}
}
