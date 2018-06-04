package selenium.xpath_css.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RamblerXPathPage extends AbstractPage {

    @FindBy(xpath = "//nav")
    private WebElement navigationBlock;

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//*[@data-logo='header::logo_rambler']")
    private WebElement logoHeaderImg;

    public RamblerXPathPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogoHeaderImgWithXPath() {
        logoHeaderImg.click();
    }
}
