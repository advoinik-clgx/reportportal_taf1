package scenarios.ui;

import objects.users.DefaultUser;
import org.testng.annotations.BeforeMethod;
import steps.BaseSteps;
import steps.LoginSteps;

class LoggedInWithUserBase extends BaseUi {
    @BeforeMethod
    public void beforeEach() {
        BaseSteps.navigate();
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.loaded();
        loginSteps.login(new DefaultUser());
    }
}
