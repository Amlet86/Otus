package xss.Page;

import static com.codeborne.selenide.Selenide.page;

public class SixthLevelPage extends BasePage {

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
