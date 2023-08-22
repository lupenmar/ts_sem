import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Booking_Like_And_Saved_Test {

    WebDriver driver;

    @BeforeEach
    public void setUp(){

        System.setProperty("webdriver.chromedriver.driver", "chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.booking.com/flights/index.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Booking_Like_And_Saved_Test(){

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

        Booking_Like_And_Saved search_stays = new Booking_Like_And_Saved(driver);

        search_stays.clickButtonStays();

        search_stays.clickButtonLanguage();

        search_stays.buttonChangeLanguage();

        try{
            Thread.sleep(10000);
            search_stays.buttonPicturePrague();
        }
        catch(InterruptedException ie){
        }

        search_stays.clickLike();

        search_stays.buttonSavedMessage();

        search_stays.myCollection();

        try{
            Thread.sleep(5000);
            String actual_txt = driver.findElement(By.cssSelector("body > div.c-container.c-container-padding > div.community-grid > main > div > h3")).getText();
            String expecteed_txt = "1 posts collected";
            Assertions.assertEquals(expecteed_txt, actual_txt);
        }
        catch(InterruptedException ie){
        }

        driver.quit();

    }



}
