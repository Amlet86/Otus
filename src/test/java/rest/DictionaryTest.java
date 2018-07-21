package rest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class DictionaryTest {

    private static final String API_KEY = "dict.1.1.20180721T140439Z.5bca30e704cc24ff.86803afeec18fc206a1dd196966d6c7db35f6c7e";

    private String getPathForLangs(String key) {
        return String.format("?key=%s", key);
    }

    private String getPathForLookup(String key, String lang, String text) {
        return String.format("?key=%s&lang=%s&text=%s", key, lang, text);
    }

    @BeforeTest
    public void beforeTest() {
        RestAssured.baseURI = "https://dictionary.yandex.net/api/v1/dicservice.json/";
    }

    @Test
    public void getLangs() {
        RestAssured.useRelaxedHTTPSValidation();

        String additionalPath = getPathForLangs(API_KEY);

        given()

            .when()
            .get(EndPointUrl.GET_LANGS.addPath(additionalPath))
            .then()
            .statusCode(200)
            .body(containsString("ru-en"));
    }

    @Test
    public void lookup() {
        String additionalPath = getPathForLookup(API_KEY, "ru-en", "черный аист");

        given()

            .when()
            .get(EndPointUrl.LOOKUP.addPath(additionalPath))
            .then()
            .statusCode(200)
            .body("def[0].tr[0].text", equalTo("black stork"));
    }
}
