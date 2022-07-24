package scenarios.ui;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import objects.users.AbstractUser;
import objects.users.DefaultSuperAdmin;
import objects.users.DefaultUser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.BaseSteps;
import steps.LeftBarSteps;
import steps.LoginSteps;

class LoginTest extends BaseUiTest {
    @DataProvider(name = "users")
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{new DefaultUser()},
                new Object[]{new DefaultSuperAdmin()},
        };
    }

    @BeforeMethod
    public void beforeEach() {
        BaseSteps.reset();
        BaseSteps.navigate();
    }

    @Test(description = "Logs in with different users", dataProvider = "users")
    @Issue("Test-2")
    @Severity(SeverityLevel.CRITICAL)
    void loginWithUserValidCredentials(AbstractUser user) {
        LoginSteps.login(user);
        Assert.assertTrue(LeftBarSteps.loaded());
    }
}
