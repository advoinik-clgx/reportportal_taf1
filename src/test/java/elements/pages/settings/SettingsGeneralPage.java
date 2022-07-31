package elements.pages.settings;

import elements.WaitFor;
import elements.components.settings.general.LaunchInactivityTimeoutValue;
import elements.pages.Page;
import helpers.AllureHelper;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class SettingsGeneralPage extends Page {
    @WaitFor
    @FindBy(css = "button[type='submit']")
    public WebElement submitBtn;
    @FindBy(xpath = "(//span[contains(@class,'inputDropdown__value')])[2]")
    public WebElement launchInactivityTimeoutDropDown;

    public LaunchInactivityTimeoutValue getLaunchInactivityTimeoutCurrentValue() {
        AllureHelper.saveElementScreenshot(launchInactivityTimeoutDropDown, "Launch Inactivity Timeout state");
        String title = launchInactivityTimeoutDropDown.getText();
        log.info("Launch Inactivity Timeout state is {}", title);
        return LaunchInactivityTimeoutValue.getByTitle(title);
    }
}
