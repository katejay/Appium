package iostest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URI;

public class InitializeDriver {

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
        capabilities.setCapability("appium:bundleId","com.example.apple-samplecode.UICatalog");

        // Initialize the driver
        driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), capabilities);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void terminate() {
        // Close the driver session
        driver.quit();

        // Stop the Appium server
        service.stop();
    }
}
