package rest.rest_ui;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
    }
}
