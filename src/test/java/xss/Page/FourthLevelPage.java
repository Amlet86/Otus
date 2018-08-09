package xss.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class FourthLevelPage extends BasePage {

    @FindBy(css = "iframe.game-frame")
    WebElement gameFrame;

    @FindBy(css = ".next-button")
    WebElement nextButton;

    public FourthLevelPage inputScriptForFourthPage(String script) {
        switchTo().frame(gameFrame);
        $("input#timer").setValue(script).pressEnter();
        return this;
    }

    public FourthLevelPage acceptAlert() {
        baseAcceptAlert();
        return this;
    }

    public FifthLevelPage goToFifthLevel() {
        nextButton.click();
        return page(FifthLevelPage.class);
    }


}
