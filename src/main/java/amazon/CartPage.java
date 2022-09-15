package amazon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private By quantitySelector = By.cssSelector("#quantity");

    private final int TIMEOUT_COOKIE = 6;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectQuantity(int quantity) {
        WebElement dropdown = driver.findElement(quantitySelector);
        Select categoriesSelect = new Select(dropdown);
        categoriesSelect.selectByIndex(2);
    }


}
