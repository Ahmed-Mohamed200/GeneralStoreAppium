package Tests;

import Pages.HomePage;
import Setup.AppiumConfiguration;
import Utils.DataReader.JsonReader;
import io.qameta.allure.Description;
import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import org.testng.annotations.Test;

import java.io.IOException;

public class EndToEndTest extends AppiumConfiguration {

    @Test
    @Description("Given I open the General Store app on an Android device\n" +
            "    And I enter my name in the name text field\n" +
            "    And I select my gender\n" +
            "    When I select country from the country dropdown list\n" +
            "    And I click on the Let’s Shop button\n" +
            "    Then I add the first two products to the cart\n" +
            "    When I navigate to the cart screen\n" +
            "    Then I should see the two products displayed in the cart\n" +
            "    And I should verify that the total amount equals the sum of the two products' prices")
    public void fillForm() throws InterruptedException, IOException {
        JsonNode testData = JsonReader.readJsonFile("src/test/resources/testData.json");


        new HomePage(driver).setName(testData.get("Name").asText())
                .hideKeyboard()
                .selectGender(testData.get("Gender").asText())
                .selectCountry(testData.get("Country").asText())
                .submitForm()
                .addItemToCart(1)
                .addItemToCart(1)
                .goToCartPage()
                .isProductsImageDisplayed()
                .validateTotalAmount()
                .viewTermsAndConditions();

    }
}



