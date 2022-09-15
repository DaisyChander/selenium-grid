import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class TP_S3 {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {

        //System.out.println(System.getProperty("user.dir"));
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\main\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        driver = new RemoteWebDriver(new URL("http://admin:admin@192.168.121.14:4449"), options);
/*
        EdgeOptions options = new EdgeOptions();
        options.setCapability(CapabilityType.BROWSER_NAME, "edge");
        //driver = new RemoteWebDriver(new URL("http://admin:admin@192.168.121.14:4444"), options);
        driver = new EdgeDriver();
*/
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();


    }

    @Test
    public void test(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");

        WebElement clickBar = driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']"));
        clickBar.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-component-type='s-search-result']")));

        List<WebElement> productList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        productList.get(1).click();
/*
        WebElement panierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']")));
        panierButton.click();

        WebElement nonmerci = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']")));
        nonmerci.click();

*/

    }

    @AfterMethod
    public void teardown1() {
        driver.quit();
    }
}
