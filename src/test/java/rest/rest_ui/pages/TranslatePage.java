package rest.rest_ui.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;
import static rest.EndPointUrl.BESE_URL_UI;

public class TranslatePage extends BasePage<TranslatePage> {

    public static TranslatePage enterToTranslatePage() {
        open(BESE_URL_UI.getPath());
        return page(TranslatePage.class);
    }

    public TranslatePage inputWords(String words) {
        $("#fakeArea").setValue(words).pressEnter();
        return this;
    }

    public TranslatePage compareTraslation(String translation) {
        $(".translation-chunk").should(Condition.text(translation));
        return this;
    }

}
