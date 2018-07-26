package rest.rest_ui;

import java.util.Random;

import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import static rest.ApiKeys.API_KEY_DICTIONARY;
import static rest.ApiKeys.API_KEY_TRANSLATE;
import static rest.EndPointUrl.*;

public class IntegrationTest extends BaseTest {

    protected String responseLangs(){
        String jsonLangs = null;
        try {
            jsonLangs = Unirest.get(BASE_URL_DICTIONARY.getPath() + LANGS.getPath())
                .queryString("key", API_KEY_DICTIONARY.getApiKey())
                .asString()
                .getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return jsonLangs;
    }

        protected String choiseLang (String jsonLangs, String userLang) {
            String listLangs = JsonPath.read(jsonLangs, "[?(@=~/^+" + userLang + ".*/)]").toString();
            int numberLangs = JsonPath.read(listLangs, "length()");
            int randomLang = new Random().nextInt(numberLangs);
            String lang = JsonPath.read(listLangs, "[" + randomLang + "]");
            return lang;
        }

        protected String translate(String word, String lang) {
            String jsonTranslation = null;
            try {
                jsonTranslation = Unirest.get(BASE_URL_TRANSLATION.getPath() + TRANSLATE.getPath())
                    .queryString("key", API_KEY_TRANSLATE.getApiKey())
                    .queryString("text", word)
                    .queryString("lang", lang)
                    .asString()
                    .getBody();
            } catch (UnirestException e) {
                e.printStackTrace();
            }

            String translation = JsonPath.read(jsonTranslation, "text[0]");
            return translation;
        }

    }
