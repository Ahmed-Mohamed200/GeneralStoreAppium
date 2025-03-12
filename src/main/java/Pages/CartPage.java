package Pages;

import Utils.Actions.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;


public class CartPage extends AndroidActions {
    AndroidDriver driver;


    private final By productPrices = AppiumBy.id("com.androidsample.generalstore:id/productPrice");
    private final By totalPrice = AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl");
    private final By termsAndConditions = AppiumBy.id("com.androidsample.generalstore:id/termsButton");
    private final By termsAndConditionsCloseBtn = AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
    private final By cartPageTitle = AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");

    private By productsImage(int index) {
        return By.xpath("(//android.widget.ImageView[@resource-id='com.androidsample.generalstore:id/productImage'])[" + index + "]");
    }

    private By productsPrice(int index) {
        return By.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice'])[" + index + "]");
    }

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @Step("Then I should see the two products displayed in the cart")
    public CartPage isProductsImageDisplayed() {
        Assert.assertTrue(driver.findElement(productsImage(1)).isDisplayed());
        Assert.assertTrue(driver.findElement(productsImage(2)).isDisplayed());
        return this;
    }

    public CartPage validateProductSum() {
        int productSize = driver.findElements(productPrices).size();
        double sum = 0;
        for (int i = 0; i < productSize; i++) {
            String ProductPrice = driver.findElements(productPrices).get(i).getText();
            double result = Double.parseDouble(ProductPrice.substring(1));
            sum += result;
        }
        String totalSum = driver.findElement(totalPrice).getText();
        double formattedTotal = formatPrice(totalSum);
        Assert.assertEquals(formattedTotal, sum);
        return this;
    }
    @Step("And I should verify that the total amount equals the sum of the two products prices")
    public CartPage validateTotalAmount() throws InterruptedException {
        waitForElement(driver.findElement(cartPageTitle), "text", "Cart");
        String firstProduct = driver.findElement(productsPrice(1)).getText().substring(1);
        String secondProduct = driver.findElement(productsPrice(2)).getText().substring(1);
        double firstProductPrice = Double.parseDouble(firstProduct);
        double secondProductPrice = Double.parseDouble(secondProduct);
        Double expectedTotalPrice = firstProductPrice + secondProductPrice;
        String actualTotal = driver.findElement(totalPrice).getText().substring(1);
        double actualTotalPrice = Double.parseDouble(actualTotal);
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
        return this;
    }

    public CartPage viewTermsAndConditions() {
        longPressGesture(driver.findElement(termsAndConditions));
        driver.findElement(termsAndConditionsCloseBtn).click();
        return this;
    }


}
