package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
        Thread.sleep(3000);
        // maximize iken pencere konumunu ve pencere olcusunu yazdiriniz
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        //  fullscreen iken pencere konumunu ve pencere olcusunu yazdiriniz
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        //  sayfayi kapatiniz
        driver.close();

    }
}
