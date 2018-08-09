package xss.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class SixthLevelPage extends BasePage {

    @FindBy(css = "input.urlbar")
    WebElement urlFld;

    @FindBy(css = "input.urlbutton")
    WebElement goBtn;

    @FindBy(css = ".next-button")
    WebElement nextButton;

    public SixthLevelPage inputScriptForSixthPage(String script) {
        urlFld.clear();
        urlFld.sendKeys(script);
        goBtn.click();
        return this;
    }

    public SixthLevelPage acceptAlert() {
        baseAcceptAlert();
        return this;
    }

    public DonePage goToDone() {
        nextButton.click();
        return page(DonePage.class);
    }
}
