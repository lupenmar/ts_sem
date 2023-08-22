import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booking_Ask_Question {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptCookies;
    @FindBy(xpath = "//*[@id=\"ss\"]")
    private WebElement addLocation;
    @FindBy(xpath = "//*[@id=\"comm-form-field-text-2-input\"]")
    private WebElement addTitle;
    @FindBy (xpath = "//*[@id=\"comm-form-field-rich-html-1-input\"]")
    private WebElement addMainText;
    @FindBy (xpath = "/html/body/div[3]/div[2]/main/div/div/form/div[9]/button")
    private WebElement sendButton;


    public Booking_Ask_Question(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

        setAcceptCookies();

    }

    public void setAcceptCookies(){this.acceptCookies.click();}
    public void setAddLocation(String location){this.addLocation.sendKeys(location);}
    public void setAddTitle(String title){this.addTitle.sendKeys(title);}
    public void setAddMainText(String text){this.addMainText.sendKeys(text);}
    public void setSendButton(){this.sendButton.click();}
}
