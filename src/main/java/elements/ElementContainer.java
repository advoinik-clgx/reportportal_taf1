package elements;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web_driver.Driver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class ElementContainer implements Loadable {
    protected ElementContainer() {
        PageFactory.initElements(Driver.get(), this);
    }

    @Override
    public boolean loaded() {
        String pageName = this.getClass().getSimpleName();
        log.info("Waiting for {} to load...", pageName);

        List<WebElement> elementsToWaitFor = new ArrayList<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.isAnnotationPresent(WaitFor.class)
                        && field.get(this) instanceof WebElement element) {
                    elementsToWaitFor.add(element);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        Driver.getWaitXL().until(ExpectedConditions.visibilityOfAllElements(elementsToWaitFor));
        log.info("{} successfully loaded", pageName);
        return true;
    }
}
