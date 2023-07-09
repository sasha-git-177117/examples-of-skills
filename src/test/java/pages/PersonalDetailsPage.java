package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsPage extends Form {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'personal-details__content')]");

    public PersonalDetailsPage() {
        super(CHECK_ELEMENT, "checkElementPersonalDetailsPage");
    }
}
