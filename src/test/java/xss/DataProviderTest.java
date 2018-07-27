package xss;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest extends BaseTest {

    @Test(dataProvider = "xssTests")
    public void test(String name, String xssQuery) {

    }

    @DataProvider(name = "xssTests")
    private Object[][] xssDataProvider() {

        return new Object[][]{
            {"email", "<script>alert(\"xx\");</script>"},
            {"email", "<script>alert(\"xx\");</script>"},
            {"email", "<script>alert(\"xx\");</script>"}
        };
    }
}
