package tests.day11_excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/test/java/tests/day11_excelAutomation/ulkeler.xlsx";

        // System.out.println(System.getProperty("user.dir"));
        // projemizin icinde oldugu icin bu islemi yapmaya gerek yok

        //Eger excel dosyasi proje icerisinde degil de masaustu/downloads gibi baska bir klasorun icinde ise
        // dosya yolu dinamik hale getirilebilir.

        FileInputStream fis = new FileInputStream(dosyaYolu); // bu satirda dosya yolunu okuyup fis e kaydedecek

        Workbook workbook = WorkbookFactory.create(fis);    // fis te ki bilgileri workbook a yukluyor.

        // 22. satirdaki dosyaya gitti okudu geldi ve bunu workbook a kopyaladi.

        // interface oldugu icin new deyip obje olusturamayiz.

        /*

        Olusturdugumuz workbook bizim excel imizi canli olarak kullanmaz
        24. satir calistiginda fis te ki (verdigimiz dosya yolunda olan excel de ki)
        tum bilgileri alip bu class ta olusturdugumuz workbook objesine yukler.

        Yani workbook objesi excel de ki bilgilerin bir kopyasina sahip olur.
        Workbook ta bir degisiklik yaparsak ana excel DEGISMEZ.

        Eger ana Excel in de degismesini istiyorsak ==> islem bittikten sonra yani class in en sonunda
            workbook taki yeni hali excel e kaydetmemiz gerekir.

         */

        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(11);
        Cell cell = row.getCell(1);
        System.out.println(cell);

        /*
        Excel de satir ve sutun numaralari index kullanir. Yani 0 dan baslar.
         */

        //12. satirda bulunan Azerbaycan in ingilizce baskent isminin Baku oldugunu test edin

        Row onIkinciSatir = sheet.getRow(11);
        Cell ingilizceBaskent = onIkinciSatir.getCell(1);

        String expectedBaskentIsmi= "Baku";
        String actualBaskentIsmi= ingilizceBaskent.toString();

        Assert.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);

        /*

        Row onikinciSatir = sheet.getRow(11);
        Cell ingilizceBaskent = row.getCell(1);
        String expectedBaskentIsmi = "Baku";
        Assert.assertEquals(expectedBaskentIsmi, ingilizceBaskent.getStringCellValue());
        */


    }
}
