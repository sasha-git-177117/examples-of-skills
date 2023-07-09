package steps;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import consts.TestEnum;
import pages.LoginPage;
import utils.TestUtils;

import java.util.List;

public class LoginPageSteps {
    private static final LoginPage LOGIN_PAGE = new LoginPage();
    private static final String COMBOBOX_OPTION_OTHER_PATH = TestEnum.COMBOBOX_OPTION_OTHER_PATH_JSON.label;
    private static final ISettingsFile ELEMENT_SETTINGS = new JsonSettingsFile(TestEnum.ELEMENT_SETTINGS_PATH.label);
    private static List<IButton> COMBO_BOX_OPTIONS = LOGIN_PAGE.getComboBoxOptions();

    public static void clickRandomOptions() {
        openComboBox();
        for (IButton option: COMBO_BOX_OPTIONS) {
            if (option.getText().equals(ELEMENT_SETTINGS.getValue(COMBOBOX_OPTION_OTHER_PATH))) {
                COMBO_BOX_OPTIONS.remove(option);
                break;
            }
        }
        LOGIN_PAGE.clickOption(COMBO_BOX_OPTIONS.get(TestUtils.getRandomListIndex(COMBO_BOX_OPTIONS)));
    }

    public static void openComboBox() {
        if (COMBO_BOX_OPTIONS.isEmpty()) {
            LOGIN_PAGE.clickComboBox(LOGIN_PAGE.getComboBoxDomains());
            COMBO_BOX_OPTIONS = AqualityServices.getElementFactory().findChildElements(
                    LOGIN_PAGE.getComboBoxDomains(),
                    LOGIN_PAGE.getByComboBoxOptionsFromComboBox(),
                    ElementType.BUTTON
            );
        }
    }

}
