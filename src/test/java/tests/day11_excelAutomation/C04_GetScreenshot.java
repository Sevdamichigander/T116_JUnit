package tests.day11_excelAutomation;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenshot extends TestBase {
    @Test
    public void test01() throws IOException {

        // amazon ansayfaya gidin
        driver.get("https://www.amazon.com");

        //Nutella icin arama yaptirin

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        //Sonuclarin Nutella icerdigini test edin

        WebElement resultElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedResult = "Nutella";
        String actualSonucYazisi = resultElementi.getText();

        // Tum sayfa fotografini cekmek icin 4 adima ihtiyac var

        // 1.adim : driver'i takeScereenshot objesine cast edelim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim : ekran resminin kaydedilecegi bir file olusturalim
        File tumSayfaSS = new File("target/ekranScreenshot/tumsayfaSS.png");

        // 3.adim tss objesini kullanarak screenshot alalim ve gecici bir dosyaya kaydedelim

        File geciciDosya= tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, olusturdugumuz tumSayfaSS'e kopyalayalim

        FileUtils.copyFile(geciciDosya,tumSayfaSS);

        Assert.assertTrue(actualSonucYazisi.contains(expectedResult));










    }
}
