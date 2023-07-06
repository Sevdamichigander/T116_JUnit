package tests.day11_excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/test/java/tests/day11_excelAutomation/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // - 1.satirdaki 2.hucreye gidelim ve yazdiralim

        System.out.println(sayfa1.getRow(0).getCell(1)); //Başkent (İngilizce)


        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

        String istenenHucre = sayfa1.getRow(0).getCell(1).toString();//Başkent (İngilizce)
        // String objesi oldugu icin cell e direk ulasamiyoruzz. toString ile ulasiyoruz
        System.out.println(istenenHucre);

        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedYazi = "Kabil";
        String actualYazi = sayfa1.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedYazi,actualYazi);

        // - Satir sayisini bulalim

        System.out.println(sayfa1.getLastRowNum()); //190 index yazdirir _ son satir indeksi

        // - Fiziki olarak kullanilan satir sayisini bulun

        System.out.println(sayfa1.getPhysicalNumberOfRows()); // 191 fiziki olarak kullanilan satiri buluyor

        //Sayfa2 icin son satir numarasi ve fiziki olarak kullanilan satir sayisini yazdirin

        Sheet sayfa2 = workbook.getSheet("Sayfa2");

        System.out.println("Son satir indeksi " + sayfa2.getLastRowNum()); //Son satir indeksi 23
        System.out.println("Sayfa 2 de fiziki olarak kullanilan satir sayisi " + sayfa2.getPhysicalNumberOfRows());
        //Sadece fiziki olarak kullanilan satir sayisini getirir ==> 8 **Index ile alakasi yok


        // Listede Togo isminde bir ulke bulundugunu test edin

        boolean flag = false;

        for (int i = 0; i < sayfa1.getLastRowNum(); i++) { // i=1 den de baslayabiliriz.

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();

            if (satirdakiUlkeIsmi.equals("Togo")) {
                System.out.println("Excel de Togo var");
                flag = true;
                break;
            }
        }

        Assert.assertTrue(flag); // Excel de Togo var

        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String, String> ulkelerMap = new TreeMap<>();

        for (int i = 1; i < sayfa1.getLastRowNum(); i++) {
            String key = sayfa1.getRow(i).getCell(0).toString();
            String value = sayfa1.getRow(i).getCell(1).toString();
            ulkelerMap.put(key, value);
        }

        System.out.println(ulkelerMap);   //{Afghanistan=Kabul, Albania=Tirana, Algeria=Aljiers,...}

        //   Listede Benin isminde bir ulke bulundugunu test edin

        Assert.assertTrue(ulkelerMap.containsKey("Benin")); // Passed

        //   Listede Ankara isminde bir baskent bulundugunu test edin

        Assert.assertTrue(ulkelerMap.containsValue("Ankara")); //Passed

    }
}
