import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Boking_Sign_In_Test {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chromedriver.driver", "chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.booking.com/flights/index.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Sign_In_ValidEmailandPass(){

        String email = "mrg.lupenko@gmail.com";
        String password = "lupenmar_2022S";
        driver.get("https://www.booking.com/flights/index.html");

        Booking_Login login = new Booking_Login(driver);

        //button register
        login.buttonRegister();

        //fill login
        login.fillEmail(email);

        //send form
        login.sendEmailButton();

        //fill pass
        login.fillPassword(password);

        //send form
        login.sendPasswordButton();

        try{
            Thread.sleep(5000);
            String expUrl = "https://www.booking.com/flights/index.html?auth_success=1";
            Assertions.assertEquals(expUrl, driver.getCurrentUrl());
        }
        catch(InterruptedException ie){
        }

        driver.quit();

    }

    @Test
    public void Sign_In_ValidEmailandNevalidPass(){

        String email = "mrg.lupenko@gmail.com";
        String password = "lupenmar_201212";

        Booking_Login login = new Booking_Login(driver);

        //click on button language
        login.setButttonLanguage();

        //change language
        login.setChangeLanguage();

        //button register
        login.setBtnRegister();

        //fill login
       login.fillEmail(email);

       //send form
        login.sendEmailButton();

        //fill pass
        login.fillPasswordNevalid(password);

        //send form
        login.sendPasswordButton();

        WebElement element = driver.findElement(By.cssSelector("#password-note"));

        String error = element.getText();

        String expected_error = "The email and password combination entered doesn't match.";

        //ASSERT
        assertEquals(expected_error, error);

        driver.quit();

    }
}
