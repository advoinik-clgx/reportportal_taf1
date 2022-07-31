package elements.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web_driver.Driver;

public class NotificationsArea extends Component {
    @FindBy(css = "div[class*='notificationList__notification-list--']>div")
    public WebElement notification;

    public String getNotificationText() {
        return Driver.getWaitM().until(ExpectedConditions.elementToBeClickable(notification)).getText();
    }

    public boolean updatesSavedSuccessfully() {
        ExpectedCondition<Boolean> settingsUpdatedNotification = input ->
                this.notification.isDisplayed()
                        && this.notification.getText().contains(NotificationTitles.SETTINGS_SUCCESSFULLY_SAVED);
        return Driver.getWaitM().until(settingsUpdatedNotification);
    }

    public static class NotificationTitles {
        public static final String SETTINGS_SUCCESSFULLY_SAVED = "Project settings were successfully updated";
    }
}
