package selenium.xpath_css.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RamblerXPathPage extends AbstractPage {

    @FindBy(xpath = "//*[@data-head-topline and @data-code='head']")
    private WebElement headBtn;

    @FindBy(xpath = "//*[@data-head-topline and @data-code='mail']")
    private WebElement mailBtn;

    @FindBy(xpath = "//*[@data-head-topline and @data-code='news']")
    private WebElement newsBtn;

    @FindBy(xpath = "//*[@data-head-topline and @data-code='games']")
    private WebElement gamesBtn;

    @FindBy(xpath = "//*[@data-head-topline and @data-code='horoscopes']")
    private WebElement horoscopesBtn;

    @FindBy(xpath = "//*[@data-head-topline and @data-code='dating']")
    private WebElement datingBtn;

    @FindBy(xpath = "//*[@data-head-topline and @data-code='top100']")
    private WebElement top100Btn;

    @FindBy(xpath = "//*[@data-head-topline and @data-code='kassa']")
    private WebElement kassaBtn;

    public RamblerXPathPage(WebDriver driver) {
        super(driver);
    }

    public void clickHeadWithXPath() {
        headBtn.click();
    }

    public void clickMailWithXPath() {
        mailBtn.click();
    }

    public void clickNewsWithXPath() {
        newsBtn.click();
    }

    public void clickGamesWithXPath() {
        gamesBtn.click();
    }

    public void clickHoroscopesWithXPath() {
        horoscopesBtn.click();
    }

    public void clickDatingWithXPath() {
        datingBtn.click();
    }

    public void clickTop100WithXPath() {
        top100Btn.click();
    }

    public void clickKassaWithXPath() {
        kassaBtn.click();
    }
}
