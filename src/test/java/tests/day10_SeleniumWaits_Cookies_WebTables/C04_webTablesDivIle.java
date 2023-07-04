package tests.day10_SeleniumWaits_Cookies_WebTables;

import org.bouncycastle.est.LimitedSource;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_webTablesDivIle extends TestBase {

    @Test
    public void test01() {

        // Syntax ==> ((//div[@role=‘row’])[2]/div[@role=‘gridcell’])[5]

        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin

        List<WebElement> headersElementList = driver.findElements(By.xpath("//div[@role='columnheader']"));

        for (int i = 0; i < headersElementList.size(); i++) {
            System.out.println(i+1+".sutun basligi : " + headersElementList.get(i).getText());

        }

        
        // 3. 3. sutunun basligini yazdirin

        System.out.println("3. sutun basligi : " + headersElementList.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin +
        int sayac = 0;
        List<WebElement> tablodakiTumDataList = driver.findElements(By.xpath("//div[@role='gridcell']"));

        for (WebElement eachData:tablodakiTumDataList
             ) {
            if (!eachData.getText().isBlank()){
                System.out.println(eachData.getText());
                sayac++;
            }

        }

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

        System.out.println("Bos olmayan cell sayisi :" + sayac); // Bos olmayan cell sayisi :18

        // 6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//div[@role='row']"));
        System.out.println("Tablodaki satir sayisi " + satirlarListesi.size());





        // 7. Tablodaki sutun sayisini yazdirin
        // 8. Tablodaki 3. kolonu yazdirin
        // 9. Tabloda “First Name”i Kierra olan kisinin Salary’sini yazdirin
        // 10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi
        // yazdirsin

    }
}
