package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class ConfigTest {
    private WebDriver driver;
    private static final String URL = "https://www.booking.com/";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();

    }

    @BeforeMethod
    public void testsSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchPage getSearchPage() {
        return new SearchPage(getDriver());
    }

    public LoginPage getLoginPage(){
        return new LoginPage(getDriver());
    }
}
