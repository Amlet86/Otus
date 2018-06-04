package selenium.xpath_css.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RamblerCSSPage extends AbstractPage {

    @FindBy(xpath = "//nav[@*]")
    private WebElement navigationBlock;

    public RamblerCSSPage(WebDriver driver) {
        super(driver);
    }

    public void clickHeadWithCSS() {
        navigationBlock.findElement(By.cssSelector("[data-code='head']")).click();
    }

    public void clickMailWithCSS() {
        navigationBlock.findElement(By.cssSelector("[data-code='mail']")).click();
    }

    public void clickNewsWithCSS() {
        navigationBlock.findElement(By.cssSelector("[data-code='news']")).click();
    }

    public void clickGamesWithCSS() {
        navigationBlock.findElement(By.cssSelector("[data-code='games']")).click();
    }

    public void clickHoroscopesWithCSS() {
        navigationBlock.findElement(By.cssSelector("[data-code='horoscopes']")).click();
    }

    public void clickDatingWithCSS() {
        navigationBlock.findElement(By.cssSelector("[data-code='dating']")).click();
    }

    public void clickTop100WithCSS() {
        navigationBlock.findElement(By.cssSelector("[data-code='top100']")).click();
    }

    public void clickKassaWithCSS() {
        navigationBlock.findElement(By.cssSelector("[data-code='kassa']")).click();
    }
}