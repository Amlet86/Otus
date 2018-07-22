package rest.rest_ui;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        Configuration.reportsFolder = "target/rest-ui-results";
        Configuration.browser = "chrome";
    }
}
