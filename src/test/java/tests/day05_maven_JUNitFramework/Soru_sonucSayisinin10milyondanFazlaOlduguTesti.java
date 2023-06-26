package tests.day05_maven_JUNitFramework;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru_sonucSayisinin10milyondanFazlaOlduguTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com/");

        WebElement cookies = driver.findElement(By.xpath("//*[text()='Tout refuser']"));
        cookies.click();

        Assert.assertTrue(driver.getTitle().contains("Google"));

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Nutella");
        searchBox.submit();

        WebElement resultStats = driver.findElement(By.id("result-stats"));
        String result = resultStats.getText();

        System.out.println("Sonuc: " + result); //Environ 184000000 résultats (0,30 secondes)

        String sonuc = result.substring(8,19);
        System.out.println(sonuc);
        String bosluksuzSonuc = sonuc.replaceAll(" ", ""); // 121 000 000
        System.out.println("bosluksuz sonuc :" + bosluksuzSonuc);
        int sonucInt = Integer.parseInt(bosluksuzSonuc);
        System.out.println(bosluksuzSonuc);


        Assert.assertTrue(sonucInt>(10000000));



        driver.quit();
    }

}

/*
1- C01_TekrarTesti isimli bir class olusturun
2- https://www.google.com/ adresine gidin
3- cookies uyarisini kabul ederek kapatin
4- Sayfa basliginin “Google” ifadesi icerdigini test edin
5- Arama cubuguna “Nutella” yazip aratin
6- Bulunan sonuc sayisini yazdirin
7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
8- Sayfayi kapatin

 */



