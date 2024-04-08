import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
    ChromeDriver  driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void googleTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.lv/");

        //Click on Accept all
        driver.findElement(By.xpath("//div[text()='Принять все']//parent::button")).click();

        //Write input into a search input field
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("acodemy IT kursi");
        searchInput.sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "acodemy IT kursi - Поиск в Google");
        Assertions.assertThat(driver.getTitle().contains("acodemy IT kursi"));
    }

    @Test(description= "Login with standard user")
    public void successLoginTest(){

        //Task1: open saucedemo.com;
        driver.get("https://www.saucedemo.com/");

        //Task2: Define Element username;
        //Enter- standard_user;
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        //Task3: Define element password
        //enter password value;
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        //Task4: Define login button;
        //And click on it
        WebElement loginButton= driver.findElement(By.id("password"));
        loginButton.submit();

        WebElement inventoryList= driver.findElement(By.className("Inventory_list"));
        Assertions.assertThat(inventoryList.isDisplayed()).isTrue();
    }

//       @AfterMethod
//       public void afterTest(){
//            driver.close();
//            driver.quit();
//        }
    }
