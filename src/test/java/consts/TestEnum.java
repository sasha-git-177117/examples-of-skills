package consts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TestEnum {
    AVATAR_PATH("src/test/resources/Avatar.jpg"),
    ELEMENT_SETTINGS_PATH("elementsSettings.json"),
    UNSELECT_ALL_ELEMENT_PATH_JSON("/checkBox/avatarPage/label/unselectAll"),
    SELECT_ALL_ELEMENT_PATH_JSON("/checkBox/avatarPage/label/selectAll"),
    COMBOBOX_OPTION_OTHER_PATH_JSON("/button/loginPage/textOnButton/other"),
    USER_INFORMATION_PATH("userInformationSettings.json"),
    USER_COUNT_INTERESTS_PATH_JSON("/user/countInterests"),
    TIMER_START_PATH_JSON("/timer/startTime"),
    USER_PASSWORD_LENGTH_PATH_JSON("/login/lengthPassword"),
    USER_EMAIL_LENGTH_PATH_JSON("/login/lengthEmail"),
    USER_DOMAIN_LENGTH_PATH_JSON("/login/lengthDomain"),
    USER_REGEX_PASSWORD_PATH_JSON("/login/regexPassword");

    public final String label;
}
