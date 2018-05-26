package jdi;

import org.testng.annotations.Test;

import static com.blazedemo.JDIBlazeDemoSite.*;

public class JDITest extends BaseTest {

    @Test
    public void buyTicket() {
        findFlightsPage.open();
        findFlightsFromTo();

    }
}
