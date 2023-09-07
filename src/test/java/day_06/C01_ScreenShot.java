package day_06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_ScreenShot extends TestBase {

    @Test
    public void test02() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");

        // arama kutusuna Nutella yazip aratın
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("nutella", Keys.ENTER);
        bekle(2);

        // tüm sayfanın fotografını cekin
        tumSayfaEkranGoruntusu();
    }

    @Test
    public void test01() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");
       // arama kutusuna Nutella yazip aratın
      WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
      aramaKutusu.sendKeys("nutella", Keys.ENTER);
      bekle(2);
      // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
      // tüm sayfanın fotografını cekin
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYY.MM.dd.HH.mm.ss");
        String tarih= date.format(dtf);

        TakesScreenshot ts= (TakesScreenshot) driver;
        String dosyaYolu="target/ekranGoruntusu/tumSayfa"+tarih+".jpeg";

        //File kaydet=new File("target/ekranGoruntusu/tumSayfa.jpeg");
        //File geciciDosya=ts.getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/ekranGoruntusu/tumSayfa.jpeg"));

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }
}
