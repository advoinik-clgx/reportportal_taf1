package scenarios.ui;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import scenarios.Base;
import web_driver.Driver;

@Slf4j
public class BaseUi extends Base {
    @BeforeMethod
    public void setUpDriver() {
        Driver.createWebDriver();
    }

    @AfterMethod
    public void shutDownDriver() {
        Driver.shutDownDriver();
    }
}
