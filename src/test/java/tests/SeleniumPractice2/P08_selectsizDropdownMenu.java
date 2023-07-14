package tests.SeleniumPractice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P08_selectsizDropdownMenu {

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/ adresine gidin
        driver.get("https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/");

        //Ülke menüsünü locate edin

        WebElement ulkeMenusu = driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']"));
        ulkeMenusu.click();

        //Türkiye Seçeneğini seçin

        WebElement turkiye = driver.findElement(By.xpath("//*[@id='icp-dropdown-item-18']"));
        turkiye.click();


        //Go to website butonuna tıklayın

        WebElement goElementi = driver.findElement(By.xpath("//span[@id='icp-save-button']"));
        goElementi.click();

        driver.close();


    }
}
