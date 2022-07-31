package steps;

import elements.components.LeftBar;
import io.qameta.allure.Step;

public class LeftBarSteps {
    private final LeftBar leftBar;

    public LeftBarSteps() {
        leftBar = new LeftBar();
    }

    @Step(value = "Left Bar. Open Settings")
    public void openSettings() {
        leftBar.settingsIcon.click();
    }

    @Step(value = "Left Bar. Open Dashboards")
    public void openDashboards() {
        leftBar.dashboardIcon.click();
    }

    public boolean loaded() {
        return leftBar.loaded();
    }
}
