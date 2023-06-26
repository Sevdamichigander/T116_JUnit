package tests.day05_maven_JUNitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");

        String expected_url = "Mamazon";

        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expected_url)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("test FAILLED");
            //throw new RuntimeException();
        }
    }
}
