package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class LoginPage extends BasePage {
    private final static String FIELD_EMAIL = "//input[@type='email']";
    private final static String FIELD_PASS = "//input[@id='password']";
    private final static String BUTTON_SIGNIN =  "//button[@type='submit']";
    private final static String CHECK_BAD_PASS = "//div[@id='password-note']";
    private final static String CHECK_LOGGING ="//span[@id='profile-menu-trigger--title']";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailField(String keyword) {
        driver.findElement(By.xpath(FIELD_EMAIL)).sendKeys(keyword, Keys.ENTER);
    }

    public void clickBtnSignIn(){
        implicitWait(10);
        driver.findElement(By.xpath(BUTTON_SIGNIN)).click();
    }

    public void enterPassToField(String keyword) {
        implicitWait(10);
        driver.findElement(By.xpath(FIELD_PASS)).sendKeys(Keys.SHIFT , Keys.HOME , Keys.DELETE);
        driver.findElement(By.xpath(FIELD_PASS)).sendKeys(keyword);
    }

    public boolean checkBadPass(){
        implicitWait(10);
        return driver.findElement(By.xpath(CHECK_BAD_PASS)).isDisplayed();
    }

    public boolean checkLogging(){
        return driver.findElement(By.xpath(CHECK_LOGGING)).isDisplayed();
    }

}
