import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Booking_Change_Language_Test {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chromedriver.driver", "chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.booking.com/flights/index.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void changeLanguageTest(){

       Booking_Change_Language changeLanguage = new Booking_Change_Language(driver);

       changeLanguage.clickButtonChangeLanguage();
       changeLanguage.clickChangeLanguageCesky();

       String act_txt = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[1]/div[1]")).getText();

        try{
            Thread.sleep(5000);
            String exp_txt = "Snadné porovnání a rezervace letů";
            Assertions.assertEquals(exp_txt, act_txt);
        }
        catch(InterruptedException ie){
        }

        driver.quit();
    }
}
