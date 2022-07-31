package scenarios.ui;

import elements.components.settings.general.LaunchInactivityTimeoutValue;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LeftBarSteps;
import steps.SettingsGeneralSteps;

class UserSettingsTest extends LoggedInWithUserBase {
    @Test(description = "A user changes settings")
    @Issue("Test-3")
    void userEditLaunchInactivityTimeout() {
        LaunchInactivityTimeoutValue newValue;
        LeftBarSteps leftBarSteps = new LeftBarSteps();
        SettingsGeneralSteps settingsGeneralSteps = new SettingsGeneralSteps();

        leftBarSteps.openSettings();
        newValue = settingsGeneralSteps.changeLaunchInactivityTimeoutRandomly();
        leftBarSteps.openDashboards();
        leftBarSteps.openSettings();
        Assert.assertEquals(settingsGeneralSteps.getLaunchInactivityTimeout(), newValue);
    }
}
