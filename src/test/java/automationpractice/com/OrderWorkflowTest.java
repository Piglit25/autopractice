package automationpractice.com;

import utils.BaseUtil;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OrderWorkflowTest extends BaseUtil {

	@Test
	@Description("Buy two dresses")
	public void orderClothes() {
		assertTrue(clothes.getDressesBtn().isDisplayed());

		action.moveToElement(clothes.getDressesBtn()).perform();

		assertTrue(clothes.getCasualDressesBtn().isDisplayed());
		assertTrue(clothes.getEveningDressesBtn().isDisplayed());
		assertTrue(clothes.getSummerDressesBtn().isDisplayed());

		action.moveToElement(clothes.getSummerDressesBtn()).perform();
		clothes.getSummerDressesBtn().click();

		assertTrue(clothes.getSummerDressProduct(1).isDisplayed());
		assertTrue(clothes.getSummerDressProduct(2).isDisplayed());
		assertTrue(clothes.getSummerDressProduct(3).isDisplayed());
		assertEquals(clothes.getDressesCount().size(), 3);

		action.moveToElement(clothes.getSummerDressProduct(1)).perform();
		action.moveToElement(shoppingActions.getAddToCartBtn()).perform();

		assertTrue(shoppingActions.getAddToCartBtn().isDisplayed());

		action.click(shoppingActions.getAddToCartBtn()).build().perform();
		action.click(shoppingActions.getContinueShoppingBtn()).build().perform();

		action.moveToElement(cart.getCartTab()).perform();

		assertEquals(cart.getCartProductsQty().size(), 1);

		// Adding second dress
		action.moveToElement(clothes.getDressesBtn()).perform();

		assertTrue(clothes.getCasualDressesBtn().isDisplayed());

		action.moveToElement(clothes.getCasualDressesBtn()).perform();
		clothes.getCasualDressesBtn().click();
		action.moveToElement(clothes.getCasualDressProduct(1)).perform();
		action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
		action.click(shoppingActions.getAddToCartBtn()).build().perform();
		action.click(shoppingActions.getContinueShoppingBtn()).build().perform();
		action.moveToElement(cart.getCartTab()).perform();

		assertEquals(cart.getCartProductsQty().size(), 2);

		action.moveToElement(cart.getCartTabCheckOutBtn()).perform();

		assertTrue(cart.getCartTabCheckOutBtn().isDisplayed());

		action.click(cart.getCartTabCheckOutBtn()).build().perform();

		assertTrue(summary.getCartSummaryTable().isDisplayed());
		assertEquals(summary.getCartSummTotalProductsNum().size(), 2);
		assertEquals(summary.getCartSummTotalShipping().getText(), "$2.00");

		summary.getCartProceedBtn().click();

		assertTrue(createAccount.getCreateAccountEmailField().isDisplayed());

        createAccount.setCreateAccountEmailField(email);
		createAccount.getCreateAccountBtn().click();

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

		assertTrue(summary.getCartSummBillingAdressName().isDisplayed());

		summary.getCartProceedBtnTwo().click();

		assertTrue(summary.getCartSummTermsOfServiceDialog().isDisplayed());

		summary.getCartSummTermsOfServiceCheck().click();
		summary.getCartProceedBtnTwo().click();
		summary.getCartSummPayByBankWire().click();

		assertEquals(summary.getCartSummPayByBankWireConfirm().getText(), "BANK-WIRE PAYMENT.");

		summary.getCartSummOtherPaymentMethods().click();
		summary.getCartSummPayByCheck().click();

		assertEquals(summary.getCartSummPayByCheckConfirm().getText(), "CHECK PAYMENT");

		summary.getCartSummConfirmOrderBtn().click();

		assertTrue(summary.getCartSummSuccessMsg().isDisplayed());
		assertEquals(summary.getCartSummSuccessMsg().getText(), "Your order on My Store is complete.");

		account.getAccountBtn().click();

		assertTrue(account.getAccountOrderHistoryBtn().isDisplayed());

		account.getAccountOrderHistoryBtn().click();

		assertTrue(account.getAccountOrderListTable().isDisplayed());

		account.getAccountBtn().click();
		account.getAccountOrderHistoryBtn().click();

		assertEquals(account.getAccountOrdersList().size(), 1, "There is not 1 order in the list");
	}
}
