package tests.day07_testBase_DropDown;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Soru_PopUp_ClickandHold_DoubleClick extends TestBase {

    @Test
    public void test01(){

        //  1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //  2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"))).perform();

        //  3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();
        bekle(5);

        //  4. Popup mesajini yazdirin

        System.out.println(driver.switchTo().alert().getText());

        //  5. Popup'i tamam diyerek kapatin

        driver.switchTo().alert().accept();

        //  6. "Click and hold" kutusuna basili tutun

        WebElement clickHold = driver.findElement(By.xpath("//*[text()='Click and Hold!']"));

        actions.clickAndHold(driver.findElement(By.xpath("//*[text()='Click and Hold!']"))).perform();

        //  7. "Click and hold" kutusunda cikan yaziyi yazdirin

        System.out.println(driver.findElement(By.id("click-box")).getText());

        //  8. "Double click me" butonunu cift tiklayin


        WebElement doubleClick = driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClick).perform();



    }
}
