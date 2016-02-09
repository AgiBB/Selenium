
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by agnieszka.bak on 2016-01-26.
 */

@RunWith(Parameterized.class)
public class KalendarzTest {

    Kalendarz kalendarz;
    private String assumedResult;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;

    public KalendarzTest(String assumedResult, String startDate, String startTime, String endDate, String endTime){
        this.assumedResult = assumedResult;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
    }

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        kalendarz = new Kalendarz();
    }

    @Test
    public void testBasicCalendarBehavior() {
        kalendarz.setStartDate(startDate)
                .setStartTime(startTime)
                .setEndDate(endDate)
                .setEndTime(endTime)
                .submit();
        assertEquals(assumedResult, kalendarz.getResult());
    }

    @After
    public void tearDown() {
        kalendarz.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
            new Object[]{"$ 40.00", "1/26/2016", "3:00", "1/27/2016", "10:00"},
            new Object[]{"","","","",""}
        );
    }
}