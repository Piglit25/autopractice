package automationpractice.com;

import utils.BaseUtil;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class NegativeRegisterTest extends BaseUtil {

    @Test
    @Description("Test will fail. We are to see report with screenshots")
    // Allure (https://docs.qameta.io/allure/) is used as a test report tool
    public void runAndFailTest() {
        homepage.getSignInBtn().click();
        createAccount.getCreateAccountBtn().click();

        assertFalse(createAccount.getCreateAccountEmailField().isDisplayed(),
                "There is no email");
    }
}
