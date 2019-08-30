package automationpractice.com.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class Account {
	
	private WebDriver driver;
	
	public Account(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAccountBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"View my customer account\"]"), 15);
	}
	
	public WebElement getAccountLogout() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Log me out\"]"), 15);
	}
	
	public WebElement getAccountOrderHistoryBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//span[contains(text(), \"Order history and details\")]"), 15);
	}
	
	public WebElement getAccountOrderListTable() {
		return Utils.waitToBeClickable(driver, By.xpath("//table[@id=\"order-list\"]"), 15);
	}
	
	public List<WebElement> getAccountOrdersList() {
		return driver.findElements(By.xpath("//table[@id=\"order-list\"]/tbody/tr"));
	}

	public WebElement getInvoiceOfTheLastOrder() {
		return Utils.waitToBeClickable(driver, By.xpath("//table[@id=\"order-list\"]/tbody/tr//a[@title=\"Invoice\"]"), 15);
	}
}
