package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Objects;

public class Utils {
	
	/**
	 * The method waits for the element to become clickable (displayed and enabled)
	 * @param driver - web driver
	 * @param selector - element selector we are waiting for
	 * @param waitInterval - time that the driver will wait for the element to appear
	 * @return WebElement selected element
	 */
	public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
		return element;
	}
	
	/**
	 * The method waits for the element to appear in the DOM tree
	 * @param driver - web driver
	 * @param selector - element selector we are waiting for
	 * @param waitInterval - time that the driver will wait for the element to appear
	 * @return WebElement selected element
	 */
	public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
		return element;
	}

	/**
	 * Wait for a file to download
	 * @param driver - web driver
	 * @param file - file to download
	 */
	public static void waitForFile(WebDriver driver, File file) {
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(1));
		wait.until((webDriver) -> Objects.requireNonNull(file.listFiles()).length>0);
	}
}
