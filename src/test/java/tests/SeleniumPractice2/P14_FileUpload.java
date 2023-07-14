package tests.SeleniumPractice2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P14_FileUpload extends TestBase {

    @Test

    public void test01(){
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseButton = driver.findElement(By.id("file-upload"));
        String dosyaYolu = "C:\\Users\\33602\\IdeaProjects\\Team116_JUnit\\src\\test\\java\\tests\\SeleniumPractice2\\img.png";


        chooseButton.sendKeys(dosyaYolu);
        driver.findElement(By.id("file-submit")).click();

        WebElement uploadYazisi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(uploadYazisi.isDisplayed());
    }

}
