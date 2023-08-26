package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        // "https://www.amazon.com/" adresine gidiniz.
        driver.get("https://www.amazon.com/");
        // "https://www.n11.com/" adresine gidiniz.
        driver.get("https://www.n11.com/");
        // amazon adresine geri donunuz
        driver.navigate().back();
        // n11 adresine ilerleyiniz
        driver.navigate().forward();
        // sayfayi yenileyiniz
        driver.navigate().refresh();
        // pencereyi kapat
        driver.close();
        // Konsola "HER ŞEY YOLUNDA" yazdir
        System.out.println("HER ŞEY YOLUNDA");
    }
}
