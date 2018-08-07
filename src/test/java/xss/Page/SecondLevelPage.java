package xss.Page;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class SecondLevelPage extends BasePage {

    @FindBy(css = "iframe.game-frame")
    WebElement gameFrame;

    @FindBy(css = "input.share")
    WebElement shareStatus;

    @FindBy(css = ".next-button")
    WebElement nextButton;

    public SecondLevelPage inputScriptForSecondPage(ArrayList<String> scripts) {
        switchTo().frame(gameFrame);
        for (String script : scripts) {
            $("#post-content").setValue(script).pressEnter();
            // cratch
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (shareStatus.isDisplayed())
                shareStatus.click();
            else
                break;
        }
        return this;
    }

    public SecondLevelPage acceptAlert() {
        baseAcceptAlert();
        return this;
    }

    public ThirdLevelPage goToThirdLevel() {
        nextButton.click();
        return page(ThirdLevelPage.class);
    }

}
