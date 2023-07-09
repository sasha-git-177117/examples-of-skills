package steps;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.interfaces.ICheckBox;
import consts.TestEnum;
import pages.AvatarPage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AvatarPageSteps {
    private static final AvatarPage AVATAR_PAGE = new AvatarPage();
    private static final ISettingsFile ELEMENT_SETTINGS = new JsonSettingsFile(TestEnum.ELEMENT_SETTINGS_PATH.label);
    private static final String UNSELECT_ALL_ELEMENT_PATH = TestEnum.UNSELECT_ALL_ELEMENT_PATH_JSON.label;
    private static final String SELECT_ALL_ELEMENT_PATH = TestEnum.SELECT_ALL_ELEMENT_PATH_JSON.label;

    public static void selectRandomInterestsCheckboxes(int count) {
        unCheckedAllInterestsCheckboxes();
        AVATAR_PAGE.getInterestsCheckboxes().removeIf(checkBox -> checkBox.getAttribute("for")
                .contains(ELEMENT_SETTINGS.getValue(UNSELECT_ALL_ELEMENT_PATH).toString())
                || checkBox.getAttribute("for").contains(ELEMENT_SETTINGS.getValue(SELECT_ALL_ELEMENT_PATH).toString()));
        int lastCheckbox = AVATAR_PAGE.getInterestsCheckboxes().size();
        List<Integer> indexes = ThreadLocalRandom.current().ints(0, lastCheckbox).distinct()
                .limit(count).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        for (Integer index : indexes) {
            AVATAR_PAGE.clickCheckBox(AVATAR_PAGE.getInterestsCheckboxes().get(index));
        }
    }
    public static void unCheckedAllInterestsCheckboxes() {
        for (ICheckBox checkBox: AVATAR_PAGE.getInterestsCheckboxes()) {
            if(checkBox.getAttribute("for").contains(ELEMENT_SETTINGS.getValue(UNSELECT_ALL_ELEMENT_PATH).toString())
                    && checkBox.getCssValue("visibility").equals("visible")) {
                AVATAR_PAGE.clickCheckBox(checkBox);
                break;
            }
        }
    }

}
