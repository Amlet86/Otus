package selenium.fifth.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenBtn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void moveMouseInWomenBtn() {
        Actions action = new Actions(driver);
        action.moveToElement(womenBtn).build().perform();
    }

    public void tShirtsBtnClick() {
        womenBtn.findElement(By.xpath(".//*[@title='T-shirts']")).click();
    }
}
