package tests.day12_Screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_jsExecutors extends TestBase {

    @Test
    public void test01(){

        // wisequarter anasayfaya gidelim
        driver.get("https://www.wisequarter.com");

        //jsExecutor kullanarak contact linkini tiklayin

        WebElement contactLink = driver.findElement(By.xpath("//a[text()='Contact']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", contactLink);

        //Anasayfaya geri donun
        // Go to Career Page butonuna kadar asagi inin ve click yapin

        WebElement goToCareerButonu = driver.findElement(By.xpath("//*[@class='fas fa-paper-plane']"));

        jse.executeScript("arguments[0].scrollIntoView();", goToCareerButonu);
        goToCareerButonu.click();

        System.out.println("/////////////////////////////////////////");

        jse.executeScript("alert('yasasinnnn');");

        bekle(3);


    }
}
