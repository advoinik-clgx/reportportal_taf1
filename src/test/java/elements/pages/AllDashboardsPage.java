package elements.pages;

import elements.WaitFor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class AllDashboardsPage extends Page {
    @WaitFor
    @FindBy(xpath = "//span[.='Add New Dashboard']")
    public WebElement addNewDashboard;
}
