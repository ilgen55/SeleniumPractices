package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        // "https://teknosa.com/" adresine gidiniz
        driver.get("https://teknosa.com/");
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String teknosaActualTitle= driver.getTitle();
        System.out.println("teknosaActualTitle = " + teknosaActualTitle);
        String teknosaActualUrl= driver.getCurrentUrl();
        System.out.println("teknosaActualUrl = " + teknosaActualUrl);
        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
      if(teknosaActualTitle.contains("Teknoloji")){
          System.out.println("TEST PASSED");
      }else {
          System.out.println("TEST FAILED");
      }
        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        if (teknosaActualUrl.contains("teknosa")) {
            System.out.println("TEST PASSED : URL teknosa içeriyor");
        }else {
            System.out.println("TEST FAILED :URL teknosa içermiyor");
        }
        // "https://medunna.com/" adresine gidiniz
        driver.get("https://medunna.com/");
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String medunnaActualTitle= driver.getTitle();
        System.out.println("medunnaActualTitle = " + medunnaActualTitle);

        String medunnaActualUrl= driver.getCurrentUrl();
        System.out.println("medunnaActualUrl = " + medunnaActualUrl);
        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        if(medunnaActualTitle.contains("MEDUNNA")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        if (medunnaActualUrl.contains("medunna")) {
            System.out.println("TEST PASSED : URL medunna içeriyor");
        }else {
            System.out.println("TEST FAILED :URL medunna içermiyor");
        }
        // teknosa adresine geri donunuz
        driver.navigate().back();
        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        // medunna adresine ilerleyiniz
        driver.navigate().forward();
        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        // pencereyi kapat
        driver.close();
    }
}
