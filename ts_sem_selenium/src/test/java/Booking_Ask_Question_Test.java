import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Booking_Ask_Question_Test {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chromedriver.driver", "chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.booking.com/communities/new?aid=2046495;label=gen173nr-1DEgdmbGlnaHRzKIICQgVpbmRleEgzWARoOogBAZgBIbgBB8gBDNgBA-gBAfgBA4gCAagCA7gCs8GalAbAAgHSAiRmZWFmOTFkMy1lZjE1LTQyY2EtOTY0OC03YzQwNDdhZjZhMzjYAgTgAgE;sid=4cf1f956869b0fba1596705b40c8ab22;stid=304142;communities_entry_point=www-index-recommended;community_ep_ref=4281;community_page_id=11;lang=en-us&utm_campaign=booking&utm_medium=www-index&utm_source=communities_ep&;type=question");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Ask_Question(){

        String location = "Prague";
        String title = "My Adventure";
        String text = "Thank you so much.";

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
            Thread.sleep(2000);
            String act_txt = driver.findElement(By.xpath("//*[@id=\"login-needed-modal-title\"]")).getText();
            String exp_txt = "Войдите в аккаунт, чтобы продолжить";
            Assertions.assertEquals(exp_txt, act_txt);
        }
        catch(InterruptedException ie){
        }

        driver.quit();

    }
}
