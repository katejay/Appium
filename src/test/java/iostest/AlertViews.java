package iostest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertViews extends InitializeDriver{

    @Test
    public void selectAlertViews() {
        //Select alert view option from the main list using accessibilityId locator
        //accessibilityId syntax -  driver.findElement(AppiumBy.accessibilityId("accessibilityId value"))
        //NOTE : accessibilityId is slightly faster than id locator
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
    }

    @Test(dependsOnMethods = "selectAlertViews")
    public void testAlertViews1() {
        //Selecting 1st alert view option from the list using xpath locator
        //NOTE : iOSClassChain is faster than xpath locator
        //xpath syntax -  driver.findElement(By.xpath("//elementName[@attribute='value']"))
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Simple']")).click();
        //Get Text from Alert View
        String alertText1 = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='A Short Title Is Best']")).getText();
        System.out.println(alertText1);
        //Accept Alert View by clicking OK CTA
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='OK']")).click();
    }

    @Test(dependsOnMethods = "selectAlertViews")
    public void testAlertViews2() {
        //Selecting 2nd alert view option from the list using iOSClassChain locator
        //iOSClassChain syntax -  driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`attribute == 'value'`]"))
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Okay / Cancel'`]")).click();
        //Get Text from Alert View
        String alertText2 =  driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'A Short Title Is Best'`]")).getText();
        System.out.println(alertText2);
        //Accept Alert View by clicking OK CTA
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'OK'`]")).click();
    }

    @Test(dependsOnMethods = "selectAlertViews")
    public void testAlertViews3() {
        //Selecting 3rd alert view option from list using iOSNsPredicateString Locator
        //NOTE : There are various way to write iOSNsPredicateString locator
        //iOSNsPredicateString syntax -  driver.findElement(AppiumBy.iOSNsPredicateString("attribute == 'value' AND attribute == 'value'"))
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm / Cancel'")).click();
        //driver.findElement(AppiumBy.iOSNsPredicateString("type =='XCUIElementTypeStaticText' AND value =='Confirm / Cancel'")).click();
        //driver.findElement(AppiumBy.iOSNsPredicateString("type =='XCUIElementTypeStaticText' AND value BEGINSWITH 'Confirm'")).click();
        //driver.findElement(AppiumBy.iOSNsPredicateString("type =='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'confirm'")).click();
        //BEGINSWITH[c] is indicate case insensitive
        //Accept Alert View by clicking Confirm CTA
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND name BEGINSWITH[c] 'Confirm'")).click();
    }

    @Test(dependsOnMethods = "selectAlertViews")
    public void testAlertViews4() {
        //Selecting 4th input alert view option from the list
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("type =='XCUIElementTypeCell'")).sendKeys("Testing Data");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'OK'`]")).click();
    }

}
