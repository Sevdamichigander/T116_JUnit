package tests.day06_JUnitFramework_CheckBox_RadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));

    }

    @After
    public void tearDown() {
        driver.close();
    }


    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement h3title = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(h3title.isEnabled());
        System.out.println(h3title.getText());

       WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));


    }

}



