package selenium.grid.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenBtn;

    @FindBy(xpath = "//a[@title='Women']/..//a[@title='T-shirts']")
    private WebElement tShirtsBtn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void moveMouseInWomenBtn() {
        Actions action = new Actions(driver);
        action.moveToElement(womenBtn).build().perform();
    }

    public void tShirtsBtnClick() {
        tShirtsBtn.click();
    }
}
