package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import consts.ConfigEnum;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.LoginPage;

abstract public class BaseTest {
    protected  LoginPage loginPage;
    @BeforeClass
    public void setupClass() {
        ISettingsFile environment = new JsonSettingsFile(ConfigEnum.FILE_PATH.label);
        String url = environment.getValue(ConfigEnum.BASE_URL.label).toString();
        Browser browser = AqualityServices.getBrowser();
        browser.maximize();
        AqualityServices.getBrowser().goTo(url);
        AqualityServices.getBrowser().waitForPageToLoad();
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(),"Не удалось открыть Домашнюю страницу");

        homePage.clickLinkHERE();
        loginPage = new LoginPage();
        Assert.assertTrue(loginPage.state().waitForDisplayed(), "Не удалось открыть карточку 1 (страницу авторизации)");
    }
    @AfterClass
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
