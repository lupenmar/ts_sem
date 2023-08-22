import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booking_Like_And_Saved {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app-header\"]/header/nav[2]/div/ul/li[1]/a")
    private WebElement buttonStays;
    @FindBy(xpath = "//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[2]/button")
    private WebElement buttonLanguage;
    @FindBy(xpath = "//*[@id=\"language-selection\"]/div/div/div/div/div/div[1]/div/div[2]/div/ul/div[1]/ul/li[3]/a")
    private WebElement changeLanguage;
    @FindBy(xpath = "//*[@id=\"basiclayout\"]/div[13]/div[2]/ul/li[1]/a/div[2]/h3")
    private WebElement picturePrague;
    @FindBy(xpath = "/html/body/div[5]/div/main/div[1]/div/div[2]/div[1]/div[1]/div[5]/div/div[5]/div/a")
    private WebElement like;
    @FindBy(xpath = "/html/body/div[5]/div/main/div[1]/div/div[2]/div[1]/div[1]/div[5]/div/div[4]/div/a")
    private WebElement buttonSavedMessage;
    @FindBy(xpath = "/html/body/div[5]/div/main/div[1]/div/div[2]/div[1]/div[2]/a")
    private WebElement myCollection;

    public Booking_Like_And_Saved(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public void clickButtonStays(){
        this.buttonStays.click();
    }
    public void clickButtonLanguage(){
        this.buttonLanguage.click();
    }
    public void buttonChangeLanguage(){
        this.changeLanguage.click();
    }
    public void buttonPicturePrague(){
        this.picturePrague.click();
    }
    public void clickLike(){
        this.like.click();
    }
    public void buttonSavedMessage() {
        this.buttonSavedMessage.click();
    }
    public void myCollection() {
        this.myCollection.click();
    }
}
