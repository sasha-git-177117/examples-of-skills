package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.interfaces.IButton;
import com.mifmif.common.regex.Generex;
import consts.TestEnum;

import java.util.List;
import java.util.Random;

public class TestUtils {
    private static final ISettingsFile USER_INFO_SETTINGS = new JsonSettingsFile(TestEnum.USER_INFORMATION_PATH.label);
    private static final Integer COUNT_SYMBOLS_PASSWORD =
            Integer.parseInt(USER_INFO_SETTINGS.getValue(TestEnum.USER_PASSWORD_LENGTH_PATH_JSON.label).toString());
    private static final Integer COUNT_SYMBOLS_EMAIL =
            Integer.parseInt(USER_INFO_SETTINGS.getValue(TestEnum.USER_EMAIL_LENGTH_PATH_JSON.label).toString());
    private static final Integer COUNT_SYMBOLS_DOMAIN =
            Integer.parseInt(USER_INFO_SETTINGS.getValue(TestEnum.USER_DOMAIN_LENGTH_PATH_JSON.label).toString());
    private static final Integer FIRST_NUMERIC_SYMBOL_CODE = 48;
    private static final Integer LAST_NUMERIC_SYMBOL_CODE = 57;
    private static final Integer FIRST_LOWER_LETTER_SYMBOL_CODE = 97;
    private static final Integer LAST_LOWER_LETTER_SYMBOL_CODE = 122;
    private static final Integer LAST_UPPER_LETTER_SYMBOL_CODE = 90;
    private static final Integer FIRST_UPPER_LETTER_SYMBOL_CODE = 65;
    private static final Generex GENEREX = new Generex(USER_INFO_SETTINGS.getValue(TestEnum.USER_REGEX_PASSWORD_PATH_JSON.label).toString());

    public static String getGeneratorEmail() {
        Random random = new Random();

        return random.ints(FIRST_NUMERIC_SYMBOL_CODE, LAST_LOWER_LETTER_SYMBOL_CODE + 1)
                .limit(COUNT_SYMBOLS_EMAIL)
                .filter(num -> (num  <= LAST_NUMERIC_SYMBOL_CODE || num  >= FIRST_UPPER_LETTER_SYMBOL_CODE)
                        && (num  <= LAST_UPPER_LETTER_SYMBOL_CODE || num  >= FIRST_LOWER_LETTER_SYMBOL_CODE))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String getGeneratorPassword(String email) {
        Random random = new Random();
        return email.charAt(random.nextInt(email.length()))+GENEREX.random(COUNT_SYMBOLS_PASSWORD);
    }

    public static String getGeneratorDomain() {
        Random random = new Random();

        return random.ints(FIRST_LOWER_LETTER_SYMBOL_CODE, LAST_LOWER_LETTER_SYMBOL_CODE + 1)
                .limit(COUNT_SYMBOLS_DOMAIN)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static int getRandomListIndex(List<IButton> options) {
        Random random = new Random();
        return random.nextInt(options.size());
    }
}
