package rest.rest_ui;

import com.codeborne.selenide.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static rest.ApiKeys.API_KEY_DICTIONARY;
import static rest.ApiKeys.API_KEY_TRANSLATE;
import static rest.EndPointUrl.*;
import static rest.rest_ui.pages.TranslatePage.enterToTranslatePage;

public class IntegrationTest {

    @BeforeTest
    public void beforeTest() {
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

    @Test
    public void restValidationTest() throws UnirestException {
        String jsonLangs = Unirest.get(BASE_URL_DICTIONARY.getPath() + LANGS.getPath())
            .queryString("key", API_KEY_DICTIONARY.getApiKey())
            .asString()
            .getBody();

        byte numberLangs = JsonPath.read(jsonLangs, "length()");
        String lang = JsonPath.read(jsonLangs, "");

        String jsonTranslation = Unirest.get(BASE_URL_TRANSLATION.getPath() + TRANSLATE.getPath())
            .queryString("key", API_KEY_TRANSLATE.getApiKey())
            .queryString("text", "storks")
            .queryString("lang", "en-ru")
            .asString()
            .getBody();

        String translation = JsonPath.read(jsonTranslation, "text[0]");

        enterToTranslatePage()
            .inputWords("storks")
            .compareTraslation(translation);
    }
}
