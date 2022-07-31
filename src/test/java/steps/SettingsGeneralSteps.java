package steps;

import elements.components.NotificationsArea;
import elements.components.settings.general.LaunchInactivityTimeoutList;
import elements.components.settings.general.LaunchInactivityTimeoutValue;
import elements.pages.settings.SettingsGeneralPage;
import helpers.AllureHelper;
import io.qameta.allure.Step;

public class SettingsGeneralSteps {
    private final SettingsGeneralPage settingsGeneralPage;

    public SettingsGeneralSteps() {
        settingsGeneralPage = new SettingsGeneralPage();
    }

    @Step(value = "Get 'Launch Inactivity Timeout' current value")
    public LaunchInactivityTimeoutValue getLaunchInactivityTimeout() {
        LaunchInactivityTimeoutValue currentValue =
                settingsGeneralPage.getLaunchInactivityTimeoutCurrentValue();
        AllureHelper.saveTextLog("Launch Inactivity Timeout state is '%s'".formatted(currentValue.getTitle()));
        return currentValue;
    }

    @Step(value = "Change 'Launch Inactivity Timeout' value randomly")
    public LaunchInactivityTimeoutValue changeLaunchInactivityTimeoutRandomly() {
        LaunchInactivityTimeoutValue currentValue, valueToSelect;

        currentValue = settingsGeneralPage.getLaunchInactivityTimeoutCurrentValue();
        AllureHelper.saveTextLog("Launch Inactivity Timeout. was before = %s".formatted(currentValue.getTitle()));

        valueToSelect = LaunchInactivityTimeoutValue.getAnyOtherThan(currentValue);
        AllureHelper.saveTextLog("Launch Inactivity Timeout. Is going to be = %s".formatted(valueToSelect.getTitle()));

        selectLaunchInactivityTimeout(valueToSelect);
        return valueToSelect;
    }

    private void selectLaunchInactivityTimeout(LaunchInactivityTimeoutValue valueToSelect) {
        LaunchInactivityTimeoutList litListComponent;
        settingsGeneralPage.launchInactivityTimeoutDropDown.click();
        litListComponent = new LaunchInactivityTimeoutList();
        litListComponent.selectByTitle(valueToSelect.getTitle());
        settingsGeneralPage.submitBtn.click();
        new NotificationsArea().updatesSavedSuccessfully();
    }
}
