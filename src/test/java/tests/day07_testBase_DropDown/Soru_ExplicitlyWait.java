package tests.day07_testBase_DropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Soru_ExplicitlyWait extends TestBase {
    @Test
    public void test01(){
       // 1. Bir class olusturun : EnableTest
       // 2. Bir metod olusturun : isEnabled()

       // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
       // 4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElement = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textboxElement.isEnabled());

       // 5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        WebElement enableButonu = driver.findElement(By.xpath("//*[text()='Enable']"));

        enableButonu.click();

       // 6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's enabled!\"]")));

        WebElement itsEnabledElementi = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));

        Assert.assertTrue(itsEnabledElementi.isDisplayed());


        // 7. Textbox’in etkin oldugunu(enabled) dogrulayın

        Assert.assertTrue(textboxElement.isEnabled());
    }
}
