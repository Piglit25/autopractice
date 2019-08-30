package automationpractice.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class Homepage {
	
	private WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignInBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(), \"Sign in\")]"), 15);
	}

	public WebElement getSearchBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//form[@id=\"searchbox\"]//button[@type=\"submit\"]"), 15);
	}

	public WebElement getSearchField() {
		return Utils.waitForElementPresence(driver, By.id("search_query_top"), 15);
	}

	public void setSearchField(String searchWord) {
		WebElement element = this.getSearchField();
		element.clear();
		element.sendKeys(searchWord);
	}
}
