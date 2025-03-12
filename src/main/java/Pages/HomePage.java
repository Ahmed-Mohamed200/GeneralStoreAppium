package Pages;

import Utils.Actions.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends AndroidActions {
    AndroidDriver driver;
    private final By nameField = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private final By letsShopBtn = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");
    private final By femaleGenderOption = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    private final By maleGenderOption = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    private final By countryDropDown = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By toastMessage = AppiumBy.xpath("//android.widget.Toast");


    public HomePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @Step("When I select Name: [{name}] from the name dropdown list")
    public HomePage setName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    @Step("And I select my gender: [{gender}]")
    public HomePage selectGender(String gender) {
        if (gender.equalsIgnoreCase("female")) {
            driver.findElement(femaleGenderOption).click();
        } else {
            driver.findElement(maleGenderOption).click();
        }
        return this;

    }

    public HomePage hideKeyboard() {
        driver.hideKeyboard();
        return this;

    }

    public HomePage assertToastMessage() {
        String text = driver.findElement(toastMessage).getDomAttribute("text");
        Assert.assertEquals(text, "Please enter your name");
        return this;

    }
    @Step("When I select country: [{country}] from the country dropdown list")
    public HomePage selectCountry(String country) {
        driver.findElement(countryDropDown).click();
        scrollToElement(country);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + country + "']")).click();
        return this;

    }
    @Step("And I click on the Let’s Shop button")
    public ProductPage submitForm() {
        driver.findElement(letsShopBtn).click();
        return new ProductPage(driver);
    }
}
