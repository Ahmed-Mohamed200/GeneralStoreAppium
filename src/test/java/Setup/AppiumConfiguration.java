package Setup;

import Utils.DataReader.PropertiesReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.service.local.AppiumDriverLocalService.buildDefaultService;

public class AppiumConfiguration {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;
    PropertiesReader reader = new PropertiesReader("src\\main\\resources\\Properties\\config.properties");
    String appPath = System.getProperty("user.dir") + reader.get("androidAppPath");


    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        service = buildDefaultService();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(reader.get("androidDeviceName"))
                .setApp(appPath);

        String appiumServerURL = reader.get("appiumServerURL");
        System.out.println("Appium Server URL: " + appiumServerURL);

        driver = new AndroidDriver(new URL(appiumServerURL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
