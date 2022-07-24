package helpers;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Slf4j
@UtilityClass
public class AllureHelper {
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] savePageScreenshot(WebDriver driver) {
        log.warn("Screenshot capturing..");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "'{message}' page screenshot", type = "image/png")
    public byte[] savePageScreenshot(WebDriver driver, String message) {
        log.warn("'{}' page screenshot capturing...", message);
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveElementScreenshot(WebElement element) {
        log.warn("Screenshot capturing..");
        return element.getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{message}", type = "image/png")
    public byte[] saveElementScreenshot(WebElement element, String message) {
        log.warn("{}. Screenshot capturing...", message);
        return element.getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public String saveTextLog(String message) {
        return message;
    }
}
