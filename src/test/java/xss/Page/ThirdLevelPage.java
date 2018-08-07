package xss.Page;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ThirdLevelPage extends BasePage {

    @FindBy(css = "iframe.game-frame")
    WebElement gameFrame;

    @FindBy(css = "input.urlbutton")
    WebElement goBtn;

    @FindBy(css = ".next-button")
    WebElement nextButton;

    public ThirdLevelPage inputScriptForThirdPage(ArrayList<String> scripts) {
        for (String script : scripts) {
            $("input.urlbar").sendKeys(script);
            goBtn.click();
            // cratch
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (goBtn.isDisplayed())
                goBtn.click();
            else
                break;
        }
        return this;
    }

    public ThirdLevelPage acceptAlert() {
        baseAcceptAlert();
        return this;
    }

    public FourthLevelPage goToFourthLevel() {
        nextButton.click();
        return page(FourthLevelPage.class);
    }
}
