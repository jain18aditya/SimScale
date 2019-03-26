package com.simscale.base;

import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase extends WebDriverBase {

	public void waitTillElementVisible(By locator, int timeout) {
		s_logs.log(Level.INFO, "Waiting for locator " + locator);
		WebDriverWait waitLong = new WebDriverWait(getWebDriver(), timeout);
		waitLong.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void sleep(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (Exception e) {
			s_logs.log(Level.ERROR, e);
			e.printStackTrace();
		}
	}

	public WebElement findElement(By locator) {
		WebElement element = null;
		try {
			element = getWebDriver().findElement(locator);
		} catch (Exception e) {
			s_logs.log(Level.ERROR, "Element not found", e);
			e.printStackTrace();
		}
		return element;
	}

	public void click(By locator) {
		try {
			findElement(locator).click();
			s_logs.log(Level.INFO, "Clicked on locator: " + locator);
		} catch (Exception e) {
			s_logs.log(Level.ERROR, "Unable to click" + locator, e);
			e.printStackTrace();
		}
	}

	public void enter(By locator, String value) {
		try {
			clear(locator);
			findElement(locator).sendKeys(value);
			s_logs.log(Level.INFO, "Entered " + value + " in locator: " + locator);
		} catch (Exception e) {
			s_logs.log(Level.ERROR, "Unable to Enter: " + value + " on locator: " + locator, e);
			e.printStackTrace();
		}
	}

	public void clear(By locator) {
		try {
			findElement(locator).clear();
			s_logs.log(Level.INFO, "Cleared value of locator: " + locator);
		} catch (Exception e) {
			s_logs.log(Level.ERROR, "Unable to Clear", e);
			e.printStackTrace();
		}
	}

	public String getText(By locator) {
		String text = "";
		try {
			text = findElement(locator).getText().trim();
			s_logs.log(Level.INFO, "Text for locator: " + locator + " : " + text);
		} catch (Exception e) {
			s_logs.log(Level.ERROR, "Unable to get Text", e);
			e.printStackTrace();
		}
		return text;
	}

	public void waitTillElementVisible(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			s_logs.log(Level.INFO, "Wait condition satisfied for locator :" + locator);
		} catch (Exception e) {
			s_logs.log(Level.ERROR, "Element not visible");
		}
	}

	public void waitUntilElementIsClickable(By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			s_logs.log(Level.ERROR, "Element not found", e);
		}
	}

	public void mouseHover(By hoverLocator, By clickLocator) {
		try {
			Actions action = new Actions(getWebDriver());
			action.moveToElement(getWebDriver().findElement(hoverLocator)).perform();
			action.moveToElement(getWebDriver().findElement(clickLocator)).click().perform();
		} catch (Exception e) {
			s_logs.log(Level.ERROR, "Unable to do mouse hover", e);
			e.printStackTrace();
		}
	}
}
