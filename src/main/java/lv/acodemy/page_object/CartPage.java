package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utilities.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {


    @FindBy (how = How.CLASS_NAME, className = "cart_item")
    @Getter
    private List<WebElement> cartItems;


    @FindBy (how = How.ID, id = "checkout")
    @Getter
    private WebElement checkoutButton;

    public CartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void checkout() {
        getCheckoutButton().click();
    }
}
