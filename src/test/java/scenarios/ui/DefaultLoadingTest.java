package scenarios.ui;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import scenarios.listeners.AllureTestListener;
import steps.BaseSteps;
import steps.LoginSteps;

@Listeners({AllureTestListener.class})
class DefaultLoadingTest extends BaseUiTest {

    @Test
    @Issue("Test-1")
    @Severity(SeverityLevel.CRITICAL)
    void rpLoadsWithLoginPageByDefaultTest() {
        BaseSteps.navigate();
        Assert.assertTrue(LoginSteps.loaded());
    }
}
