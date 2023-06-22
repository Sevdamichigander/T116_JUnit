package tests.day06_JUnitFramework_CheckBox_RadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C05_radioButton {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));

    }

    @After
    public void tearDown(){
        driver.close();
    }


    @Test
    public  void test01() throws InterruptedException {
        driver.get("https://facebook.com");

        //   b. Cookies’i kabul/red edin
        driver.findElement(By.xpath("//*[text()='Autoriser tous les cookies']")).click();

        // *  c. Create an account buton’una basin
        driver.findElement(By.xpath("//*[text()='Créer nouveau compte']")).click();

        //  *  d. Radio button elementlerini locate edin ve size uygun olani secin

        WebElement buttonFemme = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement buttonHomme = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement buttonPersonnalise = driver.findElement(By.xpath("//input[@value='-1']"));

        buttonFemme.click();

        Thread.sleep(3000);

        //  e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assert.assertTrue(buttonFemme.isSelected());
        Assert.assertFalse(buttonHomme.isSelected());
        Assert.assertFalse(buttonPersonnalise.isSelected());

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
