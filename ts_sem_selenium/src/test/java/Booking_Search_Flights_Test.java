import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Booking_Search_Flights_Test {
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chromedriver.driver", "chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.booking.com/flights/index.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Booking_Search_Test(){

        String where_from = "Madrid";
        String where_to = "Rome";
        driver.get("https://www.booking.com/flights/index.ru.html?aid=304142&label=gen173nr-1DEgdmbGlnaHRzKIICQgVpbmRleEgzWARoOogBAZgBIbgBB8gBDNgBA-gBAYgCAagCA7gCmb6QlAbAAgHSAiRjYzdhN2I3ZC0xZDM3LTRjMjMtYjhlMi04YzI4NDlmYTExZmXYAgTgAgE&sid=6620f8f03042241a12580c9c642a9483");

        Booking_Search_Flights booking_search_flights = new Booking_Search_Flights(driver);

        //click button where from
        booking_search_flights.clickButtonWhereFrom();

        //delete default city
        booking_search_flights.deleteDefaultValues();

        //input city where from
        booking_search_flights.inputWhereFrom(where_from);

        //checkbox where from
        booking_search_flights.setClickOnWhereFrom();

        //input city where from
        booking_search_flights.inputWhereTo(where_to);

        //checkbox where from
        booking_search_flights.checkBoxWhereTo();

        //click button date od
        booking_search_flights.setClickButtonDateOd();

        //click on the date od
        booking_search_flights.setClickon20();

        //click button date do
        booking_search_flights.setClickButtonDateDO();

        //click on the date od
        booking_search_flights.setClickon1();

        //button search
        booking_search_flights.buttonSearch();

        try{
            Thread.sleep(5000);
            String expUrl = "https://flights.booking.com/flights/MAD-ROM/?type=ROUNDTRIP&adults=1&cabinClass=ECONOMY&children=&from=MAD&to=ROM&fromCountry=ES&toCountry=IT&fromLocationName=%D0%90%D1%8D%D1%80%D0%BE%D0%BF%D0%BE%D1%80%D1%82+%D0%9C%D0%B0%D0%B4%D1%80%D0%B8%D0%B4-%D0%91%D0%B0%D1%80%D0%B0%D1%85%D0%B0%D1%81&toLocationName=%D0%A0%D0%B8%D0%BC&depart=2022-05-20&return=2022-06-01&sort=BEST&aid=304142&label=gen173nr-1DEgdmbGlnaHRzKIICQgVpbmRleEgzWARoOogBAZgBIbgBB8gBDNgBA-gBAYgCAagCA7gCmb6QlAbAAgHSAiRjYzdhN2I3ZC0xZDM3LTRjMjMtYjhlMi04YzI4NDlmYTExZmXYAgTgAgE";
            Assertions.assertEquals(expUrl, driver.getCurrentUrl());
        }
        catch(InterruptedException ie){
        }

        driver.quit();

    }
}
