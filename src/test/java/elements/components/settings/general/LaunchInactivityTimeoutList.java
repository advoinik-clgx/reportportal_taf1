package elements.components.settings.general;

import elements.ElementContainer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaunchInactivityTimeoutList extends ElementContainer {
    @FindBy(css = "div[class*='inputDropdown__opened--'] div[class*='inputDropdownOption__dropdown-option--']")
    public List<WebElement> options;

    @FindBy(css = "div[class*='inputDropdown__opened--'] div[class*='scrollWrapper__scrolling-content--']")
    public WebElement optionsBlock;

    public void selectByTitle(String title) {
        options.stream()
                .filter(it -> it.getText().equals(title))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to get LaunchInactivityTimeout value by title %s".formatted(title)))
                .click();
    }
}
