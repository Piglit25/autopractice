package automationpractice.com.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class CartSummary {
	
	private WebDriver driver;
	
	public CartSummary(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartSummaryTable() {
		return Utils.waitForElementPresence(driver, By.id("cart_summary"), 15);
	}
	
	public WebElement getCartSummTotalShipping() {
		return Utils.waitForElementPresence(driver, By.id("total_shipping"), 15);
	}
	
	public WebElement getCartProceedBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"), 15);
	}
	
	public WebElement getCartProceedBtnTwo() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"Proceed to checkout\")]"), 15);
	}
	
	public WebElement getCartSummBillingAdressName() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_firstname address_lastname\"]"), 15);
	}

	public WebElement getCartSummTermsOfServiceCheck() {
		return Utils.waitForElementPresence(driver, By.id("cgv"), 15);
	}
	
	public WebElement getCartSummTermsOfServiceDialog() {
		return Utils.waitForElementPresence(driver, By.xpath("//label[contains(text(), \"I agree to the terms of service and will adhere to them unconditionally\")]"), 15);
	}
	
	public WebElement getCartSummPayByBankWire() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Pay by bank wire\"]"), 15);
	}
	
	public WebElement getCartSummPayByCheck() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Pay by check.\"]"), 15);
	}
	
	public WebElement getCartSummPayByBankWireConfirm() {
		return Utils.waitForElementPresence(driver, By.xpath("//h3[contains(text(), \"Bank-wire payment.\")]"), 15);
	}
	
	public WebElement getCartSummPayByCheckConfirm() {
		return Utils.waitForElementPresence(driver, By.xpath("//h3[contains(text(), \"Check payment\")]"), 15);
	}
	
	public WebElement getCartSummConfirmOrderBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"I confirm my order\")]"), 15);
	}
	
	public WebElement getCartSummOtherPaymentMethods() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=order&step=3\"]"), 15);
	}
	
	public WebElement getCartSummSuccessMsg() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"Your order on My Store is complete.\")]"), 15);
	}
	
	public List<WebElement> getCartSummTotalProductsNum() {
		return driver.findElements(By.xpath("//table[@id=\"cart_summary\"]/tbody/tr"));
	}
}
