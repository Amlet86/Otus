package selenium.xpath_css.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RamblerCSSPage extends AbstractPage {

    @FindBy(css = "[data-code='head']")
    private WebElement headBtn;

    @FindBy(css = "[data-code='mail']")
    private WebElement mailBtn;

    @FindBy(css = "[data-code='news']")
    private WebElement newsBtn;

    @FindBy(css = "[data-code='games']")
    private WebElement gamesBtn;

    @FindBy(css = "[data-code='horoscopes']")
    private WebElement horoscopesBtn;

    @FindBy(css = "[data-code='dating']")
    private WebElement datingBtn;

    @FindBy(css = "[data-code='top100']")
    private WebElement top100Btn;

    @FindBy(css = "[data-code='kassa']")
    private WebElement kassaBtn;

    @FindBy(css = ".rui-ComplexSearch-input")
    private WebElement searchFld;

    @FindBy(css = ".rui-ComplexSearch-searchButton")
    private WebElement searchBtn;

    public RamblerCSSPage(WebDriver driver) {
        super(driver);
    }

    public void clickHead() {
        headBtn.click();
    }

    public void clickMail() {
        mailBtn.click();
    }

    public void clickNews() {
        newsBtn.click();
    }

    public void clickGames() {
        gamesBtn.click();
    }

    public void clickHoroscopes() {
        horoscopesBtn.click();
    }

    public void clickDating() {
        datingBtn.click();
    }

    public void clickTop100() {
        top100Btn.click();
    }

    public void clickKassa() {
        kassaBtn.click();
    }

    public void inputSearch(String value) {
        searchFld.sendKeys(value);
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }
}