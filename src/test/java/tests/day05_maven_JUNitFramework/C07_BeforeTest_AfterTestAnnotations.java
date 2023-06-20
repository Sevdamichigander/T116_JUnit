package tests.day05_maven_JUNitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_BeforeTest_AfterTestAnnotations {
    /*
    JUnit ile class da ki her test method u calismaya baslamadan once
    calismasini istedigimiz methodlari
    @Before,
    her test methodundan sonra calismasini istedigimiz methodlari ise
    @After annotation i ile isaretleriz.

    Boylece test methodu calismaya baslarken ekstradan method call yapmaya gerek olmadan @Before methodu calisir.
    Test methodu bitince de hicbir method call olmaksizin @After annotation ina sahip method calisir.

    Bu class, class level dan calistirildiginda class ta ki methodlar toplam kac kere calismis oldu? 9 kere calisir

    before amazon after
    before wisequarter after
    before youtube after

    * Sadece youtubeTest methodunu calistirmak istesek
    before Youtube after olmak uzere 3 method calisir.



     */
    WebDriver driver;
    @Test
    public void amazonTesti(){
        // amazon'a gidelim ve url'in amazon icerdigini test edip
        setup();
        driver.get("https://www.amazon.com");
        String expectedUrlIcerik="Ramazon";
        String actualUrl= driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Amazon url testi PASSED");
        }else {
            System.out.println("Amazon url testi FAILED");
            throw new RuntimeException();
        }
        // sayfayi kapatin
        driver.close();
    }
    @Test
    public void wisequarterTesti(){
        // Wise quarter anasayfaya gidip
        setup();
        driver.get("https://www.wisequarter.com");
        // Title'in Wise Quarter icerdigini test edin
        String expectedTitleIcerik = "Wise Quarter";
        String actualTitle= driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wise Quarter title testi PASSED" );
        }else{
            System.out.println("Wise Quarter title testi FAILED" );
            throw new RuntimeException();
        }
        // ve sayfayi kapatin
        driver.close();
    }
    @Test
    public void youtubeTesti(){
        // youtube anasayfaya gidin
        setup();
        driver.get("https://www.youtube.com");
        // title'in YouTube oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Youtube Testi PASSED");
        }else{
            System.out.println("Youtube Testi FAILED");
            throw new RuntimeException();
        }
        driver.close();
    }
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

}
