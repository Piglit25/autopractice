package automationpractice.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class CreateAccount {
	
	private WebDriver driver;
	
	public CreateAccount(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateAccountForm() {
		return Utils.waitForElementPresence(driver, By.id("create-account_form"), 15);
	}
	
	public WebElement getCreateAccountEmailField() {
		return Utils.waitForElementPresence(driver, By.id("email_create"), 15);
	}
	
	public WebElement getCreateAccountBtn() {
		return Utils.waitToBeClickable(driver, By.id("SubmitCreate"), 15);
	}
	
	public void setCreateAccountEmailField(String email) {
		WebElement element = this.getCreateAccountEmailField();
		element.clear();
		element.sendKeys(email);
	}
}
