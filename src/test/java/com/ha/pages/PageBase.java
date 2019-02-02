package com.ha.pages;

import org.apache.log4j.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ha.base.WebDriverBase;
import com.ha.utils.WebUIUtil;

public abstract class PageBase extends WebDriverBase {

	public void waitTillElementVisible(By locator, int timeout) {
		s_logs.log(Level.INFO, "Waiting for locator " + locator);
		WebDriverWait waitLong = new WebDriverWait(getWebDriver(), timeout);
		waitLong.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void sleep(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (Throwable t) {
			s_logs.log(Level.ERROR, t);
		}
	}

	public WebElement findElement(By locator) {
		WebElement element = null;
		try {
			element = getWebDriver().findElement(locator);
		} catch (Throwable t) {
			s_logs.log(Level.ERROR, "Element not found", t);
			WebUIUtil.captureScreenShot("ElementNotFound_" + System.currentTimeMillis());
		}
		return element;
	}

	public void click(By locator) {
		try {
			findElement(locator).click();
			s_logs.log(Level.INFO, "Clicked on locator: " + locator);
		} catch (Throwable t) {
			s_logs.log(Level.ERROR, "Unable to click" + locator, t);
			String screenShotName = "ElementNotClickable" + System.currentTimeMillis();
			WebUIUtil.captureScreenShot(screenShotName);
			Assert.fail("Unable to Click on locator : " + locator + " , kindly refer screenshot : " + screenShotName);
		}
	}

	public void enter(By locator, String value) {
		try {
			clear(locator);
			findElement(locator).sendKeys(value);
			s_logs.log(Level.INFO, "Entered " + value + " in locator: " + locator);
		} catch (Throwable t) {
			s_logs.log(Level.ERROR, "Unable to Enter: " + value + " on locator: " + locator, t);
			String screenShotName = "UnableToEnterText" + System.currentTimeMillis();
			WebUIUtil.captureScreenShot(screenShotName);
			Assert.fail("Unable to Enter: " + value + " on locator : " + locator + " , kindly refer screenshot : "
					+ screenShotName);
		}
	}

	public void clear(By locator) {
		try {
			findElement(locator).clear();
			s_logs.log(Level.INFO, "Cleared value of locator: " + locator);
		} catch (Throwable t) {
			s_logs.log(Level.ERROR, "Unable to Clear", t);
			String screenShotName = "UnableToClear" + System.currentTimeMillis();
			WebUIUtil.captureScreenShot(screenShotName);
			Assert.fail("Unable to Clear value from locator: " + locator + " , kindly refer screenshot : "
					+ screenShotName);
		}
	}

	public String getText(By locator) {
		String text = "";
		try {
			text = findElement(locator).getText().trim();
			s_logs.log(Level.INFO, "Text for locator: " + locator + " : " + text);
		} catch (Throwable t) {
			s_logs.log(Level.ERROR, "Unable to get Text", t);
			String screenShotName = "UnableToGetText" + System.currentTimeMillis();
			WebUIUtil.captureScreenShot(screenShotName);
			Assert.fail(
					"Unable to get Text from locator: " + locator + " , kindly refer screenshot : " + screenShotName);
		}
		return text;
	}

	public void waitTillElementVisible(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			s_logs.log(Level.INFO, "Wait condition satisfied for locator :" + locator);
		} catch (Throwable t) {
			s_logs.log(Level.ERROR, "Element not visible");
		}
	}

	public void waitUntilElementIsClickable(By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Throwable t) {
			s_logs.log(Level.ERROR, "Element not found", t);
		}
	}
}
