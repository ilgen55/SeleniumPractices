package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilesDownload extends TestBase {
    @Test
    public void test01() {

        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        // some-file.txt dosyasini indirelim
        WebElement someFileTxt= driver.findElement(By.xpath("//*[@href='download/some-file.txt']"));
        someFileTxt.click();
        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        // "C:\Users\Toshiba\Downloads\some-file.txt"
        String farklıyol=System.getProperty("user.home");
        String ortakYol="\\Downloads\\some-file.txt";
        String dosyaYolu=farklıyol+ortakYol;
        bekle(3);

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
