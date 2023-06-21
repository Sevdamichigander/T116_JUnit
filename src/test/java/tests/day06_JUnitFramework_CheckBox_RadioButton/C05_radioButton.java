package tests.day06_JUnitFramework_CheckBox_RadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C05_radioButton {

    static WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");


    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://facebook.com");

         //   b. Cookies’i kabul/red edin

        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_only_essential_button']"));

        // *  c. Create an account buton’una basin


        Actions act =  new Actions(driver);
        act.moveToElement( driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"))).click().perform();

        //  *  d. Radio button elementlerini locate edin ve size uygun olani secin

        WebElement kadinRadioButton = driver.findElement(By.xpath(("(//input[@name='sex'])[1]")));
        WebElement erkekRadioButton = driver.findElement(By.xpath(("(//input[@name='sex'])[2]")));
        WebElement digerRadioButton = driver.findElement(By.xpath(("(//input[@name='sex'])[3]")));

    }
}

/**
 * a. Verilen web sayfasına gidin.
 *      https://facebook.com
 *  b. Cookies’i kabul edin
 *  c. Create an account buton’una basin
 *  d. Radio button elementlerini locate edin ve size uygun olani secin
 *  e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
 */
/*
@Test
    public void test01(){
        //  a. Verilen web sayfasına gidin.
        //       https://facebook.com
        driver.get("https://facebook.com");
        //  b. Cookies’i kabul edin
        driver.findElement(By.xpath("//button[@title='Allow all cookies']")).click();
        //  c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //  d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement kadinRadioButton= driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
        WebElement erkekRadioButton= driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
        WebElement ozelRadioButton= driver.findElement(By.xpath("(//input[@name='sex'])[3]"));
        erkekRadioButton.click();
        //  e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(erkekRadioButton.isSelected());
        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(ozelRadioButton.isSelected());
    }

 */