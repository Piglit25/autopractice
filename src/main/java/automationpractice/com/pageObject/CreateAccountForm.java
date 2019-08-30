package automationpractice.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Utils;

public class CreateAccountForm {
	
	private WebDriver driver;
	
	public CreateAccountForm(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Getters
	 */

	public WebElement getAccountCreationForm() {
		return Utils.waitForElementPresence(driver, By.id("account-creation_form"), 15);
	}
	
	public WebElement getCustomerTitleMr() {
		return Utils.waitToBeClickable(driver, By.id("uniform-id_gender1"), 15);
	}
	
	public WebElement getCustomerTitleMrs() {
		return Utils.waitToBeClickable(driver, By.id("uniform-id_gender2"), 15);
	}
	
	public WebElement getCustomerFirstNameField() {
		return Utils.waitForElementPresence(driver, By.id("customer_firstname"), 15);
	}
	
	public WebElement getCustomerLastNameField() {
		return Utils.waitForElementPresence(driver, By.id("customer_lastname"), 15);
	}
	
	public WebElement getCustomerEmailField() {
		return Utils.waitForElementPresence(driver, By.id("email"), 15);
	}
	
	public WebElement getCustomerPasswordField() {
		return Utils.waitForElementPresence(driver, By.id("passwd"), 15);
	}
	
	public Select selectCustomerDateOfBirthDay() {
		WebElement dayOfBirth = Utils.waitForElementPresence(driver, By.id("days"), 15);
		return new Select(dayOfBirth);
	}
	
	public Select selectCustomerDateOfBirthMonth() {
		WebElement monthOfBirth = Utils.waitForElementPresence(driver, By.id("months"), 15);
		return new Select(monthOfBirth);
	}
	
	public Select selectCustomerDateOfBirthYear() {
		WebElement yearOfBirth = Utils.waitForElementPresence(driver, By.id("years"), 15);
		return new Select(yearOfBirth);
	}
	
	public WebElement getCompanyField() {
		return Utils.waitForElementPresence(driver, By.id("company"), 15);
	}
	
	public WebElement getAddressField() {
		return Utils.waitForElementPresence(driver, By.id("address1"), 15);
	}
	
	public WebElement getAddressFieldTwo() {
		return Utils.waitForElementPresence(driver, By.name("address2"), 15);
	}
	
	public WebElement getCity() {
		return Utils.waitForElementPresence(driver, By.id("city"), 15);
	}
	
	public Select selectCountry() {
		WebElement country = Utils.waitForElementPresence(driver, By.id("id_country"), 15);
		return new Select(country);
	}
	
	public Select selectState() {
		WebElement state = Utils.waitForElementPresence(driver, By.id("id_state"), 15);
		return new Select(state);
	}
	
	public WebElement getPostalCodeField() {
		return Utils.waitForElementPresence(driver, By.id("postcode"), 15);
	}
	
	public WebElement getAdditionalInformationField() {
		return Utils.waitForElementPresence(driver, By.id("other"), 15);
	}
	
	public WebElement getHomePhoneField() {
		return Utils.waitForElementPresence(driver, By.id("phone"), 15);
	}
	
	public WebElement getMobilePhoneField() {
		return Utils.waitForElementPresence(driver, By.id("phone_mobile"), 15);
	}
	
	public WebElement getAddressAliasField() {
		return Utils.waitForElementPresence(driver, By.id("alias"), 15);
	}
	
	public WebElement getRegisterBtn() {
		return Utils.waitToBeClickable(driver, By.id("submitAccount"), 15);
	}
	
	public WebElement successfullyCreatedAccount() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"Welcome to your account.\")]"), 15);
	}

	/**
	 * Setters
	 */

	public void setCustomerTitleMr() {
		this.getCustomerTitleMr().click();
	}
	
	public void setCustomerTitleMrs() {
		this.getCustomerTitleMrs().click();
	}
	
	public void setCustomerFirstNameField(String firstName) {
		WebElement customerFirstNameField = this.getCustomerFirstNameField();
		customerFirstNameField.clear();
		customerFirstNameField.sendKeys(firstName);
	}
	
	public void setCustomerLastNameField(String lastName) {
		WebElement customerLastNameField = this.getCustomerLastNameField();
		customerLastNameField.clear();
		customerLastNameField.sendKeys(lastName);
	}
	
	public void setCustomerEmailField(String email) {
		WebElement customerEmailField = this.getCustomerEmailField();
		customerEmailField.clear();
		customerEmailField.sendKeys(email);
	}
	
	public void setCustomerPasswordField(String password) {
		WebElement customerPasswordField = this.getCustomerPasswordField();
		customerPasswordField.clear();
		customerPasswordField.sendKeys(password);
	}
	
	public void selectCustomerDateOfBirthDay(String day) {
		Select dayOfBirth = this.selectCustomerDateOfBirthDay();
		dayOfBirth.selectByValue(day);
	}
	
	public void selectCustomerDateOfBirthMonth(String month) {
		Select monthOfBirth = this.selectCustomerDateOfBirthMonth();
		monthOfBirth.selectByValue(month);
	}
	
	public void selectCustomerDateOfBirthYear(String year) {
		Select yearOfBirth = this.selectCustomerDateOfBirthYear();
		yearOfBirth.selectByValue(year);
	}
	
	public void setCompanyField(String company) {
		WebElement companyField = this.getCompanyField();
		companyField.clear();
		companyField.sendKeys(company);
	}
	
	public void setAddressField(String address) {
		WebElement addressField = this.getAddressField();
		addressField.clear();
		addressField.sendKeys(address);
	}
	
	public void setAddressFieldTwo(String addresTwo) {
		WebElement addresField = this.getAddressFieldTwo();
		addresField.clear();
		addresField.sendKeys(addresTwo);
	}
	
	public void setCityField(String city) {
		WebElement cityField = this.getCity();
		cityField.clear();
		cityField.sendKeys(city);
	}
	
	public void selectState(String state) {
		Select selectState = this.selectState();
		selectState.selectByValue(state);
	}
	
	public void setPostalCodeField(String zip) {
		WebElement postalCode = this.getPostalCodeField();
		postalCode.clear();
		postalCode.sendKeys(zip);
	}
	
	public void selectCountry(String country) {
		Select selectCountry = this.selectCountry();
		selectCountry.selectByVisibleText(country);
	}
	
	public void setAdditionalInfo(String info) {
		WebElement additionalInfo = this.getAdditionalInformationField();
		additionalInfo.clear();
		additionalInfo.sendKeys(info);
	}
	
	public void setHomePhoneField(String phone) {
		WebElement homePhone = this.getHomePhoneField();
		homePhone.clear();
		homePhone.sendKeys(phone);
	}
	
	public void setMobilePhoneField(String phone) {
		WebElement mobilePhone = this.getMobilePhoneField();
		mobilePhone.clear();
		mobilePhone.sendKeys(phone);
	}
	
	public void setAddressAliasField(String alias) {
		WebElement addressAlias = this.getAddressAliasField();
		addressAlias.clear();
		addressAlias.sendKeys(alias);
	}
}
