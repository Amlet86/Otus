package rest.rest_ui;

import org.testng.annotations.Test;

import static rest.rest_ui.pages.TranslatePage.enterToTranslatePage;

public class UITest extends IntegrationTest {

    private String word = "машина";
    private String userLang = "ru";

    @Test
    public void restUITest() {
        String lang = choiseLang(responseLangs(), userLang);
        String translation = translate(word, lang);

        enterToTranslatePage(lang)
            .inputWords(word)
            .compareTraslation(translation);
    }
}