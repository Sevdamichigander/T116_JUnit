package tests.day06_JUnitFramework_CheckBox_RadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
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
        driver.get("https://www.bestbuy.com/");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    //https://www.bestbuy.com/ Adresine gidin
    // Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin

    @Test
    public void urlTest(){

        String expectedUrl = "https://www.bestbuy.com/";

        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Test
    public void titleTest(){
        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String unexpectedTitleContains = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unexpectedTitleContains));

    }

    @Test
    public void logoTest(){

        //BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("//a[@title='BestBuy.com']"));

        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void francaisLinkTest() {

        WebElement francaisLink = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francaisLink.isDisplayed());
    }


}

/*
https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
 ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
 ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
 ○ logoTest => BestBuy logosunun görüntülendigini test edin
 ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
 */