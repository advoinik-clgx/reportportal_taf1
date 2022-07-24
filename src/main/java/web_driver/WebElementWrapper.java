package web_driver;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

@Getter
public class WebElementWrapper extends RemoteWebElement {
    private WebElement webElement;
    private Actions actions;

    public WebElementWrapper(WebElement webElement) {
        this.webElement = webElement;
        this.actions = new Actions(Driver.get());
    }

    public boolean isClickable() {
        return webElement != null && webElement.isEnabled();
    }

    public void mouseHover() {
        actions.moveToElement(webElement)
                .build()
                .perform();
    }
}
