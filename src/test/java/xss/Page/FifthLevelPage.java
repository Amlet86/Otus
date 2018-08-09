package xss.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class FifthLevelPage extends BasePage {

    @FindBy(css = "input.urlbutton")
    WebElement goBtn;

    @FindBy(css = "iframe.game-frame")
    WebElement gameFrame;

    @FindBy(css = ".next-button")
    WebElement nextButton;

    public FifthLevelPage inputScriptForFifthPage(String script) {
        $("input.urlbar").sendKeys(script);
        goBtn.click();
        switchTo().frame(gameFrame);

        $("input#reader-email").setValue(script);
        $("a").click();

        return this;
    }

    public FifthLevelPage acceptAlert() {
        baseAcceptAlert();
        return this;
    }

    public SixthLevelPage goToSixthhLevel() {
        nextButton.click();
        return page(SixthLevelPage.class);
    }

}
