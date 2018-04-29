package fifth.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenBtn;

    @FindBy(css = "ul.submenu-container")
    private WebElement subMenu;

    @FindBy(xpath = "//a[@title='T-shirts']")
    private WebElement tShirtsBtn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void moveMouseInWomenBtn() {
        Actions action = new Actions(driver);
        action.moveToElement(womenBtn).build().perform();
    }

    public WebElement getTShirtsBtn() {
        return tShirtsBtn;
    }

    public void tShirtsBtnClick() {
        tShirtsBtn.click();
    }
}
