package rest.rest_assured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rest.EndPointUrl;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static rest.ApiKeys.API_KEY_TRANSLATE;
import static rest.EndPointUrl.BASE_URL_TRANSLATION;

public class TranslateTest {

    private String getPathForTranslate(String key, String text, String languageFormat) {
        return String.format("?key=%s&text=%s&lang=%s", key, text, languageFormat);
    }

    @BeforeTest
    public void beforeTest() {
        RestAssured.baseURI = BASE_URL_TRANSLATION.getPath();
    }

    @Test
    public void dictionaryTest() {
        RestAssured.useRelaxedHTTPSValidation();

        String additionalPath = getPathForTranslate(API_KEY_TRANSLATE.getApiKey(), "Аист", "ru-en");

        given()

            .when()
            .get(EndPointUrl.TRANSLATE.addPath(additionalPath))
            .then()
            .statusCode(200)
            .body("code", equalTo(200))
            .body("lang", equalTo("ru-en"))
            .body("text", hasItem("Stork"));
    }
}

