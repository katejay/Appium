package iostest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sliders extends InitializeDriver{

    @Test
    public void selectSliders() throws InterruptedException {
        //Select Sliders option from the main list using accessibilityId locator
        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();
        WebElement slider = driver.findElement(AppiumBy.iOSNsPredicateString("value ENDSWITH[c] '%'"));

        slider.sendKeys("0%");
        Assert.assertEquals(slider.getText(), "0%");

        Thread.sleep(2000);

        slider.sendKeys("1%");
        Assert.assertEquals(slider.getText(), "100%");

        Thread.sleep(2000);
    }
}
