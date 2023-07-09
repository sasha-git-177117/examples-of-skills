package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'cookies')]");
    private static final By BY_ACCEPT_COOKIES_BUTTON = By.xpath("//*[contains(@class,'button') and text()='Not really, no']");
    private static final IButton ACCEPT_COOKIES = AqualityServices.getElementFactory()
            .getButton(BY_ACCEPT_COOKIES_BUTTON,"yesButton");

    public CookiesForm() {
        super(CHECK_ELEMENT, "checkElementCookies");
    }

    public void clickAcceptCookiesButton() {
        ACCEPT_COOKIES.click();
    }
}
