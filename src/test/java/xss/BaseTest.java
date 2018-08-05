package xss;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
    }

    public ArrayList<String> getCheatSheetAlert() {
        ArrayList arrayListXSS = new ArrayList();
        try {
            FileInputStream fstream = new FileInputStream("src/test/resources/xss/CheatSheetAlert.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                arrayListXSS.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayListXSS;
    }
}
