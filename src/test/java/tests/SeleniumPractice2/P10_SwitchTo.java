package tests.SeleniumPractice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P10_SwitchTo  extends TestBase {
    /*
    1- Gerekli ayarlamalari yapin
    2- google.com adresine gidin
    3-Google in title inin Google icerdigini test edin.
    4- Yeni bir pencere acarak wisequarter sayfasina gidelim
    5- Wisequarter sayfasinin title inin wise icerdigini test edin

     */

   @Test
    public void test01() throws InterruptedException {

       driver.get("https://www.google.com");
       String ilkSayfaWHD = driver.getWindowHandle();
       System.out.println("Ilk sayfanin acildigi yerin window Handle Degeri " + ilkSayfaWHD);
       //Ilk sayfanin acildigi yerin window Handle Degeri E0DE5C6D1A7681C3AF466FAAEC692A97

       String expectedWords = "Google";
       String actualTitle = driver.getTitle();

       Assert.assertTrue(actualTitle.contains(expectedWords));

       driver.switchTo().newWindow(WindowType.WINDOW);
       Thread.sleep(2000);

       driver.get("https://www.wisequarter.com");
       String ikinciPencereWHD = driver.getWindowHandle();
       System.out.println("2. pencere WHD : " + ikinciPencereWHD);
       //2. pencere WHD : 994C7CA9D5B9C7155FF0060A7E97D25F

       String expectedWords2 = "Wise";
       String actualTitle2 = driver.getTitle();

       Assert.assertTrue(actualTitle2.contains(expectedWords2));

       driver.switchTo().window(ilkSayfaWHD);
       driver.get("https://www.amazon.com");

       String expectedWords3 = "Amazon";
       String actualTitle3 = driver.getTitle();

       Assert.assertTrue(actualTitle3.contains(expectedWords3));

       driver.switchTo().newWindow(WindowType.TAB);
       driver.get("https://www.wisequarter.com");

      String expectedWords4 = "Amazon";
      String actualTitle4 = driver.getTitle();

      Assert.assertFalse(actualTitle4.contains(expectedWords4));

       }
   }



