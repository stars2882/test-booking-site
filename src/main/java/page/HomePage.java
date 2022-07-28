package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final static String BUTTON_SELECT_LANGUAGE = "//img[@class='bui-avatar__image']";
    private final static String BUTTON_ENGLISH_UK = "//div[@class='bui-group bui-group--small']//a[@data-lang='en-gb']";
    private final static String FIELD_SEARCH = "//input[@type='search']";
    private final static String FIELD_CHECK_IN = "//div[@data-mode='checkin']";
    private final static String CALENDAR = "//div[@class='bui-calendar']";
    private final static String BUTTON_CALENDAR_NEXT = "//div[@data-bui-ref='calendar-next']";
    private final static String BUTTON_SEARCH = "//button[@data-sb-id='main']";
    private final static String BUTTON_LOGIN ="//a[contains(@data-et-click,'We:4')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectLanguageEnglishUK() {
        driver.findElement(By.xpath(BUTTON_SELECT_LANGUAGE)).click();
        driver.findElement(By.xpath(BUTTON_ENGLISH_UK)).click();
    }

    public void enterSearchCity(final String keyword) {
        driver.findElement(By.xpath(FIELD_SEARCH)).sendKeys(keyword);
    }

    public void clickToFieldCheckIn(){
        driver.findElement(By.xpath(FIELD_CHECK_IN)).click();
    }

    public void clickNextMonth(String month){
        while (!driver.findElement(By.xpath(CALENDAR)).getText().contains(month)) {
            driver.findElement(By.xpath(BUTTON_CALENDAR_NEXT)).click();
        }
    }

    public void bookingDateSelectionIn(String day, String month, String year) {
        driver.findElement(By.xpath("//td[contains(@data-date,'"+year+"-"+month+"-"+day+"')]")).click();
    }

    public void bookingDateSelectionOut(String day, String month, String year) {
        driver.findElement(By.xpath("//td[contains(@data-date,'"+year+"-"+month+"-"+day+"')]")).click();
    }

    public void clickButtonSearch() {
        driver.findElement(By.xpath(BUTTON_SEARCH)).click();
    }

    public void clickButtonRegistration(){
        driver.findElement(By.xpath(BUTTON_LOGIN)).click();
    }
}
