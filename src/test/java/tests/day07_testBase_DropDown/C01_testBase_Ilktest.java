package tests.day07_testBase_DropDown;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_testBase_Ilktest extends TestBase {

    /*
    Bir class in test class olarak kullanilabilmesi icin oncelikle Webdriver ayarlarinin yapilmasi ve
    objenin olusturulmasi lazim.


    Java OOP concept cercevesinde WebDriver objesinin illa da bu class ta olmasi sart degildir.

    Baska class ta ki ozellikleri sahiplenmenin en kolay yolu o class i parent edinmektir.
    */


    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        Thread.sleep(3000);
    }
}