package elements.components;

import elements.WaitFor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class LeftBar extends Component {
    @WaitFor
    @FindBy(css = "img[alt=avatar]")
    public WebElement avatarImg;

    @FindBy(css = "a[href*='_personal/settings']")
    public WebElement settingsIcon;

    @FindBy(css = "a[href*='_personal/dashboard']")
    public WebElement dashboardIcon;
}
