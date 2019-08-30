package automationpractice.com;

import utils.BaseUtil;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.Utils;

import java.util.Objects;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DownloadTest extends BaseUtil {

    @Test
    @Description("Download an invoice")
    public void downloadInvoice() {
        homepage.getSignInBtn().click();
        signInForm.setEmailField("test2525@mail.com");
        signInForm.setPasswordField("piglit25");
        signInForm.getSignInBtn().click();
        account.getAccountOrderHistoryBtn().click();

        assertFalse(Objects.requireNonNull(fileDownloadPath.list()).length > 0, "Folder is not empty");

        account.getInvoiceOfTheLastOrder().click();

        Utils.waitForFile(driver, fileDownloadPath);
        assertTrue(Objects.requireNonNull(fileDownloadPath.list()).length > 0, "Folder is empty");
    }
}
