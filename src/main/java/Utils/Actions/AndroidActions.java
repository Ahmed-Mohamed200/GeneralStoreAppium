package Utils.Actions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidActions {
    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
    }

    //Appium requires the elementId to be passed as a string extracted from a RemoteWebElement.
    //WebElement (the generic interface) does not provide direct access to the element ID, but RemoteWebElement does via getId().
    public void longPressGesture(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) webElement).getId()
                , "duration", 2000));

    }

    public void swipeGesture(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) webElement).getId(),
                "direction", "left",
                "percent", .50
        ));
    }

    public double formatPrice(String price) {
        double result = Double.parseDouble(price.substring(1));
        return result;
    }

    public void scrollToElement(String element) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + element + "\"));"));
    }

    public void waitForElement(WebElement ele, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(ele, attribute, value));

    }

}

