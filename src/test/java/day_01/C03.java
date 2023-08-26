package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        // https://www.amazon.com/ adresine gidin
        // Kaynak Kodlarini konsola yazdiriniz
        driver.get("https://www.amazon.com/");
        String amazonHtmlCods= driver.getPageSource();
        System.out.println("amazon htmlCods = " + amazonHtmlCods);
        // Kaynak Kodlarinda "window" yazdigini test edin
        if(amazonHtmlCods.contains("window")){
            System.out.println("html window içeriyor");
        }else {
            System.out.println("html window içermiyor");
        }
        // sayfa)yi kapatiniz
        driver.close();





    }
}
