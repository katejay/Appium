package iosinbuiltapp;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhotosApp {

    public AppiumDriverLocalService service;
    public IOSDriver driver;

    @BeforeClass
    public void initialize() throws Exception {
        //Start Appium server
        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr/local/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        // Set up Appium capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("appium:platformVersion", "16.4");
        capabilities.setCapability("appium:deviceName", "iPhone 14 Pro");
        capabilities.setCapability("appium:automationName", "XCUITest");
        //capabilities.setCapability("appium:bundleId","com.apple.mobileslideshow");

        // Initialize the driver
        driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void runAlbumsApp() {
        //launch the Photos app
        Map<String, String> params = new HashMap<String, String>();
        params.put("bundleId", "com.apple.mobileslideshow");
        driver.executeScript("mobile: launchApp", params);

        //Select All Photos option
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();

        //Get the number of images
        List<WebElement> photos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(photos.size());

        driver.findElements(AppiumBy.xpath("//XCUIElementTypeCell")).get(0).click();

        for(int i =0; i<photos.size();i++)
        {
            System.out.println(driver.findElement (AppiumBy.xpath("//XCUIElementTypeNavigationBar")).getAttribute ("name"));
            Map<String, Object> params1 = new HashMap<String, Object> ();
            params1.put ("direction","left");
            driver.executeScript("mobile:swipe", params1);
        }

        //Close image view
        driver.navigate().back();

        //Select Albums option
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Albums'`]")).click();
    }

    @AfterClass
    public void terminate() {
        // Close the driver session
        driver.quit();

        // Stop the Appium server
        service.stop();
    }
}
