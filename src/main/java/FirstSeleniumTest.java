import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by agnieszka.bak on 2016-01-25.
 */

public class FirstSeleniumTest {

    ChromeDriver ff;
    Google g;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ff = new ChromeDriver();
        g = new Google(ff);

    }

    @Test
    public void test() {
        g.open();
        ff.findElementByName("EntryTime").clear();
        ff.findElementByName("EntryTime").sendKeys("3:00");
        ff.findElementByName("EntryDate").clear();
        ff.findElementByName("EntryDate").sendKeys("1/26/2016");
        ff.findElementByName("ExitTime").sendKeys("10:00");
        ff.findElementByName("ExitDate").clear();
        ff.findElementByName("ExitDate").sendKeys("1/27/2016");
        ff.findElementByName("Submit").click();





    }

    @After
    public void tearDown() {ff.close();
    }
   }
