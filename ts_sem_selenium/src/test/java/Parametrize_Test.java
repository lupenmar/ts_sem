import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Parametrize_Test {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chromedriver.driver", "chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @ParameterizedTest(name = "In this site exist user with {0} email and {1} password")
    @CsvSource({"mrg.lupenko@gmail.com, lupenmar_2022S, https://www.booking.com/flights/index.html?auth_success=1", "mstoha123456@gmail.com, qwelqewle2323M, https://www.booking.com/flights/index.html?auth_success=1"})
    public void LogInParametrizeTest(String email, String password, String expUrl){

        driver.get("https://www.booking.com/flights/index.html");
        Booking_Login booking_login = new Booking_Login(driver);
        booking_login.buttonRegister();
        booking_login.fillEmail(email);
        booking_login.sendEmailButton();
        booking_login.fillPassword(password);

        booking_login.sendPasswordButton();

        try{
            Thread.sleep(5000);
            Assertions.assertEquals(expUrl, driver.getCurrentUrl());
        }
        catch(InterruptedException ie){
        }
    }

    @ParameterizedTest(name = "City from {0} city to {1}")
    @CsvSource({"Madrid, Rome, https://flights.booking.com/flights/MAD-ROM/?type=ROUNDTRIP&adults=1&cabinClass=ECONOMY&children=&from=MAD&to=ROM&fromCountry=ES&toCountry=IT&fromLocationName=%D0%90%D1%8D%D1%80%D0%BE%D0%BF%D0%BE%D1%80%D1%82+%D0%9C%D0%B0%D0%B4%D1%80%D0%B8%D0%B4-%D0%91%D0%B0%D1%80%D0%B0%D1%85%D0%B0%D1%81&toLocationName=%D0%A0%D0%B8%D0%BC&depart=2022-05-20&return=2022-06-01&sort=BEST&aid=304142&label=gen173nr-1FEgdmbGlnaHRzKIICQgVpbmRleEgzWARoOogBAZgBIbgBB8gBDNgBAegBAfgBCYgCAagCA7gCmb6QlAbAAgHSAiRjYzdhN2I3ZC0xZDM3LTRjMjMtYjhlMi04YzI4NDlmYTExZmXYAgbgAgE", "New York, Seattle, https://flights.booking.com/flights/NYC-SEA/?type=ROUNDTRIP&adults=1&cabinClass=ECONOMY&children=&from=NYC&to=SEA&fromCountry=US&toCountry=US&fromLocationName=New+York&toLocationName=Seattle&depart=2022-05-20&return=2022-06-01&sort=BEST&aid=304142&label=gen173nr-1FEgdmbGlnaHRzKIICQgVpbmRleEgzWARoOogBAZgBIbgBB8gBDNgBAegBAfgBCYgCAagCA7gCmb6QlAbAAgHSAiRjYzdhN2I3ZC0xZDM3LTRjMjMtYjhlMi04YzI4NDlmYTExZmXYAgbgAgE", "Berlin, Antalya, https://flights.booking.com/flights/BER-AYT/?type=ROUNDTRIP&adults=1&cabinClass=ECONOMY&children=&from=BER&to=AYT&fromCountry=DE&toCountry=TR&fromLocationName=%D0%90%D1%8D%D1%80%D0%BE%D0%BF%D0%BE%D1%80%D1%82+%D0%91%D0%B5%D1%80%D0%BB%D0%B8%D0%BD+%D0%91%D1%80%D0%B0%D0%BD%D0%B4%D0%B5%D0%BD%D0%B1%D1%83%D1%80%D0%B3&toLocationName=Antalya+Airport&depart=2022-05-20&return=2022-06-01&sort=BEST&aid=304142&label=gen173nr-1FEgdmbGlnaHRzKIICQgVpbmRleEgzWARoOogBAZgBIbgBB8gBDNgBAegBAfgBCYgCAagCA7gCmb6QlAbAAgHSAiRjYzdhN2I3ZC0xZDM3LTRjMjMtYjhlMi04YzI4NDlmYTExZmXYAgbgAgE"})
    public void booking_Search_Flights_Test(String where_from, String where_to, String expUrl) throws InterruptedException {

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
        Thread.sleep(1000);
        booking_search_flights.setClickon20();

        //click button date do
        Thread.sleep(2000);
        booking_search_flights.setClickButtonDateDO();

        //click on the date od
        Thread.sleep(2000);
        booking_search_flights.setClickon1();

        //button search
        booking_search_flights.buttonSearch();

        Assertions.assertEquals(expUrl, driver.getCurrentUrl());
    }

    @ParameterizedTest(name = "Hotel {0} name")
    @CsvSource({"Alcron Hotel Prague", "Majestic Plaza Hotel Prague", "Don Giovanni Hotel Prague - Great Hotels of The World"})
    public void searching_hotel_test(String hotel) {

        driver.get("https://www.booking.com/flights/index.html");

        Book_Search_Stays search_stays = new Book_Search_Stays(driver);
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

        try{
            Thread.sleep(1000);
            search_stays.setClickOnHotelCard();
        }
        catch(InterruptedException ie){
        }

        String act_txt = driver.findElement(By.xpath("//*[@id=\"search_results_table\"]/div/div/div/div/div[8]/div[4]/div[1]/div[2]/div/div[1]/div[1]/div/div[1]/div/h3/a/div[1]")).getText();

        Assertions.assertEquals(hotel, act_txt);

    }

    @ParameterizedTest(name = "Ask with city {0}, title {1}, text {2}")
    @CsvSource({"Prague, My Adventure, Thank you so much", "New York, Hello World, Its ok", "Berlin, Nevim co rict, Tady bude text"})
    public void Ask_Question_Test(String location, String title, String text){
        driver.get("https://www.booking.com/communities/new?aid=2046495;label=gen173nr-1DEgdmbGlnaHRzKIICQgVpbmRleEgzWARoOogBAZgBIbgBB8gBDNgBA-gBAfgBA4gCAagCA7gCs8GalAbAAgHSAiRmZWFmOTFkMy1lZjE1LTQyY2EtOTY0OC03YzQwNDdhZjZhMzjYAgTgAgE;sid=4cf1f956869b0fba1596705b40c8ab22;stid=304142;communities_entry_point=www-index-recommended;community_ep_ref=4281;community_page_id=11;lang=en-us&utm_campaign=booking&utm_medium=www-index&utm_source=communities_ep&;type=question");

        Booking_Ask_Question ask_question = new Booking_Ask_Question(driver);

        ask_question.setAcceptCookies();
        ask_question.setAddLocation(location);
        ask_question.setAddTitle(title);
        ask_question.setAddMainText(text);

        try{
            Thread.sleep(5000);
            ask_question.setSendButton();
        }
        catch(InterruptedException ie){
        }

        try{
            Thread.sleep(1000);
            String exp_txt = "Войдите в аккаунт, чтобы продолжить";
            String act_txt = driver.findElement(By.xpath("//*[@id=\"login-needed-modal-title\"]")).getText();
            Assertions.assertEquals(exp_txt, act_txt);
        }
        catch(InterruptedException ie){
        }
    }



}
