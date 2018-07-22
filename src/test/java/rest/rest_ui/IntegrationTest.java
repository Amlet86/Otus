package rest.rest_ui;

import java.util.Random;

import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.Test;

import static rest.ApiKeys.API_KEY_DICTIONARY;
import static rest.ApiKeys.API_KEY_TRANSLATE;
import static rest.EndPointUrl.*;
import static rest.rest_ui.pages.TranslatePage.enterToTranslatePage;

public class IntegrationTest extends BaseTest {

    private String word = "машина";
    private String userLang = "ru";

    @Test
    public void restValidationYandex() throws UnirestException {
        String jsonLangs = Unirest.get(BASE_URL_DICTIONARY.getPath() + LANGS.getPath())
            .queryString("key", API_KEY_DICTIONARY.getApiKey())
            .asString()
            .getBody();

        String listLangs = JsonPath.read(jsonLangs, "[?(@=~/^+" + userLang + ".*/)]").toString();
        int numberLangs = JsonPath.read(listLangs, "length()");
        int randomLang = new Random().nextInt(numberLangs);
        String lang = JsonPath.read(listLangs, "[" + randomLang + "]");

        String jsonTranslation = Unirest.get(BASE_URL_TRANSLATION.getPath() + TRANSLATE.getPath())
            .queryString("key", API_KEY_TRANSLATE.getApiKey())
            .queryString("text", word)
            .queryString("lang", lang)
            .asString()
            .getBody();

        String translation = JsonPath.read(jsonTranslation, "text[0]");

        enterToTranslatePage(lang)
            .inputWords(word)
            .compareTraslation(translation);
    }
}
