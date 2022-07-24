package scenarios.ui;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterSuite;
import scenarios.BaseTest;
import web_driver.Driver;

@Slf4j
class BaseUiTest extends BaseTest {
    @AfterSuite
    public static void afterAll() {
        Driver.get().quit();
    }
}
