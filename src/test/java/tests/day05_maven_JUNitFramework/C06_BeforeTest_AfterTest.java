package tests.day05_maven_JUNitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BeforeTest_AfterTest {

    WebDriver driver;


    @Test
    public void amazonTesti() {

        /*
        JUnit framework unde bir class veya test method u calistirildiginda
        JUnit tum class veya istenen methodun sorunsuz olarak sonuna kadar calisip calismadigini kontrol eder.
            - Sorunsuz calisirsa test passed
            - kodlar sorun ciktigi icin calistirilamazsa test failed olarak isaretlenir.

            Test fail olsa bile devam edebilmesi icin exception firlattik.
                        throw new RuntimeException();

         Eger if else ile yaptigimiz testlerde JUnit raporlarinin da test sonuclari ile uyumlu olmasini istersek
         FAILED durumlarinda throw keyword ile herhangi bir exception firlatabiliriz.



         */

        // amazon a gidelim ve url in amazon icerdigini test edip
        // sayfayi kapatalim

        setUp();

        driver.get("https://www.amazon.com");

        String expectedUrlElement = "Ramazon";
        String actualUrlElement = driver.getCurrentUrl();

        if (actualUrlElement.contains(expectedUrlElement)) {
            System.out.println("Amazon icerik testi passed");
        }
        else {
            System.out.println("Amazon icerik testi failed");

            throw new RuntimeException();
        }
        driver.close();
    }

    @Test
    public void WiseQuarterTesti() {
        //WiseQuarter ana sayfaya gidip
        //title in "Wise Quarter" icerdigini test edin ve sayfayi kapatin

        setUp();

        driver.get("https://www.wisequarter.com");

        String expectedValueTitleElement = "Wise QuarterS";

        String actualValueTitleElement = driver.getTitle();

        if (actualValueTitleElement.contains(expectedValueTitleElement)) {
            System.out.println("Title value test passed");
        }
        else {
            System.out.println("Title value test failed");
            throw new RuntimeException();

        }
        driver.close();
    }

    @Test
    public void youtubeTest() {
        setUp();
        driver.get("https://www.youtube.com");

        //Youtube anasayfaya gidin.
        //Title in youtube oldugunu test edin

        String expectedTitleYoutube = "YouTube";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitleYoutube)) {
            System.out.println("Youtube testi passed");
        }
        else {
            System.out.println("Youtube testi failed");
            throw new RuntimeException();
        }

        driver.close();

    }

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}
