package xss.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.switchTo;

public class BasePage<T extends MainPage> {

    @FindBy(css = "input.urlbar")
    WebElement urlFld;

    @FindBy(css = "input.urlbutton")
    WebElement goBtn;

    @FindBy(css = "iframe.game-frame")
    WebElement gameFrame;

    @FindBy(css = ".next-button")
    WebElement nextButton;

    public void baseAcceptAlert() {
        switchTo().alert().accept();
        switchTo().defaultContent();
    }
}
