package tests.day07_testBase_DropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Soru_HandleDropDown_Books_Amazon extends TestBase {
    @Test
    public void test01(){

        //  https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //  - Test 1
        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
        //  oldugunu test edin

        WebElement ddmenu = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

        Select select = new Select(ddmenu);

        Assert.assertEquals(28,select.getOptions().size());

    }

    @Test
    public void test02(){

        //          -Test 2
        //  1. Kategori menusunden Books secenegini secin

        driver.get("https://www.amazon.com/");
        WebElement ddmenu = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

        Select select = new Select(ddmenu);

        select.selectByVisibleText("Books");

        //  2. Arama kutusuna Java yazin ve aratin

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);

        //  3. Bulunan sonuc sayisini yazdirin

        WebElement result = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));


        String resultStr = result.getText().substring(12).replaceAll("\\D", "");
        System.out.println(resultStr);

        //  4. Sonucun Java kelimesini icerdigini test edin

        String expectedValue = "Java";
        String actualValue = result.getText();

        Assert.assertTrue(actualValue.contains(expectedValue));


    }
}
