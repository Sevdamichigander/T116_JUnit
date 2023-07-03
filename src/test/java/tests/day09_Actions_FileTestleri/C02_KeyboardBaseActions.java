package tests.day09_Actions_FileTestleri;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KeyboardBaseActions extends TestBase {
    @Test
    public void test01(){
        /*
        Her ne kadar klavyede pek cok tus olsa da bir tus icin yapilabilacek 3 temel islev var :
        1- tek seferlik basmak ==> sendKeys(Keys.ENTER)
        2- bazen belirli bir sure icin bir tusa basili tutmak isteriz ==> keyDown()
        3- basili tuttugumuz tusu serbest birakmak isteriz ==> keyUp()

         */

        //2- https://www.amazon.com sayfasina gidelim

        driver.get("https://www.amazon.com");
        //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);

        actions.click(aramaKutusuElementi)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();
        //4- aramanin gerceklestigini test edin
        String expectedValue = "Samsung A71";
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String actualSonucYazisiElementi = sonucYazisiElementi.getText();
        Assert.assertTrue(actualSonucYazisiElementi.contains(expectedValue));

    }
}
