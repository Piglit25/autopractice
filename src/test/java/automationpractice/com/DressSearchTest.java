package automationpractice.com;

import utils.BaseUtil;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DressSearchTest extends BaseUtil {

    @Test
    @Description("Find dresses references")
    public void searchForDress() {
        SoftAssert soft = new SoftAssert();

        assertTrue(homepage.getSearchField().isDisplayed());

        homepage.setSearchField("Dress");
        homepage.getSearchBtn().click();

        assertEquals(searchPage.getSearchResultHeading().getText(), "\"DRESS\"");
        assertEquals(Integer.toString(searchPage.getProductsCount().size()),
                searchPage.getSearchResultCounter().getText().replaceAll("\\D+",""));

        for(int i=1; i <= searchPage.getProductsCount().size(); i++) {
            soft.assertTrue(searchPage.getProduct(i).getText().contains("Dress"),
                    "Element № "+ i + " doesn't contain necessary word");
        }
        soft.assertAll(); // TODO Create issue in bug tracking tool or define exit criteria
    }
}
