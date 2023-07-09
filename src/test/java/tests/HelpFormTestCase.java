package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HelpFormTestCase extends BaseTest{
    @Test
    public void helpFormTestCas() {
        loginPage.getHelpForm().clickSendToBottom();
        Assert.assertTrue(loginPage.getHelpForm().state().waitForNotDisplayed(), "Не удалось закрыть форму помощи");
    }
}
