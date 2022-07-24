package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import web_driver.Driver;

import java.time.Duration;

public abstract class ElementContainer {
    protected WebDriverWait waitS = new WebDriverWait(Driver.get(), Duration.ofSeconds(1));
    protected WebDriverWait waitM = new WebDriverWait(Driver.get(), Duration.ofSeconds(3));
    protected WebDriverWait waitL = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
    protected WebDriverWait waitXL = new WebDriverWait(Driver.get(), Duration.ofSeconds(15));
    private WebDriver driver = Driver.get();

    public ElementContainer() {
        PageFactory.initElements(driver, this);
    }
}
