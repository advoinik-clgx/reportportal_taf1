package elements.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

@Slf4j
public class AllDashboardsPage extends Page {
    private final ExpectedCondition<Boolean> pageLoadedCondition = input ->
            this.addNewDashboard.isEnabled();
    @FindBy(xpath = "//span[.='Add New Dashboard']")
    public WebElement addNewDashboard;

    @Override
    public boolean loaded() {
        log.debug("Waiting for All Dashboards page to load...");
        Boolean loaded = waitL.until(pageLoadedCondition);
        log.info("All Dashboards page successfully loaded");
        return loaded;
    }
}
