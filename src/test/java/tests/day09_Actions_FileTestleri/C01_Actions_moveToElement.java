package tests.day09_Actions_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions_moveToElement extends TestBase {
    @Test
    public void test01(){

       //1- https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin



        Actions actions = new Actions(driver);
        WebElement accountLists = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
        actions.moveToElement(accountLists).perform();
        bekle(1);

       //3- “Create a list” butonuna basin




        WebElement createListElement = driver.findElement(By.xpath("//span[text()='Create a List']"));
        createListElement.click();

       //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin


       WebElement yourListYaziElementi =driver.findElement(By.xpath("//div[@role='heading']"));
       Assert.assertTrue(yourListYaziElementi.isDisplayed());


    }
}
