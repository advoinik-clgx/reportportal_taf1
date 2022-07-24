package steps;

import elements.pages.NativeLoginPage;
import helpers.AllureHelper;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.users.AbstractUser;
import org.openqa.selenium.support.PageFactory;
import web_driver.Driver;

@Slf4j
public class LoginSteps {
    private static NativeLoginPage loginPage;

    private LoginSteps() {
    }

    @Step("Login with {user.login} user")
    public static void login(AbstractUser user) {
        loaded();
        log.info("Logging in with {} user", user.getLogin());
        AllureHelper.saveTextLog("Logging in with %s user".formatted(user.getLogin()));
        loginPage.loginInput.sendKeys(user.getLogin());
        loginPage.passwordInput.sendKeys(user.getPassword());
        loginPage.submitBtn.click();
    }

    public static boolean loaded() {
        loginPage = PageFactory.initElements(Driver.get(), NativeLoginPage.class);
        return loginPage.loaded();
    }
}
