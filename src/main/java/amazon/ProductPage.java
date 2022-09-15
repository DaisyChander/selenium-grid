package amazon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private By cartButtonSelector = By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']");
    private By refuseAppleCareSelector = By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']");
    private By openCartSelector = By.cssSelector("[#attach-sidesheet-view-cart-button]");

    private final int TIMEOUT_COOKIE = 10;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cartButtonSelector));
        addToCartButton.click();
    }

    public void refuseAppleCare(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement refuseAppleCarebutton = wait.until(ExpectedConditions.visibilityOfElementLocated(refuseAppleCareSelector));
        refuseAppleCarebutton.click();
    }

    public void openCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement openTheCart = wait.until(ExpectedConditions.visibilityOfElementLocated(openCartSelector));
        openTheCart.click();
    }

}
