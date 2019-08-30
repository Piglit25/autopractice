package automationpractice.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchResultHeading() {
        return Utils.waitForElementPresence(driver, By.xpath("//h1/span[@class=\"lighter\"]"), 15);
    }

    public WebElement getSearchResultCounter() {
        return Utils.waitForElementPresence(driver, By.xpath("//h1/span[@class=\"heading-counter\"]"), 15);
    }

    public WebElement getProduct(int productNum) {
        return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + productNum + "]"), 15);
    }

    public List<WebElement> getProductsCount() {
        return driver.findElements(By.xpath("//ul[@class=\"product_list grid row\"]/li"));
    }
}
