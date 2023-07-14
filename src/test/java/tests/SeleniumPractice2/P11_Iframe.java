package tests.SeleniumPractice2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P11_Iframe extends TestBase {
    @Test
    public void iframeTest(){

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement sayfadakiYazi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sayfadakiYazi.isDisplayed());
        System.out.println(sayfadakiYazi.getText());

        // iframe olan sayfada iframe icindeki herhangi birseyi test edebilmek icin
        //once iframe cercevesine gecmek gerekir.
        //Bunu da iframe i web elemente atayarak yapabiliriz.

        WebElement iframeElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElement);

        WebElement iframeYazisi = driver.findElement(By.xpath("//*[text()='Your content goes here.']"));

        String iframedekiYazi = iframeYazisi.getText();
        System.out.println("iframe deki yazi " + iframedekiYazi);

        iframeYazisi.clear();
        iframeYazisi.sendKeys("Have a wise day!");

    }
}
