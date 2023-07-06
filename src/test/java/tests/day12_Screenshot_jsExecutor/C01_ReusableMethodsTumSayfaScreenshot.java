package tests.day12_Screenshot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_ReusableMethodsTumSayfaScreenshot extends TestBase {

    @Test
    public void test01(){

        // wisequarter anasayfaya gidin

        driver.get("https://www.wisequarter.com");

        //url in wise icerdigini test edin
        String expectedUrlValue = "wisequarter";
        String actualUrlValue = driver.getCurrentUrl();

        Assert.assertTrue(actualUrlValue.contains(expectedUrlValue));

        //tum sayfa screenshot alin

        ReusableMethods.tumSayfaScreenshot(driver);

    }
}
