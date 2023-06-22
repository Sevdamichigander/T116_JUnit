package tests.day08_iframe_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
import utilities.TestBaseQuit;

public class C03_SwitchingWindow extends TestBaseQuit {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String windowHandleAmazon = driver.getWindowHandle();
        // yeni bir tab olarak wise quarter'a gidelim


        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        String windowHandleWise = driver.getWindowHandle();

        // yeni bir sayfa olarak youtube'a gidin


        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        String windowHandleYoutube = driver.getWindowHandle();

        // amazon'un acik oldugu sayfaya donun ve url'in amazon icerdigini test edin


        driver.switchTo().window(windowHandleAmazon);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        // wise quarter'in acik oldugu sayfaya gidin ve title'in Wise icerdigini test edin


        driver.switchTo().window(windowHandleWise);
        Assert.assertTrue(driver.getTitle().contains("Wise"));

        // youtube'un acik oldugu sayfaya gidin ve url'in youtube icerdigini test edin


        driver.switchTo().window(windowHandleYoutube);
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));

    }
}


