package tests.day09_Actions_FileTestleri;

import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistsTest extends TestBase {
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. logo.png dosyasını indirelim
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='avatar.png']")).click();
        bekle(3);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        //once dosyanin indirilecegi dosya yolunu dinamik olarak olusturalim.

        String dinamikDosyaYolu = System.getProperty("user.home" + "\\Downloads\\avatar.png");
    }
    @Test
    public void masaustu(){
        // avatar resmini masaustune kopyalayin
        // masaustunde avatar dosyasi oldugunu test edin
        String dinamikDosyaYolu= System.getProperty("user.home") + "/Desktop/avatar.png";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
