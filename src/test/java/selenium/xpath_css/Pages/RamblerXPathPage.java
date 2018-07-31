package selenium.xpath_css.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RamblerXPathPage extends AbstractPage {

    @FindBy(xpath = "//nav")
    private WebElement navigationBlock;

    @FindBy(xpath = "//canvas")
    private WebElement advertising;

    @FindBy(xpath = "//header")
    private WebElement headerBlock;

    @FindBy(xpath = "//div[contains(@data-cerber-head, 'mail')]")
    private WebElement mailBlock;

    //header//@data-logo - console находит, а webDriver не работает с таким локатором
    @FindBy(xpath = "//header//*[@data-logo]")
    private WebElement logoHeaderImg;

    @FindBy(xpath = "//header//*[contains(@data-cerber-head, 'weather')]")
    private WebElement weatherWidget;

    @FindBy(xpath = "//header//*[contains(@data-cerber-head, 'traffic')]")
    private WebElement trafficWidget;

    @FindBy(xpath = "//header//*[contains(@data-cerber-head, 'finance')]")
    private WebElement financeWidget;

    @FindBy(xpath = "//*[@data-cerber-head='USD']/span[2]")
    private WebElement priceUSD;

    @FindBy(xpath = "//a[contains(@data-cerber-head, 'hint')]")
    private WebElement exampleSearch;

    @FindBy(xpath = "//a[contains(@data-cerber-head, 'hint')]/parent::div and not(a)")
    private WebElement headerSearch;

    public RamblerXPathPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogoHeaderImg() {
        logoHeaderImg.click();
    }

    public void clickWeatherWidget() {
        weatherWidget.click();
    }

    public void clickTrafficWidget() {
        trafficWidget.click();
    }

    public void clickFinanceWidget() {
        financeWidget.click();
    }

    public String getExampleSearch() {
        return exampleSearch.getText();
    }

    public String getPriceUSD() {
        return priceUSD.getText();
    }

    public String getHeaderSearch() {
        return headerSearch.getText();
    }
}
