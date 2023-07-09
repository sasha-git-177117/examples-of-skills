package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {
    private static final By BY_LINK_HERE = By.xpath("//*[contains(@class,'start__link') or text() = 'HERE']");
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'start__link') or text() = 'HERE']");
    private static final ILink LINK_HERE = AqualityServices.getElementFactory().getLink(BY_LINK_HERE,"linkHERE");

    public HomePage() {
        super(CHECK_ELEMENT, "checkElementHomePage");
    }

    public void clickLinkHERE() {
        LINK_HERE.click();
    }
}
