package iostest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PickerView extends InitializeDriver{

    @Test
    public void selectPickerView() {
        //Select Picker View option from the main list using accessibilityId locator
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        String redColoredNum = "10";
        String greenColoredNum = "130";
        String blueColoredNum = "250";

        WebElement redColoredElement = driver.findElement(AppiumBy.accessibilityId("Red color component value"));
        WebElement greenColoredElement = driver.findElement(AppiumBy.accessibilityId("Green color component value"));
        WebElement blueColoredElement = driver.findElement(AppiumBy.accessibilityId("Blue color component value"));

        redColoredElement.sendKeys(redColoredNum);
        greenColoredElement.sendKeys(greenColoredNum);
        blueColoredElement.sendKeys(blueColoredNum);

        Assert.assertEquals(redColoredElement.getText(), redColoredNum);
        Assert.assertEquals(greenColoredElement.getText(), greenColoredNum);
        Assert.assertEquals(blueColoredElement.getText(), blueColoredNum);

    }
}
