package automationpractice.com;

import utils.BaseUtil;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateAccountTest extends BaseUtil {

	@Test
    @Description("Creating an account with required fields")
	public void createAccountSuccessfully() {
		homepage.getSignInBtn().click();

		assertTrue(createAccount.getCreateAccountForm().isDisplayed());
		assertTrue(createAccount.getCreateAccountEmailField().isDisplayed());
		assertTrue(createAccount.getCreateAccountBtn().isDisplayed());

		createAccount.setCreateAccountEmailField(email);
		createAccount.getCreateAccountBtn().click();

		assertTrue(createAccountForm.getAccountCreationForm().isDisplayed(),
				"Creation account form is not present");

		createAccountForm.setCustomerFirstNameField("John");
		createAccountForm.setCustomerLastNameField("Doe");
		createAccountForm.setCustomerPasswordField("test123");
		createAccountForm.selectCustomerDateOfBirthDay("1");
		createAccountForm.selectCustomerDateOfBirthMonth("1");
		createAccountForm.selectCustomerDateOfBirthYear("1991");
		createAccountForm.setAddressField("Some street");
		createAccountForm.setCityField("Some city");
		createAccountForm.selectState("9");
		createAccountForm.setPostalCodeField("21000");
		createAccountForm.setMobilePhoneField("89997771122");
		createAccountForm.setAddressAliasField("My Address");

		createAccountForm.getRegisterBtn().click();

        assertTrue(createAccountForm.successfullyCreatedAccount().isDisplayed());
        assertTrue(account.getAccountBtn().isDisplayed());
        assertTrue(account.getAccountLogout().isDisplayed());
        assertTrue(account.getAccountOrderHistoryBtn().isDisplayed());

        account.getAccountLogout().click();

        assertTrue(createAccount.getCreateAccountForm().isDisplayed());

		createAccountForm.setCustomerEmailField(email);
		createAccountForm.setCustomerPasswordField("test123");
		signInForm.getSignInBtn().click();

        assertTrue(account.getAccountBtn().isDisplayed());

        account.getAccountLogout().click();
	}
}
