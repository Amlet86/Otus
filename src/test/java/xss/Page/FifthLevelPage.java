package xss.Page;

import static com.codeborne.selenide.Selenide.*;

public class FifthLevelPage extends BasePage {

    public FifthLevelPage inputScriptForFifthPage(String script) {
        urlFld.sendKeys(script);
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
