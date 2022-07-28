package page;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchCityAndPeriodTest extends ConfigTest {
    private final static String CITY = "New York";
    private final static String DATE_CHECK_IN = "01";
    private final static String DATE_CHECK_OUT = "30";
    private final static String MONTH_CHECK_IN_OUT_CHAR = "December";
    private final static String MONTH_CHECK_IN_OUT_INT = "12";
    private final static String YEAR_CHECK_OUT = "2022";

    @Test(priority = 1)
    public void checkingHotelSearchByCityAndDateInOut() {
        getHomePage().selectLanguageEnglishUK();
        getHomePage().enterSearchCity(CITY);
        getHomePage().clickToFieldCheckIn();
        getHomePage().clickNextMonth(MONTH_CHECK_IN_OUT_CHAR);
        getHomePage().bookingDateSelectionIn(DATE_CHECK_IN, MONTH_CHECK_IN_OUT_INT, YEAR_CHECK_OUT);
        getHomePage().bookingDateSelectionOut(DATE_CHECK_OUT, MONTH_CHECK_IN_OUT_INT, YEAR_CHECK_OUT);
        getHomePage().clickButtonSearch();

        getSearchPage().checkListSearchCity(CITY);
        getSearchPage().checkListDateCheckInOut(DATE_CHECK_IN, MONTH_CHECK_IN_OUT_INT, YEAR_CHECK_OUT);
        getSearchPage().checkListDateCheckInOut(DATE_CHECK_OUT, MONTH_CHECK_IN_OUT_INT, YEAR_CHECK_OUT);
    }

    @Test(priority = 2)
    public void checkingHotelSearchByCityAndDateInOutShowOnDisplay() {
        getHomePage().selectLanguageEnglishUK();
        getHomePage().enterSearchCity(CITY);
        getHomePage().clickToFieldCheckIn();
        getHomePage().clickNextMonth(MONTH_CHECK_IN_OUT_CHAR);
        getHomePage().bookingDateSelectionIn(DATE_CHECK_IN, MONTH_CHECK_IN_OUT_INT, YEAR_CHECK_OUT);
        getHomePage().bookingDateSelectionOut(DATE_CHECK_OUT, MONTH_CHECK_IN_OUT_INT, YEAR_CHECK_OUT);
        getHomePage().clickButtonSearch();

        assertTrue(getSearchPage().checkCityDestination(CITY));
        assertTrue(getSearchPage().checkCheckInOutDate(DATE_CHECK_IN, MONTH_CHECK_IN_OUT_CHAR, YEAR_CHECK_OUT));
        assertTrue(getSearchPage().checkCheckInOutDate(DATE_CHECK_OUT, MONTH_CHECK_IN_OUT_CHAR, YEAR_CHECK_OUT));

    }
}
