package elements.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

@Slf4j
public class NativeLoginPage extends Page {

    private final ExpectedCondition<Boolean> pageLoadedCondition = input ->
            this.loginInput.isEnabled()
                    && this.passwordInput.isEnabled()
                    && this.submitBtn.isEnabled();
    @FindBy(name = "login")
    public WebElement loginInput;
    @FindBy(name = "password")
    public WebElement passwordInput;
    @FindBy(css = "button[type=submit]")
    public WebElement submitBtn;

    @Override
    public boolean loaded() {
        log.debug("Waiting for Login page to load...");
        Boolean loaded = waitXL.until(pageLoadedCondition);
        log.info("Login page successfully loaded");
        return loaded;
    }
}
