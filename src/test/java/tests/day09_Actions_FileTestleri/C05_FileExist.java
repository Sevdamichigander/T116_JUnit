package tests.day09_Actions_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_FileExist {
    @Test
    public void test01(){

        // copy as Path
        // copy autant que chemin d'access

        //"C:\Users\33602\Downloads\avatar.png"
        // C:\Users\33602\Downloads\avatar.png

        /*
        Bir dosyanin bilgisayarimizda oldugunu test etmek cok kolaydir.
        Ancak, testimizin dinamik olmasini saglamak, yani hangi bilgisayarda calistirilirsa calistirilsin
        testin dogru calisabilmesi icin
        dosya yolunu dinamiklestirmeliyiz.

         */

        //        Bir dosyanin bilgisayarimiza var oldugunu test etmek istersek

        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\33602\\Downloads\\avatar.png")));// Pass
        Assert.assertTrue(Files.exists(Path.of("C:\\Users\\33602\\Downloads\\avatar.png")));//Pass


    }
    @Test
    public void dinamikTest(){

        // Bu dosya yolunu dinamiklestirmek icin;


        //Java da dosya yolunu bize veren iki adet kod vardir:

        //1- Calistigimiz klasorun dosya yolunu almak isterseniz;

        System.out.println(System.getProperty("user.dir"));

        // icinde bulundugumuz dosyanin yolunu verir

        //C:\Users\33602\IdeaProjects\Team116_JUnit
        //C:\Users\33602\IdeaProjects\Team116_JUnit\src\test\java\tests\day08_iframe_windows_actionsClass\C03_SwitchingWindow.java

        // 2- Bilgisayarimizin ana dosya yolu

        System.out.println(System.getProperty("user.home")); //C:\Users\33602

        // Bu bilgileri kullanarak indirdigimiz dosyanin dinamik dosya yolunu elde etmek icin
        // iki parca da elde edebiliriz

        //System.getProperty("user.home") + herkeste ayni olan kisim

        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\avatar.png";
        System.out.println(dinamikDosyaYolu);

        String dinamikDosyaYolu2 = System.getProperty("user.home") + "/Downloads/avatar.png";

        System.out.println(dinamikDosyaYolu2);

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));//C:\Users\33602\Downloads\avatar.png
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu2)));//C:\Users\33602/Downloads/avatar.png

    }
}
