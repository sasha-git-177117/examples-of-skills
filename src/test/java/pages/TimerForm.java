package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TimerForm extends Form {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'timer')]");
    private static final By BY_TIMER = By.xpath("//*[contains(@class,'timer')]");
    private static final ILabel TIMER = AqualityServices.getElementFactory().getLabel(BY_TIMER,"timer");

    public TimerForm() {
        super(CHECK_ELEMENT, "checkTimer");
    }

    public String getTimeFromTimer() {
        return TIMER.getText();
    }

}
