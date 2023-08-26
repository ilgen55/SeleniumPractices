package day_05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_FilesUploadRobot extends TestBase {
    @Test
    public void test01() {
        // https://www.ilovepdf.com/compress_pdf adrese gidelim
        driver.get("https://www.ilovepdf.com/compress_pdf");
        // Dosya sec butonuna tıklayalım
        WebElement dosyaSec = driver.findElement(By.xpath("//span[text()='Select PDF files']"));
        dosyaSec.click();
        // Dosya yuklemek icin robot class'ını kullanalım

        // "C:\Users\Toshiba   \Desktop\deneme.txt"
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\deneme.txt";
        String dosyaYolu=farkliKisim+ortakKisim;
        uploadFilePath(dosyaYolu);
    }
}
