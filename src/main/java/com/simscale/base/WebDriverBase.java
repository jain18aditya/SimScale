package com.simscale.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simscale.utils.ConfigUtil;
import com.simscale.utils.LoggerUtil;

public class WebDriverBase {
	private static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public Logger s_logs = LoggerUtil.logger();

	public void loadWebDriver(String browser) {
		switch (browser.toUpperCase()) {
		case "FIREFOX":
			driver = new FirefoxDriver();
			s_logs.log(Level.INFO, "Launched Firefox browser");
			break;

		case "CHROME":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			options.addArguments("--disable-notifications");
			if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
				System.setProperty("webdriver.chrome.driver",
						ConfigUtil.getRootDir() + ConfigUtil.getProperty("browser.path") + "/chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver",
						ConfigUtil.getRootDir() + ConfigUtil.getProperty("browser.path") + "/chromedriver");
			}
			driver = new ChromeDriver(options);
			s_logs.log(Level.INFO, "Launched Chrome browser");
			break;

		case "INTERNET EXPLORER":
			System.setProperty("webdriver.ie.driver",
					ConfigUtil.getRootDir() + ConfigUtil.getProperty("browser.path") + "/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			s_logs.log(Level.INFO, "Launched Internet explorer");
			break;

		case "CHROME EMULATION":
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "iPhone 7");
			System.setProperty("webdriver.chrome.driver",
					ConfigUtil.getRootDir() + ConfigUtil.getProperty("browser.path") + "/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(chromeOptions);
			s_logs.log(Level.INFO, "Launching chrome emulation browser");
			break;
		}
		driver.manage().deleteAllCookies();
		s_logs.log(Level.INFO, "Deleted all browser cookies.");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
	}

	public void cleanUP() {
		driver.close();
		s_logs.log(Level.INFO, "closed web browser");
	}

	public WebDriver getWebDriver() {
		if (driver == null) {
			String browser = ConfigUtil.getProperty("browser");
			if (System.getenv("browser") != null)
				browser = System.getenv("browser");
			loadWebDriver(browser);
		}
		return driver;
	}

	public void setWebDriver(WebDriver newDriver) {
		driver = newDriver;
		wait = new WebDriverWait(driver, 30);
	}
}
