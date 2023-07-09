package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import lombok.Getter;
import org.openqa.selenium.By;
import pages.enums.AuthorizationDataEnams;

import java.util.List;

@Getter
public class LoginPage extends Form {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'login-form')]//form");
    private static final By BY_COMBO_BOX = By.xpath("//*[contains(@class,'dropdown')]");
    private final By byComboBoxOptionsFromComboBox = By.xpath("//*[contains(@class,'dropdown__list-item')]");
    private static final By BY_CHECK_BOX_ACCEPT = By.xpath("//*[contains(@class,'checkbox__box')]//*[contains(@class,'icon')]");
    private static final By BY_BUTTON_NEXT = By.xpath("//*[contains(@class,'button--secondary') and text() = 'Next']");
    private static final IButton BUTTON_NEXT = AqualityServices.getElementFactory().getButton(BY_BUTTON_NEXT,"buttonNext");
    private static final ICheckBox CHECK_BOX_ACCEPT = AqualityServices.getElementFactory()
            .getCheckBox(BY_CHECK_BOX_ACCEPT,"acceptCheckbox");
    private final IComboBox comboBoxDomains = AqualityServices.getElementFactory()
            .getComboBox(BY_COMBO_BOX,"comboBox");
    private final List<IButton> comboBoxOptions = AqualityServices.getElementFactory().findChildElements(
            comboBoxDomains,
            byComboBoxOptionsFromComboBox,
            ElementType.BUTTON);
    private final HelpForm helpForm = new HelpForm();
    private final CookiesForm cookiesForm = new CookiesForm();
    private final TimerForm timerForm = new TimerForm();
    private final String INPUT = "//*[@placeholder='%s']";

    public LoginPage() {
        super(CHECK_ELEMENT, "checkElementLoginPage");
    }

    public void clickComboBox(IComboBox comboBox) {
        comboBox.click();
    }

    public void clickOption(IButton option) {
        option.click();
    }

    public void enterData(AuthorizationDataEnams element, String text) {
        ITextBox userData = AqualityServices.getElementFactory()
                .getTextBox(By.xpath(String.format(INPUT, element.label)),"input"+element);
        userData.clearAndType(text);
    }

    public void acceptConditions() {
        if(CHECK_BOX_ACCEPT.getCssValue("visibility").equals("visible")) {
            CHECK_BOX_ACCEPT.click();
        }
    }

    public void clickButtonNext() {
        BUTTON_NEXT.click();
    }

}
