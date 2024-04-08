package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utilities.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {


    @FindBy(how = How.ID, id = "first-name")
    @Getter
    private WebElement firstNameField;

    @FindBy(how = How.ID, id = "last-name")
    @Getter
    private WebElement lastNameField;

    @FindBy(how = How.ID, id = "postal-code")
    @Getter
    private WebElement postalCodeField;

    @FindBy(how = How.ID, id = "continue")
    @Getter
    private WebElement continueButton;



    public CheckoutInformationPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void fillInformationAndSubmit (String firstName, String lastName, String zipPostalCode) {
        getFirstNameField().sendKeys(firstName);
        getLastNameField().sendKeys(lastName);
        getPostalCodeField().sendKeys(zipPostalCode);
        getContinueButton().click();
    }
}
