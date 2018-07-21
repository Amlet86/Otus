package rest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class TranslateTest {

    private static final String API_KEY = "trnsl.1.1.20180721T114543Z.d58b03818313efca.51798d718478c8384510ef94555688a7d71d8091";

    private String getPathForTranslate(String key, String text, String languageFormat) {
        return String.format("?key=%s&text=%s&lang=%s", key, text, languageFormat);
    }

    @BeforeTest
    public void beforeTest() {
        RestAssured.baseURI = "https://translate.yandex.net/api/v1.5/tr.json/";
    }

    @Test
    public void dictionaryTest() {
        RestAssured.useRelaxedHTTPSValidation();

        String additionalPath = getPathForTranslate(API_KEY, "Аист", "ru-en");

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

