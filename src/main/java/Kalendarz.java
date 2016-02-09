import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by agnieszka.bak on 2016-01-26.
 */
public class Kalendarz {

    @FindBy(how = How.NAME, name = "EntryTime")
    private WebElement startTimeInput;

    @FindBy(how = How.NAME, name = "EntryDate")
    private WebElement startDateInput;

    @FindBy(how = How.NAME, name = "ExitTime")
    private WebElement endTimeInput;

    @FindBy(how = How.NAME, name = "ExitDate")
    private WebElement endDateInput;

    @FindBy(how = How.NAME, name="Submit")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, xpath = "//span[@class='SubHead']")
    private WebElement results;

    public WebDriver chromeDriver;

    public Kalendarz() {
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("http://adam.goucher.ca/parkcalc");
        initElements(chromeDriver, this);
    }

    public String getResult() {
        return results.getText();
    }

    public Kalendarz setStartDate(String startDate) {
        startDateInput.clear();
        startDateInput.sendKeys(startDate);
        return this;
    }

    public Kalendarz setStartTime(String startTime) {
        startTimeInput.clear();
        startTimeInput.sendKeys(startTime);
        return this;
    }

    public Kalendarz setEndDate(String endDate) {
        endDateInput.clear();
        endDateInput.sendKeys(endDate);
        return this;
    }

    public Kalendarz setEndTime(String endTime) {
        endTimeInput.clear();
        endTimeInput.sendKeys(endTime);
        return this;
    }

    public void submit() {
        submitButton.click();
    }

    public void quit() {
        chromeDriver.quit();
    }
}

