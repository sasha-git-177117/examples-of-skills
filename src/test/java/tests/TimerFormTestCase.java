package tests;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import consts.TestEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimerFormTestCase extends BaseTest{
    @Test
    public void timerFormTestCase() {
        String startTimePath = TestEnum.TIMER_START_PATH_JSON.label;
        ISettingsFile elementSettings = new JsonSettingsFile(TestEnum.ELEMENT_SETTINGS_PATH.label);
        loginPage.getTimerForm().state().waitForDisplayed();
        Assert.assertEquals(loginPage.getTimerForm().getTimeFromTimer(),
                elementSettings.getValue(startTimePath).toString(),
                "Таймер начинает работу не с " + elementSettings.getValue(startTimePath));
    }
}
