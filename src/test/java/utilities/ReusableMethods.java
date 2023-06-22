package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ReusableMethods {

    public static String ikinciSayfaWHDegeri(String ilkSayfaWindowHandleDegeri, WebDriver driver){

        String ikinciSayfaWindowHandleDegeri = "";

        Set<String> windowHandlesSeti = driver.getWindowHandles();

        for (String each: windowHandlesSeti
             ) {
            if (each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }


        return ikinciSayfaWindowHandleDegeri;

    }
}
