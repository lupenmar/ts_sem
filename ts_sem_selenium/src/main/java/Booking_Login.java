import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Booking_Login {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptCookies;
    @FindBy(xpath ="//*[@id=\"app-header\"]/header/nav[1]/div[2]/div[1]/span/button")
    private WebElement butttonLanguage;
    @FindBy(xpath = "//*[ text() ='English (US)']")
    private WebElement changeLanguage;
    @FindBy(xpath = "//*[@id=\"app-header\"]/header/nav[1]/div[2]/div[3]/a")
    private WebElement btnRegister;
    @FindBy(xpath = "//*[@id=\"app-header\"]/header/nav[1]/div[2]/div[3]/a")
    private WebElement  buttonRegister;
    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement email;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement pass;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement pass_nevalid;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/form/div[3]/button")
    private WebElement sendEmailButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/form/button")
    private WebElement sendPasswordButton;

    public Booking_Login(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

        acceptCookies();

    }

    public void setButttonLanguage() {
        this.butttonLanguage.click();
    }

    public void setChangeLanguage(){
        this.changeLanguage.click();
    }

    public void setBtnRegister(){
        this.btnRegister.click();
    }

    public void fillEmail(String email){
        this.email.sendKeys(email);
    }

    public void fillPassword(String password){
        this.pass.sendKeys(password);
    }
    public void fillPasswordNevalid(String nevalid_password){
        this.pass_nevalid.sendKeys(nevalid_password);
    }
    public void sendEmailButton(){
        this.sendEmailButton.click();
    }
    public void sendPasswordButton(){
        this.sendPasswordButton.click();
    }
    public void acceptCookies(){this.acceptCookies.click();}
    public void buttonRegister(){this.buttonRegister.click();}

}
