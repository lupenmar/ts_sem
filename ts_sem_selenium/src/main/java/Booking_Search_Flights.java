import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booking_Search_Flights {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptCookies;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/span/div/div/div")
    private WebElement  buttonWhereFrom;
    @FindBy(xpath = "//*[@id=\"__bui-5\"]/div/div/div/div/div/div[1]/div[1]/div/div/div/div[3]")
    private WebElement defaultCity;
    @FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div[1]/div[1]/div/input")
    public WebElement inputWhereFrom;
    @FindBy(xpath = "//*[@id=\"__bui-5\"]/div/div/div/div/div/div[3]/ul/li")
    private WebElement clickOnWhereFrom;
    @FindBy(xpath = "//*[@id=\"__bui-6\"]/div/div/div/div/div/div[3]/ul/li[1]")
    public WebElement checkBoxWhereTo;
    @FindBy(xpath = "//*[@id=\"__bui-6\"]/div/div/div/div/div/div[1]/div[1]/div/input")
    private WebElement inputWhereTo;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[4]/div/div/span/div/div/div[1]/div/input")
    private WebElement clickButtonDateOd;
    @FindBy (xpath = "//*[@id=\"__bui-7\"]/div/div/div/div/div/div/div/div[1]/div/div[1]/table/tbody/tr[4]/td[5]/span")
    private WebElement clickon20;
    @FindBy (xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[4]/div/div/span/div/div/div[2]/div/input")
    private WebElement clickButtonDateDO;
    @FindBy(xpath = "//*[@id=\"__bui-7\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/table/tbody/tr[1]/td[3]/span")
    private WebElement clickon1;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/button")
    private WebElement searchButton;

    public Booking_Search_Flights(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

        acceptCookies();

    }

    public void clickButtonWhereFrom(){
        this.buttonWhereFrom.click();
    }
    public void inputWhereFrom(String where_from){
        this.inputWhereFrom.sendKeys(where_from);
    }
    public void inputWhereTo(String where_to){
        this.inputWhereTo.sendKeys(where_to);
    }

    public void checkBoxWhereTo(){
        this.checkBoxWhereTo.click();
    }

    public void buttonSearch(){this.searchButton.click();}

    public void deleteDefaultValues(){this.defaultCity.click();}

    public void acceptCookies(){this.acceptCookies.click();}

    public void setClickOnWhereFrom(){this.clickOnWhereFrom.click();}

    public void setClickButtonDateOd() {
        this.clickButtonDateOd.click();
    }

    public void setClickon20(){
        this.clickon20.click();
    }

    public void setClickButtonDateDO() {
        this.clickButtonDateDO.click();
    }

    public void setClickon1(){
        this.clickon1.click();
    }

}
