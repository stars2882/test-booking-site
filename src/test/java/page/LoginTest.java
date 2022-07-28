package page;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends ConfigTest{
    private final static String MAIL = "ppp_my@ukr.net";
    private final static String FALSE_PASS = "101010";
    private final static String PASS = "101010AbcD";

    @Test(priority = 3)
    public void checkLoggingFalseAndTruePassword() {
        getHomePage().selectLanguageEnglishUK();
        getHomePage().clickButtonRegistration();
        getLoginPage().enterEmailField(MAIL);
        getLoginPage().enterPassToField(FALSE_PASS);
        getLoginPage().clickBtnSignIn();

        Assert.assertTrue(getLoginPage().checkBadPass());

        getLoginPage().enterPassToField(PASS);
        getLoginPage().clickBtnSignIn();

        Assert.assertTrue(getLoginPage().checkLogging());
    }
}
