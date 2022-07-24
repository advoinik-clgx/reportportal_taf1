package scenarios.ui;

import elements.components.settings.general.LaunchInactivityTimeoutValues;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LeftBarSteps;
import steps.SettingsGeneralSteps;

class UserSettingsTest extends LoggedInWithUserBaseTest {
    @Test(description = "A user changes settings")
    @Issue("Test-3")
    void userEditLaunchInactivityTimeout() {
        LaunchInactivityTimeoutValues newValue;

        LeftBarSteps.openSettings();
        newValue = SettingsGeneralSteps.changeLaunchInactivityTimeoutRandomly();
        LeftBarSteps.openDashboards();
        LeftBarSteps.openSettings();
        Assert.assertEquals(SettingsGeneralSteps.getLaunchInactivityTimeout(), newValue);
    }
}
