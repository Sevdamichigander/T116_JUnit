package tests.SeleniumPractice2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P05 extends TestBase {
    @Test
    public void test01(){

        // Kullanici https://www.google.com adresine gider

        driver.get("https://www.google.com");

        // Çıkıyorsa Kullanici cookies i reddeder

        driver.findElement(By.xpath("//*[text()='Tout refuser']")).click();

        // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer

        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("USD to TL" + Keys.ENTER);


        // Para birimlerinin karsilastirmasini alin(usd to tl)

        WebElement resultElement= driver.findElement(By.xpath("//*[@class='DFlfde SwHCTb']"));
        String result=resultElement.getText().replaceAll(",",".");
        double sonuc =Double.parseDouble(result);
        Assert.assertTrue(sonuc<27.0);

        if (sonuc<27){
            System.out.println("Çok şükür 27 olmadı daha");
        }else{
            System.out.println("Allah Yardımcımız olsun");
        }

        driver.close();

        // yorum yapılabilir



    }

}
