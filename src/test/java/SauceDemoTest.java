import com.github.javafaker.Faker;
import lv.acodemy.page_object.*;
import lv.acodemy.utilities.Constants;
import lv.acodemy.utilities.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

public class SauceDemoTest {

    AuthorizationPage authorizationPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    Header header;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutInformationOverview checkoutInformationOverview;
    CheckoutCompletePage checkoutCompletePage;

    Faker fakerData = new Faker();

    @BeforeMethod
    public void beforeTest() {
        authorizationPage = new AuthorizationPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        header = new Header();
        checkoutInformationPage = new CheckoutInformationPage();
        checkoutInformationOverview = new CheckoutInformationOverview();
        checkoutCompletePage = new CheckoutCompletePage();
        DriverManager.getDriver().get("https://saucedemo.com");
    }

    @Test
    public void purchaseItemFromInventoryTest() {

        authorizationPage.authorize("standard_user", "secret_sauce");

        inventoryPage.selectItemName("Fleece Jacket");

        Assertions.assertThat(header.getShoppingCartBadge().getText()).isEqualTo("1");

        header.openCart();

        Assertions.assertThat(cartPage.getCartItems().size()).isEqualTo(1);

        cartPage.checkout();

        checkoutInformationPage.fillInformationAndSubmit("Janis", "Grinvalds", "1037");

        checkoutInformationOverview.submitOrder();

        Assertions.assertThat(checkoutCompletePage.getHeaderMessage().getText()).isEqualTo(Constants.THANK_YOU_FOR_ORDER_MESSAGE);

    }

    @AfterMethod
    public  void afterTest(){
        DriverManager.closeDriver();
    }
}
