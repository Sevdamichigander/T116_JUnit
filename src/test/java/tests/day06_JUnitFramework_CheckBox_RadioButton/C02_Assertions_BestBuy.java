package tests.day06_JUnitFramework_CheckBox_RadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions_BestBuy {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    //https://www.bestbuy.com/ Adresine gidin
    // Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin

    @Test
    public void test01(){
        driver.get("https://www.bestbuy.com/");

        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("https://www.bestbuy.com/",(actualUrl));

    }
    @Test
    public void test02(){
        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String expectedTitleContains = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(expectedTitleContains, Boolean.parseBoolean(actualTitle));

    }


}

/*
https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
 ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
 ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
 ○ logoTest => BestBuy logosunun görüntülendigini test edin
 ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
 */
