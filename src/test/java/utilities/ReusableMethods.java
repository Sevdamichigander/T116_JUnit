package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ReusableMethods {

    public static String ikinciSayfaWHDegeri(String ilkSayfaWindowHandleDegeri, WebDriver driver) {

        String ikinciSayfaWindowHandleDegeri = "";

        Set<String> windowHandlesSeti = driver.getWindowHandles();

        for (String each : windowHandlesSeti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)) {
                ikinciSayfaWindowHandleDegeri = each;
            }
        }
        return ikinciSayfaWindowHandleDegeri;
    }

    public static String hucredekiYaziyiGetir(int satirNo, int sutunNo, WebDriver driver) {

        //==>       //tbody/tr[   5   ]/td[  1  ] dinamik degil

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucredekiElement = driver.findElement(By.xpath(dinamikXpath));
        return istenenHucredekiElement.getText();
    }

    public  static void tumSayfaScreenshot(WebDriver driver){

        // 1.adim : driver'i takeScreenshot objesine cast edelim

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim : ekran resminin kaydedilecegi bir file olusturalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("YYddhhmm");
        String dinamikDosyaYolu = "target/Screenshots/TumSayfa"+ldt.format(dtf)+".png";

        System.out.println(dinamikDosyaYolu);

        File tumSayfaPhoto = new File(dinamikDosyaYolu);

        /*    Dosya adini dinamik hale getirmek icin time stamp kullanalim.

              Adi su sayfa  olsun ama yanina su saatte cektigim fotografin screenshot ini al ve kopyala.

              Boylece ayni anda 1 foto cekecegi icin fotolar karismaz

               */

        // 3.adim tss objesini kullanarak screenshot alalim ve gecici bir dosyaya kaydedelim

        File geciciDosya= tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, olusturdugumuz tumSayfaSS'e kopyalayalim


        try {
            FileUtils.copyFile(geciciDosya,tumSayfaPhoto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webElementPhoto(WebDriver driver, WebElement fotosuIstenenWebElement) {

        LocalDateTime ldt = LocalDateTime.now(); // 2023-07-06T09:16:39.121372
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("YYddhhmm");
        String dinamikDosyaYolu = "target/Screenshots/webElement"+ldt.format(dtf)+".png";

        File webElementPhoto = new File(dinamikDosyaYolu);

        File geciciDosya = fotosuIstenenWebElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya, webElementPhoto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
