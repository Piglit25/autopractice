package automationpractice.com.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class Cart {
	
	private WebDriver driver;
	
	public Cart(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartTab() {
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"Cart\")]/.."), 15);
	}
	
	public WebElement getCartEmpty() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[@class=\"cart_block_no_products unvisible\"]"), 15);
	}
	
	public WebElement getCartProducts(int productNum) {
		return Utils.waitForElementPresence(driver, By.xpath("//dt[" + productNum + "]"), 15);
	}
	
	public WebElement getCartProductsQty(int numOfProduct) {
		return Utils.waitForElementPresence(driver, By.xpath("//dt[" + numOfProduct + "]//span[@class=\"quantity\"]"), 15);
	}
	
	public WebElement getCartProductPrice(int numOfProduct) {
		return Utils.waitForElementPresence(driver, By.xpath("//dt[" + numOfProduct + "]//span[@class=\"price\"]"), 15);
	}

	public WebElement getCartTotalPrice() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[@class=\"price cart_block_total ajax_block_cart_total\"]"), 15);
	}
	
	public WebElement getCartTabCheckOutBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@id=\"button_order_cart\"]/span[contains(text(), \"Check out\")]"), 15);
	}
	
	public List<WebElement> getCartProductsQty() {
		return driver.findElements(By.xpath("//dt"));
	}
}
