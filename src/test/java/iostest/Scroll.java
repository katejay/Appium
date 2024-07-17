package iostest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Scroll extends InitializeDriver{

    @Test
    public void scrollPage() {
        WebElement webView = driver.findElement(AppiumBy.accessibilityId("Web View"));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement)webView).getId());
        driver.executeScript("mobile:scroll", params);

        webView.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String text = driver.findElement(AppiumBy.accessibilityId("This is HTML content inside a ")).getText();
        System.out.println(text);

        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'UIKitCatalog'`]")).click();
    }
}
