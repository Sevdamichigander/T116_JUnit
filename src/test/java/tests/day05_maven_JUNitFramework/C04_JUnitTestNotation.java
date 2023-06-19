package tests.day05_maven_JUNitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_JUnitTestNotation {

    //BIr class da 3 farkli test olsa ve ben testleri istersem toplu, istersem bagimsiz olarak calistirabilsem

    /*
    JUnit in bize kazandirdigi en onemli yeniliklerden biri @Test annotation dir.
    Kucuk bilgiler barindiran yapilardir. Buna da meta data denir.Sadece ir yazi/gosterim degillerdir.
    Yaptiklari islemler vardir.

    @Test ==> siradan bir method u tek basina calistirilabilir bir test methoduna donusturur.

    JUnit ile test methodlari istersek tek basina istersek de class level dan calistirilip
     tum testlerin birlikte run edilebilecegi bir yapiya donusur.

     JUnit class icerisindeki test methodlarini belirsiz bir sirada calistirir.
     Test methodlarinin hangi sira ile calisacagini ONGOREMEYIZ ve DUZENLEYEMEYIZ.
     Test isimlerini 01,02 seklinde verince o siraya gore calisiyormus.



     */

    @Test
    public void amazonTesti(){

        // amazon a gidelim ve url in amazon icerdigini test edip
        // sayfayi kapatalim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        String expectedUrlElement = "Ramazon";
        String actualUrlElement = driver.getCurrentUrl();

        if (actualUrlElement.contains(expectedUrlElement)){
            System.out.println("Amazon icerik testi passed");
        }else{
            System.out.println("Amazon icerik testi failed");

        }

        driver.close();
    }

    @Test
    public void WiseQuarterTesti(){
        //WiseQuarter ana sayfaya gidip
        //title in "Wise Quarter" icerdigini test edin ve sayfayi kapatin

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.wisequarter.com");

        String expectedValueTitleElement = "Wise QuarterS";

        String actualValueTitleElement = driver.getTitle();

        if (actualValueTitleElement.contains(expectedValueTitleElement)){
            System.out.println("Title value test passed");
        }else{
            System.out.println("Title value test failed");
        }
        driver.close();
    }

}
