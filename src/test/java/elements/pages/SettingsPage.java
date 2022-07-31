package elements.pages;

import elements.WaitFor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class SettingsPage extends Page {

    @WaitFor
    @FindBy(xpath = "//span[.='Settings']")
    public WebElement title;
    @WaitFor
    @FindBy(css = "div[class*='navigationTabs__tabs']>a[href*='personal/settings/general']")
    public WebElement generalTab;
}
