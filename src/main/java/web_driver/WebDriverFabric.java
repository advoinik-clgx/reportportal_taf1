package web_driver;

import configuration.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

@Slf4j
class WebDriverFabric {
    private WebDriverFabric() {
    }

    protected static WebDriver createWebDriver(@SuppressWarnings("SameParameterValue") String name) {
        log.debug("Initializing a WebDriver by name {}...", name);

        if (null == name) {
            return createChromeDriver();
        } else if (name.matches(("[Cc]hrome"))) {
            if (Config.RUN_ON_SELENOID) {
                return createChromeDriverOnSelenoid();
            }
            return createChromeDriver();
        } else if (name.matches("[Ff]irefox")) {
            if (Config.RUN_ON_SELENOID) {
                return createFirefoxDriverOnSelenoid();
            }
            return createFirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unable to get the %s driver type".formatted(name));
        }
    }

    private static WebDriver createChromeDriver() {
        return WebDriverManager.chromedriver().create();
    }

    private static RemoteWebDriver createChromeDriverOnSelenoid() {
        RemoteWebDriver driver;

        WebDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "104.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        try {
            driver = new RemoteWebDriver(
                    URI.create(Config.SELENOID_BASE_URL).toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return driver;
    }

    private static ChromeDriver createChromeDriverHeadless() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1100,1200");
        options.addArguments("--disable-extensions");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-gpu");
        options.addArguments("disable-infobars");
//        options.setHeadless(true);
        options.setAcceptInsecureCerts(true);
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver() {
        return WebDriverManager.firefoxdriver().create();
    }

    private static RemoteWebDriver createFirefoxDriverOnSelenoid() {
        RemoteWebDriver driver;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("browserVersion", "103.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        try {
            driver = new RemoteWebDriver(
                    URI.create(Config.SELENOID_BASE_URL).toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return driver;
    }

    private static FirefoxDriver createFirefoxDriverHeadless() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1100,1200");
        options.addArguments("--disable-extensions");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-gpu");
        options.addArguments("disable-infobars");
        options.setHeadless(true);
        options.setAcceptInsecureCerts(true);
        return new FirefoxDriver(options);
    }
}
