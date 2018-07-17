package rest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReestAssured {

    private static final String API_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    private static final String API_KEY = "trnsl.1.1.20180711T123306Z.b012f6b5034cc719.aff4999263480fef925a97d8863cbccc7ab40f50";

    @Test
    public void dictionaryTest() {
        given()
                .header("User-Agent", "Mozilla...")
                .header("JWT", "jwt_token")

                .when()
                .get(API_URL + getPathFormated(API_KEY, "Привет", "ru-en"))
                .then()
                .statusCode(200)
                .body("text[0]", equalTo("Hi"));
    }

    protected String getPathFormated(String key, String text, String languageFormat) {
        return String.format("?key=%s&text=%s&lang=%s", key, text, languageFormat);
    }
}
