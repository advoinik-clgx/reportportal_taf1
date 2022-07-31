package elements.pages;

import elements.WaitFor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class NativeLoginPage extends Page {

    @WaitFor
    @FindBy(name = "login")
    public WebElement loginInput;
    @WaitFor
    @FindBy(name = "password")
    public WebElement passwordInput;
    @WaitFor
    @FindBy(css = "button[type=submit]")
    public WebElement submitBtn;
}
