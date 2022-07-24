package steps;

import elements.components.LeftBar;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import web_driver.Driver;

public class LeftBarSteps {
    private static LeftBar leftBar;

    private LeftBarSteps() {
    }

    public static boolean loaded() {
        leftBar = PageFactory.initElements(Driver.get(), LeftBar.class);
        return leftBar.loaded();
    }

    @Step(value = "Left Bar. Open Settings")
    public static void openSettings() {
        loaded();
        leftBar.settingsIcon.click();
    }

    @Step(value = "Left Bar. Open Dashboards")
    public static void openDashboards() {
        loaded();
        leftBar.dashboardIcon.click();
    }

    public static String getNotification() {
        loaded();
        return leftBar.getNotificationText();
    }
}
