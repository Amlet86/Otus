package rest.rest_ui.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;
import static rest.EndPointUrl.BASE_URL_UI;

public class TranslatePage extends BasePage<TranslatePage> {

    public static TranslatePage enterToTranslatePage(String lang) {
        if (lang == null) {
            open(BASE_URL_UI.getPath());
        } else
            open(BASE_URL_UI.getPath() + "?lang=" + lang);
        return page(TranslatePage.class);
    }

    public TranslatePage inputWords(String words) {
        $("#fakeArea").setValue(words).pressEnter();
        return this;
    }

    public TranslatePage compareTraslation(String translation) {
        $(".translation-chunk").should(Condition.matchText(translation));
        return this;
    }

}
