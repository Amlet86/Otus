package selenide.com.google.page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {

    public ResultPage checkSizeResult(int size) {
        $$(".srg .g").shouldHaveSize(size);
        return this;
    }

    public ResultPage checkContainsText(String search) {
        $$(".srg .g").get(0).should(text(search));
        return this;
    }
}
