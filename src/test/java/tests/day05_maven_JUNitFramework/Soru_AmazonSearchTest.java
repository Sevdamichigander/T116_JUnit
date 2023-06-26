package tests.day05_maven_JUNitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru_AmazonSearchTest {

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Samsung headphones"+ Keys.ENTER);

        WebElement result = driver.findElement(By.className("sg-col-inner"));

        String resultString = result.getText();
        System.out.println(resultString); //1-16 of 198 results for

        WebElement firstProduct = driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]"));

        firstProduct.click();

        driver.findElements(By.tagName("h2")).forEach(element -> System.out.println("Baslik: "+ element.getText()));

        driver.quit();

    }
}

/*
1- https://www.amazon.com/ sayfasina gidelim
2- arama kutusunu locate edelim
3- “Samsung headphones” ile arama yapalim
4- Bulunan sonuc sayisini yazdiralim
5- Ilk urunu tiklayalim
6- Sayfadaki tum basliklari yazdiralim
 */
