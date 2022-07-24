package steps;

import elements.components.settings.general.LaunchInactivityTimeoutList;
import elements.components.settings.general.LaunchInactivityTimeoutValues;
import elements.pages.settings.SettingsGeneralPage;
import helpers.AllureHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import web_driver.Driver;

public class SettingsGeneralSteps {
    private static SettingsGeneralPage settingsGeneralPage;

    public static boolean loaded() {
        settingsGeneralPage = PageFactory.initElements(Driver.get(), SettingsGeneralPage.class);
        return settingsGeneralPage.loaded();
    }

    @Step(value = "Get 'Launch Inactivity Timeout' current value")
    public static LaunchInactivityTimeoutValues getLaunchInactivityTimeout() {
        return settingsGeneralPage.getLaunchInactivityTimeoutCurrentValue();
    }

    @Step(value = "Change 'Launch Inactivity Timeout' value randomly")
    public static LaunchInactivityTimeoutValues changeLaunchInactivityTimeoutRandomly() {
        LaunchInactivityTimeoutValues currentValue, valueToSelect;
        LaunchInactivityTimeoutList litListComponent;

        loaded();

        currentValue = settingsGeneralPage.getLaunchInactivityTimeoutCurrentValue();
        AllureHelper.saveTextLog("Launch Inactivity Timeout. was before = %s".formatted(currentValue.getTitle()));

        valueToSelect = LaunchInactivityTimeoutValues.getAnyOtherThan(currentValue);
        AllureHelper.saveTextLog("Launch Inactivity Timeout. Is going to be = %s".formatted(valueToSelect.getTitle()));

        settingsGeneralPage.launchInactivityTimeoutDropDown.click();
        litListComponent = PageFactory.initElements(Driver.get(), LaunchInactivityTimeoutList.class);
        litListComponent.selectByTitle(valueToSelect.getTitle());
        settingsGeneralPage.submitBtn.click();
        return valueToSelect;
    }
}
