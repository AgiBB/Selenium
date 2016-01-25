import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by agnieszka.bak on 2016-01-25.
 */
public class Google {

    @FindBy(id = "lst-ib")
    public WebElement gs;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"rso\"]/div/div[1]/div/h3/a")
    public WebElement firstResults;

    public WebDriver ff;

    public Google(WebDriver ff) {
        PageFactory.initElements(ff, this);
        this.ff = ff;
    }

    public  void typeIntoSearch(String s) {
        gs.sendKeys(s);
    }

    public  void sendEnter() {
        gs.sendKeys(Keys.RETURN);
    }

    public void open() {
        ff.get("http://google.pl");
    }

    public WebElement getFirstResult() {
        return firstResults;
    }
    public boolean isVisible(){
        return gs.isDisplayed();
    }
}
