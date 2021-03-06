package jdi;

import com.blazedemo.JDIBlazeDemoSite;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends TestNGBase {

    @BeforeSuite()
    public static void setUp(){
        WebSite.init(JDIBlazeDemoSite.class);
    }
}
