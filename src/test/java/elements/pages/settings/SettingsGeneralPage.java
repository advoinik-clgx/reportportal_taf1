package elements.pages.settings;

import elements.components.settings.general.LaunchInactivityTimeoutValues;
import elements.pages.Page;
import helpers.AllureHelper;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

@Slf4j
public class SettingsGeneralPage extends Page {
    private final ExpectedCondition<Boolean> pageLoadedCondition = input ->
            this.submitBtn.isEnabled();
    @FindBy(css = "button[type='submit']")
    public WebElement submitBtn;
    @FindBy(xpath = "(//span[contains(@class,'inputDropdown__value')])[2]")
    public WebElement launchInactivityTimeoutDropDown;

    @Override
    public boolean loaded() {
        log.debug("Waiting for General tab in Settings page to load...");
        Boolean loaded = waitXL.until(pageLoadedCondition);
        log.info(" General tab in Settings page successfully loaded");
        return loaded;
    }

    public LaunchInactivityTimeoutValues getLaunchInactivityTimeoutCurrentValue() {
        AllureHelper.saveElementScreenshot(launchInactivityTimeoutDropDown, "Launch Inactivity Timeout state");
        String title = launchInactivityTimeoutDropDown.getText();
        log.info("Launch Inactivity Timeout state is {}", title);
        return LaunchInactivityTimeoutValues.getByTitle(title);
    }
}
