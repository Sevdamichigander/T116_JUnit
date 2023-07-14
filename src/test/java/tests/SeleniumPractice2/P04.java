package tests.SeleniumPractice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class P04 {

    // Assertion islemi



    @Test
    public void testTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.google.com adresine gidip title in google icerdigini test edelim

        driver.get("https://www.google.com");
        String expectedTitleValue = "google";
        String actualTitle = driver.getTitle();

        driver.findElement(By.xpath("//*[text()='Tout refuser']")).click();

        Assert.assertFalse(actualTitle.contains(expectedTitleValue));
        driver.close();

    }
}
