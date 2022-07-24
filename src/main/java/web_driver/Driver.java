package web_driver;

import configuration.Config;
import org.openqa.selenium.WebDriver;

public class Driver {
    private static WebDriver webDriver;

    private Driver() {
    }

    public static WebDriver get() {
        if (webDriver == null) {
            webDriver = WebDriverFabric.createWebDriver(Config.DRIVER_NAME);
        }

        return webDriver;
    }

    public static void restartDriver() {
        webDriver.manage().deleteAllCookies();         // Clear Cookies on the browser
        webDriver.quit();
        webDriver = null;
        webDriver = WebDriverFabric.createWebDriver(Config.DRIVER_NAME);

    }
}




