package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import consts.TestEnum;
import lombok.Getter;
import org.openqa.selenium.By;
import utils.PhotoUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class AvatarPage extends Form {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'avatar-and-interests-page')]");
    private static final By BY_INTERESTS_CHECKBOXES = By.xpath("//*[contains(@for,'interest')]");
    private static final By BY_UPLOAD_BUTTON = By.xpath("//*[contains(@class,'button') and text() = 'upload']");
    private static final By BY_NEXT_BUTTON = By.xpath("//*[contains(@class,'button') and text() = 'Next']");
    private static final IButton UPLOAD_BUTTON = AqualityServices
            .getElementFactory().getButton(BY_UPLOAD_BUTTON,"uploadButton");
    private static final IButton NEXT_BUTTON = AqualityServices
            .getElementFactory().getButton(BY_NEXT_BUTTON,"nextButton");
    private final List<ICheckBox> interestsCheckboxes = AqualityServices
            .getElementFactory().findElements(BY_INTERESTS_CHECKBOXES,ElementType.CHECKBOX);
    private static final String AVATAR_PATH = TestEnum.AVATAR_PATH.label;

    public AvatarPage() {
        super(CHECK_ELEMENT, "checkElementAvatarPage");
    }

    public void clickCheckBox(ICheckBox checkBox) {
        checkBox.click();
    }

    public void uploadAvatarImage() {
        UPLOAD_BUTTON.click();
        PhotoUtils.ImportPhotoToSite(AVATAR_PATH);
    }

    public void clickNextButton() {
        NEXT_BUTTON.click();
    }
}
