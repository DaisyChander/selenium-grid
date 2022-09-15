package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

    private WebDriver driver;
    private By openResultSelector = By.cssSelector("img.s-image");


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openResult(int index){
        List<WebElement> resultList = driver.findElements(openResultSelector);
        resultList.get(index).click();
    }
}
