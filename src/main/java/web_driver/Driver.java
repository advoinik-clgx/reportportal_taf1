package web_driver;

import configuration.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {
    public static final Duration WAIT_S_TIMEOUT = Duration.ofMillis(500);
    public static final Duration WAIT_M_TIMEOUT = Duration.ofSeconds(5);
    public static final Duration WAIT_L_TIMEOUT = Duration.ofSeconds(10);
    public static final Duration WAIT_XL_TIMEOUT = Duration.ofSeconds(60);
    private static final ThreadLocal<WebDriverWait> waitS = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> waitM = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> waitL = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> waitXL = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private Driver() {
    }

    public static WebDriver get() {
        return webDriver.get();
    }

    public static WebDriverWait getWaitS() {
        return waitS.get();
    }

    public static WebDriverWait getWaitM() {
        return waitM.get();
    }

    public static WebDriverWait getWaitL() {
        return waitL.get();
    }

    public static WebDriverWait getWaitXL() {
        return waitXL.get();
    }

    public static void createWebDriver() {
        WebDriver driver = WebDriverFabric.createWebDriver(Config.DRIVER_NAME);
        webDriver.set(driver);
        waitS.set(new WebDriverWait(driver, WAIT_S_TIMEOUT));
        waitM.set(new WebDriverWait(driver, WAIT_M_TIMEOUT));
        waitL.set(new WebDriverWait(driver, WAIT_L_TIMEOUT));
        waitXL.set(new WebDriverWait(driver, WAIT_XL_TIMEOUT));
    }

    public static void shutDownDriver() {
        webDriver.get().quit();
        webDriver.remove();
        waitS.remove();
        waitM.remove();
        waitL.remove();
        waitXL.remove();
    }
}




