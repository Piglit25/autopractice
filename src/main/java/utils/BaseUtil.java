package utils;

import automationpractice.com.pageObject.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Listeners({utils.Listener.class})
public abstract class BaseUtil {

    protected WebDriver driver;
    protected String email;
    protected Homepage homepage;
    protected CreateAccount createAccount;
    protected CreateAccountForm createAccountForm;
    protected SignInForm signInForm;
    protected Account account;
    protected Actions action;
    protected Clothes clothes;
    protected Cart cart;
    protected ShoppingActions shoppingActions;
    protected CartSummary summary;
    protected File fileDownloadPath;
    protected SearchPage searchPage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setup() throws IOException {

        String home = System.getProperty("user.dir");

        if (System.getProperty("os.name").startsWith("Windows")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        }

        fileDownloadPath = new File(home + File.separator +
                "src" + File.separator +
                "test" + File.separator +
                "java" + File.separator +
                "resources");

        if (! fileDownloadPath.exists()) {
            fileDownloadPath.mkdir();
        } else {
            FileUtils.cleanDirectory(fileDownloadPath);
        }

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory",
                fileDownloadPath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        homepage = new Homepage(driver);
        createAccount = new CreateAccount(driver);
        createAccountForm = new CreateAccountForm(driver);
        signInForm = new SignInForm(driver);
        searchPage = new SearchPage(driver);
        account = new Account(driver);
        email = DataGenerator.getEmail();
        action = new Actions(driver);
        clothes = new Clothes(driver);
        cart = new Cart(driver);
        shoppingActions = new ShoppingActions(driver);
        summary = new CartSummary(driver);
        account = new Account(driver);

        /* You can use URL below or change it to System.getProperty("environment")
         to run tests from command line (mvn -Denvironment=necessaryValue test)
         */
        String baseUrl = "http://automationpractice.com/index.php";

        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void closeAll() throws IOException {
        FileUtils.cleanDirectory(fileDownloadPath);
        driver.quit();
    }

}
