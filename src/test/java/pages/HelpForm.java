package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'help-form__title')]");
    private static final By BY_SEND_TO_BOTTOM_BUTTON = By.xpath("//button[contains(@class,'help-form__send')]");
    private static final IButton SEND_TO_BOTTOM_BUTTON = AqualityServices
            .getElementFactory().getButton(BY_SEND_TO_BOTTOM_BUTTON,"sendToBottomButton");

    public HelpForm() {
        super(CHECK_ELEMENT,"checkElementHelpForm");
    }

    public void clickSendToBottom() {
        SEND_TO_BOTTOM_BUTTON.click();
    }
}
