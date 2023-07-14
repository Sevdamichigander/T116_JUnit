package tests.SeleniumPractice2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P06 extends TestBase {

    @Test
    public void test01() {

        //https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb adresine gidin
        driver.get("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");

        // Prime Programs kismindaki ilk 3 checkbox i locate edin

        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        WebElement checkbox3 = driver.findElement(By.xpath("(//*[@type='checkbox'])[3]"));

        bekle(3);

        //uc checkbox i isaretleyin
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        bekle(3);

        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        bekle(3);

        if (!checkbox3.isSelected()) {
            checkbox3.click();
        }
        bekle(3);

        //her uc checkbox inda isaretli oldugunu dogrulayin

        Assert.assertTrue(checkbox1.isSelected() && checkbox2.isSelected() && checkbox3.isSelected());

    }
}
