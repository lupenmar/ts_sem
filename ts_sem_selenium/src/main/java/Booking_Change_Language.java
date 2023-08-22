import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booking_Change_Language {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app-header\"]/header/nav[1]/div[2]/div[1]/span/button")
    private WebElement buttonChangeLanguage;
    @FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div/div/ul[8]/li[4]/button")
    private WebElement changeLanguageCesky;

    public Booking_Change_Language(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public void clickButtonChangeLanguage(){
        this.buttonChangeLanguage.click();
    }
    public void clickChangeLanguageCesky(){this.changeLanguageCesky.click();}
}

