package tests.day05_maven_JUNitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru_SepeteEklemeTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.saucedemo.com");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user"+ Keys.ENTER);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce"+Keys.ENTER);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String nameFirstProduct = firstProduct.getText();
        firstProduct.click();

        WebElement addCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addCart.click();

        WebElement shoppingCartContainer = driver.findElement(By.id("shopping_cart_container"));
        shoppingCartContainer.click();

        WebElement actualCart = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        String actualCartStr = actualCart.getText();
        String expextedCart = "Sauce Labs Backpack";

        Assert.assertEquals(expextedCart, actualCartStr);
        System.out.println("Expected cart :" + expextedCart + "\nActual cart : "+actualCartStr);
        driver.close();







    }
}
/*
1. “https://www.saucedemo.com” Adresine gidin
2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin

 */
