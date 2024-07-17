package iostest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LongPress extends InitializeDriver{

    @Test
    public void selectSteppers() {
        //Select Steppers option from the main list using accessibilityId locator
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
    }

    @Test(dependsOnMethods = "selectSteppers")
    public void touchNHold() {
        //Touch and hold the increment stepper button
        WebElement element = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]"));
        Map <String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration", 5);
        driver.executeScript("mobile:touchAndHold", params);
    }
}
