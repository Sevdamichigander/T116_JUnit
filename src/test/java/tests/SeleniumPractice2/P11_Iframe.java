package tests.SeleniumPractice2;

import org.junit.Test;
import utilities.TestBase;

public class P11_Iframe extends TestBase {
    @Test
    public void test01(){

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
}
