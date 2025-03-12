package Pages;

import Utils.Actions.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductPage extends AndroidActions {
    AndroidDriver driver;
    private final By addToCartBtn = AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']");
    private final By productName = By.id("com.androidsample.generalstore:id/productName");
    private final By cartIcon = AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]");

    @Step("Then I add the first two products to the cart")
    private By getAddToCartBtn(int index) {
        return AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART'][" + index + "]");
    }

    public ProductPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ProductPage addItemToCart(int index) {
        driver.findElement(getAddToCartBtn(index)).click();
        return this;
    }

    public ProductPage addSpecificItemToCart(String name) {
        scrollToElement(name);
        int productSize = driver.findElements(productName).size();
        for (int i = 0; i < productSize; i++) {
            String productNames = driver.findElements(productName).get(i).getText();
            if (productNames.equalsIgnoreCase(name)) {
                driver.findElements(addToCartBtn).get(i).click();
            }

        }

        return this;
    }
    @Step("When I navigate to the cart screen")
    public CartPage goToCartPage() {
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }

}
