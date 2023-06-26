package tests.day08_iframe_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseQuit;

import java.util.Set;

public class C04_ExempleWindow extends TestBaseQuit {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        String openingYaziElementi= driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals("Opening a new window",openingYaziElementi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String actualTitle = driver.getTitle();

        Assert.assertEquals("The Internet",actualTitle);

        // gorevde bu sayfaya geri donus oldugu icin handle degerini kaydedelim

        String ilkSayfaWHD = driver.getWindowHandle();
        System.out.println("ilk sayfa whd : " + ilkSayfaWHD);

        //● Click Here butonuna basın.

        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        /*
            KONTROLUMUZ disinda yeni bir tab veya window acilinca
            driver otomatik olarak oraya gecmez
            Yeni sayfaya gecebilmek icin ikinci sayfanin Window Handle degerini bulmaliyiz
            Bunun icin

            1- ilk sayfada iken ilkSayfaWHD'ini kaydedelim
            2- yeni sayfayi acan linki tiklayalim
            3- ilk ve ikinci sayfanin window Handle Degerlerini bir Set olarak kaydedelim
                Set<String> wHDSeti = driver.getWindowHandles();
            4- Bir for-each loop ile Set'deki window handle degerlerini
               ilk sayfanin window handle degeri ile karsilastiralim
               ilkSayfaWHD'ne esit OLMAYAN window handle degerini
               ikinciSayfaWHD olarak kaydedelim
            5- buldugumuz  ikinciSayfaWHD'ni kullanarak 2.sayfaya gecelim
         */

        Set<String> wHDSeti = driver.getWindowHandles();
        System.out.println(wHDSeti);

        String ikinciSafyaHandle="";

        for (String each: wHDSeti
        ) {
            if (!each.equals(ilkSayfaWHD)){
                ikinciSafyaHandle=each;
            }
        }

        driver.switchTo().window(ikinciSafyaHandle);

        String expectedTitle ="New Window";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Sayfadaki textin "New Window" olduğunu doğrulayın.
        String baslik = driver.findElement(By.tagName("h3")).getText();
        String expectedIcerik = "New Window";
        Assert.assertEquals(expectedIcerik,baslik);
        bekle(2);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet"
        //olduğunu doğrulayın
        driver.switchTo().window(ilkSayfaWHD);
        baslik = driver.getTitle();
        String expectedBaslik = "The Internet";
        Assert.assertEquals(expectedBaslik,baslik);

        bekle(3);
    }
}

/*
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
 */
