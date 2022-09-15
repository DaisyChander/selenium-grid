import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TP_S2 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }

    @Test

    public void test() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement hamburger = driver.findElement(By.id("nav-hamburger-menu"));
        hamburger.click();

        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='hmenu hmenu-visible']/li[2]/a")));
        menu.click();

        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='anonCarousel1']/ol/li[3]")));
        product.click();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }



    @Test
    public void testList() {

        driver.findElement(By.id("nav-hamburger-menu")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item")));

        List<WebElement> menuList = driver.findElements(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item"));
        menuList.get(1).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




    @Test

    public void testExceptions() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement hamburger = driver.findElement(By.id("nav-hamburger-menu"));
        hamburger.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item")));

        List<WebElement> menuList = driver.findElements(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item"));
        menuList.get(0).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.a-carousel-col.a-carousel-center > div >ol")));

        List<WebElement> productList = driver.findElements(By.cssSelector("div.a-carousel-col.a-carousel-center > div >ol"));
        productList.get(2).click();

    }

    @AfterMethod
    public void teardown1() {
        driver.quit();
    }

    @Test
    public void testAsserts() {
        // Arrange
        final String expectedToutes = "Toutes";
        final String expectedMeilleuresVentes = "Meilleures ventes";
        final String expectedAmazonBasics = "Amazon Basics";
        final String expectedVentesLivres = "Meilleures ventes dans Livres";

        // Act
        WebElement logo = driver.findElement(By.cssSelector("#nav-logo"));
        WebElement barreRecherche = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement toutesMenu = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
        WebElement meilleuresVentes = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_bestsellers]"));
        WebElement amazonBasics = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_amazonbasics]"));
        WebElement meilleuresVentesLivres = driver.findElement(By.cssSelector("[data-csa-c-slot-id=desktop-5] h2.as-title-block-left"));

        // Asserts
        Assert.assertTrue(logo.isDisplayed(), "The Amazon Logo is not displayed");
        Assert.assertTrue(barreRecherche.isDisplayed());
        Assert.assertEquals(toutesMenu.getText(), expectedToutes);

        Assert.assertTrue(meilleuresVentes.isDisplayed());
        Assert.assertEquals(meilleuresVentes.getText(), expectedMeilleuresVentes, "The button Meilleures Ventes is not correct");

        Assert.assertTrue(amazonBasics.isDisplayed());
        Assert.assertEquals(amazonBasics.getText(), expectedAmazonBasics);

        Assert.assertTrue(meilleuresVentesLivres.isDisplayed());
        Assert.assertEquals(meilleuresVentesLivres.getText(), expectedVentesLivres);
    }

    @Test
    public void testSelect() {
        WebElement dropdown = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select categoriesSelect = new Select(dropdown);
        categoriesSelect.selectByIndex(4);
        categoriesSelect.selectByValue("search-alias=baby");
        categoriesSelect.selectByVisibleText("Informatique");
    }


}
