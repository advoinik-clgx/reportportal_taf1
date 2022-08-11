package scenarios.ui;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.BaseSteps;
import steps.LoginSteps;

class DefaultLoadingTest extends BaseUi {
    LoginSteps loginSteps;

    @BeforeMethod
    public void beforeEach() {
        loginSteps = new LoginSteps();
    }

    @Test
    @Issue("Test-1")
    @Severity(SeverityLevel.CRITICAL)
    void rpLoadsWithLoginPageByDefaultTest() {
        BaseSteps.navigate();
        Assert.assertTrue(loginSteps.loaded());
    }
}
