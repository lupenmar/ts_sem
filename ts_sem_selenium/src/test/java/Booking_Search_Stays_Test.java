import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class Booking_Search_Stays_Test {

    WebDriver driver;

//    Old Town Square Apartments
//
//    Majestic Plaza Hotel Prague
//
//    Alcron Hotel Prague

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chromedriver.driver", "chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.booking.com/flights/index.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Search_Stays_Test(){

        Book_Search_Stays search_stays = new Book_Search_Stays(driver);
        String hotel = "Majestic Plaza Hotel Prague";
        search_stays.clickButtonStays();
        search_stays.clickButtonLanguage();
        search_stays.buttonChangeLanguage();
        search_stays.setInputSearchStays(hotel);
        search_stays.setClickOnHotel();


        try{
            Thread.sleep(5000);
            search_stays.setClickOn20();
        }
        catch(InterruptedException ie){
        }

        search_stays.setGetClickOn1();
        search_stays.setSearch();

        search_stays.setClickOnHotelCard();

        String exp_txt = "Majestic Plaza Hotel Prague";
        String act_txt = driver.findElement(By.xpath("//*[@id=\"search_results_table\"]/div/div/div/div/div[8]/div[4]/div[1]/div[2]/div/div[1]/div[1]/div/div[1]/div/h3/a/div[1]")).getText();

        Assertions.assertEquals(exp_txt, act_txt);

        driver.quit();

    }



}
