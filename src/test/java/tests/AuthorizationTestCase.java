package tests;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import consts.TestEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AvatarPage;
import pages.PersonalDetailsPage;
import pages.enums.AuthorizationDataEnams;
import steps.AvatarPageSteps;
import steps.LoginPageSteps;
import utils.TestUtils;

public class AuthorizationTestCase extends BaseTest {
    @Test
    public void authorizationTestCase() {
        ISettingsFile userInfoSettings = new JsonSettingsFile(TestEnum.USER_INFORMATION_PATH.label);
        String email = TestUtils.getGeneratorEmail();
        String password = TestUtils.getGeneratorPassword(email);
        String domain = TestUtils.getGeneratorDomain();
        String countUserInterests = TestEnum.USER_COUNT_INTERESTS_PATH_JSON.label;

        LoginPageSteps.clickRandomOptions();
        loginPage.enterData(AuthorizationDataEnams.PASSWORD,password);
        loginPage.enterData(AuthorizationDataEnams.EMAIL,email);
        loginPage.enterData(AuthorizationDataEnams.DOMAIN,domain);
        loginPage.acceptConditions();
        loginPage.clickButtonNext();
        AvatarPage avatarPage = new AvatarPage();
        Assert.assertTrue(avatarPage.state().waitForDisplayed(),"Не удалось открыть карточку 2 (страницу профиля)");

        AvatarPageSteps.selectRandomInterestsCheckboxes(Integer.parseInt(userInfoSettings
                .getValue(countUserInterests).toString()));
        avatarPage.uploadAvatarImage();
        avatarPage.clickNextButton();
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        Assert.assertTrue(personalDetailsPage.state().waitForDisplayed(),
                "Не удалось открыть карточку 3 (страницу персональных данных)");
    }
}
