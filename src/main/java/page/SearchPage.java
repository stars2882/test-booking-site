package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void checkListSearchCity(String city) {
        waitForPageLoadComplete(10);
        List<WebElement> searchCity = driver.findElements(By.xpath("//div[@data-testid='property-card']//span[contains(text(),'" + city + "')]"));
        for (int i = 0; i < searchCity.size(); i++) {
            Assert.assertTrue(searchCity.get(i).getText().contains(city));
        }
    }

    public void checkListDateCheckInOut(String day, String month, String year) {
        waitForPageLoadComplete(10);
        String searchDate = year + "-" + month + "-" + day;
        List<WebElement> listHotels = driver
                .findElements(By.xpath("//div[@data-testid='property-card']//a[@target='_blank']"));
        for (int i = 0; i < listHotels.size(); i++) {
            Assert.assertTrue(listHotels.get(1).getAttribute("href").contains(searchDate));
        }
    }

    public boolean checkCityDestination(String keyword) {
        waitForPageLoadComplete(10);
        return driver
                .findElement(By
                        .xpath("//input[@placeholder='Where are you going?' and @value='" + keyword + "']"))
                .isDisplayed();
    }

    public boolean checkCheckInOutDate(String day, String month, String year) {
        String currentDay=null;
        if (day.contains("0")) {
           currentDay= day.substring(1);
        }
        return driver
                .findElement(By
                        .xpath("//button[contains(text(),'" + currentDay + " " + month + " " + year + "')]"))
                .isDisplayed();
    }
}
