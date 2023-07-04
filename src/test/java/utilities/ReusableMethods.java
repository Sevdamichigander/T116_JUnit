package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Set;

public class ReusableMethods {

    public static String ikinciSayfaWHDegeri(String ilkSayfaWindowHandleDegeri, WebDriver driver) {

        String ikinciSayfaWindowHandleDegeri = "";

        Set<String> windowHandlesSeti = driver.getWindowHandles();

        for (String each : windowHandlesSeti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)) {
                ikinciSayfaWindowHandleDegeri = each;
            }
        }
        return ikinciSayfaWindowHandleDegeri;
    }

    public static String hucredekiYaziyiGetir(int satirNo, int sutunNo, WebDriver driver) {

        //==>       //tbody/tr[   5   ]/td[  1  ] dinamik degil

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucredekiElement = driver.findElement(By.xpath(dinamikXpath));
        return istenenHucredekiElement.getText();
    }
}
