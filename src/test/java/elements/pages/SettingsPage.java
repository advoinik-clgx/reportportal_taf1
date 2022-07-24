package elements.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

@Slf4j
public class SettingsPage extends Page {

    private final ExpectedCondition<Boolean> pageLoadedCondition = input ->
            this.title.isEnabled() && this.generalTab.isEnabled();
    @FindBy(xpath = "//span[.='Settings']")
    public WebElement title;
    @FindBy(css = "div[class*='navigationTabs__tabs']>a[href='#default_personal/settings/general']")
    public WebElement generalTab;

    @Override
    public boolean loaded() {
        log.debug("Waiting for Settings page to load...");
        Boolean loaded = waitXL.until(pageLoadedCondition);
        log.info("Settings page successfully loaded");
        return loaded;
    }
}
