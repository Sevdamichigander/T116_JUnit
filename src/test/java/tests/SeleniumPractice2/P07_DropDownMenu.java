package tests.SeleniumPractice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class P07_DropDownMenu {


    @Test
    public void test01() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));




 //● https://the-internet.herokuapp.com/dropdown adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dropdown");

  //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        WebElement ddmenu = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(ddmenu);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //    4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumDDMenu = select.getOptions();

        for (WebElement eachElement:tumDDMenu
             ) {
            System.out.println(eachElement.getText());
        }
        //    5. Dropdown’un boyutunun 3 olduğunu test edin

        int ddmBoyut = tumDDMenu.size();

        Assert.assertEquals(3, ddmBoyut);

    }
}
