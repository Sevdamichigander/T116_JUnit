package tests.day12_Screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_WebElementScreenshot extends TestBase {

    @Test
    public void test01(){

        //google a gidelim

        driver.get("https://www.google.com");


        // nutella aratalim

        // cookies varsa

        driver.findElement(By.xpath("//*[text()='Tout refuser']")).click();

        WebElement searchbox = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchbox.sendKeys("Nutella");
        searchbox.submit();

        //arama sonuc sayisinin screenshot ini alalim

        WebElement searchBox = driver.findElement(By.xpath("//div[@id='result-stats']"));
        searchbox=driver.findElement(By.xpath("//div[@id='result-stats']"));
        ReusableMethods.webElementPhoto(driver, searchbox);




    }
}
