package scenarios.ui;

import objects.users.DefaultUser;
import org.testng.annotations.BeforeMethod;
import steps.BaseSteps;
import steps.LoginSteps;

class LoggedInWithUserBaseTest extends BaseUiTest {
    @BeforeMethod
    void beforeEach() {
        BaseSteps.navigate();
        LoginSteps.login(new DefaultUser());
    }
}
