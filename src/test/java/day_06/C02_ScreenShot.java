package day_06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C02_ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
       // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı");
        }

       // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("oppo", Keys.ENTER);
       // sonuc yazısını yazdiriniz
        bekle(3);
      WebElement sonucYazısı= driver.findElement(By.xpath("//*[@class='plp-panel-block1']"));
        System.out.println("sonuc yazısı :"+sonucYazısı.getText());
       // ilk urunun fotografını cekin
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYY.MM.dd.HH.mm.ss");
        String tarih= date.format(dtf);

        WebElement ilkUrun= driver.findElement(By.xpath("(//*[@class=' prd-link '])[1]"));
        File kayıt=new File("src/test/java/utilities/ekranGoruntusu/ilkUrun"+tarih+".png");
        File geciciKayıt=ilkUrun.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciKayıt,kayıt);
        bekle(2);
       // cikan ilk urune tiklayiniz
        ilkUrun.click();
        bekle(2);
       // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirabilirin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(3);
       // sepete ekleyiniz
        driver.findElement(By.xpath("//*[@id='addToCartButton']")).click();
        bekle(2);
       // sepetim'e git tilayiniz
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]")).click();
        bekle(2);
       // "Siparis Ozeti" webelementinin text'ini yazdiriniz
       WebElement siparisOzeti= driver.findElement(By.xpath("//*[@class='cart-sum-title']"));
        System.out.println("sipariş özeti : "+siparisOzeti.getText());
       // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//*[@class='btn btn-primary js-checkout-controls']")).click();
        bekle(2);
       // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
        WebElement text= driver.findElement(By.xpath("//*[@class='lrp-title']"));
        System.out.println("teknosaya hoş geldiniz : "+ text.getText());
    }

    @Test
    public void test02() throws IOException {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        try {
            driver.findElement(By.xpath("//*[@id='button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("transit gecis");
        }

        // arama cubuguna oppo yazip enter'a basınız
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='search-input']"));
        aramaKutusu.sendKeys("oppo",Keys.ENTER);

       // sonuc yazısını yazdiriniz
       WebElement sonucYazisi= driver.findElement(By.xpath("//h1"));
       System.out.println(sonucYazisi.getText());

         // ilk urunun fotografını cekin
       WebElement ilkUrun= driver.findElement(By.xpath("(//*[@class=' prd-link '])[1]"));

       String tarih=new SimpleDateFormat("_HH_mm_ss_ddMMyyy").format(new Date());
       String dosyaYolu="src/test/java/utilities/ekranGoruntusu/ilkUrun"+tarih+".jpeg";

       TakesScreenshot ts= (TakesScreenshot) driver;
       FileUtils.copyFile(ilkUrun.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
       bekle(2);
       // cikan ilk urune tiklayiniz
       ilkUrun.click();
      bekle(2);
    //   // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirabilirin

      Actions actions=new Actions(driver);
      actions.sendKeys(Keys.PAGE_DOWN).perform();

    //   // sepete ekleyiniz
      WebElement sepeteEkle= driver.findElement(By.xpath("//*[@id='addToCartButton']"));
      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
      wait.until(ExpectedConditions.visibilityOf(sepeteEkle));
      sepeteEkle.click();

    //   // sepetim'e git tilayiniz
      driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]")).click();
      bekle(2);

    //   // "Siparis Ozeti" webelementinin text'ini yazdiriniz
       WebElement siparisOzeti= driver.findElement(By.xpath("//*[@class='cart-sum-title']"));
       System.out.println(siparisOzeti.getText());

    //   // Alisverisi tamamlayiniz
       driver.findElement(By.xpath("//*[@class='btn btn-primary js-checkout-controls']")).click();
       bekle(2);

    //   // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
       System.out.println(driver.findElement(By.xpath("//*[@class='lrp-title']")).getText());


    }
}
