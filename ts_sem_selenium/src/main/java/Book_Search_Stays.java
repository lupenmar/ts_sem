import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book_Search_Stays {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app-header\"]/header/nav[2]/div/ul/li[1]/a")
    private WebElement buttonStays;
    @FindBy(xpath = "//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[2]/button")
    private WebElement buttonLanguage;
    @FindBy(xpath = "//*[@id=\"language-selection\"]/div/div/div/div/div/div[1]/div/div[2]/div/ul/div[1]/ul/li[3]/a")
    private WebElement changeLanguage;
    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptCookies;
    @FindBy(xpath = "//*[@id=\"ss\"]")
    private WebElement inputSearchStays;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")
    private WebElement clickOnHotel;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[4]/td[5]/span")
    private WebElement clickOn20;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[1]/td[3]")
    private WebElement clickOn1;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")
    private WebElement search;
    @FindBy(xpath = "//*[@id=\"search_results_table\"]/div/div/div/div/div[8]/div[4]/div[1]/div[2]/div/div[1]/div[1]/div/div[1]/div/h3/a/div[1]")
    private WebElement clickOnHotelCard;

    public Book_Search_Stays(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

        setAcceptCookies();

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
    public void setAcceptCookies(){this.acceptCookies.click();}
    public void setInputSearchStays(String hotel){this.inputSearchStays.sendKeys(hotel);}
    public void setClickOnHotel(){this.clickOnHotel.click();}
    public void setClickOn20(){this.clickOn20.click();}
    public void setGetClickOn1(){this.clickOn1.click();}
    public void setSearch(){this.search.click();}
    public void setClickOnHotelCard(){this.clickOnHotelCard.click();}

}
