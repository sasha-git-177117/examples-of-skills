package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiesFormTestCase extends BaseTest{
    @Test
    public void cookiesFormTestCase() {
        loginPage.getCookiesForm().state().waitForDisplayed();
        loginPage.getCookiesForm().clickAcceptCookiesButton();
        Assert.assertTrue(loginPage.getCookiesForm().state().waitForNotDisplayed(), "Не удалось закрыть форму cookies");
    }
}
