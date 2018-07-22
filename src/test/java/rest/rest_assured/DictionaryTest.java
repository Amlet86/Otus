package rest.rest_assured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static rest.ApiKeys.API_KEY_DICTIONARY;
import static rest.EndPointUrl.*;

public class DictionaryTest {

    private String getPathForLangs(String key) {
        return String.format("?key=%s", key);
    }

    private String getPathForLookup(String key, String lang, String text) {
        return String.format("?key=%s&lang=%s&text=%s", key, lang, text);
    }

    @BeforeTest
    public void beforeTest() {
        RestAssured.baseURI = BASE_URL_DICTIONARY.getPath();
    }

    @Test
    public void getLangs() {
        RestAssured.useRelaxedHTTPSValidation();

        String additionalPath = getPathForLangs(API_KEY_DICTIONARY.getApiKey());

        given()

            .when()
            .get(LANGS.addPath(additionalPath))
            .then()
            .statusCode(200)
            .body(containsString("ru-en"));
    }

    @Test
    public void lookup() {
        String additionalPath = getPathForLookup(API_KEY_DICTIONARY.getApiKey(), "ru-en", "черный аист");

        given()

            .when()
            .get(LOOKUP.addPath(additionalPath))
            .then()
            .statusCode(200)
            .body("def[0].tr[0].text", equalTo("black stork"));
    }
}
