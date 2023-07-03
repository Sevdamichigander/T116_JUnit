package tests.day06_JUnitFramework_CheckBox_RadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Soru_InvalidEmailTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.automationexercise.com/");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        driver.findElement(By.xpath(" //*[text()=' Signup / Login']")).click();

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("savakara"+ Keys.ENTER);

        // Uyarı mesajının görüntülenmesini bekler

        try {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-danger")));

        // Uyarı mesajını kontrol eder

        String expectedErrorMessage = "Invalid email address";
        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Test başarılı: " + actualErrorMessage);
        } else {
            System.out.println("Test başarısız: Hata mesajı beklenen değerden farklı"+actualErrorMessage);
        }
        } catch (Exception e) {
            System.out.println("Test başarısız: Uyarı mesajı görüntülenmedi.");
        }
    }
}

/*
1. Bir Class olusturalim YanlisEmailTesti
2. https://www.automationexercise.com/ sayfasina gidelim
3. Signup/Login butonuna basalim
4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid
email address” uyarisi ciktigini test edelim
*/

