import junit.framework.Assert;
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
        g.typeIntoSearch("some text");
        g.sendEnter();
        String first = g.getFirstResult().getText();
        System.out.println("Found: " + first);
        Assert.assertEquals("Lorem Ipsum - All the facts - Lipsum generator", first);
    }

    @After
    public void tearDown() {
        ff.close();
    }
}
