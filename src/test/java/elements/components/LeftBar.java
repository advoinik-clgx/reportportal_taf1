package elements.components;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class LeftBar extends Component {

    @FindBy(css = "img[alt=avatar]")
    public WebElement avatarImg;
    private final ExpectedCondition<Boolean> pageLoadedCondition = input -> this.avatarImg.isEnabled();
    @FindBy(css = "a[href='#default_personal/settings']")
    public WebElement settingsIcon;

    @FindBy(css = "a[href='#default_personal/dashboard']")
    public WebElement dashboardIcon;

    @FindBy(css = "div[class*='notificationList__notification-list--']>div")
    public WebElement notification;

    @Override
    public boolean loaded() {
        log.info("Waiting for Left bar to load...");
        Boolean loaded = waitXL.until(pageLoadedCondition);
        log.info("Left bar successfully loaded");
        return loaded;
    }

    public String getNotificationText() {
        return waitM.until(ExpectedConditions.elementToBeClickable(notification)).getText();
    }

    public static class Notifications {
        public static final String SETTINGS_SUCCESSFULLY_SAVED = "Project settings were successfully updated";
    }
}
